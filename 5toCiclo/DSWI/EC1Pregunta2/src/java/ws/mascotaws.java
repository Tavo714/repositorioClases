
package ws;

import java.util.*; 
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.mascota; 

@WebService(serviceName = "mascotaws")
public class mascotaws {

private static final Collection<mascota> itemsmascota = new ArrayList();
    static {
        
        mascota mascota1= new mascota(1, "Morocha", "Perro", new GregorianCalendar(2002,10,10).getTime(), new GregorianCalendar(2024,10,10).getTime(),"77777777", "Gustavo Valera", "Las Lomas Santa Ana");
        mascota mascota2 = new mascota(2, "Bobby", "Gato", new GregorianCalendar(2015, 5, 22).getTime(), new GregorianCalendar(2024, 6, 15).getTime(), "88888888", "Ana Gonzalez", "Av. San Felipe 102");
        mascota mascota3 = new mascota(3, "Luna", "Conejo", new GregorianCalendar(2018, 2, 8).getTime(), new GregorianCalendar(2024, 11, 12).getTime(), "99999999", "Carlos Pérez", "Calle Los Pinos 78");
        mascota mascota4 = new mascota(4, "Rocky", "Perro", new GregorianCalendar(2012, 7, 30).getTime(), new GregorianCalendar(2024, 9, 20).getTime(), "11111111", "Luis Mendoza", "Jr. Las Flores 354");
        mascota mascota5 = new mascota(5, "Max", "Gato", new GregorianCalendar(2010, 3, 12).getTime(), new GregorianCalendar(2024, 12, 5).getTime(), "22222222", "Elena Ramirez", "Calle Luna 23");
        mascota mascota6 = new mascota(6, "Simba", "Tortuga", new GregorianCalendar(2019, 1, 16).getTime(), new GregorianCalendar(2024, 8, 18).getTime(), "33333333", "Jorge Castro", "Pasaje Mirador 450");
        mascota mascota7 = new mascota(7, "Chispa", "Hamster", new GregorianCalendar(2021, 4, 5).getTime(), new GregorianCalendar(2024, 7, 25).getTime(), "44444444", "María López", "Av. Los Sauces 320");
        mascota mascota8 = new mascota(8, "Toby", "Perro", new GregorianCalendar(2016, 9, 21).getTime(), new GregorianCalendar(2024, 5, 10).getTime(), "55555555", "Ricardo Díaz", "Calle Central 89");   
        
    itemsmascota.add(mascota1);
    itemsmascota.add(mascota2);
    itemsmascota.add(mascota3);
    itemsmascota.add(mascota4);
    itemsmascota.add(mascota5);
    itemsmascota.add(mascota6);
    itemsmascota.add(mascota7);
    itemsmascota.add(mascota8);

    }
    
    @WebMethod(operationName = "lista")
    public Collection<mascota> listamedico(@WebParam(name = "codigo") String codigo) {
        return itemsmascota;
    }
}
