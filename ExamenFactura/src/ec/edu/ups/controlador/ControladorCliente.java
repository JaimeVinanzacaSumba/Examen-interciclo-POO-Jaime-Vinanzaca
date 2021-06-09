/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Factura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaime andres
 */
public class ControladorCliente {
    
    private List<Cliente> listaCliente;
    private Cliente seleccionado;
    
    public ControladorCliente() {
        listaCliente = new ArrayList<Cliente>();
        seleccionado = null;
    }
    
    public long generarId(){
        return (listaCliente.size() > 0)? listaCliente.get(listaCliente.size()-1).getId()+1 : 1;
    }
    
    public boolean crear(String nombre, String cedula, String fiabilidadDePago)
    {
        Cliente cliente = new Cliente(this.generarId(), nombre, cedula, fiabilidadDePago);
        return listaCliente.add(cliente);
    }
    
    public Cliente buscar(String Cedula) 
    {
        for(Cliente cliente : listaCliente) 
        {
            if(cliente.getCedula().equals(Cedula)) 
            {
                return cliente;
            }
        }
        return null;
    }
    
    public boolean actualizar(String nombre, String cedula, String fiabilidadDePago)
    {
        Cliente cliente = this.buscar(cedula);
        if(cliente != null)
        {
            int posicion = listaCliente.indexOf(cliente);
            cliente.setNombre(nombre);
            cliente.setCedula(cedula);
            cliente.setFiabilidadDePago(fiabilidadDePago);
            listaCliente.set(posicion, cliente);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String Cedula)
    {
        Cliente cliente = this.buscar(Cedula);
        if(cliente != null)
            return listaCliente.remove(cliente);
        return false;
    }
    
    public void imprimir(){
        for (Cliente client : listaCliente){
            System.out.println("cliente");
        }
    }
    
    public boolean agregarFactura(Factura factura){
        return seleccionado.getListaFactura().add(factura);
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Cliente seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
    
}
