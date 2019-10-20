import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Selector extends JPanel implements ActionListener
{
	JLabel Earth=new JLabel();
	Image Background, logo;
	Timer timer=new Timer(8, this);
	
	String[] AmericaCityNames={"Houston", "Miami", "Los Angeles", "New York City", "San Francisco", "Boston", "New Orleans", "Honolulu"};
	JButton[] AmericaCityButtons=new JButton[AmericaCityNames.length];
	
	String[] CanadaCityNames= {"St. Johns", "Vancouver", "Victoria", "Toronto"};
	JButton[] CanadaCityButtons=new JButton[CanadaCityNames.length];

	HashMap<String, Integer> map = new HashMap<>(){
		{

			for(int i = 0; i <= Main.cityNames.length-1; i++){

				put(Main.cityNames[i], i);

			}

		}
	};

	Color ocean=new Color(0, 105, 148);
	
	public Selector()
	{
		setSize(MainGUI.Width, MainGUI.Height);
		//Setting the layout of the panel to null (absolute positioning)
		setLayout(null);
		
		timer.start();
		
		createGUI();
	}

	public void createGUI()
	{
		
		int USButtonX=1100, USButtonY=140;
		
		for (int i=0; i<AmericaCityNames.length; i++)
		{
			AmericaCityButtons[i]=new JButton(AmericaCityNames[i]);
			AmericaCityButtons[i].setForeground(ocean);
			AmericaCityButtons[i].setContentAreaFilled(false);
			AmericaCityButtons[i].setFocusable(false);
			AmericaCityButtons[i].setFont(new Font("Dialog", Font.PLAIN, 18));
			AmericaCityButtons[i].setBounds(USButtonX, USButtonY, 175, 50);
			
			USButtonY+=60;
			final int index = map.get(AmericaCityNames[i]);
			AmericaCityButtons[i].addActionListener(e ->{

				City next = new City(Main.cityNames[index], Main.citySeaLvls[index], Main.cityEcons[index], Main.cityCitz[index], Main.seaWallHeight[index]);
				Map showMap = new Map(next);

			});
			add(AmericaCityButtons[i]);
		}
		
		int CAButtonX=125, CAButtonY=370;
		
		for (int i=0; i<CanadaCityNames.length; i++)
		{
			CanadaCityButtons[i]=new JButton(CanadaCityNames[i]);
			CanadaCityButtons[i].setForeground(ocean);
			CanadaCityButtons[i].setContentAreaFilled(false);
			CanadaCityButtons[i].setFocusable(false);
			CanadaCityButtons[i].setFont(new Font("Dialog", Font.PLAIN, 18));
			CanadaCityButtons[i].setBounds(CAButtonX, CAButtonY, 175, 50);

			CAButtonY+=60;
			final int index = map.get(CanadaCityNames[i]);
			CanadaCityButtons[i].addActionListener(e ->{

				City next = new City(Main.cityNames[index], Main.citySeaLvls[index], Main.cityEcons[index], Main.cityCitz[index], Main.seaWallHeight[index]);
				Map showMap = new Map(next);

			});
			add(CanadaCityButtons[i]);
		}

		JLabel NASA=new JLabel();
		NASA.setBounds(65, 50, 300, 150);
		logo=new ImageIcon(this.getClass().getResource("NASAlogo.png")).getImage();
		NASA.setIcon(new ImageIcon(resizeImage(logo, 300, 150)));
		add(NASA);
		
		//JLabel CAFlag=new JLabel();
		//CAFlag.setBounds(125, 340, 175, 50);
		//Image CAFlagImage=new ImageIcon(this.getClass().getResource("CAFlag.png")).getImage();
		
		//Earth.setBounds(0, 0, Main.Width, Main.Height);
		//Background=new ImageIcon(this.getClass().getResource("Google Earth, North America, Mr. Rungsun Klinkaeo, September 6, 2017..jpg")).getImage();
		//Earth.setIcon(new ImageIcon(resizeImage(Background, Main.Width, Main.Height)));
		//add(Earth);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Background=new ImageIcon(this.getClass().getResource("Google Earth, North America, Mr. Rungsun Klinkaeo, September 6, 2017..jpg")).getImage();
		g.drawImage(Background, 0, 0, MainGUI.Width, MainGUI.Height, this);
		
		Image CAFlag=new ImageIcon(this.getClass().getResource("CAFlag.png")).getImage();
		g.drawImage(CAFlag, 125, 260, 180, 90, this);
		
		Image USFlag=new ImageIcon(this.getClass().getResource("USA.png")).getImage();
		g.drawImage(USFlag, 1100, 35, 180, 90, this);
		
		//logo=new ImageIcon(this.getClass().getResource("NASAlogo.png")).getImage();
		//g.drawImage(logo, 50, 260, 300, 150, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==AmericaCityButtons[0])
		{
			
		}
		
		repaint();
	}
	
	public static Image resizeImage(Image img, int width, int height)
	{
		//This method takes in an image, width, and height and resizes that image to the specified width and height, and then returns the resized
		//image
		
		//Declaring an image called resizedImage and setting it equal to the parameter image scaled to the specified dimensions
		@SuppressWarnings("static-access")
		Image resizedImage=img.getScaledInstance(width, height, img.SCALE_SMOOTH);
		
		//returning the resized image
		return resizedImage;
	}
}
