import java.util.Iterator;
import java.util.logging.*;
import java.lang.*;
/*
 * @author: Dellius Alexander
 * @date: 9/6/2020
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
/**
 * The Node class to encapsulate the data and reference of a data structure
 * node. This class is an independent class, so we need setters and getters.
 * @author Ken Nguyen
 * @version 1 - Node class is independent.
 */
class Node<T extends Comparable<T>> implements Comparable<T>{
    /**
     * The debug logger object.
     */
    private static Logger log = Logger.getLogger("Node<T>");
    /**
     * Get the line number for tracking execution calls.
     * @return  The current tread line number of calling object.
     */
    private int getLineNumber(){ return Thread.currentThread().getStackTrace()[2].getLineNumber();}

    /**
     * The data stored in the node.
     */
    private T data;
    /**
     * The pointer/link to the next node in the list.
     */
    private Node<T> next;
    /**
     * The pointer/link to the previous node in the list.
     */
    private Node<T> previous;
    /**
     * Assigns data to the current object and pointer
     * to the next node.
     * @param data  the data stored in the node.
     */
    public Node(T data)
    {
        this.data = data;
        this.next = null;
        this.previous = null;
        log.info("Line ["+ getLineNumber() + "] " +
                "Constructor(T data)...\n\tData: " + data.toString());
    }

    /**
     * Assigns data to the current node, sets the next node and
     * sets the previous node.
     * @param data  the data stored in the node.
     * @param next  the next node in the list.
     * @param previous  the previous node in the list.
     */
    public Node(T data, Node<T> next, Node<T> previous)
    {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
    /**
     * Gets the date stored in the node.
     * @return the data field stored in the node.
     */
    public T getData(){
        log.info("Line ["+ getLineNumber() + "] " +
                "getData()...\n\tData: " + data.toString());
        return this.data;
    }
    /**
     * set the given data to the data attribute.
     * @param data  the data stored in the node.
     */
    public void setData(T data){
        log.info("Line ["+ getLineNumber() + "] " +
                "setData(T data)...\n\tData: " + data.toString());
        this.data = data;
    }
    /**
     * Gets the next node in the list.
     * @return the reference to the next node.
     */
    public Node<T> getNext() {
        log.info("Line ["+ getLineNumber() + "] " +
                "getNext()...\n\tNext node: " + this.next);
        return this.next;
    }
    /**
     * Points to the next node in the list.
     * @param next  the next node in the list.
     */
    public void setNext(Node<T> next) {
        log.info("Line ["+ getLineNumber() + "] " +
                "setNext(Node<T> next)...\n\tNext node added: " + next);
        this.next = next;
    }
    public Node<T> getPrevious(){
        log.info("Line ["+ getLineNumber() + "] " +
                "getPrevious()...\n\tPrevious node: " + this.previous);
        return this.previous;
    }
    public void setPrevious(Node<T> previous){
        log.info("Line ["+ getLineNumber() + "] " +
                "setPrevious(Node<T> previous)...\n\tPrevious node added: " + previous);
        this.previous = previous;
    }
    /**
     * Compares the data to the data of the current object.
     * @param data  the data being compared.
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(T data)
    {
        log.info("Line ["+ getLineNumber() + "] compareTo(T data)...\n\tData: " + data.toString());
        return data.compareTo(this.data);
    }
}   // End of class Node<T>
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
class ListIterator<T extends Comparable<T>> implements Iterator<Node<T>> {
    Node<T> current;

    // initialize pointer to head of the list for iteration
    public ListIterator(ListIterator<T> list)
    {
        current = list.current;
    }

    private Node<T> getNext() {

        return null;
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current data and update pointer
    public Node<T> next()
    {
        return current.getNext();

    }
    /**
     * Iterates over the nodes in the list
     * @return an iterable object of the list
     */
    public ListIterator iterator()
    {
        return new ListIterator<T>(this);
    }
}   // End of class ListIterator
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
/**
 * This class implements a singly linked list.
 */
class DLinkList<T extends Comparable<T>> { //note: T is a placeholder for a data type
    //attributes
    /**
     * The pointer/reference to the first node in the list.
     */
    private Node<T> head;   // defines the first node in the list
    /**
     * The pointer/reference to the last node in the list.
     */
    private Node<T> tail;   // defines the last node in the list
    /**
     * The size of the list.
     */
    private int size;   // defines the size of the list
    /**
     * The debug logger object
     */
    private static Logger log = Logger.getLogger("SList<T>");
    /**
     * Get the line number for tracking execution calls.
     * @return  The current tread line number of calling object.
     */
    private int getLineNumber(){ return Thread.currentThread().getStackTrace()[2].getLineNumber();}

    /**
     * Initializes a new list.
     */
    public DLinkList()
    {
        this.size = 0;
        // The head and tail nodes are arbitrary values pointing to the same address
        this.head = this.tail = null;
        log.info("Line ["+ getLineNumber() + "] Constructor()...\n\tHead: " + this.head);
        log.info("Line ["+ getLineNumber() + "] Constructor()...\n\tTail: " + this.tail);
        log.info("Line ["+ getLineNumber() + "] Constructor()...\n\tSize: " + this.size);
    }
    /**
     * Copy constructor. Copy a list to a new list.
     * @param list
     */
    public DLinkList(DLinkList<T> list)
    {
        this.head = list.head;
        this.tail = list.tail;
        this.size = list.size;
        log.info("Line ["+ getLineNumber() + "] Copy Constructor()...\n\tHead: " + this.head);
        log.info("Line ["+ getLineNumber() + "] Copy Constructor()...\n\tTail: " + this.tail);
        log.info("Line ["+ getLineNumber() + "] Copy Constructor()...\n\tSize: " + this.size);
    }
    /**
     * Checks to see if the list is empty.
     * @return  true if list empty, false if not empty.
     */
    public boolean isEmpty()
    {
        log.info("Line ["+ getLineNumber() + "] isEmpty()...\n\tHead: " + (this.head == null));
        return this.head == null;
    }
    /**
     * Gets the first node in the list.
     * @return  the first node in the list.
     */
    public Node<T> getHead()
    {
        log.info("Line ["+ getLineNumber() + "] getHead()...\n\tHead: " + this.head);
        return this.head;
    }
    /**
     * Gets the last node in the list.
     * @return  the last node in the list.
     */
    public Node<T> getTail()
    {
        log.info("Line ["+ getLineNumber() + "] getTail()...\n\tTail: " + this.tail);
        return this.tail;
    }
    /**
     * add the given data as the first node of the list.
     * @param data - data to be added as the first node to the list.
     * @return - the reference to the newly added Node object containing
     *           the data in the list.
     */
    public Node<T> addFirst(T data)
    {
        Node<T> current = this.head;
        Node<T> newNode;
        if (this.isEmpty() == true)
        {   // check if the list is empty
            newNode = new Node<>(data);
            this.head = this.tail = newNode;
            this.size++;
            log.info("Line ["+ getLineNumber() + "] addFirst(T data)...\n\t" +
                    "First node added.  Size: " + this.size);
            log.info("Line ["+ getLineNumber() + "] addFirst(T data)...\n\t" +
                    "Data: " + data.toString());
            log.info("Line ["+ getLineNumber() + "] addFirst(T data)...\n\t" +
                    "Added new node : " + newNode);
        }
        else
        {
            while (current != null)
            {
                if (current.getNext() == null)
                {
                    newNode = new Node<>(data);
                    this.head.setPrevious(newNode);
                    newNode.setNext(this.head);
                    this.head = newNode;
                    this.size++;
                    log.info("Line ["+ getLineNumber() + "] addFirst(T data)...\n\t" +
                            "Size: " + this.size);
                    log.info("Line ["+ getLineNumber() + "] addFirst(T data)...\n\t" +
                            "Data: " + data.toString());
                    log.info("Line ["+ getLineNumber() + "] addFirst(T data)...\n\t" +
                            "Added new node : " + newNode);
                    break;
                }
                current = current.getNext();
            }
        }
        return this.head;
    }
    /**
     * add the given data as a node to the end of the list
     * @param data - data to be added to the end of the list
     * @return - the reference to the newly added Node object containing
     *           the data in the list
     */
    public Node<T> addLast(T data)
    {
        Node<T> current = this.head;
        Node<T> newNode;
        if(this.isEmpty() == true)
        {   // check if the list is empty
            this.tail = this.addFirst(data);
            log.info("Line ["+ getLineNumber() + "] addLast(T data)...\n\t" +
                    "Size: " + this.size);
            log.info("Line ["+ getLineNumber() + "] addLast(T data)...\n\t" +
                    "Data: " + data.toString());
            log.info("Line ["+ getLineNumber() + "] addLast(T data)...\n\t" +
                    "Added last node : " + this.tail);
        }
        else
        {
            while (current != null)
            {
                if (current.getNext() == null)
                {
                    newNode = new Node<>(data);
                    this.tail.setNext(newNode);
                    newNode.setPrevious(this.tail);
                    this.tail = newNode;
                    this.size++;
                    log.info("Line ["+ getLineNumber() + "] addLast(T data)...\n\t" +
                            "Size: " + this.size);
                    log.info("Line ["+ getLineNumber() + "] addLast(T data)...\n\t" +
                            "Data: " + data.toString());
                    log.info("Line ["+ getLineNumber() + "] addLast(T data)...\n\t" +
                            "Added last node : " + newNode);
                    break;
                }
                current = current.getNext();
            }
        }
        return this.tail;
    }
    /**
     * Remove the first node from the list
     */
    public void removeFirst()
    {
        Node<T> current = this.head;
        Node<T> temp;
        if(this.isEmpty() == true)
        {
            this.tail = this.head = null;
            this.size = 0;
            System.out.println("The list is empty...");
            log.info("Line ["+ getLineNumber() + "] removeFirst()...\n\t" +
                    "Size: " + this.size);
            return;
        }
        else
        {   // find and remove the first node
            temp = current;
            this.head = current.getNext();
            this.size--;
            log.info("Line ["+ getLineNumber() + "] removeFirst()...\n\t" +
                    "Size: " + this.size);
            log.info("Line ["+ getLineNumber() + "] removeFirst()...\n\t" +
                    "Data Removed: " + temp.getData());
            log.info("Line ["+ getLineNumber() + "] removeFirst()...\n\t" +
                    "Node removed: " + temp);
        }
    }

    /**
     * Remove the last node from the list
     */
    public void removeLast()
    {
        Node<T> current = this.head;
        Node<T> temp;
        if(this.isEmpty() == true)
        {
            this.tail = this.head = null;
            this.size = 0;
            System.out.println("The list is empty...");
            log.info("Line ["+ getLineNumber() + "] removeLast()...\n\t" +
                    "Size: " + this.size);
            return;
        }
        else
        { // find and remove the last node
            while (current != null)
            {
                temp = current.getNext();  // holds the current node being tested
                if (temp.getNext() == null)
                {   // now we remove temp from the list
                    current.setNext(null);
                    this.tail = current;
                    this.size--;
                    log.info("Line ["+ getLineNumber() + "] removeLast()...\n\t" +
                            "Size: " + this.size);
                    log.info("Line ["+ getLineNumber() + "] removeLast()...\n\t" +
                            "Data Removed: " + temp.getData());
                    log.info("Line ["+ getLineNumber() + "] removeLast()...\n\t" +
                            "Node removed: " + temp);
                    break;
                }
                current = current.getNext();
            }
        }
    }
    /**
     * toString method
     * @return a string representing the list
     */
    public String toString(){

        String output = "";
        for(Node<T> temp = this.head; temp != null; temp = temp.getNext())
        {
            output += temp.getData() + " " ;
        }
        return output;
    }

    /**
     * The size of the list
     * @return the number of nodes in the list
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Compares the contents of two nodes.
     * @param data the contents of a given node
     * @return  the node that contains the data object
     * @throws NullPointerException
     */
    public Node<T> findNode(T data)
    {
        // define a temporary node
        Node<T> tmp = this.head;
        // compare the data of both nodes
        int results = this.compareTo(tmp.getData(), data);
        try{   // catch null pointer exception
            while(results != 0)  // check the results
            {
                tmp = tmp.getNext();    // get the next node
                // compare again for next iteration
                results = this.compareTo(tmp.getData(), data);
                if(tmp == this.tail)  // break the loop and return null if we reach the end of the loop
                {   // check if you reached the end of the list
                    System.out.println(data + " does not exist in the list.\nEnd of the list has been reached\n");
                    break;
                }
            }
        }catch (NullPointerException ne){ // catch exceptions
            System.out.println("\nThe end of the list is reached...\nWe will add this data to end of the list.\n");
            this.addLast(data);
            this.size++;
            return this.findNode(data);
        }
        return tmp;
    }
    /**
     * Compares the data to the data of the current object.
     * @param a  the object doing the comparison operation
     * @param b  the object being compared to object a
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object.
     */
    private int compareTo(T a, T b) {
        return a.compareTo(b);
    }

    /**
     * Takes a key and a value and then insert the value after the node
     *     containing the same value of the given key.
     * @param key   the value in the node we are searching for
     * @param value the value to insert after we find the node containing the key
     */
    public void insertAfter(T key, T value){
        Node<T> newNode = this.findNode(key);
        newNode.setNext(new Node<T>(value));
    }

    /**
     * The main driver method
     * @param args command line arguments
     */
    public static void main(String args[])
    {

        //== Add code to test all functionalities of the SList class==

        //create a list of integers
        System.out.println();
        DLinkList<Integer> myList = new DLinkList<Integer>();
        myList.addFirst(5); //add a value
        myList.addFirst(6);
        myList.addFirst(58);
        myList.addFirst(51); //add a value
        myList.addFirst(62);
        myList.addFirst(50);
        //myList.removeLast();
        System.out.println("My List: " + myList);
        System.out.println("List size: " + myList.getSize());
        myList.addFirst(6); //add a value
        myList.addFirst(8); //add a value
        myList.addFirst(81); //add a value
        System.out.println("My List: " + myList);
        System.out.println("List size: " + myList.getSize());
        myList.addLast(10);
        myList.addLast(12);
        System.out.println("My List: " + myList);
        System.out.println("List size: " + myList.getSize());
        myList.addFirst(1);
        myList.addLast(2);
        System.out.println("My List: " + myList);
        System.out.println("List size: " + myList.getSize());
        myList.removeFirst();
        myList.removeFirst();
        System.out.println("My List: " + myList);
        System.out.println("List size: " + myList.getSize());
        myList.removeLast();
        myList.removeLast();
        myList.removeLast();
        System.out.println("My List: " + myList);
        System.out.println("List size: " + myList.getSize());

        Node<Integer> foundNode = myList.findNode(78);
        System.out.println("Found the node containing: " + foundNode.getData() + "\n");
//        myList.insertAfter(78, 92);
//        System.out.println("My List: " + myList);
//        System.out.println("List size: " + myList.getSize());
//
//        SList<Integer> listCopy = new SList<Integer>(myList);
//        System.out.println("\nCopied list: " + listCopy);
//        System.out.println("Copied list size: " + listCopy.getSize() + "\n");







//        while() {
//
//        }
//        while(listCopy.iterator(listCopy.head)){
//
//        }
        //TO BE COMPLETED
        //     while(myList.getSize() > 0){
        //         myList.removeFirst();
        //         myList.removeLast();
        //     }
        //     System.out.println("\nMy List: " + myList);
        //     System.out.println("List size: " + myList.getSize());
    }  //==== END of the DRIVER =============







    /*
    Using the given SList as a template to implement a doubly linked list with the following functionalities

    1. Add first: add an element to the head of the list
    2. Add last: add an element to the end of the list
    3. Print: print the content of the list starting from the head
    4. Find: a private method that will return a reference to a node if it contains the same
    value of a given argument - you may want to implement the Comparable interface, java.lang.Comparable,
    with compareTo method to compare all type of data
    5. Insert after: a method that takes a key and a value and then insert the value after the node
    containing the same value as the given key. If there is no node matching the given key, add the new
    node to the end of the list.
    6. Implement a copy constructor for the list
    7. Implement a list iterator class for the your doubly-linked list following the standard Java ADT
    usage of iterator, and demonstrate its usage in a driver code.

Note:

+ You can extend the code you have completed for the last hands-on activity or you can use either the
posted (on D2L) SList.java or SList2.java to complete this work.

+ Grading:

      -Make sure to write your code incrementally and test it thoroughly. Code contains syntax errors are not gradable and zero point will be given.

      - Make sure to thoroughly document your code, give sufficient comment to explain your code, and follow a proper format - Points will be deducted for failure to do so.


     */
}


