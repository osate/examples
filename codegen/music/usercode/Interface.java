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
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.osate.runtime.Output;

public class Interface {
	private static boolean initialized = false;
	private static int val1 = 0;
	private static int val2 = 0;
	private static boolean newValue = false;
	private static JSlider slider1;
	private static JSlider slider2;

	public static void start(LatencyValue pos1, LatencyValue pos2) {
		if (! initialized)
		{
			
			slider1 = new JSlider(JSlider.HORIZONTAL,0, 1000, 0);
			slider2 = new JSlider(JSlider.HORIZONTAL,0, 1000, 0);
			slider1.addChangeListener(
					new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					val1 = slider1.getValue();
				}
			});
			slider2.addChangeListener(
					new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					val2 = slider2.getValue();
				}
			});
			
			

			JFrame frame = new JFrame();
			Container cp = frame.getContentPane();
			cp.add(slider2,BorderLayout.SOUTH);
			cp.add(slider1,BorderLayout.NORTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			initialized = true;
		}
		pos1.setValue(val1);
		pos1.setNewValue(true);
		pos1.setValid(true);
		pos2.setValue(val2);
		pos2.setNewValue(true);
		pos2.setValid(true);

	}

}
