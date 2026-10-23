package First;
//Используя список, удалить их текста заданный набор букв.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input text: ");
        String text = in.nextLine();
        //String text = "bgsihg skfhg sk fskfjs";
        // Преобразуем исходный текст в односвязный список
        CharLinkedList textList = CharLinkedList.fromString(text);

        System.out.print("Input how many letters you want to delete: ");
        int num = in.nextInt();
        //int num = 2;
        // Создаем список для букв, которые нужно удалить
        CharLinkedList deleteList = new CharLinkedList();
        for (int i = 0; i < num; i++) {
            System.out.print("Input letter " + (i + 1) + ": ");
            String letter = in.next();
//            String letter = "b";
//            String letter2 = "s";
//            deleteList.pushBack(letter2.charAt(0));
            deleteList.pushBack(letter.charAt(0));

        }

        // Удаляем заданные буквы из списка текста
        textList.removeAll(deleteList);

        System.out.print("Result text: ");
        textList.print();
    }

}

