// Online Java Compiler
// Use this editor to write, compile and run your Java code online

 class ListNode{
    int data;
    ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main{

    public static int[] nextGreater(ListNode head){
           int length = size(head);
           int[] output = new int[length];
           ListNode ahead; 
           int k = 0;

           while(head != null){
                if(head.next == null){
                     output[k] = 0;
                     break;
                }

                ahead = head.next;
                if(ahead.data > head.data){
                    output[k] = ahead.data;
                    k++;
                }
                else if(ahead.data <= head.data){
                    while(ahead != null && ahead.data <= head.data){
                        ahead = ahead.next;
                    }

                    if(ahead == null){
                        output[k] = 0;
                        k++;
                    }
                    else{
                        output[k] = ahead.data;
                        k++;
                    }
                }

              head = head.next;
           }
            
            return output;
    }


    public static int size(ListNode head){
        int count = 0;

        while(head != null){
            count++;
            head = head.next;
        }

        return count;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        int arr[] = nextGreater(l1);

        for(int element : arr){
            System.out.print(element + " ");
        }
    }
}
