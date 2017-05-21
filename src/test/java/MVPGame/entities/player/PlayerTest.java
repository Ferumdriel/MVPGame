package MVPGame.entities.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nazwa on 2017-05-21.
 */
public class PlayerTest {
    private Player player;

    @Before
    public void setUp(){
        player = new Player("TestPlayer", 100);
    }

    @Test
    public void whenExpIsAboveExpNeededToNextLevelThenLevelUp(){
        int expectedLevel = player.getLevel() + 1;

        player.addExp(player.getExpRange()[player.getLevel()]);
        Assert.assertEquals(player.getLevel(),expectedLevel);
        Assert.assertEquals(player.getHealth(),player.getMaxHealth());
    }

    @Test
    public void whenLevelUpThenMaxHealthIsIncreased(){
        int previousMaxHealth = player.getMaxHealth();
        player.addExp(player.getExpRange()[player.getLevel()]);
        Assert.assertEquals(player.getMaxHealth(),previousMaxHealth + Player.healthGain);
    }

    @Test
    public void whenLevelUpThenHealthIsSetToMaxHealth(){
        player.setHealth(player.getHealth()/2);
        player.addExp(player.getExpRange()[player.getLevel()]);
        Assert.assertEquals(player.getHealth(),player.getMaxHealth());
    }
}