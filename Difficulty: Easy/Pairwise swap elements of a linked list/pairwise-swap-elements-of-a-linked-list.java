/* node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head) {
        // code here
        Node dummy = new Node(-1);
        dummy.next = head;

        Node node = dummy;
        while(node!=null){
            Node first = node.next;
            Node second = null;
            if(first!=null){
                second = first.next;
            }

            if(second!=null){
                Node secondNext = second.next;
                second.next = first;
                node.next = second;
                first.next = secondNext;
                node = first;
            }else{
                break;
            }
        }
    
        return dummy.next;
    }
}