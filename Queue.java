import java.util.NoSuchElementException;
public class Queue<E> {
    private Node first;
    private Node last;

    private class Node<E> {
        private Node next;
        private Node previous;
        private E item;

        public Node() {

        }

        public Node(E userItem) {
            item = userItem;
        }
    }

    public Queue() {

    }

    public int size() {
        if (first == null)
            return 0;
	
        else {
            Node current = first;
            int size = 0;
            while (current != null) {
                size++;
                current = current.next;
            }
            return size;
        }
    }

    public boolean isEmpty() {
        if ( size() == 0)
            return true;
        else
            return false;
    }

    public void enqueue(E thing) {
        Node temp = new Node(thing);
        if (this.first == null){
            this.first = temp;
            this.last = temp;
        }
        else if(size()==1){
            this.first.next = temp;
            last = temp;
            this.last.previous = first;
        }
        else{
            this.last.next = temp;
            this.last.next.previous = last;
            this.last = last.next;
        }
    }

    public E dequeue() throws NoSuchElementException {
        if(size()==0){
            throw new NoSuchElementException();
        }
        else if (size() == 1){
            Node returnNode = first;
            last = null;
            first = null;
            return (E) returnNode.item;
        }
        else{
            Node newFirst = first.next;
            newFirst.previous = null;
            Node returnNode = first;
            first = newFirst;
            return (E) returnNode.item;
        }
    }

    public E peek() throws NoSuchElementException{
        if(size()==0){
            throw new NoSuchElementException();
        }
        else{
            return (E) first.item;
        }
    }

}