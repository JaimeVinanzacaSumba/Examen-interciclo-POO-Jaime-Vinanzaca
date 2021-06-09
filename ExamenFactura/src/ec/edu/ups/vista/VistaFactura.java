/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorFactura;
import ec.edu.ups.modelo.Factura;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jaime andres
 */
public class VistaFactura {
    
    private Scanner teclado;
    private ControladorCliente controladorCliente;
    private ControladorFactura controladorFactura;
    private VistaCliente vistaCliente;
    private VistaDetalleFactura vistaDetalleFactura;
    private VistaProducto vistaProducto;
    private SimpleDateFormat formatoFecha;
    public static String formato = "dd-MM-yyyy";

    public VistaFactura(VistaCliente vistaCliente, VistaDetalleFactura vistaDetalleFactura, VistaProducto vistaProducto) {
        controladorFactura = new ControladorFactura();
        this.vistaCliente = vistaCliente;
        this.vistaDetalleFactura = vistaDetalleFactura;
        this.vistaProducto = vistaProducto;
        teclado = new Scanner(System.in);
        formatoFecha = new SimpleDateFormat(formato);
    }
    
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    actualizar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    listar();
                    break;
                
            }
        } while (opcion < 6);
    }
    
    public void crear(){
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese fecha de emision de la Factura "+formato+" : ");
        String fechaFactura = teclado.nextLine();
        System.out.println("Total: ");
        Double total = teclado.nextDouble();
        //Date fechaFactura = formatoFecha.parse(teclado.nextLine());
        System.out.println("Creado: "+ controladorFactura.crear(fechaFactura, total, controladorCliente.getSeleccionado()));
        System.out.println("----------------------------------------------------");
    }
    
    public Factura buscar(){
        System.out.println("-----------------------------------------------------");
        System.out.println("Ingrese fecha "+formato+": ");
        String fechaFactura = teclado.nextLine();
        //Date fechaFactura = formatoFecha.parse(teclado.nextLine());
        Factura factura = controladorFactura.buscar(fechaFactura);
        controladorFactura.setSeleccionado(factura);
        System.out.println(factura);
        return factura;
    }
    
    public void actualizar(){
        Factura factura = buscar();
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese nueva fecha "+formato+": ");
        String fechaFactura = teclado.nextLine();
        System.out.println("Ingrese valor nuevo: ");
        Double valor = teclado.nextDouble();
        System.out.println("Resultado: "+controladorFactura.actualizar(fechaFactura, valor));
        System.out.println("----------------------------------------------------");
    }
    
    public void eliminar(){
        Factura factura = buscar();
        System.out.println("----------------------------------------------------");
        System.out.println("Resultado: "+ controladorFactura.eliminar(factura.getFechaFactura()));
        System.out.println("----------------------------------------------------");
    }
    
    public void listar(){
        System.out.println("----------------------------------------------------");
        for(Factura factura : controladorFactura.getListaFactura()){
            System.out.println("factura");
        }
        System.out.println("----------------------------------------------------");
    }
    
}
