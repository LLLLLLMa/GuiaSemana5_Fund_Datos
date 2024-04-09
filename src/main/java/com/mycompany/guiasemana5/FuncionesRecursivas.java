/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guiasemana5;
import java.util.Scanner;

/**
 *
 * @author pclab0.pc24
 */
public class FuncionesRecursivas {
    
    private Scanner leer;
    
    public FuncionesRecursivas()
    {
        leer = new Scanner(System.in);
    }
    
    public int CantidadDigitos(int numero)
    {
        //Se comprueba si el numero es menor o igual a 0 para terminar la recursividad
        if (numero <= 0)
        {
            return 0;
        }
        else
        {
            //Se divide el numero por 10 y se vuelve a llamar a la funcion pero con el numero modificado,
            //como es un numero entero no pueden quedar decimales
            numero /= 10;
            return 1 + CantidadDigitos(numero);
        }
    }
    
    public int SumaDigitos(int numero)
    {
        //Se comprueba si el numero es menor o igual a 0 para terminar la recursividad.
        if (numero <= 0)
        {
            return 0;
        }
        else
        {
            //Se quita el digito del numero
            int digito = numero % 10;
            //Se le resta el digito al numero, para luego dividirlo por 10
            //esto se hace para obtener el mismo numero pero con un digito menos.
            numero -= digito;
            numero /= 10;
            //Se van sumando los digitos obtenidos del numero y se llama a la funcion
            //nuevamente pero ahora con el numero con un digito menos.
            return digito + SumaDigitos(numero);
        }
    }
    
    public int MaximoComunDivisor(int numero1, int numero2, int divisor)
    {
        //Comprobamos si el divisor actual divide ambos numeros para terminar la recursividad
        if (numero1 % divisor == 0 && numero2 % divisor == 0)
        {
            return divisor;
        }
        //En caso de no dividir ambos numeros, se vuelve a llamar a la funcion con un valor menos en el divisor
        else
        {
            return MaximoComunDivisor(numero1, numero2, divisor-1);
        }
    }
    
    public String CadenaInvertida(String cadena)
    {
        //Comprobamos si la cadena esta vacia para terminar la recursividad.
        if (cadena.isEmpty())
        {
            return "'";
        }
        else
        {
            //Tomamos el ultimo caracter de la cadena y lo guardamos en la variable lastChar
            char ultimoCaracter = cadena.charAt(cadena.length() - 1);
            
            //Ahora quitamos ese ultimo caracter de la cadena con la funcion
            //substrring que corta la cadena entre los indices que se indiquen
            //En este caso se corta la cadena desde el primer caracter hasta el penultimo
            String cadenaMenosUltimo = cadena.substring(0, cadena.length() - 1);
            
            //Se vuelve a llamar a la funcion sumando el ultimo caracter pero ahora como primer valor.
            return ultimoCaracter + CadenaInvertida(cadenaMenosUltimo);
        }
    }
}
