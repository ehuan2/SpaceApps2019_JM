
import java.awt.*;
import javax.swing.*;

import java.util.Timer;

public class Main {

    static JFrame frame = new JFrame();
    static JPanel sideBar = new JPanel(null);
    static JPanel mainPanel = new JPanel(null);
    static JSplitPane spliter = new JSplitPane();
    static JLabel seaLvl = new JLabel("Sea Level: ");
    static JLabel rising = new JLabel("Rate of Rising Water: ");
    static JLabel mAbove = new JLabel("Metres above sea level: ");
    static JButton btnNext = new JButton("Next Year");
    static JLabel popSize = new JLabel("Current Population: ");
    static JLabel currMoney = new JLabel("$");
    static JLabel citMor = new JLabel("Citizen Morale: ");
    static JButton upEcon = new JButton("Upgrade Economy");
    static JButton upWall = new JButton("Upgrade Sea Wall");
    static Image houst;// = new ImageIcon(Main.class.getResource("houston.PNG")).getImage();
    static Image johns;// = new ImageIcon(Main.class.getResource("stJohns.PNG")).getImage();
    static Image miami;// = new ImageIcon(Main.class.getResource("miami.PNG")).getImage();
    static Image losA;// = new ImageIcon(Main.class.getResource("losAngeles.PNG")).getImage();
    static Image nyc;// = new ImageIcon(Main.class.getResource("newYork.PNG")).getImage();
    static Image van;// = new ImageIcon(Main.class.getResource("vancouver.PNG")).getImage();
    static Image sanFran;// = new ImageIcon(Main.class.getResource("sanfran.PNG")).getImage();
    static Image bos;// = new ImageIcon(Main.class.getResource("boston.PNG")).getImage();
    static Image newOr;// = new ImageIcon(Main.class.getResource("newOrleans.PNG")).getImage();
    static Image vic;// = new ImageIcon(Main.class.getResource("vic.PNG")).getImage();
    static Image hon;// = new ImageIcon(Main.class.getResource("hono.PNG")).getImage();
    static Image tor;// = new ImageIcon(Main.class.getResource("toronto.PNG")).getImage();
    static Image choice;// = new ImageIcon(Main.class.getResource("choice.jpg")).getImage();
    static final Image[] CITY_PICS = {houst,johns,miami,losA,nyc,van,sanFran,bos,newOr,vic,hon,tor};
    static volatile CityGame userCity;
    static final int yearTime = 1;
    static City[] cities = new City[11];
    static String[] cityNames = {"Houston","St. Johns","Miami","Los Angeles","New York City","Vancouver","San " +
            "Fransisco","Boston","New Orleans","Victoria", "Honolulu","Toronto"};
    static int[] citySeaLvls = {32,35,2,87,10,52,16,43,-2,23,6,76};
    static int[] cityEcons = {50000000,50000000,100000000,15000000,60000000,50000000,60000000,20000000,110000000,
            60000000,80000000,20000000};
    static int[] cityCitz = {2000000,2000000,500000,3000000,1000000,6000000,1000000,2000000,500000,1000000,600000,
            3000000};
    static int[] seaWallHeight = {5,5,1,2,5,3,2,0,6,4,8,0};

    public static void main(String[] args) {

        //collecting images
        collImages();

        //filling cities with actual cities
        finCits();

        //user picked city
        //userCity = new CityGame(new City("Eric", 100, 10000000, 1000000, 0, 100, 100, 100, .8,choice);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Timing(), 0, yearTime*1000); //30 seconds

        setGUI();

    }

    static void collImages(){

        houst = new ImageIcon(Main.class.getResource("houston.PNG")).getImage();
        johns = new ImageIcon(Main.class.getResource("stJohns.PNG")).getImage();
        miami = new ImageIcon(Main.class.getResource("miami.PNG")).getImage();
        losA = new ImageIcon(Main.class.getResource("losAngeles.PNG")).getImage();
        nyc = new ImageIcon(Main.class.getResource("newYork.PNG")).getImage();
        van = new ImageIcon(Main.class.getResource("vancouver.PNG")).getImage();
        sanFran = new ImageIcon(Main.class.getResource("sanfran.PNG")).getImage();
        bos = new ImageIcon(Main.class.getResource("boston.PNG")).getImage();
        newOr = new ImageIcon(Main.class.getResource("newOrleans.PNG")).getImage();
        vic = new ImageIcon(Main.class.getResource("vic.PNG")).getImage();
        hon = new ImageIcon(Main.class.getResource("hono.PNG")).getImage();
        tor = new ImageIcon(Main.class.getResource("toronto.PNG")).getImage();
        choice = new ImageIcon(Main.class.getResource("choice.jpg")).getImage();
    }

    //initializing new cities
    static void finCits(){

        for (int i = 0; i < cities.length; i++){
            cities[i] = new City(cityNames[i],citySeaLvls[i],cityEcons[i],cityCitz[i], seaWallHeight[i],CITY_PICS[i]);
            System.out.println(cities[i]); //for testing purposes
        }


    }

    private static void setGUI(){

        frame.setSize(1400,700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sideBar.setBackground(new Color(128,128,128));

        spliter.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        spliter.setDividerLocation(1100);
        spliter.setLeftComponent(mainPanel);
        spliter.setRightComponent(sideBar);
        spliter.setEnabled(false);
        frame.add(spliter);

        seaLvl.setBounds(10,0,100,17);
        seaLvl.setFont(new Font("Dialog",Font.BOLD,16));
        mainPanel.add(seaLvl);

        mAbove.setBounds(860,0,200,17);
        mAbove.setFont(new Font("Dialog",Font.BOLD,16));
        mainPanel.add(mAbove);

        rising.setBounds(10,frame.getHeight()-10,100,17);
        rising.setFont(new Font("Dialog",Font.BOLD,16));
        mainPanel.add(rising);



    }
}
