package problemSolving.tree;

public class PrintLongestPath {
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }

    }
    public static void main(String[] args) {
        // write your code here
        int arr[] = new int[10];
        int counter=0;
        Node node = new Node(5);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.left.left.left = new Node(7);
        node.left.left.right = new Node(8);
        node.left.right =  new Node(3);
        node.left.right.left =  new Node(9);
        node.right =  new Node(6);
        node.right.left = new Node(11);
        node.right.left.left = new Node(15);
        node.right.left.left.right = new Node(10);
        node.right.right = new Node(12);
        int h = height(node);
        printLongestPath(node, arr, counter, h);
    }
    private static void printLongestPath(Node node, int arr[], int counter, int h){
        if(node==null) {
            return;
        }
        arr[counter++] = node.data;
        if(node.left == null && node.right == null){
            printArray(arr,counter, h);
        }
        printLongestPath(node.left, arr, counter, h);
        printLongestPath(node.right, arr, counter, h);

    }
    private static void printArray(int arr[], int counter, int h){
        if(counter==h) {
            for (int i = 0; i < counter; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
    private static int height(Node node){
        if(node==null)
            return 0;
        if(node.left == null && node.right == null) {
            return 1;
        }
        else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
}
