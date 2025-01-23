package dao;

import dbase.ConexionDb;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import vo.EmpleadoVO;


public class EmpleadoDAO {
    private Connection connection;
    private PreparedStatement prepSt;
    private ResultSet rSet;
    
    public List<EmpleadoVO> getAllEmpleados(){
        List<EmpleadoVO> empleados = new ArrayList<>();
        try{
            connection = ConexionDb.MySQL();
            prepSt = connection.prepareStatement("SELECT * FROM empleado");
            rSet = prepSt.executeQuery();
            while(rSet.next()){
                EmpleadoVO empleado = new EmpleadoVO();
                empleado.setIdempleado(rSet.getInt("idempleado"));
                empleado.setNomemp(rSet.getString("nomemp"));
                empleado.setApeemp(rSet.getString("apeemp"));
                empleado.setDniemp(rSet.getString("dniemp"));
                empleado.setTelemp(rSet.getString("telemp"));
                empleado.setCoremp(rSet.getString("coremp"));  
                empleados.add(empleado);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return empleados;
    }
    public EmpleadoVO getEmpleadoById(int id){
        EmpleadoVO empleado = null;
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("SELECT * FROM empleado WHERE idempleado = ?");
            prepSt.setInt(1, id);
            rSet=prepSt.executeQuery();
            if(rSet.next()) {
                empleado =new EmpleadoVO();                
                empleado.setIdempleado(rSet.getInt("idempleado"));
                empleado.setNomemp(rSet.getString("nomemp"));
                empleado.setApeemp(rSet.getString("apeemp"));
                empleado.setDniemp(rSet.getString("dniemp"));
                empleado.setTelemp(rSet.getString("telemp"));
                empleado.setCoremp(rSet.getString("coremp")); 
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return empleado;
    }
    public void insertEmpleado(EmpleadoVO empleado){
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("INSERT INTO empleado (nomemp, apeemp, dniemp, telemp, coremp) VALUES (?, ?, ?, ?, ?)");  
            prepSt.setString(1, empleado.getNomemp());
            prepSt.setString(2, empleado.getApeemp());
            prepSt.setString(3, empleado.getDniemp());
            prepSt.setString(4, empleado.getTelemp());
            prepSt.setString(5, empleado.getCoremp());
            int rows=prepSt.executeUpdate();
            if(rows!=1)
            throw new Exception("Error al insertar!!!");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void updateEmpleado(int idempleado, EmpleadoVO empleado){
        EmpleadoVO empleadoExistente = getEmpleadoById(idempleado);
        if(empleadoExistente !=null){
            try {
                connection=ConexionDb.MySQL();            
                prepSt=connection.prepareStatement("UPDATE empleado SET nomemp = ?, apeemp = ?, dniemp = ?, telemp = ?, coremp = ? WHERE idempleado = ?"); 
                prepSt.setString(1, empleado.getNomemp()!= null ? empleado.getNomemp(): empleadoExistente.getNomemp());
                prepSt.setString(2, empleado.getApeemp()!= null ? empleado.getApeemp(): empleadoExistente.getApeemp());
                prepSt.setString(3, empleado.getDniemp()!= null ? empleado.getDniemp(): empleadoExistente.getDniemp());
                prepSt.setString(4, empleado.getTelemp()!= null ? empleado.getTelemp(): empleadoExistente.getTelemp());
                prepSt.setString(5, empleado.getCoremp()!= null ? empleado.getCoremp(): empleadoExistente.getCoremp());
                prepSt.setInt(6,idempleado);
                
                int rows = prepSt.executeUpdate();
                if(rows!=1)
                throw new Exception("Error al ACTUALIZAR!!!");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            
        }
    }
        public void deleteEmpleado(int id) {
        EmpleadoVO empleadoExistente = getEmpleadoById(id);
       
        if (empleadoExistente != null) {
            try {
                connection= ConexionDb.MySQL();
                prepSt = connection.prepareStatement("DELETE FROM empleado WHERE idempleado = ?");
                prepSt.setInt(1, id);  
                int rows = prepSt.executeUpdate();
                if (rows != 1) {
                    throw new Exception("Error al eliminar el pedido.");
                }  
                
            } catch (Exception ex) {
                ex.printStackTrace();
                }   
        } else {
            
        }
        
    }
    public List<EmpleadoVO> marshall() {
        List<EmpleadoVO> empleados = getAllEmpleados(); 
        ObjectMapper objectmapper = new ObjectMapper();
        try{
            objectmapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
            objectmapper.writeValue(new File("D:\\repositoriosRemotos\\WS\\JSON\\empleados.json"), empleados);
            System.out.println(objectmapper.writeValueAsString(empleados));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return empleados;
    }
    public void unmarshall() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            
            List<EmpleadoVO> empleados = objectMapper.readValue(
                new File("D:\\repositoriosRemotos\\WS\\JSON\\empleados.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, EmpleadoVO.class)
            );
            
            for (EmpleadoVO empleado : empleados) {
                System.out.println("Datos del Empleado \n ===============");
                System.out.println("ID Empleado: " + empleado.getIdempleado());
                System.out.println("Nombre del Empleado: " + empleado.getNomemp());
                System.out.println("Apellido del Empleado: " + empleado.getApeemp());
                System.out.println("DNI del empleado: " + empleado.getDniemp());
                System.out.println("Telefono del empleado: " + empleado.getTelemp());
                System.out.println("Correo del empleado: " + empleado.getCoremp());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
