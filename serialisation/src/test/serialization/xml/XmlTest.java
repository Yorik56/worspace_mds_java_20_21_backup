package test.serialization.xml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import test.serialization.xml.entities.Class1;

public class XmlTest {

  public static void main(String[] args) throws Exception {
    Class1 class1 = new Class1() {
      {
        setId(10);
        setProp1("prop1");
        setProp2(true);
      }
    };

    // SÚrialisation XML simple
    // NÚcessite l'annotation @XmlRootElement
    JAXBContext jaxbContext = JAXBContext.newInstance(Class1.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    StringWriter sw1 = new StringWriter();
    jaxbMarshaller.marshal(class1, sw1);
    String xmlStringC1 = sw1.toString();
    sw1.close();

    System.out.println(xmlStringC1);

    StringReader sr1 = new StringReader(xmlStringC1);
    Class1 c1Test = JAXB.unmarshal(sr1, Class1.class);
    sr1.close();
    System.out.println(c1Test);
  }
}