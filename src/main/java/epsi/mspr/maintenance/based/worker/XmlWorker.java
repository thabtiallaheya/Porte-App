package epsi.mspr.maintenance.based.worker;

import epsi.mspr.maintenance.based.models.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlWorker {
    public static Document readFromXml(String filePath) throws JAXBException {
        File file = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Document) jaxbUnmarshaller.unmarshal(file);
    }
}