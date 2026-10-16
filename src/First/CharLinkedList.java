package First;

public class CharLinkedList {
    Node head = null;

    // Добавление символа в конец списка
    public void pushBack(char value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Проверка наличия символа в списке
    /*public boolean contains(char value) {
        Boolean exist = false;
        for (char letter : deleteList){

        }

    }*/

    // Удаление из текущенго списка всех символов, находящихся в другом списке toRemove
    public void removeAll(CharLinkedList toRemove) {
        ...
    }

    // Вывод списка в виде строки
    public void print() {
        ...
    }

    // Статический метод для создания списка из строки
    public static CharLinkedList fromString(String text) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < text.length(); i++){
            Node newNode = new Node(text.charAt(i));

            if (head == null){
                head = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }

        }
        return head;
    }


}
