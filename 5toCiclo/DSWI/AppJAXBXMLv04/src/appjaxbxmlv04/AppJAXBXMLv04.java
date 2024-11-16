
package appjaxbxmlv04;

import java.io.File;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import model.empleado;

public class AppJAXBXMLv04 {

    public static void main(String[] args) {
        
        empleado empleado1=new empleado(101,"Juan", "Zapata", new GregorianCalendar(2024, 02,22).getTime());
        
        try{
            File empleadoXML= new File("D:\\GITrepositories\\empleadov04.xml");
            JAXBContext jaxbContext= JAXBContext.newInstance(empleado.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(empleado1, empleadoXML);
            marshaller.marshal(empleado1, System.out);
        }
        catch(JAXBException e){
            e.printStackTrace();
        }        
    }    
}
