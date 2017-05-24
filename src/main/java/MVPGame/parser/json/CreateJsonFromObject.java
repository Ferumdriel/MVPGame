package MVPGame.parser.json;

import MVPGame.entities.fightInterface.FightingInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 20305 on 24.05.2017.
 */
public class CreateJsonFromObject {
    public static void create(Object o, String fileName){
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(FightingInterface.class, new InterfaceAdapter<FightingInterface>())
                .create();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try{
            File file = new File(ParsingPaths.RESOURCES_PATH + ParsingPaths.getObjectResourcesPath(o));
            file.mkdirs();
            FileWriter fileWriter = new FileWriter(file + "/" + fileName + ".json");
            gson.toJson(o, fileWriter);
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
