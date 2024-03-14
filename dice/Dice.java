package dice;
import java.util.Random;

public class Dice {
    private int roll;

    public Dice(){
        Random r = new Random();
        this.roll = r.nextInt(6)+1;
    }
    public int getroll(){
        Random r = new Random();
        this.roll = r.nextInt(6)+1;
        return this.roll;
    }
}
