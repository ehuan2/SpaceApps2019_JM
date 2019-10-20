
import javax.swing.*;
import java.awt.*;

public class MainGUI 
{

	static int Width=1400, Height=700;
	static VidIntro video;
	static JFrame frame=new JFrame();
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		createFrame();
	}
	
	public static void createFrame()
	{
		frame.setSize(Width, Height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		video=new VidIntro();
		
		frame.add(video);
		
		//Setting the frame's visibility to true
		frame.setVisible(true);
	}

}
