package usercode;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import org.osate.runtime.Output;

public class Motor {
	private static boolean initialized = false;
	private static  WheelInterface demo;
	public static void exec(StepCmd step, Notification no) 
	{
		no.setValid(false);
		if (! initialized)
		{
			demo = new WheelInterface();
		    JFrame frame = new JFrame();
		    Container cp = frame.getContentPane();
		    cp.add(demo,BorderLayout.CENTER);

		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(500, 500);
		    frame.setLocation(500, 500);
		    frame.setVisible(true);
		    initialized = true;
		}
		if ((step.isValid()) && (step.getReaction()))
		{
			//Output.output ("[MOTOR] should react");
			//Output.outputWithTime ("[MOTOR] react starts");
			if (step.goBackward())
			{
				demo.addIncrement(-1);
			}
			else
			{
				demo.addIncrement(1);
			}
//			try {
//				Thread.sleep((int)(Math.random() * 100));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		try {
			Thread.sleep(50); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			no.setReaction(true);
			no.setValid(true);
			step.setValid(false);
			//Output.outputWithTime ("[MOTOR] react complete");

		}
		else
		{
			//Output.output ("[MOTOR] should not react");
		}
	}

}
