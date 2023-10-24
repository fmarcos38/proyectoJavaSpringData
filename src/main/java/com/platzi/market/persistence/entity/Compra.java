package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="compras")
public class Compra {

    @Column(name="id_compra")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    @Column(name="id_cliente")
    private Integer idCliente;

    private LocalDate fecha;

    @Column(name="medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    //atributo para relacion Muchas compras a un cliente
    @ManyToOne
    @JoinColumn(name="id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    //atributo relacion con compraProductos (osea los productos de una compra)
    //Genero una lista de productos
    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> productos;

    //get and set
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
