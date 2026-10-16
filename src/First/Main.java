package First;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input text: ");
        String text = in.nextLine();

        // Преобразуем исходный текст в односвязный список
        CharLinkedList textList = CharLinkedList.fromString(text);

        System.out.print("Input how many letters you want to delete: ");
        int num = in.nextInt();

        // Создаем список для букв, которые нужно удалить
        CharLinkedList deleteList = new CharLinkedList();
        for (int i = 0; i < num; i++) {
            System.out.print("Input letter " + (i + 1) + ": ");
            String letter = in.next();
            deleteList.pushBack(letter.charAt(0));
        }

        // Удаляем заданные буквы из списка текста
        textList.removeAll(deleteList);

        System.out.print("Result text: ");
        textList.print();
    }
}

