/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaime andres
 */
public class DetalleFactura {
    
    private long id;
    private String producto;
    private int cantidad;
    private Double valor;
    private Factura factura;
    private List<Producto> listaProducto;

    public DetalleFactura(long id, String producto, int cantidad, Double valor) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public DetalleFactura(long id, String producto, int cantidad, Double valor, Factura factura) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.factura = factura;
    }
    
     public DetalleFactura(long id, String producto, int cantidad, Double valor, List<Producto> listaProducto) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.listaProducto = new ArrayList();
    }

    public DetalleFactura(long id, String producto, int cantidad, Double valor, Factura factura, List<Producto> listaProducto) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.factura = factura;
        this.listaProducto = listaProducto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", valor=" + valor + ", factura=" + factura + ", listaProducto=" + listaProducto + '}';
    }
}
