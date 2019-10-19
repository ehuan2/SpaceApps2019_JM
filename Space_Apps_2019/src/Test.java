
public class Test {

    public static void main(String[]args){

        CityGame city = new CityGame("RosaCity", 100, 1000000, 1, 1, 100, 20, 1);

        for(int i = 0; i <= 10; i++){
            System.out.println("Year " + Integer.toString(i) + " " + city);
            city.changeYear();
        }
        System.out.println("Year 11 " + city);

    }

}
