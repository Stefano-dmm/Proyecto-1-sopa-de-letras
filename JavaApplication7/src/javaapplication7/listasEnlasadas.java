/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;

/**
 *
 * @author mainp
 */
public class listasEnlasadas {
    // Clase Node para representar cada nodo en la lista enlazada
    public static class Node {
        int data; // Dato almacenado en el nodo
        Node next; // Puntero al nodo siguiente

        // Constructor para crear un nuevo nodo con el dato especificado
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Atributos de la clase listasEnlasadas
    private Node head; // Puntero al primer nodo de la lista
    private Node tail; // Puntero al último nodo de la lista
    private int size; // Tamaño de la lista

    // Constructor para crear una nueva lista enlazada vacía
    public listasEnlasadas() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Método para imprimir los nodos y su secuencia en la lista
    public void printList() {
        Node current = head; // Inicializar un puntero al primer nodo

        System.out.print("Secuencia: ");

        for (int i = 0; i < size; i++) {
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

    // Método para agregar un nuevo nodo al final de la lista
    public void AGGnodo(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
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

    // Método para eliminar el nodo en la posición especificada
    public void ELMnodo(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = getNode(index - 1);
            current.next = current.next.next;
        }
    }
}

       