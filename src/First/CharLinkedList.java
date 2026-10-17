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
        while (current != null)
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


        if (head == null || toRemove == null || toRemove.head == null){
            return;
        }

        while (head != null && toRemove.contains(head.data)){
            head = head.next;
        }

        if (head == null){
            return;
        }

        Node current = head;

        while (current.next != null){
            if (toRemove.contains(current.next.data)){
                current.next = current.next.next;
            } else {
                current = current.next;
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
        CharLinkedList list = new CharLinkedList();
        for (int i = 0; i < text.length(); i++){
            list.pushBack(text.charAt(i));
        }
        return list;
    }


}
