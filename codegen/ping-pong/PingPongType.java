package usercode;

import java.io.Serializable;

import org.osate.runtime.types.OjrType;

public class PingPongType implements Serializable, OjrType
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6061533309025619478L;
	private boolean valid = true;
	
	private int value = 0;
	public PingPongType ()
	{
		value = 0;
	}
	
	public boolean isValid ()
	{
		return this.valid;
	}
	
	public void setValid (boolean b)
	{
		this.valid = b;
	}
	
	public void setValue (int i)
	{
		this.value = i;
	}
	
	public int getValue ()
	{
		return this.value;
	}


	public void copy(Object dst)
	{	
		if( ! (dst instanceof PingPongType))
		{
			return;
		}
		
		PingPongType myDestinationObject = (PingPongType) dst;
		myDestinationObject.setValue(this.getValue());
	}
	
}