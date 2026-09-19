public class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }

    Node head = null;

    public static Node find(Node head, char value) {
        Node current = head;

        while (current != null) {
            if (current.data == value)
                return current;

            current = current.next;
        }

        return null;
    }

    public static void pushBack(char value) {
        Node newNode = new Node(value);

        if (newNode.head == null) {
            newNode.head = newNode;
        }
        newNode.next = newNode;
    }

    public Node giveData() {
        Node current = head;
        while (current != null){
            return current;
        }
        return null;
    }

}
