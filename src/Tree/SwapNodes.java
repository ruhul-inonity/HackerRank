package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ruhul on 5/20/17.
 */


// problem : https://www.hackerrank.com/challenges/swap-nodes-algo

class Node {
    int data;
    int depth;
    Node left, right;
    Node(int data, int depth){
        this.data = data;
        this.depth = depth;
    }
}
public class SwapNodes {
    public static void swap_nodes(Node root, int K){
        /*Queue<Node> nodes = new LinkedList<Node>();
        nodes.offer(root);
        Node cur;
        while (!nodes.isEmpty()){
            cur = nodes.poll();
            if (cur.depth%K == 0){
                Node tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
            }
            if (cur.left != null) nodes.offer(cur.left);
            if (cur.right != null) nodes.offer(cur.right);
        }*/
        if (root != null){
            if (root.depth%K == 0){
                Node tmp = root.left;
                root.left = root.right;
                root.right = tmp;
            }
            swap_nodes(root.left, K);
            swap_nodes(root.right, K);
        }
    }

    public static void inorder_print(Node root){
        if (root != null){
            inorder_print(root.left);
            System.out.print(root.data+" ");
            inorder_print(root.right);
        }
    }

    public static void print_nodes(Node root, int K){
        swap_nodes(root, K);
        inorder_print(root);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node root = new Node(1, 1);
        Node cur = root;
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.offer(cur);
        while (N-->0){
            cur = nodes.poll();
            int leftData = sc.nextInt();
            int rightData = sc.nextInt();
            cur.left = (leftData==-1)? null: new Node(leftData, cur.depth+1);
            cur.right = (rightData==-1)? null: new Node(rightData, cur.depth+1);
            if (cur.left != null && cur.left.data!= -1)
                nodes.offer(cur.left);
            if (cur.right != null && cur.right.data!=-1)
                nodes.offer(cur.right);
        }
        int T = sc.nextInt();
        while (T-->0){
            int K = sc.nextInt();
            print_nodes(root, K);
        }
    }
}

/*    Sample Input #00

        3
        2 3
        -1 -1
        -1 -1
        2
        1
        1
        */
