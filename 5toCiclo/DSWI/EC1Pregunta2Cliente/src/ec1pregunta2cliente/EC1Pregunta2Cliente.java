
package ec1pregunta2cliente;

import java.util.Collection;
import ws.Mascota;

public class EC1Pregunta2Cliente {

    public static void main(String[] args) {
        
        Collection<Mascota> itemsmascota = lista("101");
        
        for (Mascota item : itemsmascota) {

            System.out.println("Id Mascota: " + item.getIdMascota());
            System.out.println("Nombre de la Mascota: " + item.getNombre());
            System.out.println("Tipo de Animal: " + item.getAnimal());
            System.out.println("Fecha de Nacimiento: " + item.getNacimiento());
            System.out.println("Fecha de Registro: " + item.getRegistro());
            System.out.println("DNI del dueño: " + item.getDni());
            System.out.println("Nombre del dueño: " + item.getDueño());
            System.out.println("Direccion: " + item.getDomicilio());
            System.out.println("\n");
        }

    }

    private static java.util.List<ws.Mascota> lista(java.lang.String codigo) {
        ws.Mascotaws_Service service = new ws.Mascotaws_Service();
        ws.Mascotaws port = service.getMascotawsPort();
        return port.lista(codigo);
    }
    
}
