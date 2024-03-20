import java.util.*;
import board.Board;
import dice.Dice;
import game.Game;
import player.Player;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to Snakes and Ladders!");
        ArrayList<Player> players = new ArrayList<>();
        System.out.print("Number of players: ");
        int n = scn.nextInt();
        while(n<2){
            System.out.println("You'll need minimum 2 players to play");
            System.out.print("Enter no.of players");
            n = scn.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.println("Enter "+ (i+1) +" player details");
            Player temp = new Player();
            players.add(temp);
        }
        Dice dice = new Dice();
        Board b = new Board(10);
        b.printBoard();
        Game g = new Game(b, players, dice);
        g.play();
    }
}
