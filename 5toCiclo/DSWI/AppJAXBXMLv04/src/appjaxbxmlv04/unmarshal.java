
package appjaxbxmlv04;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import model.empleado;

public class unmarshal {
    
    public static void main(String[] args){
        
         try{
            File empleadoXML= new File("D:\\GITrepositories\\empleadov04.xml");
            JAXBContext jaxbContext= JAXBContext.newInstance(empleado.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            
            empleado empleado1=(empleado)unmarshaller.unmarshal(empleadoXML);
            
            System.out.println("Datos del Empleado");
            System.out.println("ID Empleado: "+empleado1.getId_empleado());
            System.out.println("Nombre: "+empleado1.getNombre());
            System.out.println("Apellidos: "+empleado1.getApellidos());
            System.out.println("Fecha de Contrato: "+empleado1.getFecha_contrato());
            
        }
         catch(JAXBException e){
             e.printStackTrace();
         }
    }
}
