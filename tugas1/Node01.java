package tugas1;

// import org.w3c.dom.Node;

public class Node01 {
    Faksinasi01  data;
    Node01 prev, next;

    Node01(Node01 prev, Faksinasi01 data, Node01 next)
    {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}