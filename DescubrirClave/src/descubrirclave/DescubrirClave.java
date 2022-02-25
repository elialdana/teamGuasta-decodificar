/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descubrirclave;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author TEAM GUASTA
 * @version 1
 * @fecha: 23/02/2022
 */
public class DescubrirClave {

    public static void main(String[] args) {
        int n=generarNumero();
//        Scanner reader = new Scanner(System.in);
//        System.out.printf("Ingrese un número: ");
//        n = reader.nextInt();
        factorizar(n);

    }

    static int cant_factores = 0;
    static boolean hay_factores = false;

    private static void factorizar(int n) {
        int productoria = 1;
        int copia_n = n;
        int factor_primo = 2;
        do {
            int resto = copia_n % factor_primo;
            if (resto == 0) {
                copia_n /= factor_primo;
                productoria *= factor_primo;
                cant_factores++;
            } else {
                if (cant_factores > 0) {
                    escribe_factor(factor_primo);

                }
                factor_primo = next(factor_primo);
            }
        } while (productoria != n);
        escribe_factor(factor_primo);
    }

    private static int next(int n) {
        do {
            n++;
        } while (!valido(n));
        return n;
    }

    private static boolean valido(int n) {
        if (n <= 0) {
            return false;
        }
        int cant_divisores = 0;
        boolean encontro_divisores = false;
        int limite = (int) sqrt(n);
        int i = 2;
        while (i <= limite && !encontro_divisores) {
            if (n % i == 0) {
                cant_divisores++;
                encontro_divisores = true;
            }
            i++;
        }
        if (cant_divisores > 0 || n == 1) {
            return false;
        }
        return true;
    }

    private static void escribe_factor(int factor_primo) {
        if (hay_factores) {
            System.out.printf("x");
        } else {
            hay_factores = true;
        }
        if (cant_factores == 1) {
            System.out.printf("%d", factor_primo);
        } else {
            System.out.printf("%d^%d", factor_primo, cant_factores);
        }
        cant_factores = 0;
    }
    
    
    
    private static int generarNumero(){
 
            
            
        int[] numeros = new int[50];
        int indice=0;
        for (int i = 1; i < 100; i++) {
            if( valido(i)){
                numeros[indice]=i;
                  System.out.println(indice);
                indice ++;
            }
            
            
        }
        int numeroAleatorio1 = (int) (Math.random()*indice);
         int numeroAleatorio2= (int) (Math.random()*indice);
        System.out.println("numeroAleatorio1 "+ numeroAleatorio1); 
        int n1 = getPrimo(numeros,numeroAleatorio1);
        int n2 = getPrimo(numeros,numeroAleatorio2);
        int r= n1 * n2;
        System.out.println(n1+ " X " +n2 +"= "+ r );
        return r;
    }
        private static int getPrimo(  int[] numeros ,int indice){
            
            return numeros[indice];
        }
}
