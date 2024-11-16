package ec3gvpregunta3parte2;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import model.prestamista;

public class EC3GVPregunta3parte2 {   
    
    public static void main(String[] args) {

        prestamista prestamista1 = new prestamista("77777777", "Gustavo Valera", new GregorianCalendar(2024, 10, 30).getTime(), "Administrador de Obra", "Administrador de Empresas", 10000);
        prestamista prestamista2 = new prestamista("88888888", "María Torres", new GregorianCalendar(2023, 5, 15).getTime(), "Ingeniera Civil", "Especialista en Gestión de Proyectos", 8500);
        prestamista prestamista3 = new prestamista("99999999", "José Martínez", new GregorianCalendar(2022, 2, 10).getTime(), "Arquitecto", "Diseñador de Interiores", 9500);
        prestamista prestamista4 = new prestamista("66666666", "Ana Gómez", new GregorianCalendar(2025, 8, 25).getTime(), "Contadora", "Asesora Financiera", 7800);
        prestamista prestamista5 = new prestamista("55555555", "Carlos Rivas", new GregorianCalendar(2023, 11, 5).getTime(), "Gerente de Proyectos", "Ingeniero Industrial", 9200);
        
        List<prestamista> prestamistas = new ArrayList<>();
        prestamistas.add(prestamista1);
        prestamistas.add(prestamista2);
        prestamistas.add(prestamista3);
        prestamistas.add(prestamista4);
        prestamistas.add(prestamista5);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {

            objectMapper.configure(Feature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File("D:\\IDAT\\IDAT V - 2024\\Desarrollo de Servicios Web I\\Archivos EC3\\prestamistas.json"), prestamistas);
            
            System.out.println(objectMapper.writeValueAsString(prestamistas));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }   
    
}
