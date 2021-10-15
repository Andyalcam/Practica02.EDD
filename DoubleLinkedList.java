import java.util.Iterator;

public class DoubleLinkedList<T> implements TDAList<T>{

    private Node head;
    private Node tail;
    private int size;

    /**
     * Inserta un nuevo elemento <i>e</i> en la posición <i>i</i>.
     *
     * @param i la posición donde agregar el elemento.
     * @param e el elemento a insertar.
     * @throws IndexOutOfBoundException si el índice está fuera de rango.
     */
    @Override
    public void add(int i, T e) throws IndexOutOfBoundsException{

        // Cuando i no está en los rangos definidos
        if(i < 0 || i > size)
            throw new IndexOutOfBoundsException();

        Node nuevo = new Node(e);

        //Si la lista es vacia
        if(head==null){
            head = nuevo;
            tail = nuevo;
            size++;
            return;
        }

        //Si se desea agregar al inicio
        if(i == 0){
            if(size == 1){
                tail = head;
            }
            nuevo.setNext(head);
            nuevo.setPrevious(null);
            head.setPrevious(nuevo);
            head = nuevo;
            size++;
            return;
        }

        //Si se desea agregar al final
        if(i == size){
            nuevo.setPrevious(tail);
            tail.setNext(nuevo);
            tail = nuevo;
            size++;
            return;
        }

        //Si el indice es menor a la mitad del tamaño de la lista y se agrega en cualquier posicion
        if(i<=size/2){
            Node iterador = head;
            for(int j = 0; j < i-1; j++)
                iterador = iterador.getNext();
            nuevo.setNext(iterador.getNext());
            nuevo.setPrevious(iterador);
            iterador.setNext(nuevo);
            nuevo.getNext().setPrevious(nuevo);
            size++;
            return;
        }

        //Si el indice es menor a la mitad del tamaño de la lista y se agrega en cualquier posicion
        if(i > size/2){
            Node iterador=tail;

            for(int j = 0; j < i-1 ; j++)
                iterador = iterador.getPrevious();

            nuevo.setNext(iterador.getNext());
            nuevo.setPrevious(iterador);
            iterador.setNext(nuevo);
            nuevo.getNext().setPrevious(nuevo);
            size++;
            return;
        }

    }

    /**
     * Limpia la lista. Elimina todos los elementos.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Verifica si un elemento está contenido en la lista.
     *
     * @param e el elemento a verificar si está contenido.
     * @return true si el elemento está contenido, false en otro caso.
     */
    @Override
    public boolean contains(T e) {
        Node aux = head;
        while(aux != null){
            if(aux.getElement().equals(e)){
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    /**
     * Obtiene el elemento en la posición <i>i</i>.
     *
     * @param i el índice a obtener elemento.
     * @throws IndexOutOfBoundException si el índice está fuera de rango.
     */
    @Override
    public T get(int i) throws IndexOutOfBoundsException {
        if( i < 0 || i > size){
            throw new IndexOutOfBoundsException();
        }
        if(isEmpty()){
            return null;
        }

        if(i == 0){
            return head.getElement();
        }
        if(i == size-1){
            return tail.getElement();
        }

        Node iterator = head;

        for(int j = 0; j < i; j++){
            iterator = iterator.getNext();
        }
        return iterator.getElement();
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista no contiene elementos, false en otro caso.
     */
    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        return false;
    }

    /**
     * Elimina el elemento en la posición <i>i</i>.
     *
     * @param i el índice del elemento a eliminar.
     * @return el elemento eliminado.
     * @throws IndexOutOfBoundException si el índice está fuera de rango.
     */
    @Override
    public T remove(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i > size ){
            throw new IndexOutOfBoundsException();
        }
        if(i == 0){
            T element = head.getElement();
            head = head.getNext();
            head.getNext().setPrevious(head);
            return element;
        }
        if(i == size-1){
            T element = tail.getElement();
            tail = tail.getPrevious();
            tail.setNext(null);
            tail.getPrevious().setNext(tail);
            return element;
        }
        Node iterator = head;
        for(int j = 1; j <= i; j++){
            iterator = iterator.getNext();
        }
        iterator.getPrevious().setNext(iterator.getNext());
        iterator.getNext().setPrevious(iterator.getPrevious());

        return iterator.getElement();
    }

    /**
     * Regresa la cantidad de elementos contenidos en la lista.
     *
     * @return la cantidad de elementos contenidos.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Revierte los elementos de la lista. Esto es, da la reversa de la lista.
     */
    @Override
    public void revert() {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        Node aux = tail;
        while(aux != null){
            doubleLinkedList.add(0, aux.getElement());
            aux = aux.getPrevious();
        }
        clear();
        for(int j = 0; j < doubleLinkedList.size(); j++){
            add(0, (T) doubleLinkedList.get(j));
        }
        //System.out.println(doubleLinkedList.toString());

    }

    /**
     * Da la mitad derecha o izquierda de una lista.
     *
     * @param side la mitad que recortar de la lista original.
     *             true - mitad derecha.
     *             false - mitad izquierda.
     * @return una nueva lista con la mitad de los elementos.
     */
    @Override
    public DoubleLinkedList cut(boolean side) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        if(side){
            Node aux = tail;
            for(int i = size/2; i < size; i++){
                doubleLinkedList.add(0, aux.getElement());
                aux = aux.getPrevious();
            }
        }else{
            for(int i = 0; i < size/2; i++){
                doubleLinkedList.add(i, this.get(i));
            }
        }

        return doubleLinkedList;
    }

    /**
     * Da un iterador para la lista.
     *
     * @return un iterador para la estructura.
     */
    @Override
    public Iterator listIterador() {
        return null;
    }

    /**
     * Imprime en pantalla los elementos de la lista
     *
     * @return una cadena con los elementos en la lista.
     */
    @Override
    public String toString(){
        if(!isEmpty()) {
            String result = "";
            Node aux = head;
            while (aux != null) {
                result += aux.getElement() + ", ";
                aux = aux.getNext();
            }
            return result.substring(0, result.length() - 2);
        }
        return "La lista es vacía";
    }

    private class Node{

        private T element;
        private Node next;
        private Node previous;

        public Node(T element){
            this.element = element;
            next = null;
            previous = null;
        }

        public Node(T element, Node next, Node previous){
            this.element = element;
            this.next = next;
            this.previous = previous;
        }


        public void setElement(T element) {
            this.element = element;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getPrevious() {
            return previous;
        }

        public Node getNext(){
            return next;
        }

        public T getElement(){
            return element;
        }



    }


}