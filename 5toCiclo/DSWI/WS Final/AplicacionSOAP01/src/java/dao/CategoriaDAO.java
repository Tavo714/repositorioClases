package dao;

import Wrappers.CategoriasWrapper;
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
import vo.CategoriaVO;

public class CategoriaDAO {
    private Connection connection;
    private PreparedStatement prepSt;
    private ResultSet rSet;
    public CategoriaDAO(){}
    
    public List<CategoriaVO> getAllCategorias(){
        List<CategoriaVO> Categorias = new ArrayList<>();
        try{
            connection = ConexionDb.MySQL();
            prepSt = connection.prepareStatement("SELECT * FROM categoria");
            rSet = prepSt.executeQuery();
            while(rSet.next()){
                CategoriaVO categoria = new CategoriaVO();
                categoria.setIdcategoria(rSet.getInt("idcategoria"));
                categoria.setDescat(rSet.getString("descat"));
                Categorias.add(categoria);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return Categorias;
    }
    public CategoriaVO getCategoriaById(int id){
        CategoriaVO categoria = null;
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("SELECT * FROM categoria WHERE idcategoria = ?");
            prepSt.setInt(1, id);
            rSet=prepSt.executeQuery();
            if(rSet.next()) {
                categoria =new CategoriaVO();                
                categoria.setIdcategoria(rSet.getInt("idcategoria"));
                categoria.setDescat(rSet.getString("descat"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return categoria;
    }
    public void insertCategoria(CategoriaVO categoria){
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("INSERT INTO categoria (descat) VALUES (?)");  
            prepSt.setString(1, categoria.getDescat());
            int rows=prepSt.executeUpdate();
            if(rows!=1)
            throw new Exception("Error al insertar!!!");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void updateCategoria(CategoriaVO categoria){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        CategoriaVO categeoriaExistente = categoriaDAO.getCategoriaById(categoria.getIdcategoria());
        if(categeoriaExistente !=null){
            try {
                connection=ConexionDb.MySQL();            
                prepSt=connection.prepareStatement("UPDATE categoria SET descat = ? WHERE idcategoria = ?"); 
                prepSt.setString(1, categoria.getDescat()!= null ? categoria.getDescat(): categeoriaExistente.getDescat());
                prepSt.setInt(2, categoria.getIdcategoria());
                
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
    public void deleteCategoria(Integer id) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        CategoriaVO categoriaExistente = categoriaDAO.getCategoriaById(id);
       
        if (categoriaExistente != null) {
            try {
                connection= ConexionDb.MySQL();
                prepSt = connection.prepareStatement("DELETE FROM categoria WHERE idcategoria = ?");
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
        List<CategoriaVO> categorias = new ArrayList<>();
        categorias = getAllCategorias();
        try{
            // Configura JAXBContext con la clase de la lista (CategoriaVO)
            JAXBContext jaxbContext = JAXBContext.newInstance(CategoriasWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 

            // Envuelve la lista en una clase auxiliar
            CategoriasWrapper wrapper = new CategoriasWrapper();
            wrapper.setCategorias(categorias);

            // Serializa la lista a un archivo XML
            marshaller.marshal(wrapper, new File("D:\\repositoriosRemotos\\WS\\XML\\categorias.xml"));

            // También imprime en consola el XML generado
            marshaller.marshal(wrapper, System.out);
            
        }
        catch(JAXBException e){
            e.printStackTrace();
        }
    }
    public void unmarshall() {
        try{
            File categoriasXML  = new File("D:\\repositoriosRemotos\\WS\\XML\\categorias.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(CategoriasWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            CategoriasWrapper wrapper = (CategoriasWrapper)unmarshaller.unmarshal(categoriasXML );
            
            System.out.println("Categorias:");
            System.out.println("===========");
            for (CategoriaVO categoria : wrapper.getCategorias()) {
                System.out.println("ID Categoria: " + categoria.getIdcategoria());
                System.out.println("Descripcion: " + categoria.getDescat());
                System.out.println("---------------------");
            }
        }
        catch(JAXBException e){
            e.printStackTrace();
        }  
    }
}