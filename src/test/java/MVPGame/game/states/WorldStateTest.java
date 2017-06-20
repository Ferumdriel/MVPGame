package MVPGame.game.states;

import MVPGame.entities.player.Player;
import MVPGame.game.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 20305 on 20.06.2017.
 */
public class WorldStateTest {
    private Player player;
    private WorldState state;

    @Before
    public void setUp(){
        state = new WorldState(new Game());
        player = new Player("TestPlayer",100);
    }


    @Test
    public void whenPlayerChoosesHealThenHeal(){
        player.setHealth(player.getHealth()/2);
        int currentHealth = player.getHealth();
        state.getPicker().pickEvent(player, PlayerChoice.HEAL.getNumber());
        assertNotEquals(currentHealth, player.getHealth());
    }

}