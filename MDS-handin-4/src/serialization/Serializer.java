package serialization;

import java.io.*;
import javax.xml.bind.*;

public class Serializer implements Serializable {

    public static <T extends Serializable> String serialize(T serializable) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(serializable.getClass());
        StringWriter writer = new StringWriter();
        context.createMarshaller().marshal(serializable, writer);
        return writer.toString();
    }

    public static <T extends Serializable> T deSerialize(String xml, Class<T> target) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(target);
        return (T) context.createUnmarshaller().unmarshal(new StringReader(xml));
    }
}
