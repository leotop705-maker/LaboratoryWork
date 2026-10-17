package First;
//Используя список, удалить их текста заданный набор букв.
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
    public boolean contains(char value) {
        boolean exist = false;
        Node current = head;
        while (current.next != null)
            if (value == current.data){
                exist = true;
                return exist;
            }else{
                current = current.next;
            }
        return exist;
    }

    // Удаление из текущего списка всех символов, находящихся в другом списке toRemove
    public void removeAll(CharLinkedList toRemove) {
        Node current = head;
        Node prev = head;
        Node currentRemote = toRemove.head;
        while (current.next != null){
            while (contains(toRemove.head.data)){
                if (current == currentRemote){
                    current = current.next;
                    prev.next = current;
                }
                currentRemote = currentRemote.next;
            }
        }
    }

    // Вывод списка в виде строки
    public void print() {
        Node current = head;
        while(current != null){
            System.out.print(current.data);
            current = current.next;
        }
    }

    // Статический метод для создания списка из строки
    public static CharLinkedList fromString(String text) {
        Node current = head;
        for (int i = 0; i < text.length(); i++){
            //pushBack(text.charAt(i));
            Node newNode = new Node(text.charAt(i));
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
        return null;
    }


}
