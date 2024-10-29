//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class SortLL {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }
}
// } Driver Code Ends



/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }

}*/
// you have to complete this function
class GfG {
    public static Node quickSort(Node node) {
        // Your code here
        Node end=getLastNode(node);
        quickSortRecursive(node,end);
        return node;
    }
    
     // Helper method to get the last node of the list
    private static Node getLastNode(Node head) {
        while (head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }

    // Partition function using the end node as the pivot
    private static Node partition(Node start, Node end) {
        int pivot = end.data;
        Node i = start, j = start;

        while (j != end) {
            if (j.data < pivot) {
                // Swap i and j node values
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
                i = i.next;
            }
            j = j.next;
        }

        // Swap pivot data with current i position
        int temp = i.data;
        i.data = end.data;
        end.data = temp;

        return i; // Return the pivot node
    }

    // QuickSort recursive function with null checks
    private static void quickSortRecursive(Node start, Node end) {
        if (start == null || start == end || start == end.next) return;

        // Partition the list and get the pivot node
        Node pivotNode = partition(start, end);

        // Recursively sort before and after partition node
        Node beforePivot = getPrevNode(start, pivotNode);
        if (beforePivot != null) quickSortRecursive(start, beforePivot);
        if (pivotNode != null && pivotNode.next != null) quickSortRecursive(pivotNode.next, end);
    }

    // Helper function to get the previous node of the target node
    private static Node getPrevNode(Node start, Node target) {
        Node temp = start;
        while (temp != null && temp.next != target) {
            temp = temp.next;
        }
        return temp;
    }
}