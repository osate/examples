package usercode;

import java.io.Serializable;

import org.osate.runtime.types.OjrType;

public class Notification implements Serializable, OjrType
{
	private boolean valid = true;
	private boolean reaction = true;
	
	public void setReaction (boolean b)
	{
		this.reaction = b;
	}
	
	public boolean getReaction ()
	{
		return this.reaction;
	}
	
	public boolean isValid ()
	{
		return this.valid;
	}
	
	public void setValid (boolean b)
	{
		this.valid = b;
	}
	private static final long serialVersionUID = -6061533309025619478L;
	

	public Notification ()
	{
		this.reaction = true;
	}
	


	public void copy(Object dst)
	{	
		if( ! (dst instanceof Notification))
		{
			return;
		}
		
		Notification myDestinationObject = (Notification) dst;

	}
	
}