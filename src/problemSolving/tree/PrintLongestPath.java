package problemSolving.tree;

public class PrintLongestPath {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }

    }

    public static void main(String[] args) {

        int arr[] = new int[20];
        int counter = 0;
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.right.left = new Node(6);
        node.left.right.right = new Node(7);
        node.left.left.right = new Node(8);
        node.left.left.right.left = new Node(9);

        int h = height(node);
        System.out.println("Height : " + h);
        printLongestPath(node, arr, counter, h);
    }

    private static void printLongestPath(Node node, int arr[], int counter, int h) {
        if (node == null) {
            return;
        }
        arr[counter++] = node.data;
        if (node.left == null && node.right == null) {
            printArray(arr, counter, h);
        } else {
            printLongestPath(node.left, arr, counter, h);
            printLongestPath(node.right, arr, counter, h);
        }

    }

    private static void printArray(int arr[], int counter, int h) {
        if (counter == h) {
            for (int i = 0; i < counter; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    private static int height(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
}
