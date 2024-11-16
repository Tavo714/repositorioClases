
package ec2gvpregunta4;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import model.pelicula;

public class EC2GVPregunta4 {

    public static void main(String[] args) {
        
        pelicula pelicula1=new pelicula(1,null, "Ben-Hur","Charlton Heston","Haya Harareet","A mi papi lo traiciona su best friend pero salio adelante a pesar de todo");
        
        pelicula1.setGeneros(new ArrayList<String>(){{
            add("Terror");
            add("Comedia");
            add("Accion");
            add("Aventuras");
            add("Sci-Fi");
        }});
        
        try{
            File peliculaXML= new File("D:\\IDAT\\IDAT V - 2024\\Desarrollo de Servicios Web I\\Archivos EC3\\pelicula.xml");
            JAXBContext jaxbContext= JAXBContext.newInstance(pelicula.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(pelicula1, peliculaXML);
            marshaller.marshal(pelicula1, System.out);
        }
        catch(JAXBException e){
            e.printStackTrace();
        }        
    }       
    
}
