import java.util.Scanner;
/* задание 15 используя список, удалить из текста заданный набор букв*/
void main(String[] args) {
    String text_del;
    Scanner in = new Scanner(System.in);
    System.out.print("Input text: ");
    String text = in.nextLine();
    System.out.print("Input how much letter do you want to dell: ");
    int num = in.nextInt();
    for (int i = 0; i <= num; i++) {
        System.out.print("Input letter: ");
        String letter = in.next();
//        if (Node.head == null){
//            Node head = new Node(letter.charAt(0));
//        }
        Node.pushBack(letter.charAt(0));
    }

    while (Node.giveData() != null){
        String text_del = text.replace(буква, );

    }
//    for (int i = 0; i <= text.length(); i++) {
//        Node current = Node.head;
//        while(current != null){
//            char let = text.charAt(i);
//            if (let == Node.find(current)){
//                text.replace
//            }
//
//        }
//    }

    System.out.print(text_del);
}

