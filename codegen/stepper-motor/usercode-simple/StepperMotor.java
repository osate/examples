package usercode;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class StepperMotor
{
	public static int count = 0;
	private static  WheelInterface demo;
	private static boolean receiverInitialized = false;
	private static boolean senderInitialized = false;

	public static void Send (ActionType val)
	{
		if (! senderInitialized)
		{
			initializeSender();
		}
		
		System.out.println ("[PING] " + count);
		if (count > 0)
		{
			val.setValue (count);
			val.setNewValue(true);
		}
		else
		{
			val.setNewValue(false);
		}
		count = 0;
	}
	
	
	public static void Receive (ActionType val)
	{
		if (! receiverInitialized)
		{
			initializeReceiver();
		}
		
		if (val != null)
		{
			if (val.getNewValue())
			{
				System.out.println ("[PONG] " + val.getValue ());
				
				demo.addIncrement(val.getValue());
				val.setNewValue(false);
			}
		}
	}
	
	public static void initializeSender ()
	{
		Button btnStrat= new Button("Wheel of Fortune");
		final TextField tf = new TextField();
		btnStrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count = Integer.parseInt(tf.getText());
			}
		});

		JFrame frame = new JFrame();
		Container cp = frame.getContentPane();
		cp.add(btnStrat,BorderLayout.SOUTH);
		cp.add(tf,BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		senderInitialized = true;
	}
	
	public static void initializeReceiver ()
	{
		demo = new WheelInterface();
	    JFrame frame = new JFrame();
	    Container cp = frame.getContentPane();
	    cp.add(demo,BorderLayout.CENTER);

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 500);
	    frame.setLocation(500, 500);
	    frame.setVisible(true);
	    receiverInitialized = true;
	}
}


