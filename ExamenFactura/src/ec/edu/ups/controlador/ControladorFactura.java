/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.DetalleFactura;
import ec.edu.ups.modelo.Factura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jaime andres
 */
public class ControladorFactura {
    
    private List<Factura> listaFactura;
    private List<Cliente> listaCliente;
    private Factura seleccionado;
    
    public ControladorFactura(){
        listaFactura = new ArrayList();
        listaCliente = new ArrayList();
        seleccionado =  null;
    }
    
    public long generarId(){
        return (listaFactura.size() > 0)? listaFactura.get(listaFactura.size()-1).getId()+1 : 1;
    }
    
    public boolean crear(String fechaFactura, Double total, Cliente cliente){
        Factura factura = new Factura(this.generarId(), fechaFactura, total, cliente);
        
        return listaFactura.add(factura);
    }
    
    public Factura buscar(String fechaFactura){
        for(Factura dato : listaFactura){
            if(dato.getFechaFactura().equals(fechaFactura))
                return dato;
        }
        return null;
    }
    
    public boolean actualizar(String fechaFactura, Double total){
        Factura factura = this.buscar(fechaFactura);
        if(factura != null){
            int posicion = listaFactura.indexOf(factura);
            factura.setFechaFactura(fechaFactura);
            factura.setTotal(total);
            listaFactura.set(posicion, factura);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String fechaFactura){
        Factura factura = this.buscar(fechaFactura);
        if(factura != null){
            factura.getCliente().getListaFactura().remove(factura);
            return listaFactura.remove(factura);
        }
        return false;
    }
    
    
    public boolean agregarDetalleFactura(DetalleFactura detalleFactura){
        return seleccionado.getListaDetaelleFactura().add(detalleFactura);
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public Factura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Factura seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
    
    
}
