package jumper;
import coordinates.Coordinates;

public class Jumper {
    Coordinates start;
    Coordinates end;
    String name;

    public Jumper(Coordinates s,Coordinates e){
        this.start = s;
        this.end = e;

        if(start.getRow() > end.getRow()) this.name = "Ladder";
        else {
            this.name = "Snake";
        }

    }
    public String JumpergetName() {
        return this.name;
    }
    public Coordinates getEnd(){
        return this.end;
    }
    public Coordinates getStart(){
        return this.start;
    }

}
