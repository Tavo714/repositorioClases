
package appjsonv04;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import model.area;


public class unmarshal {
    
    public static void main(String[] args){
        
        ObjectMapper objectMapper = new ObjectMapper();
        
         try{
             area area1= objectMapper.readValue(new File("D:\\GITrepositories\\areav04.json"), area.class);
             
             System.out.println("Datos del Area");
             System.out.println("ID Area: "+area1.getId_area());
             System.out.println("Nombre: "+area1.getNombre());
             System.out.println("Telefono: "+area1.getTelefono());
             System.out.println("Empleados: "+area1.getEmpleados());

        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
