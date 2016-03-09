package usercode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WheelInterface extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private double angleInDegrees = 1;
private Timer rotatingTimer;
private double toTurn = 0;

public void addIncrement (int n)
{
	toTurn = toTurn + (n * 10);
}

public WheelInterface() {
    rotatingTimer = new Timer(1, new ActionListener() {
        //            @Override
        public void actionPerformed(ActionEvent e)
        {
        	if (toTurn > 0)
        	{
        		angleInDegrees = angleInDegrees +1;
        		toTurn = toTurn - 1;
        	}
            if (angleInDegrees == 360) {
                angleInDegrees = 0;
            }
            repaint();
        }
    });
    
   
    rotatingTimer.setRepeats(false);
    rotatingTimer.start();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    rotatingTimer.stop();

    g2d.clearRect(0, 0, getWidth(), getHeight());
    g2d.setBackground(Color.white);
    g2d.setColor(Color.black);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
    g2d.setStroke(new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
    g2d.rotate(angleInDegrees * Math.PI / 180.0, getWidth() / 2, getHeight() / 2);
    g2d.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2 + 100, getHeight() / 2);
    //**************************************************************************************
    AffineTransform transformer = new AffineTransform();
    transformer.translate(5,5);
    transformer.scale(2,2);
    g2d.getTransform().concatenate(transformer);
    //***************************************************************************************
    g2d.dispose();
    rotatingTimer.start();
}
public void start(){
    rotatingTimer.start();
}
public void stop(){
  rotatingTimer.stop();
}

public static void main(String[] args) {
    final WheelInterface demo = new WheelInterface();
    Button btnStrat= new Button("Start"),btnStop= new Button("Stop");
    btnStrat.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	demo.addIncrement(1);
            demo.setVisible(true);
            //demo.start();
        }
    });
    btnStop.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            demo.stop();
            demo.setVisible(false);
        }
    });
    JFrame frame = new JFrame();
    Container cp = frame.getContentPane();
    cp.add(demo,BorderLayout.CENTER);
    cp.add(btnStrat,BorderLayout.NORTH);
    cp.add(btnStop,BorderLayout.SOUTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocation(500, 500);
    frame.setVisible(true);
}
}  