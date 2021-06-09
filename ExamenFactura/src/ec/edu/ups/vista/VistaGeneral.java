/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import java.util.Scanner;

/**
 *
 * @author jaime andres
 */
public class VistaGeneral {
    
    private Scanner teclado; 
    private VistaFactura vistaFactura;
    private VistaCliente vistaCliente;
    private VistaDetalleFactura vistaDetalleFactura;
    private VistaProducto vistaProducto;
    
    public VistaGeneral(){
        vistaCliente = new VistaCliente();
        vistaDetalleFactura = new VistaDetalleFactura();
        vistaProducto = new VistaProducto();
        vistaFactura = new VistaFactura(vistaCliente, vistaDetalleFactura, vistaProducto);
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("1.- Clientes");
            System.out.println("2.- Facturas");
            System.out.println("3.- Detalle Factura");
            System.out.println("4.- Productos");
            System.out.println("5.- Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    vistaCliente.menu();
                    break;
                case 2:
                    vistaFactura.menu();
                    break;
                case 3:
                    vistaDetalleFactura.menu();
                    break;
                case 4: 
                    vistaProducto.menu();
                    break;
            }
        }while(opcion<5);
    }
}
