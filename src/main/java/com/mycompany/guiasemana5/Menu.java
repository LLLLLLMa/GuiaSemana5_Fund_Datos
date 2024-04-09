/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guiasemana5;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author pclab0.pc24
 */
public class Menu {
    
    private Scanner leer;
    private FuncionesRecursivas funciones;
    
    public Menu()
    {
        leer = new Scanner(System.in);
        funciones = new FuncionesRecursivas();
    }
    
    public void MostrarOpciones()
    {
        System.out.println("========OPCIONES========");
        System.out.println("1.........Cantidad de digitos de un numero entero positivo");
        System.out.println("2.........Suma de los digitos de un numero entero positivo");
        System.out.println("3.........MCD de dos numero enteros positivos");
        System.out.println("4.........Invertir cadena ingresada");
        System.out.println("5.........Salir");
        int opcion = ValidarOpcion();
        Opcion(opcion);
    }
    
    public void Opcion(int opcion)
    {
        switch (opcion)
        {
            //CASO CANTIDAD DE DIGITOS
            case 1:
                //Se obtiene un numero valido con la funcion.
                int cantidadDigitos = ObtenerNumeroValidado();
                //Se muestra la cantidad de digitos
                System.out.println("La cantidad de digitos de su numero es: " + funciones.CantidadDigitos(cantidadDigitos));
                //Se vuelve a llamar a MostrarOpciones() para que se vuelva a ingresar una opcion si se desea
                MostrarOpciones();
                break;
                
            //CASO SUMA DE DIGITOS
            case 2:
                //Se obtiene un numero valido con la funcion.
                int suma = ObtenerNumeroValidado();
                //Se muestra la suma de los digitos
                System.out.println("La suma de los digitos de su numero es: " + funciones.SumaDigitos(suma));
                //Se vuelve a llamar a MostrarOpciones() para que se vuelva a ingresar una opcion si se desea
                MostrarOpciones();
                break;
            
            //CASO MCD DE DOS NUMEROS
            case 3:
                //Se obtiene un numero valido con la funcion.
                int num1 = ObtenerNumeroValidado();
                
                //En el caso de MCD no se puede aceptar que uno de los numeros sea 0
                //En caso de ser 0 se muestra el error y se vuelve a pedir un numero con la funcion.
                while (num1 == 0)
                {
                    System.out.println("Error, sus numero para MCD no pueden contener un 0, vuelva a ingresar el numero");
                    num1 = ObtenerNumeroValidado();
                }
                
                //Se obtiene un numero valido con la funcion.
                int num2 = ObtenerNumeroValidado();
                
                //En el caso de MCD no se puede aceptar que uno de los numeros sea 0
                //En caso de ser 0 se muestra el error y se vuelve a pedir un numero con la funcion.
                while (num2 == 0)
                {
                    System.out.println("Error, sus numero para MCD no pueden contener un 0, vuelva a ingresar el numero");
                    num2 = ObtenerNumeroValidado();
                }
                
                //Para optimizar se comienza del numero que sea menor entre ambos.
                int numeroMenor = num1 <= num2 ? num1 : num2;
                
                //Se muestra el MCD
                System.out.println("El MCD de sus numeros es: " + funciones.MaximoComunDivisor(num1, num2, numeroMenor));
                
                //Se vuelve a llamar a MostrarOpciones() para que se vuelva a ingresar una opcion si se desea
                MostrarOpciones();
                break;
            
            //CASO INVERTIR CADENA
            case 4:
                System.out.println("Ingrese la cadena que quiere invertir: ");
                leer.nextLine();
                String cadenaAInvertir = leer.nextLine();
                
                //Se muestra la cadena invertida
                System.out.print("Su cadena invertida es '" + funciones.CadenaInvertida(cadenaAInvertir));
                
                //Se vuelve a llamar a MostrarOpciones() para que se vuelva a ingresar una opcion si se desea
                MostrarOpciones();
                break;
                
            case 5:
                System.out.println("Saliendo del programa...");
                
                //En este caso no se vuelve a llamar al metodo MostrarOpciones() para romper el bucle
                break;
        }
    }
    
    //Funcion para validar que el numero ingresado es entero positivo y evitar errores
    //por ingresar letras o decimales.
    public int ObtenerNumeroValidado()
    {
        System.out.println("Ingrese un numero entero positivo: ");
        while (true)
        {
            try
            {
                int numero = leer.nextInt();
                while (numero < 0)
                {
                    System.out.println("Error, debe ser un numero positivo");
                    numero = leer.nextInt();
                }
                return numero;
            }
            catch (InputMismatchException ex)
            {
                leer.next();
                System.out.println("Error, ingrese un numero entero positivo.");
            }
        }
    }
    
    //Funcion para validar que la opcion es valida, y evitar errores por ingresar letras
    public int ValidarOpcion()
    {
        while (true)
        {
            try
            {
                System.out.println("Ingrese su opcion: ");
                int opcion = leer.nextInt();
                while (opcion < 1 || opcion > 5)
                {
                    System.out.println("Error, ingrese una opcion valida.");
                    opcion = leer.nextInt();
                }
                return opcion;
            }
            catch (InputMismatchException ex)
            {
                leer.next();
                System.out.println("Error, ingrese un numero entero que este en las opciones.");
            }
        }
    }
}
