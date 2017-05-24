package MVPGame.game;

import MVPGame.entities.player.Player;
import MVPGame.parser.json.CreatePlayerFromJson;

/**
 * Created by nazwa on 2017-05-21.
 */
public class Launcher {
    public static void main(String[] args){
        Game game = new Game();
//        Game game = new Game(new Player("Ferumdriel", 150));
        game.run();
    }

}
