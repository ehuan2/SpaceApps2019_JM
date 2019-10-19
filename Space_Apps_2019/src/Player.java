
public class Player implements Comparable<Player>{

    String name;
    int score;


    @Override
    public int compareTo(Player o) {
        return o.score - this.score;
    }

    public String toString(){

        return name + " " + score;

    }

}
