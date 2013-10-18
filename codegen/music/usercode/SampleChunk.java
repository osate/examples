package usercode;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.osate.runtime.Debug;
import org.osate.runtime.types.OjrType;

public class SampleChunk implements OjrType , Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5743129475022856715L;
	public static final int SAMPLE_SIZE = 64*1024;
	private boolean valid = false;
	private boolean containData = false;
	private byte[]  buffer = new byte[SAMPLE_SIZE] ;
	
	public SampleChunk ()
	{

	}
	
	public boolean getContainData ()
	{
		return this.containData;
	}
	
	public void setContainData (boolean b)
	{
		this.containData = b;
	}
	 
	
	public void setBuffer (byte[] b)
	{
		this.buffer = b;
//		for (int i = 0 ; i < SAMPLE_SIZE ; i++)
//		{
//			this.buffer[i] = b[i];
//		}
	}

	
	public byte[] getBuffer ()
	{
		return this.buffer;
	}
	
	public void copy(Object dst) 
	{
		if (dst instanceof SampleChunk)
		{
			((SampleChunk)dst).setBuffer(this.buffer);
			((SampleChunk)dst).setContainData(this.getContainData());;
		}		
	}


	public boolean isValid() 
	{
		return this.valid;
	}

	@Override
	public void setValid(boolean b) 
	{
		this.valid = b;	
	}

}
 