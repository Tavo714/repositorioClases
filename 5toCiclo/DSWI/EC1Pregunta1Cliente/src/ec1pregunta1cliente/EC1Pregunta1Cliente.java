package ec1pregunta1cliente;

import java.util.Collection;
import ws.Medico;

public class EC1Pregunta1Cliente {

    public static void main(String[] args) {
        Collection<Medico> itemsmedico = lista("101");
        
        for (Medico item : itemsmedico) {
            double bonificacionFamiliar = item.getBasico() * 0.25; // 25% del sueldo básico
            double sueldoBruto = item.getBasico() + bonificacionFamiliar; // Sueldo Bruto = básico + bonificación
            double seguroSocial = sueldoBruto * 0.09; // 9% de descuento por seguro social
            double afp = sueldoBruto * 0.11; // 11% de descuento por AFP
            double descuentos = seguroSocial + afp; // Total descuentos
            double sueldoNeto = sueldoBruto - descuentos; // Sueldo Neto = Sueldo bruto - descuentos

            System.out.println("Id Medico: " + item.getIdMedico());
            System.out.println("DNI: " + item.getDni());
            System.out.println("Apellidos: " + item.getApellidos());
            System.out.println("Nombres: " + item.getNombres());
            System.out.println("Titulo: " + item.getTitulo());
            System.out.println("Especialidad: " + item.getEspecialidad());
            System.out.println("Fecha de Nacimiento: " + item.getNacimiento());
            System.out.println("Fecha de Ingreso: " + item.getIngreso());
            System.out.println("Sueldo Basico S/ " + item.getBasico());
            System.out.println("Bonificación Familiar S/ " + bonificacionFamiliar);
            System.out.println("Sueldo Bruto S/ " + sueldoBruto);
            System.out.println("Descuento Seguro Social (9%) S/ " + seguroSocial);
            System.out.println("Descuento AFP (11%) S/ " + afp);
            System.out.println("Total Descuentos S/ " + descuentos);
            System.out.println("Sueldo Neto S/ " + sueldoNeto);
            System.out.println("\n");
        }
    }

    private static java.util.List<ws.Medico> lista(java.lang.String codigo) {
        ws.Medicows_Service service = new ws.Medicows_Service();
        ws.Medicows port = service.getMedicowsPort();
        return port.lista(codigo);
    }
}
