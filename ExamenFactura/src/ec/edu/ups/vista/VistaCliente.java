/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorFactura;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Factura;
import java.util.Scanner;

/**
 *
 * @author jaime andres
 */
public class VistaCliente {
    
    private Scanner teclado;
    private ControladorFactura controladorFactura;
    private ControladorCliente controladorCliente;

    public VistaCliente (){
        this.teclado = new Scanner(System.in);
        this.controladorCliente = new ControladorCliente();
        this.controladorFactura = controladorFactura;
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("------------------------------------------------");
            System.out.println("Gestion de Clientes");
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
            System.out.println("------------------------------------------------");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: 
                    this.crear();
                break;
                case 2:
                    this.actualizar();
                break;
                case 3:
                    this.buscar();
                break;
                case 4:
                    this.eliminar();
                break;
                case 5: 
                    System.out.println("listado de Clientes: ");
                    controladorCliente.imprimir();
            }
        }while(opcion < 6);
    }
    
    public void crear(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese los suuiguinetes datos: ");
        System.out.println("Id: ");
        long id = teclado.nextLong();
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Cedula: ");
        String cedula = teclado.next();
        System.out.println("Fiabilidad de pago: ");
        String fiabilidad = teclado.next();
        boolean resultado = controladorCliente.crear(nombre, cedula, fiabilidad);
        System.out.println("Cliente creado: "+resultado);
        System.out.println("----------------------------------------------------");
    }
    
    public void actualizar(){
        System.out.println("----------------------------------------------------");
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Cedula: ");
        String cedula = teclado.next();
        System.out.println("Fiabilidad: ");
        String fiabilidad = teclado.next();
        boolean resultado = controladorCliente.actualizar(nombre, cedula, fiabilidad);
        System.out.println("Cliente actualizado: "+resultado);
        System.out.println("----------------------------------------------------");
    }
    
    public void eliminar(){
        System.out.println("----------------------------------------------------");
        System.out.println("Eliminar cliente");
        System.out.println("Cedula: ");
        String cedula = teclado.next();
        boolean resultado = controladorCliente.eliminar(cedula);
        System.out.println("Cliente eliminado: "+resultado);
        System.out.println("----------------------------------------------------");
    }
    
    public Cliente buscar(){
        System.out.println("----------------------------------------------------");
        System.out.println("Cedula: ");
        String cedula = teclado.next();
        Cliente cliente = controladorCliente.buscar(cedula);
        System.out.println(cliente);
        return cliente;
    }
    
    public void asignarSeleccionado(Cliente cliente){
        controladorCliente.setSeleccionado(cliente);
    }

    public ControladorCliente getControladorCliente() {
        return controladorCliente;
    }

    public void setControladorCliente(ControladorCliente controladorCliente) {
        this.controladorCliente = controladorCliente;
    }
    
    public ControladorFactura getControladorFactura() {
        return controladorFactura;
    }

    public void setControladorFactura(ControladorFactura controladorFactura) {
        this.controladorFactura = controladorFactura;
    }
    
    
}
