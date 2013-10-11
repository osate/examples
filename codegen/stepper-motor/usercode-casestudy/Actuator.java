package usercode;

import org.osate.runtime.Output;

public class Actuator {
	private static int numberofsteps = 0;
	
	public static void exec(StepCmd step, Position commanded)
	{
		if (commanded.getNewValue())
		{
			Output.output ("[ACTUATOR] receive new commanded value " + commanded.getValue());

			numberofsteps = commanded.getValue();
		}
		
		if (numberofsteps > 0)
		{
			Output.output ("[ACTUATOR]number of steps " + numberofsteps);

			step.setReaction(true);
			numberofsteps = numberofsteps - 1;
		}
		else
		{
			step.setReaction(false);
		}
		
	}

}
