import java.util.Queue;
import java.util.LinkedList;

class MyStack{
   Queue<Integer> q1;
   Queue<Integer> q2;
    
    public MyStack(){
         q1 = new LinkedList<>();
         q2 = new LinkedList<>();
    }
    
    public void push(int element){
         while(!q1.isEmpty()){
             q2.add(q1.poll());
         }
         q1.add(element);
         
         while(!q2.isEmpty()){
             q1.add(q2.poll());
         }
    }
    
    public boolean isEmpty(){
        return q1.isEmpty();
    }
    
    public int top(){
        return q1.peek();
    }
    
    public int pop(){
        return q1.poll();
    }
    
    
    
    public static void main(String[]args){
        MyStack stk = new MyStack();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        
        while(!stk.isEmpty()){
             System.out.print(stk.pop() + " ");
        }
    }
}