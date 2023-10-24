package com.platzi.market.persistence;

import com.platzi.market.dominian.Product;
import com.platzi.market.dominian.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
  ESTA Clase IMPLEMENTA de la INTERFAZ (dominio) Product.
  De esta manera NO le pega directo a la DB sino a travez del dominio(clase Product) antes nombrado
  ESTA clase es la q le pega a la DB(no directmnt)
  por eso le indico eso mediante @Repository; tamb se podría usar @Component
 */

@Repository
public class ProductoRepository implements ProductRepository {

    //creo un atributo/variable de Tipo de la clase Antes creada, para invocar sus metodos desde los
    //metodos propios de esta clase
    private ProductoCrudRepository productoCrudRepository;
    //llamo a ProductMapper --> para utilizarlo en el metodo getAll()
    private ProductMapper mapper;

    //metodo Q retorna una lista d todos los productos de la DB
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll(); //los () son para castear
        return mapper.toProducts(productos); //llamo a mapper con dicha funcion PARA la conversión
    }

    //metodo q retorna una lista de productos por categoría
    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoria(categoryId);//invoco el metodp creado en la clase productoCrudRepository
        return Optional.of(mapper.toProducts(productos));
    }

    //metodo para stock de productos
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        //la lista de productos q va dentro del Optional LA recupero de la DB
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        //como NO tengo una funcion Especifica desarrollada en ProductMapper como las anteriores
        //al Optional q cont la  lista de productos la mapeo y dentro llamo a la funcio q convierte toProducts
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
    }


    //busco prod por id
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    //metodo guardar un producto
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    //eliminar
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
