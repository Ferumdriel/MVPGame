package MVPGame.game.states;

import MVPGame.entities.player.Player;
import MVPGame.game.Game;

import java.util.Scanner;

/**
 * Created by 20305 on 31.05.2017.
 */
public class LoginState implements StateInterface{
    private boolean finished;
    private Game game;

    public LoginState(Game game){
        this.game = game;
    }

    public Player preparePlayer(){
        Player player;
        System.out.println("Do you want to load your character? Yes/No");
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().equals("Yes")) {
            System.out.println("Type name of your character: ");
            player = Player.loadPlayer(sc.nextLine());
            if(player == null){
                System.out.println("Player not found. Starting new game. Choose character's nickname.");
                player = new Player(sc.nextLine(),100);
            }
        }else{
            System.out.println("Starting new game. Choose character's nickname.");
            player = new Player(sc.nextLine(),100);
        }
        return player;
    }

    public void run(){
        game.setPlayer(preparePlayer());
        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }
}
