/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasdobles;

/**
 *
 * @author adria
 */
public class nodoD {
     // atributos
    private int dato;
    private nodoD sig;
    private nodoD ant;

    // constructor
    public nodoD(int x) {
        dato = x;
        sig = null;
        ant = null;
    }

    // obtenerdato
    public int getDato() {
        return dato;
    }

    // modificar dato
    public void setDato(int dato) {
        this.dato = dato;
    }

    // obtener siguiente nodo
    public nodoD getSig() {
        return sig;
    }

    // modificar el siguiente nodo
    public void setSig(nodoD sig) {
        this.sig = sig;
    }

    // obtener el nodo anterior
    public nodoD getAnt() {
        return ant;
    }

    // modificar el nodo anterior
    public void setAnt(nodoD ant) {
        this.ant = ant;
    }
    
}
