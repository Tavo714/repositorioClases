
package ec2gvpregunta4;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import model.pelicula;

public class unmarshalpelicula {
    
    public static void main(String[] args){
        
         try{
            File peliculaXML= new File("D:\\IDAT\\IDAT V - 2024\\Desarrollo de Servicios Web I\\Archivos EC3\\pelicula.xml");
            JAXBContext jaxbContext= JAXBContext.newInstance(pelicula.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            
            pelicula pelicula1=(pelicula)unmarshaller.unmarshal(peliculaXML);
            
            System.out.println("Datos de la Pelicula");
            System.out.println("Codigo: "+pelicula1.getCodigo());
            System.out.println("Generos: "+pelicula1.getGeneros());
            System.out.println("Pelicula: "+pelicula1.getNombre());
            System.out.println("Actor Principal: "+pelicula1.getActor());
            System.out.println("Actriz Principal: "+pelicula1.getActriz());
            System.out.println("Argumento: "+pelicula1.getArgumento());
            
        }
         catch(JAXBException e){
             e.printStackTrace();
         }
    }
    
}
