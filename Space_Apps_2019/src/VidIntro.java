import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class VidIntro extends JPanel implements ActionListener
{
	Image image;
	ImageIcon imageIcon;
	Timer timer=new Timer(10, this);
	double secs=0.00;
	
	Rectangle boundsOfImage;
	
	int height;
	int width;
	int imageHeight;
	int imageWidth;
	
	static Selector selectorObject;
	
	public VidIntro()
	{
		setSize(MainGUI.Width, MainGUI.Height);
		setLayout(null);
		setBackground(Color.WHITE);
		
		imageHeight=MainGUI.Height;
		imageWidth=MainGUI.Width;
		
		//height=(200-imageHeight)/2;
		//width=(170-imageWidth/2);

		imageIcon=new ImageIcon("ezgif.com-video-to-.gif");
		image=imageIcon.getImage();
		
		boundsOfImage=new Rectangle(width, height, imageWidth, imageHeight);
		
		timer.start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(image,  height,  width,  imageWidth,  imageHeight,  this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if (secs>=4.28)
		{
			timer.stop();
			
			selectorObject=new Selector();
			MainGUI.frame.remove(MainGUI.video);
			MainGUI.frame.add(selectorObject);
		}
		
		secs+=0.01;
	}

}
