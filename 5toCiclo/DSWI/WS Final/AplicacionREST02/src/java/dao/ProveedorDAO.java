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
import vo.ProveedorVO;


public class ProveedorDAO {
    private Connection connection;
    private PreparedStatement prepSt;
    private ResultSet rSet;
    
    public List<ProveedorVO> getAllProveedores(){
        List<ProveedorVO> proveedores = new ArrayList<ProveedorVO>();
        try{
            connection = ConexionDb.MySQL();
            prepSt = connection.prepareStatement("SELECT * FROM proveedor");
            rSet = prepSt.executeQuery();
            while(rSet.next()){
                ProveedorVO proveedor = new ProveedorVO();
                proveedor.setIdproveedor(rSet.getInt("idproveedor"));
                proveedor.setRazsocial(rSet.getString("razsocial"));
                proveedor.setRuc(rSet.getString("ruc"));
                proveedor.setTelefonocon(rSet.getString("telefonopro"));
                proveedor.setCorreopro(rSet.getString("correopro"));
                proveedor.setContacto(rSet.getString("contacto"));  
                proveedor.setTelefonopro(rSet.getString("telefonocon"));
                proveedor.setCorreocon(rSet.getString("correocon"));
                
                proveedores.add(proveedor);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return proveedores;
    }
    public ProveedorVO getProveedorById(int id){
        ProveedorVO proveedor = null;
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("SELECT * FROM proveedor WHERE idproveedor = ?");
            prepSt.setInt(1, id);
            rSet=prepSt.executeQuery();
            if(rSet.next()) {
                proveedor = new ProveedorVO();                
                proveedor.setIdproveedor(rSet.getInt("idproveedor"));
                proveedor.setRazsocial(rSet.getString("razsocial"));
                proveedor.setRuc(rSet.getString("ruc"));
                proveedor.setTelefonocon(rSet.getString("telefonopro"));
                proveedor.setCorreopro(rSet.getString("correopro"));
                proveedor.setContacto(rSet.getString("contacto"));  
                proveedor.setTelefonopro(rSet.getString("telefonocon"));
                proveedor.setCorreocon(rSet.getString("correocon"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return proveedor;
    }
    public void insertProveedor(ProveedorVO proveedor){
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("INSERT INTO proveedor (razsocial, ruc, telefonopro, correopro, contacto, telefonocon, correocon) VALUES (?, ?, ?, ?, ?, ?, ?)");  
            prepSt.setString(1, proveedor.getRazsocial());
            prepSt.setString(2, proveedor.getRuc());
            prepSt.setString(3, proveedor.getTelefonopro());
            prepSt.setString(4, proveedor.getCorreopro());
            prepSt.setString(5, proveedor.getContacto());
            prepSt.setString(6, proveedor.getTelefonocon());
            prepSt.setString(7, proveedor.getCorreocon());
            int rows=prepSt.executeUpdate();
            if(rows!=1)
            throw new Exception("Error al insertar!!!");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void updateProveedor(int idproveedor, ProveedorVO proveedor){
        ProveedorVO proveedorExistente = getProveedorById(idproveedor);
        if(proveedorExistente !=null){
            try {
                connection=ConexionDb.MySQL();            
                prepSt=connection.prepareStatement("UPDATE proveedor SET razsocial = ?, ruc = ?, telefonopro = ?, correopro = ?, contacto = ?, telefonocon = ?, correocon = ? WHERE idproveedor = ?"); 
                prepSt.setString(1, proveedor.getRazsocial()!= null ? proveedor.getRazsocial(): proveedorExistente.getRazsocial());
                prepSt.setString(2, proveedor.getRuc()!= null ? proveedor.getRuc(): proveedorExistente.getRuc());
                prepSt.setString(3, proveedor.getTelefonopro()!= null ? proveedor.getTelefonopro(): proveedorExistente.getTelefonopro());
                prepSt.setString(4, proveedor.getCorreopro()!= null ? proveedor.getCorreopro(): proveedorExistente.getCorreopro());
                prepSt.setString(5, proveedor.getContacto()!= null ? proveedor.getContacto(): proveedorExistente.getContacto());
                prepSt.setString(6, proveedor.getTelefonocon()!= null ? proveedor.getTelefonocon(): proveedorExistente.getTelefonocon());
                prepSt.setString(7, proveedor.getTelefonocon()!= null ? proveedor.getCorreocon(): proveedorExistente.getCorreocon());
                prepSt.setInt(8,idproveedor);
                
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
    public void deleteProveedor(int id) {
        ProveedorVO proveedorExistente = getProveedorById(id);
       
        if (proveedorExistente != null) {
            try {
                connection= ConexionDb.MySQL();
                prepSt = connection.prepareStatement("DELETE FROM proveedor WHERE idempleado = ?");
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
    public List<ProveedorVO> marshall() {
        List<ProveedorVO> proveedores = new ArrayList<>();
        proveedores = getAllProveedores();
        ObjectMapper objectmapper = new ObjectMapper();
        try{
            objectmapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
            objectmapper.writeValue(new File("D:\\repositoriosRemotos\\WS\\JSON\\proveedores.json"), proveedores);
            System.out.println(objectmapper.writeValueAsString(proveedores));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return proveedores;
    }
    public void unmarshall() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            
            List<ProveedorVO> proveedores = objectMapper.readValue(
                new File("D:\\repositoriosRemotos\\WS\\JSON\\proveedores.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, ProveedorVO.class)
            );
            
            for (ProveedorVO proveedor : proveedores) {
                System.out.println("Datos del Empleado \n =================");
                System.out.println("ID Proveedor: " + proveedor.getIdproveedor());
                System.out.println("Razon Social: " + proveedor.getRazsocial());
                System.out.println("RUC: " + proveedor.getRuc());
                System.out.println("Telefono del proveedor: " + proveedor.getTelefonopro());
                System.out.println("Correo del proveedor: " + proveedor.getCorreopro());
                System.out.println("Contacto del proveedor: " + proveedor.getContacto());
                System.out.println("Telefono del contacto: " + proveedor.getTelefonocon());
                System.out.println("Correo del contacto: " + proveedor.getCorreocon());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
}
