package MVPGame.parser.json;

import MVPGame.entities.Entity;
import MVPGame.entities.fightInterface.FightingInterface;
import MVPGame.entities.player.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by 20305 on 24.05.2017.
 */
public class CreatePlayerFromJson {
    public static Player create(String fileName){
        Player tmp;
//        Type genericType = new TypeToken<T>(){}.getType();
//        Class genericClass = new TypeToken<T>(){}.getClass();
        try {
            FileReader fileReader = new FileReader(ParsingPaths.RESOURCES_PATH + ParsingPaths.getClassResourcesPath(Player.class) + fileName + ".json");
            Gson gson = new GsonBuilder().registerTypeAdapter(FightingInterface.class, new InterfaceAdapter<FightingInterface>())
                    .create();
//            JsonParser parser = new JsonParser();
//            JsonObject data = parser.parse(response).getAsJsonObject();
            tmp = gson.fromJson(fileReader, Player.class);
            return tmp;
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
