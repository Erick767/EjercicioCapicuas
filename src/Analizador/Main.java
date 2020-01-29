/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.util.Scanner;

/**
 *
 * @author Erick
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creamos el objeto de la clase "Capicuas" y usar el metodo 'capicua' con el ingreso de cualquier numero
        Capicuas numeros = new Capicuas();
        
        System.out.println("Ingrese cualquier número:");
        Scanner ingresoNumero= new Scanner(System.in);
        long numero = ingresoNumero.nextLong();
        numeros.capicua(numero);
    }
    
}
