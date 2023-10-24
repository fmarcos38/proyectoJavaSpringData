package com.platzi.market.persistence.mapper;

import com.platzi.market.dominian.Product;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})//como estoy usando como ATRIBUTO  target = "category" Y YA tiene su propio mapper USO el 2do param de @Mapper
public interface ProductMapper {

    //creo mapeador para producto
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),//para este atrib uso --> uses = {CategoryMapper.class}
    })
    Product toProduct(Producto producto);
    //creo mapeador para una Lista de (producto a product) <---es la conversión q realicé arriba
    List<Product> toProducts(List<Producto> productos);//no hace falta desarrollar nada YA q mapping SE da cuenta Q c/elemto de la lista es del tipo CREADO arriba

    //ahora realizo la conversión opuesta a lo de arriba
    //de product a producto
    //y una lista para dicho tipo de objeto
    @InheritInverseConfiguration
    //aqúi ignoramos el atributo CODIGO DE BARRAS q no lo utilizamos en el dominio
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);

}
