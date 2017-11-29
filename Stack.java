import java.util.EmptyStackException;
public class Stack<E>
{
	private Object[] stack;
	private int top = -1;
	private int curArraySize = 0;


	public Stack()
	{
		stack = new Object[10];
		curArraySize = 10;
	}

	public void push(E item)
	{
		if (stack[curArraySize-1]!=null){
			Object[] temp = new Object[stack.length*2] ;
			for (int i = 0; i < stack.length; i++) {
				temp[i] = stack[i];
			}
			stack = temp;
			curArraySize = stack.length;

			stack[top]=item;
			top++;
		}
		else{
			top++;
			stack[top] = item;
		}
	}

	public E pop() throws EmptyStackException
	{
		if (isEmpty()){
			throw new EmptyStackException();
		}
		else{

			Object temp = stack[top];
			stack[top] = null;
			top--;
			return (E) temp;
		}

	}

	public E peek()
	{
		if (isEmpty()){
			throw new EmptyStackException();
		}
		else{


			return (E) stack[top];
		}
	}

	public boolean isEmpty()
	{if (size()==0)
		return true;
	else
		return false;
	}


	public int size()
	{
		if (top == -1)
			return 0;
		else{
			return top + 1;
		}

	}
}