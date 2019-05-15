package usercode;

import java.io.Serializable;

import org.osate.runtime.types.OjrType;

public class ActionType implements Serializable, OjrType
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6061533309025619478L;
	
	private int 		value 		= 0;
	private boolean 	newValue 	= false;
	
	public ActionType ()
	{
		value = 0;
	}
	
	public void setValue (int i)
	{
		this.value = i;
	}
	
	public int getValue ()
	{
		return this.value;
	}
	
	public boolean getNewValue ()
	{
		return this.newValue;
	}
	
	public void setNewValue (boolean b)
	{
		this.newValue = b;
	}


	public void copy(Object dst)
	{	
		if( ! (dst instanceof ActionType))
		{
			return;
		}
		
		ActionType myDestinationObject = (ActionType) dst;
		myDestinationObject.setValue(this.getValue());
		myDestinationObject.setNewValue(this.getNewValue());

	}
	
}