/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasdobles;

/**
 *
 * @author adria
 */
public class listaDoble {
    
      // atributos
    private int tamanio;
    private nodoD cabeza;
    private nodoD cola;

    // constrructor
    public listaDoble() {
        tamanio = 0;
        cabeza = null;
        cola = null;
    }

    // verificar si la lista esta vacia
    public boolean estaVacia() {
        if (cabeza == null && cola == null) {
            return true;
        } else {
            return false;
        }
    }

    // obtener el tamaño de la lista
    public int getTamanio() {
        return tamanio;
    }
    
    
    // 1. metodo de buscar un dato en la lista
    public boolean buscar(int x) {

        // primero hay que verificar si la lista esta vacia
        if (estaVacia()) {
            return false;
        }

        // crear nodo aux para que se pueda recorrer la listasin modificar cabeza
        nodoD aux = cabeza;

        // aux tiene que apuntar a un ndo existente
        while (aux != null) {

            // si el valor almacenado en el nodo es igual a x=dato
            if (aux.getDato() == x) {
                return true;
            }

            // entonces avanzar al siguiente nodo
            aux = aux.getSig();
        }

        // sino el dato no fue encontrado
        return false;
    }
    
    
    // 2. metodo para obtener un nodo segun su posicion
    public nodoD obtenerNodo(int pos) {

        // primero verificar que la posicion sea valida
        if (pos < 0 || pos >= tamanio) {
            throw new IndexOutOfBoundsException(
                "Posición fuera de rango"
            );
        }

        // despues comenzar desde la cabeza
        nodoD aux = cabeza;

        // un for para avanzar hasta la posicion que se quiere
        for (int i = 0; i < pos; i++) {
            aux = aux.getSig();
        }

        // devuelve el nodo encontrado
        return aux;
    }
    
    
    // 3. metodo para actualizar el dato de un nodo segun la posiicion
    public void actualizar(int dato, int pos) {

        // llama a obtenerNodo(pos) para obtener el nodo y guarda su referencia en aux
        nodoD aux = obtenerNodo(pos);

        // cambiarel dato almacenado en el nodo
        aux.setDato(dato);
    }
    
    
    
    // 4. metodo toString 
    //mostrar los elementos de la lista
    @Override
    public String toString() {

        // verificar si la lista esta vacia
        if (estaVacia()) {
            return "null";
        }

        // cadena donde se guardaran los datos
        String res = "null <- ";

        // comienza desde la cabeza
        nodoD aux = cabeza;

        // recorrertodos los nodos
        while (aux != null) {

            res = res + "[" + aux.getDato() + "]";

            // agregar enlace si existe otro nodo
            if (aux.getSig() != null) {
                res = res + " <-> ";
            }

            // y avanzar al siguiente nodo
            aux = aux.getSig();
        }

        // indicar el final de la lista
        res = res + " -> null";

        return res;
    }
    
    
    
    
    // 5. Metodo parainsertar un nodo al inicio de la lista
    public void insertarAlInicio(int dato) {

        // primero se tiene que crear el nuevo nodo
        nodoD nuevo = new nodoD(dato);

        // y verificar si la lista esta vacia
        if (estaVacia()) {

            cabeza = nuevo;
            cola = nuevo;

        } else {

            // si no esta vacia ell nuevo apunta a la cabeza actual
            nuevo.setSig(cabeza);

            // la cabeza actual apunta hacia atras al nuevo
            cabeza.setAnt(nuevo);

            // se ctualiza la cabeza
            cabeza = nuevo;
        }

        // y aumenta el tamaño
        tamanio++;
    }
    
    
    // 6. metodo para nsertar un nodo al final de la lista
    public void insertarFinal(int dato) {

        nodoD nuevo = new nodoD(dato);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSig(nuevo);
            nuevo.setAnt(cola);
            cola = nuevo;
        }

        tamanio++;
    }


    // 7. metodo eliminar el primer nodo de la lista
    public int eliminarAlInicio() {

        if (estaVacia()) {
            throw new IllegalStateException(
                "La lista está vacía"
            );
        }

        nodoD eliminado = cabeza;
        int dato = eliminado.getDato();

        cabeza = cabeza.getSig();

        if (cabeza == null) {
            cola = null;
        } else {
            cabeza.setAnt(null);
        }

        eliminado.setSig(null);

        tamanio--;

        return dato;
    }


    // 8. metodo paransertar un nodo en una posición específica
    public void insertarEnPosicion(int pos, int dato) {

        // validar la posicion
        if (pos < 0 || pos > tamanio) {
            throw new IndexOutOfBoundsException(
                "Posición fuera de rango"
            );
        }

        // insertar al inicio
        if (pos == 0) {
            insertarAlInicio(dato);
            return;
        }

        // insertar al final
        if (pos == tamanio) {
            insertarFinal(dato);
            return;
        }

        // obtener el nodo de la posicion
        nodoD actual = obtenerNodo(pos);
        nodoD anterior = actual.getAnt();

        // crear el nuevo nodo
        nodoD nuevo = new nodoD(dato);

        // conectar el nuevo nodo
        nuevo.setAnt(anterior);
        nuevo.setSig(actual);

        // y actualizar los nodos de a lado
        anterior.setSig(nuevo);
        actual.setAnt(nuevo);

        tamanio++;
    }


    // 9. metodo Eliminar la primera aparicion de un valor
    public boolean eliminarPorValor(int x) {

        nodoD actual = cabeza;

        // buscar el dato
        while (actual != null && actual.getDato() != x) {
            actual = actual.getSig();
        }

        // siel dato no existe
        if (actual == null) {
            return false;
        }

        // si el dato esta al inicio
        if (actual == cabeza) {
            eliminarAlInicio();
            return true;
        }

        // el dato esta al final
        if (actual == cola) {
            return eliminarUltimo();
        }

        // el dato esta en medio
        nodoD anterior = actual.getAnt();
        nodoD siguiente = actual.getSig();

        // unir los nodos  alado
        anterior.setSig(siguiente);
        siguiente.setAnt(anterior);

        // desconectar el nodo eliminado
        actual.setAnt(null);
        actual.setSig(null);

        tamanio--;

        return true;
    }


    // 10. metodo para eliminar un nodo segun su posicion
    public int eliminarEnPosicion(int pos) {

        // validar la posicion
        if (pos < 0 || pos >= tamanio) {
            throw new IndexOutOfBoundsException(
                "Posición fuera de rango"
            );
        }

        // eliminar al inicio
        if (pos == 0) {
            return eliminarAlInicio();
        }

        // eliminar al final
        if (pos == tamanio - 1) {
            int dato = cola.getDato();
            eliminarUltimo();
            return dato;
        }

        // obtener el nodo que se eliminara
        nodoD actual = obtenerNodo(pos);

        nodoD anterior = actual.getAnt();
        nodoD siguiente = actual.getSig();

        // unir el nodo anterior con el siguiente
        anterior.setSig(siguiente);
        siguiente.setAnt(anterior);

        // desconectar el nodo eliminado
        actual.setAnt(null);
        actual.setSig(null);

        tamanio--;

        return actual.getDato();
    }


    // eliminar el último nodo
    public boolean eliminarUltimo() {

        if (estaVacia()) {
            return false;
        }

        nodoD eliminado = cola;

        // retroceder al nodo anterior
        cola = cola.getAnt();

        if (cola == null) {
            cabeza = null;
        } else {
            cola.setSig(null);
        }

        eliminado.setAnt(null);

        tamanio--;

        return true;
    }


    // 11. metodo para insertar un dato manteniendo el orden ascendente
    public void insertarOrdenado(int dato) {

        // lista vaciia o insertar al inicio
        if (estaVacia() || dato <= cabeza.getDato()) {
            insertarAlInicio(dato);
            return;
        }

        // insertar al final
        if (dato >= cola.getDato()) {
            insertarFinal(dato);
            return;
        }

        // buscar la posicion correcta
        nodoD actual = cabeza;

        while (actual != null && actual.getDato() <= dato) {
            actual = actual.getSig();
        }

        nodoD anterior = actual.getAnt();

        // crear el nodo
        nodoD nuevo = new nodoD(dato);

        // conectar el nuevo nodo en ambos sentidos
        nuevo.setAnt(anterior);
        nuevo.setSig(actual);

        // actualizar los nodos de a lado
        anterior.setSig(nuevo);
        actual.setAnt(nuevo);

        tamanio++;
    }


    // Mostrar la lista desde cola hasta cabeza
    public String mostrarInverso() {

        if (estaVacia()) {
            return "null";
        }

        String res = "null <- ";

        nodoD aux = cola;

        while (aux != null) {

            res = res + "[" + aux.getDato() + "]";

            if (aux.getAnt() != null) {
                res = res + " <-> ";
            }

            aux = aux.getAnt();
        }

        res = res + " -> null";

        return res;
    }






    
}
