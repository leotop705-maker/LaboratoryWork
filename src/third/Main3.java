package third;
//вариант 15
//Дано бинарное дерево. Найти все поддеревья, структура которых совпадает с заданной.

public class Main3 {
    public static void main(String[] args)
    {
        int[] valuesMainTree = new int[]{19,1,6,5,2,3,4,9,7,8,12,10,15,18,23,25};
        int[] valuesSmallTree = new int[]{1,2,3,4,5,7};

        int sumMain = 0;
        int sumSmall = 0;
        for(int i : valuesMainTree){sumMain += i;}
        for(int i : valuesSmallTree){sumSmall += i;}

        TreeGen mainTree = new TreeGen();
        TreeGen smallTree = new TreeGen();

        mainTree.insertNode(sumMain / valuesMainTree.length);

        smallTree.insertNode(sumSmall / valuesSmallTree.length);

        for (int i : valuesMainTree){mainTree.insertNode(i);}
        for (int i : valuesSmallTree){smallTree.insertNode(i);}

        System.out.println("Основное дерево");
        mainTree.printTree();
        System.out.println("Искомое поддерево");
        smallTree.printTree();


    }
}