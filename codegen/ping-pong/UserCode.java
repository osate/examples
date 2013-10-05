public class PingPong
{
	public static int count = 0;
	public static void Send ()
	{
		System.out.println ("[PING] " + count);
		count = count + 1;
	}
	
	
	public static void Receiver (int r)
	{
		System.out.println ("[PONG] " + count);
	}
}