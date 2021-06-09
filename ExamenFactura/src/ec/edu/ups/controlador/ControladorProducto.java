/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.DetalleFactura;
import ec.edu.ups.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaime andres
 */
public class ControladorProducto {
    
    private List<Producto> listaProducto;
    private Producto seleccionado;
    
    public ControladorProducto(){
        listaProducto = new ArrayList();
        seleccionado = null;
    }
    
     public long generarId(){
        return (listaProducto.size() > 0)? listaProducto.get(listaProducto.size()-1).getId()+1 : 1;
    }
     
     public boolean crear (String descripcion, Double precioUnitario, int stock, String iva, DetalleFactura detalleFactura){
         Producto producto = new Producto(this.generarId(), descripcion, precioUnitario, stock, iva, detalleFactura);
         detalleFactura.getListaProducto().add(producto);
         return listaProducto.add(producto);
     }
     
     public Producto buscar (String descripcion){
         for(Producto producto : listaProducto){
             if(producto.getDescripcion().equals(descripcion)){
                 return producto;
             }
         }
         return null;
     }
     
     public boolean actualizar (String descripcionAnterior, String descripcion, Double precioUnitario, int stock, String iva){
         Producto producto = this.buscar(descripcionAnterior);
         if(producto != null){
             int posicion = listaProducto.indexOf(producto);
             producto.setDescripcion(descripcion);
             producto.setPrecioUnitario(precioUnitario);
             producto.setStock(stock);
             producto.setIva(iva);
             listaProducto.set(posicion, producto);
             return true;
         }
         return false;
     }
     
     public boolean eliminar (String descripcion){
         Producto producto = this.buscar(descripcion);
         if(producto != null){
             producto.getDetalleFactura().getListaProducto().remove(producto);
             return listaProducto.remove(producto);
         }
         return false;
     }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Producto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Producto seleccionado) {
        this.seleccionado = seleccionado;
    }
     
     
    
}
