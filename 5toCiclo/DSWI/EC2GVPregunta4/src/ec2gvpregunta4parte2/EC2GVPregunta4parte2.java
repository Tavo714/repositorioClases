package ec2gvpregunta4parte2;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import model.servicio;

public class EC2GVPregunta4parte2 {
    
    public static void main(String[] args) {
 
        servicio servicio1 = new servicio(1, "Palomitas", 15.00, new GregorianCalendar(2024, 10, 30).getTime(), "Te llenan la panza pero te estafamos cobrando el 5000% del costo");
        servicio servicio2 = new servicio(2, "Amiguitas", 100.00, new GregorianCalendar(2024, 10, 29).getTime(), "Para que si te ve tu causa solo no piense que aun no te olvidas de ella");
        servicio servicio3 = new servicio(3, "Amiguitos", 5.00, new GregorianCalendar(2024, 10, 28).getTime(), "Como las amiguitas pero con presa");
        servicio servicio4 = new servicio(4, "Psicodelicos", 30.00, new GregorianCalendar(2024, 10, 27).getTime(), "Para que la vivas mejor que en 3D");
        servicio servicio5 = new servicio(5, "Baño", 7.00, new GregorianCalendar(2024, 10, 26).getTime(), "Papi, la cosa esta brava. Lleva tu propio papel.");

        List<servicio> servicios = new ArrayList<>();
        servicios.add(servicio1);
        servicios.add(servicio2);
        servicios.add(servicio3);
        servicios.add(servicio4);
        servicios.add(servicio5);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.configure(Feature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File("D:\\IDAT\\IDAT V - 2024\\Desarrollo de Servicios Web I\\Archivos EC3\\servicios.json"), servicios);

            System.out.println(objectMapper.writeValueAsString(servicios));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
