import javax.swing.*;

public class ChooseCity
{
  //selector screen from the menu itself to the city choices, then to a zoomed in map/game itself, should include the creation of own city (possibly)

    JFrame frame;
    JPanel panel;
    JTextField txtName;
    JLabel lblName;
    JSpinner levelSpinner;
    JLabel lblLvl;
    JSpinner incomeSpinner;
    JLabel lblIn;
    JSpinner popSpinner;
    JLabel lblPop;
    JSpinner sWallSpinner;
    JLabel lblsWall;
    JSpinner landSpinner;
    JLabel lblLand;
    JSpinner costPerMeterSpinner;
    JLabel lblcpm;
    JSpinner minMoraleSpinner;
    JLabel lblMinMorale;
    JSpinner minCitizenSpinner;
    JLabel lblminCiti;
    JButton buttonEnter;

    public ChooseCity(){
        frame = new JFrame("Choose your own city!");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000,800);


        panel = new JPanel();
        panel.setLayout(null);

        frame.add(panel);

        txtName = new JTextField(30);
        lblName = new JLabel("Enter the name of your city: ");
        panel.add(lblName);
        panel.add(txtName);
        lblName.setBounds(50,50, 300, 50);
        txtName.setBounds(400, 50, 300, 50);

        levelSpinner = new JSpinner(new SpinnerNumberModel(0, -100, 1000, 1));
        lblLvl = new JLabel("Enter the meters above sea level that your city is at: ");
        panel.add(lblLvl);
        panel.add(levelSpinner);
        levelSpinner.setBounds(400, 120, 300, 50);
        lblLvl.setBounds(50, 120, 300, 50);

        incomeSpinner = new JSpinner(new SpinnerNumberModel(1000000, 5000, 3000000, 1000));
        lblIn = new JLabel("Enter the starting gdp of the city");
        panel.add(incomeSpinner);
        panel.add(lblIn);
        lblIn.setBounds(50,180, 300, 50);
        incomeSpinner.setBounds(400, 180, 300, 50);

        popSpinner = new JSpinner(new SpinnerNumberModel(1000, 1, 5000000, 100));
        lblPop = new JLabel("Enter the starting population size: ");
        panel.add(popSpinner);
        panel.add(lblPop);
        lblPop.setBounds(50,240, 300, 50);
        popSpinner.setBounds(400, 240, 300, 50);

        sWallSpinner = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
        lblsWall = new JLabel("Enter the starting height of the sea wall: ");
        panel.add(sWallSpinner);
        panel.add(lblsWall);
        lblsWall.setBounds(50,300, 300, 50);
        sWallSpinner.setBounds(400, 300, 300, 50);

        landSpinner = new JSpinner(new SpinnerNumberModel(100, 10, 1000, 10));
        lblLand = new JLabel("Enter the land area: ");
        panel.add(lblLand);
        panel.add(landSpinner);
        lblLand.setBounds(50,360, 300, 50);
        landSpinner.setBounds(400, 360, 300, 50);

        costPerMeterSpinner = new JSpinner(new SpinnerNumberModel(10000, 1000, 1000000, 1000));
        lblcpm = new JLabel("Enter the cost per meter of the wall: ");
        panel.add(lblcpm);
        panel.add(costPerMeterSpinner);
        lblcpm.setBounds(50,420, 300, 50);
        costPerMeterSpinner.setBounds(400, 420, 300, 50);

        minMoraleSpinner = new JSpinner(new SpinnerNumberModel(.5, 0.0, 1.0, 0.05));
        lblMinMorale = new JLabel("Enter the minimum morale (Citizen happiness) from a scale of 0 to 1.0 : ");
        panel.add(lblMinMorale);
        panel.add(minMoraleSpinner);
        lblMinMorale.setBounds(50,480, 300, 50);
        minMoraleSpinner.setBounds(400, 480, 300, 50);

        minCitizenSpinner = new JSpinner(new SpinnerNumberModel(40000, 10000, 1000000, 1000)); // citizen min. salary for happiness
        lblminCiti = new JLabel("Enter the salary that citizens would be happy with : ");
        panel.add(lblminCiti);
        panel.add(minCitizenSpinner);
        lblminCiti.setBounds(50,540, 300, 50);
        minCitizenSpinner.setBounds(400, 540, 300, 50);

        buttonEnter = new JButton("Enter");
        panel.add(buttonEnter);
        buttonEnter.setBounds(500,600, 100, 50);


    }

    public static void main(String[]args){
        ChooseCity cc = new ChooseCity();
    }


}
