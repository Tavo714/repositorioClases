package dao;

import Wrappers.PedidoProductoWrapper;
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
import vo.Pedido_ProductoVO;

public class Pedido_ProductoDAO {
   private Connection connection;
   private PreparedStatement prepSt;
   private ResultSet rSet;
    
   public double insertPedidoProducto(int idPedido, List<Pedido_ProductoVO> productosPedido){
       double total = 0;
       try {
            connection=ConexionDb.MySQL(); 
            prepSt=connection.prepareStatement("INSERT INTO pedido_producto (idpedido, idproducto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)");

            for (Pedido_ProductoVO productoPedido : productosPedido) {
                prepSt.setInt(1, idPedido);
                prepSt.setInt(2, productoPedido.getIdproducto());
                prepSt.setInt(3, productoPedido.getCantidad());
                prepSt.setDouble(4, productoPedido.getPrecio_unitario()); 
                prepSt.addBatch();
                total += productoPedido.getCantidad() * productoPedido.getPrecio_unitario();
            }
            int[] rows = prepSt.executeBatch(); // Ejecuta todas las inserciones en lote
            // Verifica si todas las inserciones se realizaron
            for (int row : rows) {
                if (row != 1) {
                throw new Exception("Error al insertar un producto del pedido.");
                }
            }   
        } catch (Exception ex) {}   
       return total;
   }
   
   public List<Pedido_ProductoVO> listPedidoProductos(int idPedido){
       List<Pedido_ProductoVO> productosPedido = new ArrayList<>();
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("SELECT * FROM pedido_producto WHERE idpedido = ?");
            prepSt.setInt(1, idPedido);
            rSet=prepSt.executeQuery();
            while(rSet.next()) {
                Pedido_ProductoVO productoPedido =new Pedido_ProductoVO();                
                productoPedido.setIdpedido(rSet.getInt("idpedido"));
                productoPedido.setIdproducto(rSet.getInt("idproducto"));
                productoPedido.setCantidad(rSet.getInt("cantidad"));
                productoPedido.setPrecio_unitario(rSet.getDouble("precio_unitario"));
                productosPedido.add(productoPedido);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return productosPedido;
   }
   public List<Pedido_ProductoVO> getAllPedidoProducto(){
        List<Pedido_ProductoVO> pedidosProductos = new ArrayList<>();
        try{
            connection = ConexionDb.MySQL();
            prepSt = connection.prepareStatement("SELECT * FROM pedido_producto");
            rSet = prepSt.executeQuery();
            while(rSet.next()){
                Pedido_ProductoVO pedidoProducto = new Pedido_ProductoVO();
                pedidoProducto.setIdpedido(rSet.getInt("idpedido"));
                pedidoProducto.setIdproducto(rSet.getInt("idproducto"));
                pedidoProducto.setCantidad(rSet.getInt("cantidad"));
                pedidoProducto.setPrecio_unitario(rSet.getDouble("precio_unitario"));
                
                pedidosProductos.add(pedidoProducto);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return pedidosProductos;
        
    }
//Actualizar
//   public void updateProductosPedido(int idPedido, List<Pedido_ProductoVO> productosPedido){
//        List<Pedido_ProductoVO> productosExist = listPedidoProductos(idPedido);
//        List<Pedido_ProductoVO> nuevosProductos = new ArrayList<>();
//       try {
//           for (Pedido_ProductoVO producto : productosPedido) {
//                boolean exists = productosExist.stream()
//                        .anyMatch(p -> p.getIdproducto() == producto.getIdproducto());
//                if (exists) {
//                    // Actualizar el producto si ya existe
//                    actualizarProducto(idPedido, producto);
//                } else {
//                    // Insertar el producto si no existe
//                    nuevosProductos.add(producto);
//                }
//            }
//       } catch (Exception ex) {
//           ex.printStackTrace();
//       }
//   }
   //Eliminar todos los productos de un pedido
   public void deleteProductosDePedido(int idPedido) {
       try {
           connection = ConexionDb.MySQL(); 
           prepSt = connection.prepareStatement("DELETE FROM pedido_producto WHERE idpedido = ?");
           prepSt.setInt(1, idPedido);
           int rows = prepSt.executeUpdate();
           if (rows == 0) {
               throw new Exception("Error al Eliminar los productos del pedido!!!");
           }
       } catch (Exception ex) {
           ex.printStackTrace();
       }
   }

//    private void actualizarProducto(int idPedido, Pedido_ProductoVO producto) {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    }
//
//    private void insertarProducto(int idPedido, Pedido_ProductoVO producto) {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    }
   
   public void marshall() {
        List<Pedido_ProductoVO> pedidosProductos = new ArrayList<>();
        pedidosProductos = getAllPedidoProducto();
        try{
            // Configura JAXBContext con la clase de la lista (CategoriaVO)
            JAXBContext jaxbContext = JAXBContext.newInstance(PedidoProductoWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 

            // Envuelve la lista en una clase auxiliar
            PedidoProductoWrapper wrapper = new PedidoProductoWrapper();
            wrapper.setPedidosProductos(pedidosProductos);

            // Serializa la lista a un archivo XML
            marshaller.marshal(wrapper, new File("D:\\repositoriosRemotos\\WS\\XML\\pedidos_productos.xml"));

            // También imprime en consola el XML generado
            marshaller.marshal(wrapper, System.out);
            
        }
        catch(JAXBException e){
            e.printStackTrace();
        }
    }
   public void unmarshall() {
        try{
            File pedidosProductosXML  = new File("D:\\repositoriosRemotos\\WS\\XML\\pedidos_productos.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(PedidoProductoWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            PedidoProductoWrapper wrapper = (PedidoProductoWrapper)unmarshaller.unmarshal(pedidosProductosXML );
            
            for (Pedido_ProductoVO pedidoProducto : wrapper.getPedidosProductos()) {
                System.out.println("Productos del Pedido: " + pedidoProducto.getIdpedido());
                System.out.println("========================");
                System.out.println("ID Producto: " + pedidoProducto.getIdproducto());
                System.out.println("Cantidad: " + pedidoProducto.getCantidad());
                System.out.println("Precio Unitario: " + pedidoProducto.getPrecio_unitario());
                System.out.println("---------------------");
            }
        }
        catch(JAXBException e){
            e.printStackTrace();
        }  
    }
   
}
