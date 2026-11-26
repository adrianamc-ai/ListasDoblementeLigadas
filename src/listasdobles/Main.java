/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasdobles;

/**
 *
 * @author adria
 */
public class Main {
    
     public static void main(String[] args) {

        listaDoble lista = new listaDoble();

        System.out.println("=== LISTA DOBLEMENTE LIGADA ===");

        
        lista.insertarAlInicio(20);
        lista.insertarFinal(40);

        System.out.println("\nLista inicial:");
        System.out.println(lista);


        
        System.out.println("\n=== INSERTAR EN POSICION ===");

        lista.insertarEnPosicion(1, 30);
        lista.insertarEnPosicion(0, 10);
        lista.insertarEnPosicion(lista.getTamanio(), 50);

        System.out.println(lista);
        System.out.println("Tamaño: " + lista.getTamanio());


        
        System.out.println("\n=== ELIMINAR POR VALOR ===");

        System.out.println("Eliminar 30: "
                + lista.eliminarPorValor(30));

        System.out.println(lista);


       
        System.out.println("\n=== ELIMINAR EN POSICION ===");

        System.out.println("Dato eliminado: "
                + lista.eliminarEnPosicion(1));

        System.out.println(lista);


        // 4. Eliminar último
        System.out.println("\n=== ELIMINAR ULTIMO ===");

        System.out.println("Eliminado: "
                + lista.eliminarUltimo());

        System.out.println(lista);


        // omprobar las referencias en ambos sentidos
        System.out.println("\n=== RECORRIDOS ===");

        System.out.println("Adelante: " + lista);
        System.out.println("Atras: " + lista.mostrarInverso());


        
        System.out.println("\n=== INSERTAR ORDENADO ===");

        listaDoble ordenada = new listaDoble();

        int[] valores = {25, 10, 40, 30, 5, 27, 25, 50, 3};

        for (int dato : valores) {
            ordenada.insertarOrdenado(dato);
        }

        System.out.println("Orden ascendente:");
        System.out.println(ordenada);

        System.out.println("Orden inverso:");
        System.out.println(ordenada.mostrarInverso());

        System.out.println("Tamaño: " + ordenada.getTamanio());


        // probar lista vacia y un solo nodo
        System.out.println("\n=== CASOS ESPECIALES ===");

        listaDoble prueba = new listaDoble();

        System.out.println("Lista vacía: " + prueba.estaVacia());
        System.out.println("Eliminar último: "
                + prueba.eliminarUltimo());
        System.out.println("Eliminar valor inexistente: "
                + prueba.eliminarPorValor(99));

        prueba.insertarEnPosicion(0, 100);
        System.out.println("Un nodo: " + prueba);

        System.out.println("Eliminar único nodo: "
                + prueba.eliminarEnPosicion(0));

        System.out.println("Lista vacía: " + prueba.estaVacia());


        // probar posiciones invalidas
        System.out.println("\n=== VALIDACIONES ===");

        try {
            prueba.insertarEnPosicion(-1, 10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            prueba.eliminarEnPosicion(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
