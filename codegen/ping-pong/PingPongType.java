package usercode;

import java.io.Serializable;

import org.osate.runtime.types.OjrType;

public class PingPongType implements Serializable, OjrType
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6061533309025619478L;
	
	private int value = 0;
	public PingPongType ()
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