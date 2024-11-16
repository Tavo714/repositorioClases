package ec2gvpregunta4parte2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import model.servicio;

public class unmarshalservicio {
    
    public static void main(String[] args) {
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            List<servicio> servicios = objectMapper.readValue(
                new File("D:\\IDAT\\IDAT V - 2024\\Desarrollo de Servicios Web I\\Archivos EC3\\servicios.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, servicio.class)
            );

            System.out.println("Lista de Servicios:");
            for (servicio s : servicios) {
                System.out.println("ID: " + s.getId());
                System.out.println("String: " + s.getDescripcion());
                System.out.println("Precio: " + s.getImporte());
                System.out.println("Fecha: " + s.getFecha());
                System.out.println("Descripción: " + s.getBeneficio());
                System.out.println("---------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
