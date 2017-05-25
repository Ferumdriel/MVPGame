package MVPGame.parser.xml;

import MVPGame.parser.json.ParsingPaths;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by 20305 on 24.05.2017.
 */

//FIXME
public class CreateXmlFromObject {
    public static void create(Object o, String fileName){
        try {

            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            m.marshal(o, sw);
            String xmlString = sw.toString();

            File file = new File(ParsingPaths.RESOURCES_PATH + ParsingPaths.getObjectResourcesPath(o));
            file.mkdirs();
            FileWriter fileWriter = new FileWriter(file + "/" + fileName + ".xml");
            fileWriter.write(xmlString);
        }catch(JAXBException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
