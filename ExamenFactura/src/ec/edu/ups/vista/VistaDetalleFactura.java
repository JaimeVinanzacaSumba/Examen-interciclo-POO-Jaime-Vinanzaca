/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorDetalleFactura;
import ec.edu.ups.controlador.ControladorFactura;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.DetalleFactura;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author jaime andres
 */
public class VistaDetalleFactura {
    
    private ControladorDetalleFactura controladorDetalleFactura;
    private ControladorFactura controladorFactura;
    private Scanner teclado;
    private SimpleDateFormat formatoFecha;
    public static String formato = "dd-MM-yyyy";
    
    public VistaDetalleFactura(){
        this.controladorFactura = controladorFactura;
        controladorDetalleFactura = new ControladorDetalleFactura();
        teclado = new Scanner(System.in);
        formatoFecha = new SimpleDateFormat(formato);
    }
    
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("------------------------------------------------"); 
            System.out.println("Gestion de Detalle de Facturas");
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
                case 5: this.imprimir();
                    break;
            }
        } while (opcion<6);
    }
    
    public void crear(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese los siguientes datos: ");
        System.out.println("Producto: ");
        String producto = teclado.next();
        System.out.println("Cantidad: ");
        int cantidad = teclado.nextInt();
        System.out.println("Valor: ");
        Double valor = teclado.nextDouble();
        boolean resultado = controladorDetalleFactura.crear(producto, cantidad, valor, controladorFactura.getSeleccionado());
        System.out.println("Creado: "+resultado);
        System.out.println("----------------------------------------------------");
    }
    
    public void actualizar(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese los datos a actualizar: ");
        System.out.println("Producto: ");
        String producto = teclado.next();
        System.out.println("Cantidad: ");
        int cantidad = teclado.nextInt();
        System.out.println("Valor: ");
        Double valor = teclado.nextDouble();
        boolean resultado = controladorDetalleFactura.actualizar(producto, cantidad, valor);
        System.out.println("Actualizado: "+resultado);
        System.out.println("----------------------------------------------------");
    }
    
    public DetalleFactura buscar(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese producto: ");
        String producto = teclado.next();
        DetalleFactura detalleFactura = controladorDetalleFactura.buscar(producto);
        System.out.println(detalleFactura);
        return detalleFactura;
    }
    
    public void eliminar(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese el producto: ");
        String producto = teclado.next();
        boolean resultado = controladorDetalleFactura.eliminar(producto);
    }
    
    public void imprimir(){
        for(DetalleFactura detalleFactura : controladorDetalleFactura.getListaDetalleFactura()){
            System.out.println(detalleFactura);
        }
    }
    
    public void asiganarSeleccionado(DetalleFactura detalleFactura){
        controladorDetalleFactura.setSeleccionado(detalleFactura);
    }

    public ControladorDetalleFactura getControladorDetalleFactura() {
        return controladorDetalleFactura;
    }

    public void setControladorDetalleFactura(ControladorDetalleFactura controladorDetalleFactura) {
        this.controladorDetalleFactura = controladorDetalleFactura;
    }

    public ControladorFactura getControladorFactura() {
        return controladorFactura;
    }

    public void setControladorFactura(ControladorFactura controladorFactura) {
        this.controladorFactura = controladorFactura;
    }
    
    
    
}


