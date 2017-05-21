package MVPGame.game;

import MVPGame.entities.player.Player;

/**
 * Created by nazwa on 2017-05-21.
 */
public class Launcher {
    public static void main(String[] args){
        Game game = new Game(new Player("Ferumdriel", 150));
        game.run();
    }

}
