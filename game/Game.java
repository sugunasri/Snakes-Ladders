package game;
import java.util.*;

import board.Board;
import player.Player;
import dice.Dice;
import jumper.Jumper;
import coordinates.Coordinates;

public class Game {
    Board board;
    ArrayList<Player> players;
    Dice dice;
    ArrayList<Coordinates> places;
    int turn;


    public Game(Board board,ArrayList<Player> players,Dice dice){
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.turn = 0;

        for(int i=0;i<players.size();i++){
            this.places = new ArrayList<>();
            Coordinates temp = new Coordinates(board.size-1, 0);
            this.places.add(temp);
        }
    }
    public void play(){
        int n = this.board.size;
        while(true){
            int num = this.dice.getroll();
            System.out.println("Player "+this.players.get(turn).getName()+" rolled: "+num);
            Coordinates curr = places.get(turn);
            int row = curr.getRow();
            int col = curr.getRow();
            int newp = Integer.parseInt(this.board.matrix[row][col]) +num;

            if(newp == n*n){
                Scanner scn = new Scanner(System.in);
                System.out.println("----GAME ENDS----");
                System.out.print(("player "+players.get(turn).getName()+" won the game"));
                System.out.println("Want to play one more game?(Y/n)");
                char ch = scn.nextLine().charAt(0);
                if(Character.toLowerCase(ch) == 'y'){
                    setback();
                    System.out.println("New Game starts: ");
                    play();
                }else{
                    break;
                }
            }
            if(newp > n*n){
                System.out.println("Your roll is exceeding.. wait for your next turn!");
                turn = (turn+1)%players.size();
                continue;
            }
            row = n-(newp/n)-1;
            col = newp%n;
            if(row%2==0){
                col = n-col-1;
            }
            places.set(turn,new Coordinates(row,col));
            if(this.board.jumpers.containsKey(newp+"")){
                Jumper temp = this.board.jumpers.get(newp+"");
                Coordinates c = temp.getEnd();
                newp = Integer.parseInt(this.board.matrix[c.getRow()][c.getCol()]);
                row = n-(newp/n)-1;
                col = newp%n;
                if(row%2==0){
                    col = n-col-1;
                }
                places.set(turn,new Coordinates(row,col));
            }

            turn = (turn+1)%this.players.size();
        }
    }
    private void setback(){
        this.places.clear();
        this.turn = 0;

    }

}
