package usercode;

public class PingPong
{
	public static int count = 0;
	public static void Send (PingPongType val)
	{
		System.out.println ("[PING] " + count);
		count = count + 1;
		val.setValue (count);
		
	}
	
	
	public static void Receive (PingPongType val)
	{
		if ((val != null) && val.isValid())
		{
			System.out.println ("[PONG] " + val.getValue ());
		}
	}
}