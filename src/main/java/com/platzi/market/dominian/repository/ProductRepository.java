package com.platzi.market.dominian.repository;

import com.platzi.market.dominian.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    /*
      aquí Por ser una interfaz SOLO incluyo los nombres de los metodos
      q qremos q se utilicen con el manejo de PRODUCTOS
     */

    List<Product>getAll();
    Optional<List<Product>>getByCategory(int categoryID);
    Optional<List<Product>>getScarseProducts(int quantity);//quantity --> es la cantidad Q menor a eso debe de retornar
    Optional<Product> getProduct(int productId);

    //metodo guardar un producto
    Product save(Product product);

    void delete(int productId);
}
