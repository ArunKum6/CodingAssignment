import java.util.Scanner;

class Stack{
	private int stack[];
	private int top;
	private int size;
	public Stack(int size) {
		stack = new int[size];
		this.size = size;
		top = -1;
	}
	
	public void push(int val) {
		if(!isFull())
			stack[++top] = val;
		else
			System.out.println("Stack Overflow");
	}
	
	public int pop() {
		if(!isEmpty())
			return stack[top--];
		else
			System.out.println("Stack Underflow");
		return -1;
	}
	
	public int peek() {
		if(!isEmpty())
			return stack[top];
		else
			return -1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == size);
	}
}

public class SuperStack {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		SuperStack ss = new SuperStack();
		s.nextLine();
		while(N > 0) {
			String input = s.nextLine();
			String params[] = input.split(" ");
			switch(params[0]) {
				case "push" :  ss.push(Integer.parseInt(params[1]));
							   break;
				case "pop"  :  ss.pop();
				               break;
				case "inc"  :  ss.inc(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
							   break;
			}
			ss.print();
			N--;
		}
		s.close();
	}
	
	private Stack stack,incStack;
	public SuperStack() {
		stack = new Stack(10);
		incStack = new Stack(10);
	}
	
	public void push(int val) {
		stack.push(val);
	}
	
	public Integer pop() {
		return stack.pop();
	}
	
	public void print() {
		if(stack.isEmpty())
			System.out.println("EMPTY");
		else
			System.out.println(stack.peek());
	}
	
	public void inc(int e,int k) {
		while(!stack.isEmpty())
			incStack.push(stack.pop());
		
		while(e-- > 0)
			stack.push(incStack.pop() + k);
		
		while(!incStack.isEmpty())
			stack.push(incStack.pop());
	}
}