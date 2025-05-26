class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node newNode = new Node(data);
        
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        
        Node current = head;
        
        if(data <= head.data){
            while(current.next != head){
                current = current.next;
            }
            
            current.next = newNode;
            newNode.next = head;
            return data < head.data ? newNode : head;
        }
        
        current = head;
        
        while(current.next != head && current.next.data < data){
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        
        return head;
    }
}