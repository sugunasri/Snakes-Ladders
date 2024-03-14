package coordinates;

public class Coordinates {
    int row;
    int col;

    
    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return this.col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Coordinates(int r,int c){
        this.row = r;
        this.col = c;
    }

    public String printCoordinates() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.row).append(",").append(this.col).append("]");
        return sb.toString();
    }
}
