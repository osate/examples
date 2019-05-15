package usercode;

import java.io.Serializable;

import org.osate.runtime.types.OjrType;

public class StepCmd implements Serializable, OjrType
{
	private boolean valid = true;
	private boolean backWard = false;
	
	public boolean isValid ()
	{
		return this.valid;
	}
	
	public boolean goBackward ()
	{
		return this.backWard;
	}
	
	public void setBackward (boolean b)
	{
		this.backWard = b;
	}
	
	public void setValid (boolean b)
	{
		this.valid = b;
	}
	private static final long serialVersionUID = -6061533309025619478L;
	
	private boolean 	shoudReact 	= false;
	private boolean 	newValue 	= false;
	
	public StepCmd ()
	{
		this.shoudReact = false;
	}
	
	public void enableReaction ()
	{
		this.shoudReact = true;
	}
	
	public void disableReaction ()
	{
		this.shoudReact = false;
	}
	
	public boolean getReaction ()
	{
		return this.shoudReact;
	}
	
	public void setReaction (boolean r)
	{
		this.shoudReact = r;
	}

	public void copy(Object dst)
	{	
		if( ! (dst instanceof StepCmd))
		{
			return;
		}
		
		StepCmd myDestinationObject = (StepCmd) dst;
		myDestinationObject.setReaction(this.shoudReact);
		myDestinationObject.setBackward(this.backWard);
	}
	
}