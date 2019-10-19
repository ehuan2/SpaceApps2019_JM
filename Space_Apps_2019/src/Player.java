
public class Player implements Comparable<Player>{ // this comparable is used for the leaderboard

    String name;
    int score;


    @Override
    public int compareTo(Player o) { // this compareTo is again, used for the Array.sort()
        return o.score - this.score;
    }

    public String toString(){

        return name + " " + score;

    }

}
