package MVPGame.game;

import MVPGame.entities.Entity;
import MVPGame.entities.creatures.Creature;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.BattleInitiator;
import MVPGame.game.states.LoginState;
import MVPGame.game.states.StateInterface;
import MVPGame.game.states.WorldState;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by nazwa on 2017-05-21.
 */
public class Game {
    private Player player;
    private boolean finish;
    private StateInterface currentState;

    public Game(){
        finish = false;
        currentState = new LoginState(this);
    }

    public String listenToPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose action:");
        System.out.println("1. Heal");
        System.out.println("2. Fight");
        System.out.println("3. Save");
        System.out.println("4. Exit");
        return sc.nextLine();
    }

    public void pickEvent(){
        String tmp = listenToPlayer();
        if(tmp.equals("1")) {
            player.setHealth(player.getMaxHealth());
            System.out.println("Player fully healed");
            System.out.println(player);
        }else if(tmp.equals("2")) {
            Random r = new Random();
            Entity creature = new Creature("Hiena Cmentarna", 100);
            BattleInitiator battleInitiator = new BattleInitiator(player, creature);
            battleInitiator.initiateBattle();
        }else if (tmp.equals("3")){
                player.savePlayer();
        }else if (tmp.equals("4")){
            finish = true;
            System.out.println("Game has ended.");
        }
    }

    public void prepareToLaunch(){
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
    }

    private boolean isGameDone(){
        return !currentState.isFinished() && player.isAlive();
    }

    public void run(){
        if(currentState instanceof LoginState){
            currentState.run();
            if(currentState.isFinished()) {
                setCurrentState(new WorldState(this));
            }
        }
        while(isGameDone()){
            currentState.run();
        }
        System.out.println("Game has ended");
    }

    private void setCurrentState(StateInterface state){
        currentState = state;
    }

    public boolean isFinish() {
        return finish;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }
}
