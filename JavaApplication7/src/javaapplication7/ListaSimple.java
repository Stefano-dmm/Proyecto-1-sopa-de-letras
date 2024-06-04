/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;

/**
 *
 * @author mainp
 */
public class ListaSimple {
    // Clase Node para representar cada nodo en la lista simple
    public static class Node {
        int data; // Dato almacenado en el nodo
        Node next; // Puntero al siguiente nodo

        // Constructor para crear un nuevo nodo con el dato especificado
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Atributos de la clase ListaSimple
    private Node head; // Puntero al primer nodo de la lista
    private int size; // Tamaño de la lista

    // Constructor para crear una nueva lista simple vacía
    public ListaSimple() {
        this.head = null;
        this.size = 0;
    }

    // Método para imprimir los nodos y su secuencia en la lista simple
    public void printList() {
        Node current = head; // Inicializar un puntero al primer nodo

        System.out.print("Secuencia: ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // Avanzar al siguiente nodo
        }

        System.out.println();
    }

    // Método para obtener el nodo en la posición especificada
    public Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        Node current = head; // Inicializar un puntero al primer nodo

        for (int i = 0; i < index; i++) {
            current = current.next; // Avanzar al siguiente nodo
        }

        return current;
    }

    // Método para obtener el dato del nodo en la posición especificada
    public int get(int index) {
        Node node = getNode(index);
        return node.data;
    }

    // Método para obtener el tamaño de la lista
    public int getSize() {
        return size;
    }

    // Método para agregar un nuevo nodo al final de la lista simple
    public void AGGnodo(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next; // Avanzar al siguiente nodo
            }

            current.next = newNode;
        }

        size++;
    }

    // Método para agregar un nuevo nodo en la posición especificada
    public void AGGnodo(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {
            Node current = getNode(index - 1);
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }
}
