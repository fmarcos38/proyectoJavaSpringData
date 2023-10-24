package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//esta interfaz q extiende de CrudRepository --> es la q hace de modelo PARA la CLASE PRODUCTOREPOSITORY
// recibe 2 parametros son: la tabla(a la q hace referenc), y el Tipo de la PK de dicha tabala
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //Metodo para retornar una Lista de productos q pertenenzcan a una derterm categoría
    //esto --> findByIdCategoria(int idCategoria) --> es construido mediante los metodos q proporciona -->
    //Spring Data Queries Methods --> ver pagina oficial
    List<Producto>findByIdCategoria(int idCategoria);

    //otra forma es con @Query() [esto es de manera nativa]
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true);
    //List<Producto>getByCategory(int idCategoria);//aquí el nombre del metodo , va cualquiera


    //metodo para retornar NO una lista SINO un TIPO optional(programacion funcional)
    //osea retorna un optional de tipo List
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
