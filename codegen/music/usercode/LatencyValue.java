package usercode;

import java.io.Serializable;

import org.osate.runtime.types.OjrType;

public class LatencyValue implements Serializable, OjrType
{
	
	private boolean valid = true;
	
	public boolean isValid ()
	{
		return this.valid;
	}
	
	public void setValid (boolean b)
	{
		this.valid = b;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6061533309025619478L;
	
	private int 		value 		= 0;
	private boolean 	newValue 	= false;
	
	public LatencyValue ()
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
		if( ! (dst instanceof LatencyValue))
		{
			return;
		}
		
		LatencyValue myDestinationObject = (LatencyValue) dst;
		myDestinationObject.setValue(this.getValue());
		myDestinationObject.setNewValue(this.getNewValue());

	}
	
}