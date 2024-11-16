
package ws;

import java.util.*; 
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.medico; 


@WebService(serviceName = "medicows")
public class medicows {
    
    private static final Collection<medico> itemsmedico = new ArrayList();
    static {
    
    medico medico1= new medico(1, "77777777", "Valera Mendoza", "Gustavo Andres","Ingeniero Medico", "Biomecanica", new GregorianCalendar(1986,25,05).getTime(), new GregorianCalendar(2024,9,10).getTime(), 10000.00);
    medico medico2= new medico(2, "88888888", "Dos Santos Aveiro", "Cristiano Ronaldo","Medicina Cardiaca", "Futbol Salubre", new GregorianCalendar(1985,11,04).getTime(), new GregorianCalendar(2024,3,01).getTime(), 7000.00);
    medico medico3 = new medico(3, "99999999", "Smith", "John", "Medicina General", "Neurología", new GregorianCalendar(1980,6,15).getTime(), new GregorianCalendar(2024,5,20).getTime(), 9000.00);
    medico medico4 = new medico(4, "11111111", "Doe", "Jane", "Pediatría", "Salud Infantil", new GregorianCalendar(1990,2,10).getTime(), new GregorianCalendar(2024,7,15).getTime(), 8500.00);
    medico medico5 = new medico(5, "22222222", "Lopez", "Maria", "Dermatología", "Cuidado de la piel", new GregorianCalendar(1987,9,8).getTime(), new GregorianCalendar(2024,12,01).getTime(), 9200.00);
    medico medico6 = new medico(6, "33333333", "Gonzalez", "Carlos", "Cardiología", "Salud Cardiaca", new GregorianCalendar(1983,4,22).getTime(), new GregorianCalendar(2024,10,25).getTime(), 9700.00);
    medico medico7 = new medico(7, "44444444", "Martinez", "Elena", "Oncología", "Tratamiento de cáncer", new GregorianCalendar(1982,3,17).getTime(), new GregorianCalendar(2024,8,12).getTime(), 9100.00);
    medico medico8 = new medico(8, "55555555", "Perez", "Fernando", "Ortopedia", "Cuidado de huesos", new GregorianCalendar(1986,1,30).getTime(), new GregorianCalendar(2024,6,5).getTime(), 8800.00);

    itemsmedico.add(medico1);
    itemsmedico.add(medico2);
    itemsmedico.add(medico3);
    itemsmedico.add(medico4);
    itemsmedico.add(medico5);
    itemsmedico.add(medico6);
    itemsmedico.add(medico7);
    itemsmedico.add(medico8);
    }
        
    @WebMethod(operationName = "lista")
    public Collection<medico> listamedico(@WebParam(name = "codigo") String codigo) {
        return itemsmedico;
    }
}
