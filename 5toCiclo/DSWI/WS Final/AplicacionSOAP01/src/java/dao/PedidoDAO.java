package dao;

import Wrappers.PedidoWrapper;
import dbase.ConexionDb;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import vo.PedidoVO;

public class PedidoDAO {
    private Connection connection;
    private PreparedStatement prepSt;
    private ResultSet rSet;
    public PedidoDAO(){}
    
    public List<PedidoVO> getAllPedidos(){
        List<PedidoVO> pedidos = new ArrayList<>();
        try{
            connection = ConexionDb.MySQL();
            prepSt = connection.prepareStatement("SELECT * FROM pedido");
            rSet = prepSt.executeQuery();
            while(rSet.next()){
                PedidoVO pedido = new PedidoVO();
                pedido.setIdpedido(rSet.getInt("idpedido"));
                pedido.setFecha(rSet.getString("fecha"));
                pedido.setIdempleado(rSet.getInt("idempleado"));
                pedido.setIdproveedor(rSet.getInt("idproveedor"));
                pedido.setEstado(rSet.getString("estado"));
                pedido.setTotal(rSet.getDouble("total"));
                pedidos.add(pedido);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return pedidos;
        
    }
    public PedidoVO getPedidoById(int id) {
        PedidoVO pedido = null;
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("SELECT * FROM pedido WHERE idpedido = ?");
            prepSt.setInt(1, id);
            rSet=prepSt.executeQuery();
            if(rSet.next()) {
                pedido =new PedidoVO();                
                pedido.setIdpedido(rSet.getInt("idpedido"));
                pedido.setFecha(rSet.getString("fecha"));
                pedido.setIdempleado(rSet.getInt("idempleado"));
                pedido.setIdproveedor(rSet.getInt("idproveedor"));
                pedido.setEstado(rSet.getString("estado"));
                pedido.setTotal(rSet.getDouble("total"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return pedido;
    }
    //Obtener Pedidos segun el proveedor:
    public List<PedidoVO> getPedidoByIdproveedor(int idproveedor) {
        List<PedidoVO> pedidos = new ArrayList<>();
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("SELECT * FROM pedido WHERE idproveedor = ?");
            prepSt.setInt(1, idproveedor);
            rSet=prepSt.executeQuery();
            while(rSet.next()) {
                PedidoVO pedido =new PedidoVO();                
                pedido.setIdpedido(rSet.getInt("idpedido"));
                pedido.setFecha(rSet.getString("fecha"));
                pedido.setIdempleado(rSet.getInt("idempleado"));
                pedido.setIdproveedor(rSet.getInt("idproveedor"));
                pedido.setEstado(rSet.getString("estado"));
                pedido.setTotal(rSet.getDouble("total"));
                pedidos.add(pedido);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return pedidos;
    }
    //Obtener ID del ultimo Pedido
    
//    public int getUltimoIDPedido() {
//        List<PedidoVO> pedidos = new ArrayList<>();
//        int idUltimoIDPedido = 0;
//        try {
//            connection = ConexionDb.MySQL();
//            prepSt = connection.prepareStatement("SELECT MAX(idpedido) AS max_id FROM pedido");
//            rSet = prepSt.executeQuery();
//
//            if (rSet.next()) {
//                idUltimoIDPedido = rSet.getInt("max_id"); 
//            }
//        }
//        catch(Exception ex){
//        }
//        return idUltimoIDPedido;
//    }
    
    public int insertPedido(PedidoVO pedido){
        int total = 0;
        int idPedido = -1;
        try {
            connection=ConexionDb.MySQL();            
            prepSt = connection.prepareStatement(
            "INSERT INTO pedido (fecha, idempleado, idproveedor, estado, total) VALUES (?, ?, ?, ?, ?)", 
            PreparedStatement.RETURN_GENERATED_KEYS);
            
            prepSt.setString(1, pedido.getFecha());
            prepSt.setInt(2, pedido.getIdempleado());
            prepSt.setInt(3, pedido.getIdproveedor());
            prepSt.setString(4, pedido.getEstado());
            prepSt.setDouble(5, total);
            int rows=prepSt.executeUpdate();
            ResultSet keys = prepSt.getGeneratedKeys();
            if (keys.next()) {  
                idPedido = keys.getInt(1); // Obtiene la primera clave generada
            }   
            if(rows!=1)
            throw new Exception("Error al insertar!!!");
            
        } catch (Exception ex) {}    
        return idPedido;
    }
    
    public void updatePedido(PedidoVO pedido, double total){
        PedidoDAO pedidoDAO = new PedidoDAO();
        PedidoVO pedidoExistente = pedidoDAO.getPedidoById(pedido.getIdpedido());
        if(pedidoExistente !=null){
            try {
                connection=ConexionDb.MySQL();            
                prepSt=connection.prepareStatement("UPDATE pedido SET fecha = ?, idempleado = ?, idproveedor = ?, estado = ?, total = ? WHERE idpedido = ?"); 
                prepSt.setString(1, pedido.getFecha() != null ? pedido.getFecha() : pedidoExistente.getFecha());
                prepSt.setInt(2, pedido.getIdempleado()!= null ? pedido.getIdempleado(): pedidoExistente.getIdempleado());
                prepSt.setInt(3, pedido.getIdproveedor() != null ? pedido.getIdproveedor() : pedidoExistente.getIdproveedor());
                prepSt.setString(4, pedido.getEstado() != null ? pedido.getEstado() : pedidoExistente.getEstado());
                prepSt.setDouble(5, pedido.getTotal() != null ? pedido.getTotal() : pedidoExistente.getTotal());
                prepSt.setInt(6, pedido.getIdpedido());
                
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
    
    public void deletePedido(Integer id) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        PedidoVO pedidoExistente = pedidoDAO.getPedidoById(id);
       
        if (pedidoExistente != null) {
            try {
                connection= ConexionDb.MySQL();
                prepSt = connection.prepareStatement("DELETE FROM pedido WHERE idpedido = ?");
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
    public void marshall() {
        List<PedidoVO> pedidos = new ArrayList<>();
        pedidos = getAllPedidos();
        try{
            // Configura JAXBContext con la clase de la lista (CategoriaVO)
            JAXBContext jaxbContext = JAXBContext.newInstance(PedidoWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 

            // Envuelve la lista en una clase auxiliar
            PedidoWrapper wrapper = new PedidoWrapper();
            wrapper.setPedidos(pedidos);

            // Serializa la lista a un archivo XML
            marshaller.marshal(wrapper, new File("D:\\repositoriosRemotos\\WS\\XML\\pedidos.xml"));

            // También imprime en consola el XML generado
            marshaller.marshal(wrapper, System.out);
            
        }
        catch(JAXBException e){
            e.printStackTrace();
        }
    }
    public void unmarshall() {
        try{
            File pedidosXML = new File("D:\\repositoriosRemotos\\WS\\XML\\pedidos.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(PedidoWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            PedidoWrapper wrapper = (PedidoWrapper) unmarshaller.unmarshal(pedidosXML);

            System.out.println("Pedidos:");
            System.out.println("===========");
            for (PedidoVO pedido : wrapper.getPedidos()) {
                System.out.println("ID Pedido: " + pedido.getIdpedido());
                System.out.println("Fecha: " + pedido.getFecha());
                System.out.println("Id Empleado: " + pedido.getIdempleado());
                System.out.println("Id Proveedor: " + pedido.getIdproveedor());
                System.out.println("Estado: " + pedido.getEstado());
                System.out.println("Total: " + pedido.getTotal());
                System.out.println("---------------------");
            }
        }
        catch(JAXBException e){
            e.printStackTrace();
        }  
    }
}
            
                
            
            
    

