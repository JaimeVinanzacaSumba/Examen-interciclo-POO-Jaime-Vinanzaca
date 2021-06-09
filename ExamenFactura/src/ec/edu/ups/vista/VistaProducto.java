/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorDetalleFactura;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.modelo.Producto;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author jaime andres
 */
public class VistaProducto {
    
    private ControladorProducto controladorProducto;
    private ControladorDetalleFactura controladorDetalleFactura;
    private Scanner teclado;
    
    public VistaProducto (){
        this.controladorDetalleFactura = controladorDetalleFactura;
        controladorProducto = new ControladorProducto();
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opcion = 0;
        do {            
            System.out.println("Gestión del Producto");
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
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
                        this.imprimir(); 
                    break;
            }
        } while (opcion < 6);
    }
    
    public void crear(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese descripcion: ");
        String descripcion = teclado.nextLine();
        System.out.println("Precio Unitario: ");
        Double precioUnitario = teclado.nextDouble();
        System.out.println("Stock: ");
        int stock = teclado.nextInt();
        System.out.println("Iva: ");
        String iva = teclado.next();
        boolean resultado = controladorProducto.crear(descripcion, precioUnitario, stock, iva, controladorDetalleFactura.getSeleccionado());
        System.out.println("Creado: "+resultado);
        System.out.println("----------------------------------------------------");
    }
    
    public void actualizar(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese descripcion anterior: ");
        String descripcionAntigua = teclado.nextLine();
        System.out.println("Ingrese descripcion nueva: ");
        String descripcionNueva = teclado.nextLine();
        System.out.println("Precio Unitario: ");
        Double precioUnitario = teclado.nextDouble();
        System.out.println("Stock: ");
        int stock = teclado.nextInt();
        System.out.println("Iva: ");
        String iva = teclado.next();
        boolean resultado = controladorProducto.actualizar(descripcionAntigua, descripcionNueva, precioUnitario, stock, iva);
        System.out.println("Actualizado: "+resultado);
        System.out.println("----------------------------------------------------");
    }
    
    public Producto buscar(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese descripcion: ");
        String descripcion = teclado.nextLine();
        Producto producto = controladorProducto.buscar(descripcion);
        System.out.println(producto);
        return producto;
    }
    
    public void eliminar(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese descripcion: ");
        String descripcion = teclado.next();
        boolean resultado = controladorProducto.eliminar(descripcion);
    }
    
    public void imprimir(){
        System.out.println("-----------------------------------------------------");
        for(Producto producto : controladorProducto.getListaProducto()){
            System.out.println(producto);
        }
    }
    
    public void asignarSeleccionado (Producto producto){
        controladorProducto.setSeleccionado(producto);
    }

    public ControladorProducto getControladorProducto() {
        return controladorProducto;
    }

    public void setControladorProducto(ControladorProducto controladorProducto) {
        this.controladorProducto = controladorProducto;
    }

    public ControladorDetalleFactura getControladorDetalleFactura() {
        return controladorDetalleFactura;
    }

    public void setControladorDetalleFactura(ControladorDetalleFactura controladorDetalleFactura) {
        this.controladorDetalleFactura = controladorDetalleFactura;
    }
    
    
    
}
