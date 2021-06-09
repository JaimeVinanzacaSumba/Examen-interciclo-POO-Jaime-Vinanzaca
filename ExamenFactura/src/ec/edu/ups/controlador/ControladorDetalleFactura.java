/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.DetalleFactura;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaime andres
 */
public class ControladorDetalleFactura {
    
    private List<DetalleFactura> listaDetalleFactura;
    private DetalleFactura seleccionado;
    
    public ControladorDetalleFactura(){
        listaDetalleFactura = new ArrayList();
        seleccionado = null;
    }
    
    public long generarId(){
        return (listaDetalleFactura.size() > 0)? listaDetalleFactura.get(listaDetalleFactura.size()-1).getId()+1 : 1;
    }
    
    public boolean crear(String producto, int cantidad, Double valor, Factura factura){
        DetalleFactura detalleFactura = new DetalleFactura(this.generarId(), producto, cantidad, valor, factura);
        factura.getListaDetaelleFactura().add(detalleFactura);
        return listaDetalleFactura.add(detalleFactura);
    }
    
    public DetalleFactura buscar (String producto){
        for(DetalleFactura detalleFactura : listaDetalleFactura){
            if(detalleFactura.getProducto().equals(producto)){
                return detalleFactura;
            }
        }
        return null;
    }
    
    public boolean actualizar (String producto, int cantidad, Double valor){
        DetalleFactura detalleFactura = this.buscar(producto);
        if(detalleFactura != null){
            int posicion = listaDetalleFactura.indexOf(detalleFactura);
            detalleFactura.setProducto(producto);
            detalleFactura.setCantidad(cantidad);
            detalleFactura.setValor(valor);
            listaDetalleFactura.set(posicion, detalleFactura);
            return true;
        }
        return false;
    }
    
    public boolean eliminar (String producto){
        DetalleFactura detalleFactura = this.buscar(producto);
        if(detalleFactura != null)
            return listaDetalleFactura.remove(detalleFactura);
        return false;
    }
    
    public boolean agregarProducto(Producto producto){
        return seleccionado.getListaProducto().add(producto);
    }

    public List<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }

    public DetalleFactura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(DetalleFactura seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
        
}
