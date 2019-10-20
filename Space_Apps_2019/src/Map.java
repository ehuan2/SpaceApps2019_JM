import javax.swing.*;

public class Map {

    JFrame frame;
    JPanel panel;
    CityGame city;
    JButton nextYear;
    JLabel[] labels = new JLabel[11]; // 0 is morale, 1 is name, 2 is land, 3 is cost per meter, 4 is sea wall, 5 is year, 6 is level,
                                        // 7 is income, 8 is citizens, 9 is waterlevel, 10 is remaining level

    JButton buySeaWall;

    public Map(CityGame city1){

        frame = new JFrame();
        panel = new JPanel();
        city = city1;
        nextYear = new JButton("next year");
        buySeaWall = new JButton("buy sea wall");
        buySeaWall.addActionListener(e -> {

            city.addSeaWall(Integer.parseInt(JOptionPane.showInputDialog(null, "Add the extra wall height in")));

        });

        nextYear.addActionListener(e -> {

            city.changeYear();
            labels[0].setText("Morale " + Double.toString(city.morale));
            labels[1].setText("Name " + city.name);
            labels[2].setText("Land " + Double.toString(city.land));
            labels[3].setText("Cost per meter of the wall " + Double.toString(city.costPerMeter));
            labels[4].setText("Sea wall height  " + Double.toString(city.seaWall));
            labels[5].setText("Year " + Double.toString(city.year));
            labels[6].setText("Original sea level " + Double.toString(city.level));
            labels[7].setText("Income " + Double.toString(city.incomeTotal));
            labels[8].setText("Citizens " + Double.toString(city.citizens));
            labels[9].setText("Water level " + Double.toString(city.waterLevel));
            labels[10].setText("Remaining height " + Double.toString(city.level+city.seaWall-city.waterLevel));

            if(city.citizens == 0){

                JOptionPane.showMessageDialog(null, "All citizens are dead, you lasted to year " + city.year);

            }

        });

        panel.setLayout(null);

        for(int i = 0; i <= labels.length-1; i++){
            labels[i] = new JLabel();
            panel.add(labels[i]);
            labels[i].setBounds(200*(i/5 + 1), 70*(i%5), 300, 50); // this is where you guys figure it out
        }


        labels[0].setText("Morale " + Double.toString(city.morale));
        labels[1].setText("Name " + city.name);
        labels[2].setText("Land " + Double.toString(city.land));
        labels[3].setText("Cost per meter of the wall " + Double.toString(city.costPerMeter));
        labels[4].setText("Sea wall height  " + Double.toString(city.seaWall));
        labels[5].setText("Year " + Double.toString(city.year));
        labels[6].setText("Original sea level " + Double.toString(city.level));
        labels[7].setText("Income " + Double.toString(city.incomeTotal));
        labels[8].setText("Citizens " + Double.toString(city.citizens));
        labels[9].setText("Water level " + Double.toString(city.waterLevel));
        labels[10].setText("Remaining height " + Double.toString(city.level+city.seaWall-city.waterLevel));

        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,850);

        panel.add(nextYear);
        panel.add(buySeaWall);
        nextYear.setBounds(200,400,100,50);
        buySeaWall.setBounds(200, 400, 100, 50);

    }

}
