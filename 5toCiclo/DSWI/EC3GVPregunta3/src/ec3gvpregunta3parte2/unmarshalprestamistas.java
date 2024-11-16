package ec3gvpregunta3parte2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import model.prestamista;

public class unmarshalprestamistas {
    
    public static void main(String[] args) {
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {

            List<prestamista> prestamistas = objectMapper.readValue(
                new File("D:\\IDAT\\IDAT V - 2024\\Desarrollo de Servicios Web I\\Archivos EC3\\prestamistas.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, prestamista.class)
            );

            System.out.println("Lista de Prestamistas:");
            for (prestamista p : prestamistas) {
                System.out.println("DNI: " + p.getDni());
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Fecha de Ingreso: " + p.getIngreso());
                System.out.println("Ocupacion: " + p.getCargo());
                System.out.println("Profesión: " + p.getTitulo());
                System.out.println("Salario: " + p.getSueldo());
                System.out.println("---------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
