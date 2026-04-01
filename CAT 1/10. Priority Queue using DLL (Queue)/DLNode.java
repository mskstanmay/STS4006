@SuppressWarnings("unused")
public class DLNode extends Object {

    DLNode prev;
    int priority;
  
    int data;
    DLNode next;

    public DLNode(int data, int priority){
        this.data = data;
        this.priority = priority;
    }
}
