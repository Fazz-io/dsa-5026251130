package Lw06.Unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        String[] values = read.nextLine().trim().split(" ");
        int target = Integer.parseInt(read.nextLine().trim());

        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < values.length; i++) {
            tree.insert(Integer.parseInt(values[i]));
        }

        System.out.print("Preorder : ");
        tree.preOrder();

        System.out.print("Inorder : ");
        tree.inOrder();

        System.out.print("Postorder : ");
        tree.postOrder();

        System.out.println("Search " + target + " : " + tree.search(target));
        System.out.println("Nodes : " + tree.countNodes());
        System.out.println("Leaves : " + tree.countLeaves());

        read.close();
    }
}
