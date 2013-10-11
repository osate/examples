package usercode;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.osate.runtime.Output;

public class Interface {
	private static boolean initialized = false;
	private static int count = 0;
	private static boolean newValue = false;
	
	public static void start(Position pos) {
		if (! initialized)
		{
			Button btnStrat= new Button("Send the position");
			final TextField tf = new TextField();
			btnStrat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					count = Integer.parseInt(tf.getText());
					newValue = true;
				}
			});

			JFrame frame = new JFrame();
			Container cp = frame.getContentPane();
			cp.add(btnStrat,BorderLayout.SOUTH);
			cp.add(tf,BorderLayout.NORTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			initialized = true;
		}
		
		if (newValue)
		{
			Output.output ("[INTERFACE] send new value " + count);

			pos.setNewValue(newValue);
			pos.setValue(count);
			newValue = false;
		}
		else
		{
			pos.setNewValue(false);
			Output.output ("[INTERFACE] does not send a new value");
		}
	}

}
