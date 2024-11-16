
package ec3gvpregunta3;

import java.io.File;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import model.prestamo;

public class EC3GVPregunta3 {

    public static void main(String[] args) {
                
        prestamo prestamo1=new prestamo(101, new GregorianCalendar(2024, 10,30).getTime(),"Gustavo Valera", 1000, 0.1, 10);
        
            try{
                File prestamoXML= new File("D:\\IDAT\\IDAT V - 2024\\Desarrollo de Servicios Web I\\Archivos EC3\\EC3prestamo.xml");
                JAXBContext jaxbContext= JAXBContext.newInstance(prestamo.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(prestamo1, prestamoXML);
                marshaller.marshal(prestamo1, System.out);
            }
            catch(JAXBException e){
                e.printStackTrace();
            }        
    }  

}
    

