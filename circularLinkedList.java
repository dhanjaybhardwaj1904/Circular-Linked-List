import java.util.Scanner;

public class circularLinkedList {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public int size = 0;
    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node temp = new Node(data);

        if (size == 0) {
            head = temp;
            tail = temp;
            temp.next = head;
        }
        else {
            Node tmp = head;
            temp.next = tmp;
            head = temp;
            tail.next = head;
        }
        size++;
    }

    public void endNode(int data) {
        if (size == 0) {
            addNode(data);
        }
        else {
            Node tmp = new Node(data);
            tail.next = tmp;
            tail = tmp;
            tail.next = head;
            size++;
        }
    }

    public void deleteNode() {
        if (size == 0) {
            return;
        }
        else {
            head = head.next;
            tail.next = head;
            size--;
        }
    }

    public void display() {
        Node temp = head;
        if (size <= 0) {
            return;
        }
        else {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            while(temp != head);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        circularLinkedList list = new circularLinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <n; i++) {
            int value = sc.nextInt();
            list.addNode(value);
        }
        list.display();
        list.deleteNode();
        list.display();
        int a = sc.nextInt();
        list.endNode(a);
        list.display();
    }
}