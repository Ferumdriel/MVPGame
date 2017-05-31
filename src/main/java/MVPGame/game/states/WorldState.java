package MVPGame.game.states;

import MVPGame.entities.Entity;
import MVPGame.entities.creatures.Creature;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.BattleInitiator;
import MVPGame.game.Game;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by 20305 on 25.05.2017.
 */
public class WorldState implements StateInterface{
    private Game game;
    private boolean finished;

    public WorldState(Game game){
        this.game = game;
    }

    private void pickEvent(Player player){
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
            finished = true;
            System.out.println("Game has ended.");
        }
    }

    private String listenToPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose action:");
        System.out.println("1. Heal");
        System.out.println("2. Fight");
        System.out.println("3. Save");
        System.out.println("4. Exit");
        return sc.nextLine();
    }

    public void run() {
        pickEvent(game.getPlayer());
    }

    public boolean isFinished() {
        return finished;
    }
}
