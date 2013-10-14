package usercode;

import org.osate.runtime.Output;

public class Actuator {
	private static int numberofsteps = 0;
	private static boolean  canIncrement = true;
	public static void exec(StepCmd step, Notification no , Position commanded)
	{
		step.setValid(false);
		//Output.output ("[ACTUATOR] execution ");

		if ((commanded.isValid()) &&(commanded.getNewValue()))
		{
			//Output.output ("[ACTUATOR] receive new commanded value " + commanded.getValue());
			numberofsteps = commanded.getValue();
			commanded.setNewValue(false);
		}
		
		if (no.isValid())
		{
			canIncrement = true;
			no.setValid(false);
		}
		
		if ((numberofsteps > 0) && canIncrement)
		{
			//Output.output ("[ACTUATOR]number of steps " + numberofsteps);

			step.setReaction(true);
			step.setValid(true);
			
			canIncrement = false;
			numberofsteps = numberofsteps - 1;
		}
		else
		{
			step.setReaction(false);
		}
		
	}

}
