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
        int expectedLevel = player.getCurrentLevel().getLevel() + 1;

        player.addExp(player.getCurrentLevel().getExpToNextLevel());
        Assert.assertEquals(player.getCurrentLevel().getLevel(),expectedLevel);
        Assert.assertEquals(player.getHealth(),player.getMaxHealth());
    }

    @Test
    public void whenLevelUpThenMaxHealthIsIncreased(){
        int previousMaxHealth = player.getMaxHealth();
        player.addExp(player.getCurrentLevel().getExpToNextLevel());
        Assert.assertEquals(player.getMaxHealth(),previousMaxHealth + Player.healthGain);
    }

    @Test
    public void whenLevelUpThenHealthIsSetToMaxHealth(){
        player.setHealth(player.getHealth()/2);
        player.addExp(player.getCurrentLevel().getExpToNextLevel());
        Assert.assertEquals(player.getHealth(),player.getMaxHealth());
    }
    @Test
    public void whenLoadingPlayerAndSomeFieldsAreMissingThenReturnNull(){
        Player tmp = Player.loadPlayer("TestWronglySavedCharacter");
        Assert.assertNull(tmp);
    }
    @Test
    public void whenLoadingPlayerAndAllFieldsAreCorrectThenReturnPlayer(){
        Player tmp = Player.loadPlayer("TestProperlySavedCharacter");
        Assert.assertNotNull(tmp);
    }
}