package usercode;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.osate.runtime.Output;

public class Interface {
	private static boolean initialized = false;
	private static int val1 = 0;
	private static int val2 = 0;
	private static boolean track1Enabled = false;
	private static boolean track2Enabled = false;
	private static boolean newValue = false;
	private static JSlider slider1;
	private static JSlider slider2;
	private static Label label1;
	private static Label label2;
	private static Checkbox checkbox1;
	private static Checkbox checkbox2;
	
	public static void start(LatencyValue pos1, LatencyValue pos2) {
		if (! initialized)
		{
			checkbox1 = new Checkbox ();
			checkbox2 = new Checkbox ();

			slider1 = new JSlider(JSlider.HORIZONTAL,0, 1000, 0);
			slider2 = new JSlider(JSlider.HORIZONTAL,0, 1000, 0);
			
			checkbox1.addItemListener(
					new ItemListener ()
					{

						@Override
						public void itemStateChanged(ItemEvent e) {
							track1Enabled = checkbox1.getState();
							
						}
						
					});
			checkbox2.addItemListener(
					new ItemListener ()
					{

						@Override
						public void itemStateChanged(ItemEvent e) {
							track2Enabled = checkbox2.getState();
							
						}
						
					});
			
			
			slider1.addChangeListener(
					new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					val1 = slider1.getValue();
					label1.setText(val1 + "ms");

				}
			});
			slider2.addChangeListener(
					new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					val2 = slider2.getValue();
					label2.setText(val2 + "ms");
				}
				
			});
			
			
			JLabel tmp = new JLabel ("Track1");
			FlowLayout fl = new FlowLayout ();
			JFrame frame = new JFrame();
			Container cp = frame.getContentPane();
			JPanel panel = new JPanel();
			label1 = new Label ("XXX ms");
			panel.add(checkbox1);
			panel.add(tmp);
			panel.add(slider1);
			panel.add(label1);
			cp.add(panel,BorderLayout.NORTH);
			
			
			 tmp = new JLabel ("Track2");
			label2 = new Label ("XXX ms");
			JPanel panel2 = new JPanel();
			panel2.add(checkbox2);
			panel2.add(tmp);
			panel2.add(slider2);
			panel2.add(label2);
			cp.add(panel2,BorderLayout.SOUTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			initialized = true;
		}
		
		
		pos1.setValue(val1);
		pos1.setNewValue(true);
		pos1.setValid(true);
		pos1.setEnable(track1Enabled);
		
		pos2.setValue(val2);
		pos2.setNewValue(true);
		pos2.setValid(true);
		pos2.setEnable(track2Enabled);

	}

}
