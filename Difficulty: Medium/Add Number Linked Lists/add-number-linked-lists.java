//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/
class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node l1 = reverseList(num1);
        Node l2 = reverseList(num2);
        Node curr = null;
        int carry = 0;
        while(l1!=null || l2!=null || carry >0){
            int v1 = l1!=null ? l1.data : 0;
            int v2 = l2!=null ? l2.data : 0;
            int sum = v1+v2+carry;
            carry = sum/10;
            Node tmp = new Node(sum%10);
            tmp.next = curr;
            curr = tmp;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        while(curr!=null && curr.data == 0){
            curr=curr.next;
        }
        return curr;
    
    }
    static Node reverseList(Node head) {
        // code here
        Node tmpHead = null;
        while(head!=null){
            Node nex = head.next;
            if(tmpHead == null) {
                tmpHead = head;
                tmpHead.next = null;
            }
            else {
                head.next = tmpHead;
                tmpHead = head;
            }
            head = nex;
        }
        return tmpHead;
    }
}


//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends