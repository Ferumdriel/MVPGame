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
    }

    private boolean isGameDone(){
        return !currentState.isFinished();
    }

    public void run(){
        currentState = new LoginState(this);
        currentState.run();
        setCurrentState(new WorldState(this));

        while(isGameDone()){
            currentState.run();
        }
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
