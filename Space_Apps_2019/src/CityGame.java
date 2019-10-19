
public class CityGame extends City {

    // the citygame is part of city, but has added stuff like citizen happiness
    // economy at a level, citizen

    int morale;
    double growth; // economic growth
    double growthCitizens; // growth rate of citizens
    int land; // land mass
    int birthRate; // birth rate
    int deathRate; // death rate
    int tempRise; // temp rise based on how well the economy is doing, affects sea level

    // turn based year, by 1 year
    public void changeYear(){

        birthRate = 1;
        deathRate = 9/(1000/46213*incomePerCapita);
        growthCitizens = (birthRate-deathRate)/citizens;


    }


}
