public class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }

    Node head = null;

    public static char printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }


    public static Node find(Node head, int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value)
                return current;

            current = current.next;
        }

        return null;
    }

    public static Node pushFront(Node head, char value) {
        Node newNode = new Node(value);

        newNode.next = head;
        return newNode;
    }
}
