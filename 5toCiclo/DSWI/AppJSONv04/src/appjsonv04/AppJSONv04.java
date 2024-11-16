
package appjsonv04;

import java.io.*;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import model.area;


public class AppJSONv04 {

    public static void main(String[] args) {
        area area1= new area(101, "Informatica", 353535, null);
        
        area1.setEmpleados(new ArrayList<String>(){{
            add("Teresa");
            add("Francisco");
            add("Yuliana");
        }});
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try{
            objectMapper.configure(Feature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File("D:\\GITrepositories\\areav04.json"),area1);
            
            System.out.println(objectMapper.writeValueAsString(area1));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
