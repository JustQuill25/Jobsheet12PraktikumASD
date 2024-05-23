package tugas2;

public class DoubleLinkedLists01 {
    Node01 head;
    int size;

    public DoubleLinkedLists01() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Film01 item) {
        if (isEmpty()) {
            head = new Node01(null, item, null);
        } else {
            Node01 newNode = new Node01(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;

    }

    public void addlast(Film01 item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node01 current = head;
            while (current.next != null) {
                current = current.next;
            }

            Node01 newNode = new Node01(current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(Film01 item, int index) throws Exception {
        if (isEmpty()) {
            addFirst(item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else {
            Node01 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }

            if (current.prev == null) {
                Node01 newNode = new Node01(null, item, current);
                current.prev = newNode;
                head = newNode;
            } else {
                Node01 newNode = new Node01(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node01 tmp = head;
            System.out.println("Cetak Data");
            while (tmp != null) {
                System.out.println("ID \t: " +tmp.data.id);
                System.out.println("  Judul \t: " +tmp.data.judul);
                System.out.println("  Rating \t: " +tmp.data.rating);
                tmp = tmp.next;
            }
            // System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node01 current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node01 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }

            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public Film01 getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        return head.data;
    }

    public Film01 getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        Node01 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public Film01 get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas.");
        }
        Node01 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public Film01 searchById(int id) throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong");
        }

        Node01 current = head;
        while (current != null) {
            if (current.data.id == id) {
                return current.data;
            }
            current = current.next;
        }

        throw new Exception("Film dengan ID " + id + " tidak ditemukan");
    }

    public void sortByRatingDesc() {
        if (isEmpty() || size == 1) {
            return; 
        }

        for (int i = 0; i < size - 1; i++) {
            Node01 current = head;
            Node01 maxNode = current;

            for (int j = 0; j < size - i - 1; j++) {
                if (current.next != null && current.next.data.rating > maxNode.data.rating) {
                    maxNode = current.next;
                }
                current = current.next;
            }

            if (maxNode != current) {
                Film01 temp = current.data;
                current.data = maxNode.data;
                maxNode.data = temp;
            }
        }
    }
}