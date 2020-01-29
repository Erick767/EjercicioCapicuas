/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

/**
 *
 * @author Erick
 */
public class Capicuas {

    public static int contador = 0; //Se crea una variable global para contar el número de iteraciones del método "capicua"

    public static void capicua(long numero) {  //método para valorar si el número ingresado es capicúa
        boolean confirma = false;
        long modulo = 0, suma = 0;
        long numeroA = sumaNumeros(numero); //llamamos al metodo para sumar el numero y su inverso (123 + 321)
        long numeroB = numeroA;
        contador++;
        //obtenemos el ultmo digito del numero ingresado para despues verificar que sea un numerp capicúa
        //en cada iteración quitamos ese digito y valoramos la siguiente cifra
        //(123--obtenemos 3, lo "eliminamos" asignandolo a otra variable)
        //(12--obtenemos 2, lo "eliminamos" asignandolo a otra variable)
        //(1--obtenemos 1)
        while (numeroA >= 10) { 
            modulo = numeroA % 10; 
            suma = modulo + suma * 10;
            numeroA = numeroA / 10;
        }
        //asignamos el ultmo digito del numero para que este al contrario (321)
        double sumModulos = suma * 10 + numeroA;
        //evaluamos el numero obtenido con el numero inicial, si coinciden es un numero capicúa
        if (sumModulos == numeroB) {
            confirma = true;
        }
        if (confirma == true) {
            System.out.println(numeroB + " " + contador);
        } else {                        //En caso de que no sea un numero capicúa se llama nuevamente al metodo "capicua" con el proceso de suma de digitos
            capicua(numeroB);
        }
    }
    
    //Metodo para invertir el numero original y poder realizar su suma
    private static long invertirNumero(long numero, long pos) {
        if (numero < 10) {
            return numero;
        } else {
            return (numero % 10) * potencia(pos) + (invertirNumero(numero / 10, pos - 1));
        }
    }

    private static long potencia(long pot) {
        long res = 1;
        for (int i = 1; i <= pot; i++) {
            res = res * 10;
        }
        return res;
    }

    //metodo para sumar los dos numeros que se generan al ingresar el numero original
    public static long sumaNumeros(long numero) {
        long primerNumero = numero;
        String posicion = String.valueOf(numero);
        long segundoNumero = invertirNumero(primerNumero, posicion.length() - 1);
        long res = primerNumero + segundoNumero;
        return res;
    }
    
}
