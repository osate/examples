package usercode;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.osate.runtime.Output;

public class App {
	private static int desiredPosition = 0;
	private static int commandedPosition = 0;
	private static boolean initialized = false;
	private static final Label desiredPositionLabel = new Label();
	private static final Label commandedPositionLabel = new Label();
	private static final int MAX_STEPS = 15;
	private static final int NB_STEPS  = 36;
	
	public static void exec(Position user,Position commanded) 
	{
		if (! initialized)
		{
			JFrame frame = new JFrame();
			Container cp = frame.getContentPane();
			desiredPositionLabel.setText  ("Desired Position    = " + desiredPosition);
			commandedPositionLabel.setText("Commanded Position  = " + commandedPosition);
			cp.add(desiredPositionLabel,BorderLayout.SOUTH);
			cp.add(commandedPositionLabel,BorderLayout.NORTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.pack();
			frame.setLocation(200, 200);
			frame.setVisible(true);
			initialized = true;
		}
		Output.output ("[APP] starts activation");
		commanded.setValid(false);
		
		if (user.isValid() && user.getNewValue())
		{
			Output.output ("[APP] receive new value from user " + user.getValue());
			if (user.getValue() < NB_STEPS)
			{
				desiredPosition = user.getValue();
			}
			user.setValid(false);
			user.setNewValue(false);
		}
		
		if (desiredPosition != commandedPosition)
		{
			int nbSteps = 0;
			int delta;
			
			if (desiredPosition < commandedPosition)
			{
				delta = desiredPosition + (NB_STEPS - commandedPosition);
			}
			else
			{
				delta = desiredPosition - commandedPosition; 
			}
		//	System.out.println ("delta=" + delta);
			
			if (delta > 15)
			{
				nbSteps = 15;
			}
			else
			{
				nbSteps = delta;
			}
			commandedPosition = (commandedPosition + nbSteps) % NB_STEPS;
			commanded.setNewValue(true);
			commanded.setValue(nbSteps);
			commanded.setValid(true);
		}

		
		desiredPositionLabel.setText  ("Desired Position    = " + desiredPosition);
		commandedPositionLabel.setText("Commanded Position  = " + commandedPosition);
	}


}
