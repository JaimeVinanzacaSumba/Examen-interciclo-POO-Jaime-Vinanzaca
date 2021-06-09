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
public class Cliente 
{
    private long id;
    private String nombre;
    private String cedula;
    private String fiabilidadDePago;
    private Factura factura;
    private List<Factura> listaFactura;

    public Cliente(long id) {
        this.id = -1;
    }

    public Cliente(long id, String nombre, String cedula, String fiabilidadDePago) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.fiabilidadDePago = fiabilidadDePago;
        this.listaFactura = new ArrayList();
    }

    public Cliente(long id, String nombre, String cedula, String fiabilidadDePago, List<Factura> listaFactura) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.fiabilidadDePago = fiabilidadDePago;
        this.listaFactura = listaFactura;
    }
    
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFiabilidadDePago() {
        return fiabilidadDePago;
    }

    public void setFiabilidadDePago(String fiabilidadDePago) {
        this.fiabilidadDePago = fiabilidadDePago;
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }
    

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", fiabilidadDePago=" + fiabilidadDePago + ", listaFactura=" + listaFactura + '}';
    }

    
    
}
