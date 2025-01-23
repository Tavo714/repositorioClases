package ws;

import dao.CategoriaDAO;
import dao.PedidoDAO;
import dao.Pedido_ProductoDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import vo.CategoriaVO;
import vo.PedidoVO;
import vo.Pedido_ProductoVO;

@WebService(serviceName = "soap01")
public class soap01 {

    private final PedidoDAO pedidoDAO= new PedidoDAO();
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();
    private final Pedido_ProductoDAO pedidoProductoDAO = new Pedido_ProductoDAO();
    
     //Pedidos
    @WebMethod(operationName = "listarPedidos")
    public List<PedidoVO> listarPedidos(){
        return pedidoDAO.getAllPedidos();
    }
    @WebMethod(operationName = "obtenerPedido")
    public PedidoVO obtenerPedido(@WebParam(name = "id") int id){
        return pedidoDAO.getPedidoById(id);
    }
    //Obtener Pedidos Segun el proveedor:
    @WebMethod(operationName = "obtenerPedidosProveedor")
    public List<PedidoVO> obtenerPedidosProveedor(@WebParam(name = "idproveedor") int idproveedor){
        return pedidoDAO.getPedidoByIdproveedor(idproveedor);
    }
    //
    @WebMethod(operationName = "insertPedido")
    public int insertPedido(@WebParam(name = "pedido") PedidoVO pedido){
        return pedidoDAO.insertPedido(pedido);  
    }   
    @WebMethod(operationName = "updatePedido")
    public void updatePedido(@WebParam(name = "pedido") PedidoVO pedido, @WebParam(name = "total") double total){
        pedidoDAO.updatePedido(pedido, total);
    }
    @WebMethod(operationName = "deletePedido")
    public void deletePedido(@WebParam(name = "id") int id){
        pedidoDAO.deletePedido(id);
    }
    
    //Categorias
    @WebMethod(operationName = "listarCategorias")
    public List<CategoriaVO> listarCategorias(){
        return categoriaDAO.getAllCategorias();
    }
    @WebMethod(operationName = "obtenerCategoria")
    public CategoriaVO obtenerCategoria(@WebParam(name = "id") int id){
        return categoriaDAO.getCategoriaById(id);
    }
    @WebMethod(operationName = "insertCategoria")
    public void insertCategoria(@WebParam(name = "categoria") CategoriaVO categoria){
        categoriaDAO.insertCategoria(categoria);
    }   
    @WebMethod(operationName = "updateCategoria")
    public void updateCategoria(@WebParam(name = "categoria") CategoriaVO categoria){
        categoriaDAO.updateCategoria(categoria);
    }
    @WebMethod(operationName = "deleteCategoria")
    public void deleteCategoria(@WebParam(name = "id") int id){
        categoriaDAO.deleteCategoria(id);
    }
    
    //Pedido_Productos
    @WebMethod(operationName = "insertarProductosPedido")
    public void insertPedidoProducto(@WebParam(name = "pedido") PedidoVO pedido, @WebParam(name = "productosPedido") List<Pedido_ProductoVO> productosPedido){   
        int idPedido = insertPedido(pedido);
        double total = pedidoProductoDAO.insertPedidoProducto(idPedido, productosPedido);
        pedido.setIdpedido(idPedido);
        pedido.setTotal(total);
        pedidoDAO.updatePedido(pedido, total);    
    }
    
    @WebMethod(operationName = "listarProductosPedido")
    public List<Pedido_ProductoVO> listPedidoProducto(@WebParam(name = "idpedido") int idpedido){   
       return pedidoProductoDAO.listPedidoProductos(idpedido);
    }
//    @WebMethod(operationName = "updateProductosPedido")
//    public void updateProductosPedido(@WebParam(name = "pedido") int idpedido, @WebParam(name = "productosPedido") List<Pedido_ProductoVO> productosPedido){
//        pedidoProductoDAO.updatePedidoProducto(idpedido, productosPedido);
//    }
    @WebMethod(operationName = "deleteProductosPedido")
    public void deleteProductosPedido(@WebParam(name = "id") int idpedido){
        pedidoProductoDAO.deleteProductosDePedido(idpedido);
    }
    
    //MARSHALL
    
    @WebMethod(operationName = "marshallCategoria")
    public void marshallCategoria(){
        categoriaDAO.marshall();
    }
    @WebMethod(operationName = "marshallPedidos")
    public void marshallPedido(){
        pedidoDAO.marshall();
    }
    @WebMethod(operationName = "marshallPedidoProducto")
    public void marshallPedidoProductos(){
        pedidoProductoDAO.marshall();
    }
    
    //UNMARSHALL
    @WebMethod(operationName = "unmarshallCategoria")
    public void unmarshallCategoria(){
        categoriaDAO.unmarshall();
    }
    @WebMethod(operationName = "unmarshallPedidos")
    public void unmarshallPedido(){
        pedidoDAO.unmarshall();
    }
    @WebMethod(operationName = "unmarshallPedidoProducto")
    public void unmarshallPedidoProductos(){
        pedidoProductoDAO.unmarshall();
    }
    
}
