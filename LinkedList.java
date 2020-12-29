public class LinkedList {

    private String str;
    private LinkedList next;

    public LinkedList(String input) {
        this.str = input;
        this.next = null;
    }

    public String getString() {
        return this.str;
    }

    public LinkedList get(int index) {
        int currInd = 0;
        LinkedList currNode = this;
        while (currInd != index && this != null) {
            if (currInd == index) {
                return currNode;
            }
            currNode = currNode.next;
            currInd++;
        }
        return null;
    }

    public LinkedList getLast() {
        LinkedList curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    public int size() {
        int size = 0;
        LinkedList curr = this;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    public void insert(LinkedList node, int index) {
        if (node.next != null) {
            System.out.println("You can only insert a single node");
        }
        if (this.size() < index) {
            System.out.println("Index out of bounds");
        }
        int currInd = 0;
        LinkedList curr = this;
        while (currInd < index && curr != null) {
            if (currInd == index - 1) {
                LinkedList temp = curr.next;
                curr.next = node;
                node.next = temp;
                break;
            }
            currInd++;
            curr = curr.next;
        }
    }

    public void delete(int index) {
        if (this.size() <= index) {
            System.out.println("Index out of bounds");
        }
        int currInd = 0;
        LinkedList curr = this;
        while (currInd < index && curr != null) {
            if (currInd == index - 1) {
                curr.next = curr.next.next;
                break;
            }
            currInd++;
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        int index = 0;
        String total = "";
        while (index < this.size()) {
            total = total + " " + this.str;
        }
        return total;
    }

    public static void main(String[] var0) {
        LinkedList first = new LinkedList("one");
        first.next = new LinkedList("two");
        System.out.println(first.size());
        first.insert(new LinkedList("three"), 2);
        System.out.println(first.size());
        System.out.println(first.getLast().getString());

        first.delete(1);
        System.out.println(first.get(0).getString());
        System.out.println(first.get(1).getString());
    }
}