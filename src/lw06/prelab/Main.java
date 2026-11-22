package lw06.prelab;

import java.util.Scanner;

public class Main {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.kiri = insert(root.kiri, data);
        } else if (data > root.data) {
            root.kanan = insert(root.kanan, data);
        }

        return root;
    }

    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (target == root.data) {
            return true;
        } else if (target < root.data) {
            return search(root.kiri, target);
        } else {
            return search(root.kanan, target);
        }
    }

    public static void preorder(Node root) {
        // root - kiri - kanan
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.kiri);
            preorder(root.kanan);
        }
    }

    public static void inorder(Node root) {
        // kiri - root - kanan
        if (root != null) {
            inorder(root.kiri);
            System.out.print(root.data + " ");
            inorder(root.kanan);
        }
    }

    public static void postorder(Node root) {
        // kiri - kanan - root
        if (root != null) {
            postorder(root.kiri);
            postorder(root.kanan);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        Node root = null;
        String n = sc.nextLine();
        String[] angka = n.trim().split(" ");
        for (int i = 0; i < angka.length; i++) {
            root = insert(root, Integer.parseInt(angka[i]));
        }

        int target = sc.nextInt();

        System.out.print("Preorder  : ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder   : ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder : ");
        postorder(root);
        System.out.println();

        System.out.println("Search " + target + " : " + search(root, target));

        sc.close();
    }
}