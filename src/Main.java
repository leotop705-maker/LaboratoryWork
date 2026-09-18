import java.util.Scanner;

void main(String[] args) {
    String text_del;
    Scanner in = new Scanner(System.in);
    System.out.print("Input text: ");
    String text = in.nextLine();
    System.out.print("Input how much letter do you want to dell: ");
    int num = Integer.parseInt(in.nextLine());
    for (int i = 0; i <= num; i++){
        System.out.print("Input letter: ");
        String letter = in.nextLine();
        Node.pushFront(letter);
    }
    for (int i = 0; i <= text.length(); i++) {

    }

    System.out.print(text_del);
}

