package com.company;
import java.util.Scanner;//importamos el Scanner;


public class Main {

    private static int min = 10000; //Se crea una variable min, la cual tendra un valor base.
    private static int max = 0;// se crea una variable max.

    public static void main(String[] args) throws Exception {

        Pila pila = new Pila();// creacion de la pila.

        Scanner sc = new Scanner(System.in);//inicializamos la variable Scanner;

        boolean continuar = true;
        int opcion =0;
        do {
            // creamos nuestro menú
            System.out.println(" ");
            System.out.println("Elija una opción");
            System.out.println("( 1 ) --> Insertar");
            System.out.println("( 2 ) --> Mostrar");
            System.out.println("( 3 ) --> Buscar");
            System.out.println("( 4 ) --> Eliminar");
            System.out.println("( 5 ) --> Tamaño");
            System.out.println("( 6 ) --> Máximo");
            System.out.println("( 7 ) --> Mínimo");
            System.out.println("( 8 ) --> Terminar");
            System.out.println(" ");

            try{ //creamos la excepción correspondiente para solo abmitir valores numericos como respuesta a la opcion que el usuario elija.
                opcion = sc.nextInt();//almacenamos el valor proporcionado por el usuario en la variable opcion;
            } catch (Exception e) {// el catch manda un mensaje de error,lo cual hace que el usuario corrija lo que se ingresa en el programa.
                sc = new Scanner(System.in);// se inicializa nuevamente.
                System.out.println("No es una opción");
                continue;
            }
            // implementamos un switch con sus respectivos case para cada opcion que se muestra en el menu;
            switch (opcion) { // insertar
                case 1: int valor;
                    System.out.println("<<--ingresa el número que deseas insertar-->> ");
                    try { //creamos la excepción correspondiente para solo abmitir valores numericos;
                        valor = sc.nextInt();
                        // se toma el valor obtenido y se evalua por medio de un if para obtener en minimo y maximo de los elementos.
                        if (valor < min){
                            min = valor;
                        }
                        if (valor > max){
                            max = valor;
                        }
                        pila.apilar(valor);// el metodo apilar almacena los valores ingresados
                        System.out.println("Guardado.");
                    } catch (Exception e) { // el catch manda un mensaje de aviso;
                        sc = new Scanner(System.in);// se inicializa nuevamente.
                        System.out.println("No me diste un valor numerico");
                        continue;
                    }

                    break;

                case 2://Mostrar
                    if (pila.esVacia()) //Checa si la pila esta vacia
                    {

                        System.out.println(" La pila esta vacia,no hay valores para mostrar");

                    }else {

                        System.out.println("<<-- Pila -->>"); // muestra la pila.
                        pila.listar();
                    }
                      break;

                case 3://Buscar
                    if (pila.esVacia()) //Checa si la pila esta vacia antes de buscar algun dato.
                    {

                        System.out.println(" La pila esta vacia,no hay valores para buscar");

                    }else {


                        System.out.println(" valor a buscar");
                        int num2 = sc.nextInt();
                        System.out.println(pila.buscar(num2));
                        System.out.println(pila.getPosicion(num2));


                    }

                    break;
                case 4://Eliminar
                    if (pila.esVacia()) { //Checa si la pila esta vacia.

                        System.out.println(" La pila esta vacia");
                    }
                        else{
                            pila.cima();//manda a traer el metodo cima para obtener el tope a eliminar.
                            pila.Eliminar();// posiciona el siguiente nodo en el topo de la cima.
                            pila.listar(); //muestra la lista actual
                        }


                    break;

                case 5:// regresa el tamaño actual de la pila.

                    System.out.println("\n<<-- Tamaño -->");
                    System.out.println(pila.getTamaño());
                    break;

                case 6:// se muestra el valor máximo.
                    if (pila.esVacia()) { //Checa si la pila esta vacia.

                        System.out.println(" La pila esta vacia");
                    }
                    else {
                        System.out.println("valor maximo: " + max);
                    }
                        break;


                case 7:// se muestra el valor minimo
                    if (pila.esVacia()) { //Checa si la pila esta vacia.

                        System.out.println(" La pila esta vacia");
                    }
                    else {
                        System.out.println("valor minimo: " + min);
                    }
                    break;


                case 8://Esta case  finaliza el programa.
                    System.out.println("Usted salio del menú.. :D");

                    break;
            }
        }while (opcion !=8);




    }
}