package com.platzi.market.persistence.entity;

import javax.persistence.*;

//esta clase posee una PK compuesta --> por ende debo crear una clase para dicha PK y luego la invoco desde
//esta clase
@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId //clave compuesta
    private ComprasProductoPK id; //clase creada aparte posee 2 atributos ID compra y ID producto

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    //atributo para relacion many to one con compra
    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    //atributo para relacion many to one con compra
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;


    //get y set
    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
