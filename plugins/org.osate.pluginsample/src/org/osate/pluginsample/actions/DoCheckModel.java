/**
 * <copyright>
 * Copyright  2013 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 * 
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 * 
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 * 
 */
package org.osate.pluginsample.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Comment;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.impl.AnnexSubclauseImpl;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.pluginsample.Activator;
import org.osate.pluginsample.CheckModel;
import org.osate.ui.actions.AaxlModifyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.unparsing.AadlUnparser;
import org.osgi.framework.Bundle;


public final class DoCheckModel extends AaxlModifyActionAsJob {
	
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	protected String getMarkerType() {
		return "org.osate.pluginsample";
	}

	protected String getActionName() {
		return "Check the AADL model";
	}

		
	
	public void doAaxlAction(IProgressMonitor monitor, Element obj)
	{
		SystemInstance si;
		CheckModel validator;
		
		monitor.beginTask("Check the AADL model", IProgressMonitor.UNKNOWN);
		
		validator = new CheckModel (monitor,getErrorManager());
		
		if (obj instanceof InstanceObject)
		{
			si = ((InstanceObject)obj).getSystemInstance();
		}
		else
		{
			si = null;
		}

		if (si != null) 
		{

			validator.defaultTraversal(si);
			ComponentClassifier ccl = si.getComponentClassifier();
			Comment ci = ccl.createOwnedComment();
			ci.setBody("this is my sample comment");
			
			AnnexSubclause as = ccl.createOwnedAnnexSubclause();
			AnnexSubclauseImpl asi = (AnnexSubclauseImpl) as;
			asi.setName("EMV2");
			asi.bypassUnparser(true);
			asi.setAnnexContent("hello in annex");
			System.out.println("si=" + si );
			System.out.println("ccl=" + ccl );
			System.out.println("ccl owner=" + ccl.getOwner() );
			System.out.println("ccl owner owner=" + ccl );
			AadlUnparser.getAadlUnparser().doUnparseToFile(ccl.getOwner().getOwner());
			
			
			Dialog.showInfo("Analysis result", "done");
		}
		else
		{
			Dialog.showInfo("Analysis result", "Please choose an instance model");	
		}
		monitor.done();


		
	}
}
 