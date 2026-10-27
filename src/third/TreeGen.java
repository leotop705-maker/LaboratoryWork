package third;


import java.util.Stack;

public class TreeGen
{
    private Node rootNode;

    public TreeGen()
    {
        rootNode = null;
    }

    public boolean sameStructure(Node main,  Node small)
    {
        if (main == null && small == null) return true;
        if (main == null || small == null) return false;
        return sameStructure(main.leftChild, small.leftChild) && sameStructure(main.rightChild, small.rightChild);
    }

    public void insertNode(int value)
    {
        Node newNode = new Node();
        newNode.setValue(value);
        if (rootNode == null)
        {

            rootNode = newNode;

        }
        else
        {
            Node current = rootNode;
            Node parentNode;
            while(true)
            {
                parentNode = current;
                if (value == current.getValue())
                {
                    return;
                }
                else if (value < current.getValue())
                {
                    current = current.getLeftChild();
                    if (current == null)
                    {
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
                else
                {
                    current = current.getRightChild();
                    if (current == null)
                    {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }



    public void printTree() // метод для вывода дерева в консоль, да его тоже взял из статьи
    {
        Stack<Node> globalStack = new Stack<>(); // общий стек для значений дерева
        globalStack.push(rootNode);
        int gaps = 64; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack<Node> localStack = new Stack<>(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // сохраняем в локальный стек наследников текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }


}
