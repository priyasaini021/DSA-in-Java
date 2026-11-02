import java.util.ArrayList;
    
    public class StackUsingArrayList {
    
        static class Stack {
            ArrayList<Integer> list = new ArrayList<>();
    
            public boolean isEmpty() {
                return list.size() == 0;
            }
    
            public void push(int data) {
                list.add(data);
            }
    
            public int pop() {
                if (isEmpty()) {
                    return -1;
                }
    
                return list.remove(list.size() - 1);
            }
    
            public int peek() {
                if (isEmpty()) {
                    return -1;
                }
    
                return list.get(list.size() - 1);
            }
        }
    
        public static void main(String[] args) {
            Stack s = new Stack();
    
            s.push(10);
            s.push(20);
            s.push(30);
    
            System.out.println("Stack: " + s.list);
            System.out.println("Pop: " + s.pop());
            System.out.println("Peek: " + s.peek());
        }

}

