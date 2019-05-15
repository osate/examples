package usercode;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
			
			tf.addKeyListener(
		            new KeyListener(){

		                public void keyPressed(KeyEvent e){

		                    if(e.getKeyChar() == KeyEvent.VK_ENTER){

		    					count = Integer.parseInt(tf.getText());
		    					newValue = true;
		    					tf.setText("");
		                    }       
		                }

						@Override
						public void keyReleased(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void keyTyped(KeyEvent arg0) {
							
						}
		            }
		        );

			JFrame frame = new JFrame();
			Container cp = frame.getContentPane();
			cp.add(btnStrat,BorderLayout.SOUTH);
			cp.add(tf,BorderLayout.NORTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			initialized = true;
		}
		pos.setNewValue(false);
		pos.setValid(false);
		if (newValue)
		{
			Output.output ("[INTERFACE] send new value " + count);

			pos.setNewValue(newValue);
			pos.setValue(count);
			pos.setValid(true);
			newValue = false;
		}
		else
		{

			//Output.output ("[INTERFACE] does not send a new value");
		}
	}

}
