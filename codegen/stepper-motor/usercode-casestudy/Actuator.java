package usercode;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Label;

import javax.swing.JFrame;

import org.osate.runtime.Output;

public class Actuator {
	private static int numberofsteps = 0;
	private static boolean  canIncrement = true;
	private static boolean initialized = false;
	private static int commandedPosition = 0;
	private static final Label commandedPositionLabel = new Label();

	public static void exec(StepCmd step, Notification no , Position commanded)
	{
		if (! initialized)
		{
			JFrame frame = new JFrame();
			Container cp = frame.getContentPane();
			commandedPositionLabel.setText("Commanded Position  = " + commandedPosition);
			
			cp.add(commandedPositionLabel,BorderLayout.NORTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.pack();
			frame.setLocation(200, 200);
			frame.setVisible(true);
			initialized = true;
		}
		
		
		step.setValid(false);
		//Output.output ("[ACTUATOR] execution ");

		if ((commanded.isValid()) &&(commanded.getNewValue()))
		{
			//Output.output ("[ACTUATOR] receive new commanded value " + commanded.getValue());
			Output.outputWithTime("[ACTUATOR] receive new commanded value " + commanded.getValue() + " actual number of steps:"+numberofsteps);
			numberofsteps = commanded.getValue();
			commanded.setNewValue(false);
		}
		
		if (no.isValid())
		{
			canIncrement = true;
			no.setValid(false);
		}
		step.setReaction(false);
		
		if ((numberofsteps > 0) && canIncrement)
		{
			//Output.output ("[ACTUATOR]number of steps " + numberofsteps);

			step.setReaction(true);
			step.setValid(true);
			step.setBackward(false);
			canIncrement = false;
			numberofsteps = numberofsteps - 1;
			commandedPosition = commandedPosition + 1;
		//	Output.outputWithTime ("[ACTUATOR] send increment");

		}

		if ((numberofsteps < 0) && canIncrement)
		{
			//Output.output ("[ACTUATOR]number of steps " + numberofsteps);

			step.setReaction(true);
			step.setValid(true);
			step.setBackward(true);
			canIncrement = false;
			numberofsteps = numberofsteps + 1;
			commandedPosition = commandedPosition - 1;

			//Output.outputWithTime ("[MOTOR] send increment");

		}
		commandedPositionLabel.setText  ("Actuator Commanded Position    = " + commandedPosition);

	}

}
