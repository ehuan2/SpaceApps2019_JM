
public class CityGame extends City {

    // the citygame is part of city, but has added stuff like citizen happiness
    // economy at a level, citizen

    int morale;
    double growth; // economic growth
    double growthCitizens; // growth rate of citizens
    int land; // land mass
    int birthRate; // birth rate
    int deathRate; // death rate
    int tempRise = 3; // temp rise based on how well the economy is doing, affects sea level

    // turn based year, by 1 year
    public void changeYear(){
        // birth rate and death rates are functions of the income per capita and canada's gdp
            // canada's gdp per capita is 46213, our birth rate is 10/1000 and the death rate is 9/1000
        birthRate = 10/(1000/46213*incomePerCapita); // needs to add the rate difference based on the land mass/pop density
        deathRate = 9/(1000/46213*incomePerCapita); // needs to add the rate difference based on the land mass/pop density
        growthCitizens = (birthRate-deathRate)/citizens;

        land -= (level-seaWall > 0) ?
        tempRise +=

    }


}
