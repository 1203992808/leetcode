import java.util.Stack;

/**
 * @Auther: syz
 * @Date: 2019/1/10 10:32
 * @Description:
 */
/*
* leetcode 155 最小栈
*
* **/
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MinStack() {
        stackMin  = new Stack<Integer>();
        stackData = new Stack<Integer>();
    }

    public void push(int x) {
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else if (x < stackMin.peek()) {
            stackMin.push(x);
        } else {
            stackMin.push(stackMin.peek());
        }
        stackData.push(x);

    }

    public void pop() throws Exception {
        if (stackData.isEmpty()) {
            throw new Exception("栈为空");
        }
        stackData.pop();
        stackMin.pop();

    }

    public int top() throws Exception {
        if (stackData.isEmpty()) {
            throw  new Exception("栈为空");
        }
        return  stackData.peek();

    }

    public int getMin() throws Exception {
        if (stackMin.isEmpty()) {
            throw new Exception("栈为空");
        }
        return  stackMin.peek();

    }
}
