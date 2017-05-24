package MVPGame.parser.json;

/**
 * Created by 20305 on 24.05.2017.
 */
public class ParsingPaths {
    public static final String RESOURCES_PATH = "src/main/db/resources/";

    public static String getClassResourcesPath(Class c){
        return c.getSimpleName().toLowerCase() + "/";
    }

    public static String getObjectResourcesPath(Object o){
        return o.getClass().getSimpleName().toLowerCase() + "/";
    }


}
