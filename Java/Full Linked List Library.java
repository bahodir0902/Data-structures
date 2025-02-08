import java.util.HashMap;
class SingleLinkedList<T> {
    private Node<T> head;
    int size;

    private static class Node<T>{
        Node<T> next = null;
        T data;

        public Node(T data) {
           this.data = data;
        }
        
   }
    public SingleLinkedList() {
        this.size = 0;
    }

    public void push_back(T data){
        Node<T> newNode = new Node<>(data);
        if(this.head == null){
            head = newNode;
        }else{
            Node<T> temp = this.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public void push_front(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAt(T data, int index){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return;
        }else if(index == 0){
            push_front(data);
        }else{
            int counter = 0;
            Node<T> current = this.head;
            while(counter < index - 1){
                if(current == null || current.next == null){
                    System.out.println("Index is out of bounds!");
                    return;
                }
                current = current.next;
                counter++;
            }
            Node<T> newNode = new Node<T>(data);
            newNode.next = current.next;
            current.next = newNode;
            
        }
        size++;
    }

    public void pop_front(){
        if(this.head == null){
            System.out.println("Underflow! List is empty!");
            return;
        }else{
            this.head =this.head.next;
        }
        size--;
    }

    public void pop_back(){
        if (this.head == null) {
            System.out.println("Underflow! List is empty!");
            return;
        }else if(this.head.next == null){
            this.head = null;
            return;
        }
        else{  
            Node<T> current = this.head;
            while(current.next != null){
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public void removeAt(int index){
        if(this.head == null){
            System.out.println("Underflow! The list is empty");
            return;
        }else if(index == 0){
            pop_front();
        }
        else{
            int counter = 0;
            Node<T> current = head;
            while (counter < index - 1) {
                if(current.next == null){
                    System.out.println("Index is out of range!");
                    return;
                }
                current = current.next;
                counter++;
            }
            if(current.next == null){
                System.out.println("Index is out of range!");
                return;
            }
            Node<T> temp = current.next;
            current.next = temp.next;
        }
        size--;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void display(){
        if(this.head == null){
            System.out.println("The list is empty!");
            return;
        }
        Node<T> current = head;
        while(current != null){
            System.out.print(current.data);
            if(current.next != null){
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }

    public int size(){
        return this.size;
    }

    public T get(int index){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return null;
        }
        if(index >= this.size){
            System.out.println("Overflow! Index is out of range!");
            return null;
        }
        Node<T> current = head;
        int counter = 0;
        while(counter < index){
            current = current.next;
            counter++;
        }
        return current.data;
    }

    public int indexOf(T data){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return -1;
        }
        Node<T> current = head;
        int counter = 0;
        while(current != null){
            if(current.data.equals(data)){
                return counter;
            }
            current = current.next;
            counter++;
        }
        System.out.println("Element does not exist in the list!");
        return -1; 
    }

    public boolean contains(T data){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return false;
        }
        Node<T> current = this.head;
        while(current != null){
            if(current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear(){
        if(this.head == null){
            System.out.println("List is already empty!");
            return;
        }
        this.head = null;
        size = 0;
    }

    public void reverse(){
        Node<T> current = head;
        if(this.head == null){
            System.out.println("The list is empty!");
            return;
        }
        Node<T> previous = null;
        Node<T> next = null;
        while(current != null){
            next = current.next;
            previous = current;
            current.next = previous;
            current = next;
        }
        
        head = previous; 
        
    }

    public T middleNode(){
        Node<T> fast = head;
        Node<T> slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public boolean isCycled(){
        Node<T> fast = head;
        Node<T> slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(DoubleLinkedList<T> lst){
        if(lst.isCycled()){
            Node<T> fast = this.head;
            Node<T> slow = this.head;

            while(fast.next != null && fast != null){
                fast = fast.next.next;
                slow = slow.next;

                if(fast == slow){
                    break;
                }
            }

            slow = this.head;
            if(fast == slow){
                while(fast.next != slow){
                    fast = fast.next;
                }
            }else{
                while(fast.next != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            fast.next = null;
        }
    }

    
}

class DoubleLinkedList<T>{
    private static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node<T> head;
    private int size;

    public DoubleLinkedList() {
        this.size = 0;
    }

    public void push_back(T data){
        Node<T> newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        }else{
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        size++;
    }

    public void push_front(T data){
        Node<T> newNode = new Node(data);
        if(this.head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            this.head = newNode;
        }
        size++;
    }

    public void insertAt(T data, int index){
        if(index < 0 || index > this.size){
            System.out.println("Error! Index out of range!");
            return;
        }

        if(index == this.size){
            push_back(data);
            return;
        }
        Node<T> newNode = new Node(data);
        Node<T> current = this.head;
        if(this.head == null || index == 0){
            push_front(data);
            return;
        }
        
        int counter = 0;
        while(counter < index - 1){
            current = current.next;
            counter++;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if(current.next != null){
            current.next.prev = newNode;
        }
        current.next = newNode;
        size++; 
    }

    public void pop_back(){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return;
        }
        if(this.head.next == null){
            this.head = null;
        }else{   
            Node<T> current = head;
            while(current.next.next != null){
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public void pop_front(){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return;
        }
        if(head.next != null){
            head.next.prev = null;
            head = head.next;
        }else{
            head = null;
        }
        size--;
    }

    public void removeAt(int index){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return;
        }
        if(index >= this.size){
            System.out.println("Overflow! Index is out of range!");
            return;
        }
        if(index == 0){
            pop_front();
            return;
        }
        if(index == size - 1){
            pop_back();
            return;
        }

        Node current = head;
        int counter = 0;
        while(counter < index){
            current = current.next;
            counter++;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        return this.size;
    }

    public String display(){
        if(this.head == null){
            return "The list is empty!";
        }
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while(current != null){
            sb.append(current.data);
            if(current.next != null){
                sb.append("->");
            }
            current = current.next;
        }
        return sb.toString();
    }

    public T get(int index){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return null;
        }
        if(index >= this.size){
            System.out.println("Overflow! Index is out of range!");
            return null;
        }
        Node<T> current = head;
        int counter = 0;
        while(counter < index){
            current = current.next;
            counter++;
        }
        return current.data;
    }

    public int indexOf(T data){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return -1;
        }
        Node<T> current = head;
        int counter = 0;
        while(current != null){
            if(current.data.equals(data)){
                return counter;
            }
            current = current.next;
            counter++;
        }
        System.out.println("Element does not exist in the list!");
        return -1; 
    }

    public boolean contains(T data){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return false;
        }
        Node<T> current = this.head;
        while(current != null){
            if(current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear(){
        if(this.head == null){
            System.out.println("List is already empty!");
            return;
        }
        this.head = null;
        size = 0;
    }

    public void reverse(){
        Node<T> current = head;
        if(this.head == null){
            System.out.println("The list is empty!");
            return;
        }
        Node<T> temp = null;
        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev; 
        }
    }

    public T middleNode(){
        Node<T> fast = head;
        Node<T> slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public boolean isCycled(){
        Node<T> fast = head;
        Node<T> slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(DoubleLinkedList<T> lst){
        if(lst.isCycled()){
            Node<T> fast = this.head;
            Node<T> slow = this.head;

            while(fast.next != null && fast != null){
                fast = fast.next.next;
                slow = slow.next;

                if(fast == slow){
                    break;
                }
            }

            slow = this.head;
            if(fast == slow){
                while(fast.next != slow){
                    fast = fast.next;
                }
            }else{
                while(fast.next != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            fast.next = null;
        }
    }

}

class CircularSingleLinkedList<T>{
    private Node last = null;
    private Node head = null;
    private int size;

    private static class Node<T>{
        T data= null;
        Node<T> next = null;
        public Node(T data) {
            this.data = data;
        }
    }

    public void push_front(T data){
        Node<T> newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            this.last = newNode;
            newNode.next = this.head;
        }else{
            this.last.next = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        ++this.size;
    }

    public void push_back(T data){
        Node<T> newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            this.last = newNode;
            newNode.next = this.head;
        }else{
            this.last.next = newNode;
            this.last = newNode;
            newNode.next = this.head;
        }
        ++this.size;
    }

    public void insertAt(T data, int index){
        Node<T> newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            this.last = newNode;
            newNode.next = this.head;
        }else if(index == 0){
            push_front(data);
        }else if(index == this.size){
            push_back(data);
        }else if(index >= size){
            System.out.println("Overflow! Index is out of range!");
            return;
        }else if(index < 0){
            System.out.println("Underflow! Index is out of range!");
            return;
        }else{
            int counter = 0;
            Node<T> current = this.head;
            while(counter < index -1){
                current = current.next;
                ++counter;
            }
            newNode.next = current.next;
            current.next = newNode;
            ++this.size;    
        }
        
    }

    public void pop_front(){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return;
        }else if(this.head == this.last){
            this.last = null;
            this.head = null;
        }else{
            this.last.next = this.head.next;
            this.head = this.head.next;
        }
        --this.size;
    }

    public void pop_back(){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return;
        }else if(this.head == this.last){
            this.last = null;
            this.head = null;
        }else{
            Node<T> current_head = this.last.next;
            while(current_head.next != this.last){
                current_head = current_head.next;
            }
            current_head.next = this.head;
            this.last = current_head;
        }
        --this.size;
    }

    public void removeAt(int index){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return;
        }else if(index >= this.size || index < 0){
            System.out.println("Index is out of range!");
            return;
        }else if(index == 0){
            pop_front();
            return;
        }else if(index == this.size - 1){
            pop_back();
            return;
        }else{
            int counter = 0;
            Node<T> current = last.next;
            while(counter < index - 1){
                current = current.next;
                ++counter;
            }
            Node<T> temp = current.next;
            current.next = temp.next;
            --this.size;
        }

    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void display(){
        if(this.head == null){
            System.out.println("The list is empty!");
            return;
        }
        Node<T> current = this.head;
        do{
            System.out.print(current.data);
            if(current.next != this.head){
                System.out.print("->");
            }
            current = current.next;
        }while(current != this.head);
        System.out.println();
    }

    public int indexOf(T data){
        if(this.last == null){
            System.out.println("The list is empty!");
            return -1;
        }else{
            Node<T> current = this.last.next;
            for (int i = 0; i < this.size; i++) {
                if(current.data == data){
                    return i;
                }
                current = current.next;
            }
            return -1;
        }
    }

    public T get(int index){
        if(this.last == null){
            System.out.println("The list is empty!");
            return null;
        }else if(index >= this.size || index < 0){
            System.out.println("Index is oout of range!");
            return null;
        }else{
            Node<T> current = this.last.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    public boolean contains(T data){
        if(this.last == null){
            System.out.println("The list is empty!");
            return false;
        }else{
            Node<T> current = this.last.next;
            for (int i = 0; i < this.size; i++) {
                if(current.data == data){
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    public void clear(){
        if(this.last == null){
            System.out.println("The list is empty!");
            return;
        }else{
            this.last = null;
            this.head = null;
            this.size = 0;
        }
    }

    public void removeCycle(){
        if(this.last == null){
            System.out.println("The list is empty!");
            return;
        }else{
            this.head = this.last.next;
            this.last = null;
        }
    }

    public int size(){
        return this.size;
    }
    
}

class CircularDoubleLinkedList<T>{
    private int size = 0;
    private Node<T> head;
    private Node<T> last;

    private class Node<T>{
        Node<T> prev = null;
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void push_back(T data){
        Node<T> newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            this.last = newNode;
            this.head.next = this.head;
            this.head.prev = this.head;
        }else{
            newNode.next = this.head;
            newNode.prev = this.last;
            this.head.prev = newNode;
            this.last.next = newNode;
            this.last = newNode;
        }
        ++this.size;
    }

    public void push_front(T data){
        Node<T> newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            this.last = newNode;
            this.head.next = this.head;
            this.head.prev = this.head;
            
        }else{
            this.last.next = newNode;
            newNode.next = this.head;
            newNode.prev = this.last;
            this.head.prev = newNode;
            this.head = newNode;
            
        }
        ++this.size;
    }

    public void insertAt(T data, int index){
        Node<T> newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            this.head.prev = newNode;
            this.last.next = newNode;
            this.last = newNode;
        }else if(index == 0){
            push_front(data);
        }else if(index == this.size){
            push_back(data);
        }else if(index >= this.size || index < 0){
            System.out.println("Index is out of range!");
            return;
        }else{
            Node<T> current = this.last.next;
            int counter = 0;
            while(counter < index - 1){
                current = current.next;
                counter++;
            }
            newNode.next = current.next;
            current.next = newNode;
            current.next.prev = newNode;
            newNode.prev = current;
            ++this.size;
        }
    }

    public void pop_front(){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return;
        }if (this.head == this.last) {
            this.head = null;
            this.last = null;
        } else {
           this.head = this.head.next;
           this.head.prev = this.last;
           this.last.next = this.head;
        }
        --this.size;
    }

    public void pop_back(){
        if(this.head == null){
            System.out.println("Underflow! The list is empty!");
            return;
        }if (this.head == this.last) {
            this.head = null;
            this.last = null;
        } else {
            this.last = this.last.prev;  
            this.head.prev = this.last; 
            this.last.next = this.head;
        }
        --this.size;
    }

    public void removeAt(int index) {
        if (this.head == null) {
            System.out.println("Underflow! The list is empty!");
            return;
        }
        if (index < 0 || index >= this.size) {
            System.out.println("Index is out of range!");
            return;
        }
        if (index == 0) {
            pop_front();
            return;
        }
        if (index == this.size - 1) {
            pop_back();
            return;
        }
        Node<T> current = this.head; 
        int counter = 0;
        while (counter < index) {
            current = current.next;
            counter++;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        --this.size;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public void display(){
        if(this.head == null){
            System.out.println("The list is empty!");
            return;
        }
        Node<T> current = this.head;
        do{
            System.out.print(current.data);
            if(current.next != this.head){
                System.out.print("->");
            }
            current = current.next;
        }while(current != this.head);
        System.out.println();
    }

    
    public boolean contains(T data){
        if(this.head == null){
            System.out.println("The list is empty!");
            return false;
        }else{
        Node<T> current = this.head;
           do {
                if(current.data.equals(data)){
                    return true;
                }
                 current = current.next;
             }
            while (current != this.head);
        return false;
        }
    }

    public T get(int index){
        if(this.last == null){
            System.out.println("The list is empty!");
            return null;
        }else if(index >= this.size || index < 0){
            System.out.println("Index is oout of range!");
            return null;
        }else{
            Node<T> current = this.head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    public int indexOf(T data){
        if(this.last == null){
            System.out.println("The list is empty!");
            return -1;
        }else{
            Node<T> current = this.head;
            for (int i = 0; i < this.size; i++) {
                if(current.data == data){
                    return i;
                }
                current = current.next;
            }
            return -1;
        }
    }

    public void clear(){
        this.head = null;
        this.last = null;
    }
}

class Solution {
    private static class Node<T>{
        Node<T> next = null;
        T data;

        public Node(T data) {
           this.data = data;
        }
        
   }
    public ListNode mergeTwoLists(SingleLinkedList<Integer> list1, SingleLinkedList<Integer> list2) {

        if(list1 == null || list2 == null){
            return null;
        }
    
        // Create copies of the original lists to traverse
        SingleLinkedList<Integer> temp1 = list1;
        SingleLinkedList<Integer> temp2 = list2;
    
        int size = 0;
        
        while(temp1 != null){
            size++;
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            size++;
            temp2 = temp2.next;
        }
        
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Duplicates {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode current = head;
        while(current != null){
            if(map.containsKey(current.val)){
                current = current.next;
                continue;
            }else{
                map.put(current.val, 1);
            }
        }
        System.out.println(map);
        return current;

    }
}

// class Leetcode {
//     public static void main(String[] args) {

        
        
//     }
// }

public class DynamicStructures{
    public static void main(String[] args){

        Duplicates sol = new Duplicates();
        ListNode lst1 = new ListNode(1);
        lst1.next = new ListNode(1);
        lst1.next.next = new ListNode(2);
        ListNode result = sol.deleteDuplicates(lst1);

        while(result != null){
            System.out.print(result.val);
            if(result.next != null){
                System.out.print("->");
            }
            result = result.next;
        }

        /*CircularDoubleLinkedList<Integer> cdll = new CircularDoubleLinkedList();
        cdll.push_back(1);
        cdll.push_back(3);
        cdll.push_back(5);
        cdll.push_back(21);
        cdll.push_back(32);
        cdll.push_front(7);
        cdll.display();*/
        
        /*CircularSingleLinkedList<Integer> cList = new CircularSingleLinkedList();
        cList.push_back(23);
        cList.push_back(1);
        cList.push_front(3);
        cList.push_back(7);
        cList.insertAt(4, 2);
        cList.display();
        cList.pop_back();
        cList.pop_front();
        cList.display();
        cList.removeAt(1);
        cList.display();
        System.out.println(cList.indexOf(23));
        System.out.println(cList.get(1));
        System.out.println(cList.contains(23));*/

        /*SingleLinkedList<Integer> lst1 = new SingleLinkedList<>();

        lst1.push_back(1);
        lst1.push_back(2);
        lst1.push_back(4);
        lst1.display();
        SingleLinkedList<Integer> lst2 = new SingleLinkedList<>();
        lst2.push_back(1);
        lst2.push_back(3);
        lst2.push_back(4);
        lst2.display();
        
        Solution sol = new Solution();
        System.out.println(sol.mergeTwoLists(lst1, lst2));*/
        /*

        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.push_back(1);
        dll.push_back(2);
        dll.push_back(3);
        System.out.println("After push_back: " + dll.display());
        dll.push_front(0);
        System.out.println("After push_front: " + dll.display());
        dll.insertAt(4, 2);
        System.out.println("After insertAt: " + dll.display());
        dll.pop_back();
        System.out.println("After pop_back: " + dll.display());
        dll.pop_front();
        dll.removeAt(1);
        System.out.println("After removeAt: " + dll.display());
        System.out.println("Is empty? " + dll.isEmpty());
        System.out.println("Size: " + dll.size());

        System.out.println(dll.contains(1));
        System.out.println(dll.get(0));
        System.out.println(dll.indexOf(1));
        dll.reverse();
        System.out.println(dll.display());

        System.out.println(dll.isCycled());*/
    

    }
}
