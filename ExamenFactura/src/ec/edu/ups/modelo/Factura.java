/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jaime andres
 */
public class Factura{
    
    private long id;
    private String fechaFactura;
    private Double total;
    private Cliente cliente;
    private List<DetalleFactura> listaDetaelleFactura;

    public Factura(long id, String fechaFactura, Double total) {
        this.id = id;
        this.fechaFactura = fechaFactura;
        this.total = total;
    }
    
    public Factura(long id, String fechaFactura, Double total, Cliente cliente) {
        this.id = id;
        this.fechaFactura = fechaFactura;
        this.total = total;
        this.cliente = cliente;
        this.listaDetaelleFactura = new ArrayList();
    }

    public Factura(long id, String fechaFactura, Double total, Cliente cliente, List<DetalleFactura> listaDetaelleFactura) {
        this.id = id;
        this.fechaFactura = fechaFactura;
        this.total = total;
        this.cliente = cliente;
        this.listaDetaelleFactura = listaDetaelleFactura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getListaDetaelleFactura() {
        return listaDetaelleFactura;
    }

    public void setListaDetaelleFactura(List<DetalleFactura> listaDetaelleFactura) {
        this.listaDetaelleFactura = listaDetaelleFactura;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", fechaFactura=" + fechaFactura + ", total=" + total + ", cliente=" + cliente + ", listaDetaelleFactura=" + listaDetaelleFactura + '}';
    }

    

}
