
package ec3gvpregunta3;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import model.prestamo;

public class unmarshalprestamo {
    
    public static void main(String[] args){
        
         try{
            File prestamoXML= new File("D:\\IDAT\\IDAT V - 2024\\Desarrollo de Servicios Web I\\Archivos EC3\\EC3Prestamo.xml");
            JAXBContext jaxbContext= JAXBContext.newInstance(prestamo.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            
            prestamo prestamo1=(prestamo)unmarshaller.unmarshal(prestamoXML);
            
            System.out.println("Datos del Prestamo");
            System.out.println("Numero del Prestamo: "+prestamo1.getNroprestamo());
            System.out.println("Fecha: "+prestamo1.getFechaprestamo());
            System.out.println("Nombre: "+prestamo1.getNombre());
            System.out.println("Importe: "+prestamo1.getImporte());
            System.out.println("Tasa de Interes: "+prestamo1.getInteres());
            System.out.println("Numero de Cuotas: "+prestamo1.getNrocuotas());
            
        }
         catch(JAXBException e){
             e.printStackTrace();
         }
    }
    
}
