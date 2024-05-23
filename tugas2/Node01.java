package tugas2;

// import org.w3c.dom.Node;

public class Node01 {
    Film01  data;
    Node01 prev, next;

    Node01(Node01 prev, Film01 data, Node01 next)
    {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}