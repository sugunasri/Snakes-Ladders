package game;
import java.util.*;

import board.Board;
import player.Player;
import dice.Dice;
import coordinates.Coordinates;

public class Game {
    Board board;
    ArrayList<Player> players;
    Dice dice;
    ArrayList<Coordinates> places;
    int turn;
    ArrayList<Boolean> isallowed;


    public Game(Board board,ArrayList<Player> players,Dice dice){
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.turn = 0;
        this.places = new ArrayList<>();
        this.isallowed = new ArrayList<>();

        for(int i=0;i<players.size();i++){
            Coordinates temp = new Coordinates(board.size-1, 0);
            this.places.add(temp);
            this.isallowed.add(false);
        }
    }
    public void play() {
        Scanner scn = new Scanner(System.in);
        int n = this.board.size;
        while(true) {
            int row,col,pos;
            int num = this.dice.getroll();
            System.out.println(players.get(turn).getName() + " rolled -> " + num + places.get(turn).printCoordinates());
            if(isallowed.get(turn)){
                row = places.get(turn).getRow();
                col = places.get(turn).getCol();
                pos = Integer.parseInt(this.board.matrix[row][col]);

                if(pos+num == n*n){
                    System.out.println("----GAME ENDS----");
                    System.out.println("And the winner is "+players.get(turn).getName().toUpperCase());
                    pos += num;
                    System.out.println();
                    System.out.println("Want to play one more game?(Y/n)");
                    String check = scn.nextLine().toLowerCase();
                    if(check.equals("y")){
                        setback();
                        play();
                    }
                    return;
                }else if(pos+num >= n*n){
                    System.out.println("roll exceeded.. wait for your next turn");
                    turn = (turn+1)%players.size();
                    continue;
                }

                pos += num;

                if(this.board.jumpers.containsKey(pos+"")){
                    Coordinates end_Coordinates = this.board.jumpers.get(pos+"").getEnd();
                    row = end_Coordinates.getRow();
                    col = end_Coordinates.getCol();
                    places.set(turn, end_Coordinates);
                }else{
                    Coordinates new_pos = getplaces(pos);
                    row = new_pos.getRow();
                    col = new_pos.getCol();
                    places.set(turn, new_pos);
                }

            }  
            if(!isallowed.get(turn) && num == 1){
                isallowed.set(turn, true);
            }
            turn = (turn+1)%players.size();
        }
    }
    private void setback(){
        this.places.clear();
        this.turn = 0;
        this.isallowed.clear();
    }

    private Coordinates getplaces(int num){
        int n = this.board.size;
        int row, col;
        row = n - 1 - (num - 1) / n;
        if (row % 2 == 0) {
            col = (num - 1) % n;
        } else {
            col = n - 1 - ((num - 1) % n);
        }
    
        return new Coordinates(row, col);
    }

}