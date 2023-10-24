package com.platzi.market.persistence.mapper;

import com.platzi.market.dominian.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")  //indico q es un mapeador con integracion de spring
public interface CategoryMapper {

    //creo conversor Recibe un obj de tipo Categoria
    //Category es el tipo q vamos a obtener del mapeador/conversor creado
    //osea vamso a convert una Categoria en Category
    //idCategoria --> viene de clase Categoria --> ubicada en carpeta entity
    //categoryId --> viene de clase Category --> ubicada en carpeta dominian

    @Mappings({
            //aqui expreso de donde tomo(source) y a donde dirijo(target --> manda a la Clase Category)
            //osea aquí DENTRO declaro los atributos de las clases PARA source los de Categoria y PARA target los de Category
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);//convierto de Categoria a Category


    @InheritInverseConfiguration//esto indica q la conversion es la inversa de la de arriba, no hace falta definir @Mappings
    @Mapping(target = "productos", ignore = true)//aquí expreso Q ignore este PARAMETRO Q SOLO ESTA EN LA CLASE CATEGORIA(NO VA A VENIR DE LA CLASE CATEGORY)
    Categoria toCategoria(Category category);//convierto de Category a Categoria


}
