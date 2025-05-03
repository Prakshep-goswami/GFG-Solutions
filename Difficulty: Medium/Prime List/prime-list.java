//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<=10007;i++){
            if(isPrime(i))
                list.add(i);
        }
        Node ans=null,temp=null;
        while(head!=null){
            int newVal=0;
            if(head.val==1){
                newVal=2;
            }
            else{
            int index=lowerBound(head.val,list);
            //System.out.print(index);
            if(list.get(index)==head.val){
                newVal=list.get(index);
            }
            else if(index+1<list.size()){
                if(head.val-list.get(index)>list.get(index+1)-head.val)
                    newVal=list.get(index+1);
                else
                    newVal=list.get(index);
            }}
            if(ans==null){
                ans=new Node(newVal);
                temp=ans;
            }
            else{
                temp.next=new Node(newVal);
                temp=temp.next;
            }
            head=head.next;
        }
        return ans;
    }
    boolean isPrime(int no){
        if(no==1)
            return false;
        else if(no==2)
            return true;
        int limit=no;
        for(int i=2;i<=limit;i++){
            if(no%i==0)
                return false;
            limit=no/i;
        }
        return true;
    }
    int lowerBound(int no,ArrayList<Integer> list){
        int low=0,high=list.size()-1,mid=-1;
        for(;low<=high;){
            mid=(low+high)/2;
            if(list.get(mid)==no)
                return mid;
            else if(list.get(mid)<no)
                low=mid+1;
            else
                high=mid-1;
        }
        return high;
    }
}