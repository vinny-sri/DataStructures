import java.lang.Exception;

public class Stack {

    private String[] nodes;
    private int top;

    public Stack() {
        nodes = new String[1];
        top = 1;
    }

    public void resize() {
        String[] newNodes = new String[this.getNodes().length * 2];
        for (int i = 0; i < this.getNodes().length; i++) {
            newNodes[i] = this.getNodes()[i];
        }
        this.nodes = newNodes;
    }

    public String[] getNodes() {
        return this.nodes;
    }

    public int getTop() {
        return this.top;
    }

    public void push(String str) {
        if (this.top >= this.nodes.length) {
            this.resize();
        }
        this.getNodes()[this.getTop()] = str;
        this.top = this.top + 1;
    }

    public String pop() {
        if (this.top == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        this.top = this.top - 1;
        String popped = this.getNodes()[this.top];
        this.getNodes()[this.top] = "";
        return popped;
    }

    public String poll() {
        return this.getNodes()[this.top - 1];
    }

    public static void main(String[] args) {
        Stack first = new Stack();
        first.push("one");
        first.push("two");
        System.out.println(first.poll());
        first.push("three");
        System.out.println(first.poll());
        System.out.println(first.pop());
        System.out.println(first.pop());
        System.out.println(first.poll());
    }
}