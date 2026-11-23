package lw06.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (Main.class.getResourceAsStream("treenumbers.txt"));
        
      BinarySearchTree bst = new BinarySearchTree();
        String s = sc.nextLine();
        String[] a = s.trim().split(" ");
        for (int i = 0; i < a.length; i++) {
            bst.insert(Integer.parseInt(a[i]));
        }
        int x = sc.nextInt();

        System.out.print("Preorder : ");
        bst.preOrder();
        System.out.print("Inorder : ");
        bst.inOrder();
        System.out.print("Postorder : ");
        bst.postOrder();
        System.out.println("Search " + x + " : " + bst.search(x));
        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());

        sc.close();
    }
}
