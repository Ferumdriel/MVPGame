package MVPGame.game;

import MVPGame.entities.Entity;
import MVPGame.entities.creatures.Creature;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.BattleInitiator;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by nazwa on 2017-05-21.
 */
public class Game {
    Player player;
    boolean finish;

    public Game(Player player){
        this.player = player;
        finish = false;
    }

    public String listenToPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose action:");
        System.out.println("1. Heal");
        System.out.println("2. Fight");
        System.out.println("3. Exit");
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
        }else if (tmp.equals("3")){
            finish = true;
            System.out.println("Game has ended.");
        }
    }

    public void run(){
        while(!finish){
            pickEvent();
        }
    }
}
