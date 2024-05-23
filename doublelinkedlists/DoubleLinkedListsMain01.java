package doublelinkedlists;

public class DoubleLinkedListsMain01 {
    public static void main(String[] args) {
        DoubleLinkedLists01 dll = new DoubleLinkedLists01();

        System.out.println("Linked Lists Kosong");
        System.out.println("Size: " + dll.size());
        System.out.println("========================");

        try {
            dll.addFirst(3);
            dll.addLast(4);
            dll.addFirst(7);
            dll.print();
            System.out.println("Size: " + dll.size());
            System.out.println("========================");

            dll.add(40, 1);
            dll.print();
            System.out.println("Size: " + dll.size());
            System.out.println("========================");

            System.out.println("Data awal pada Linked Lists adalah: " + dll.getFirst());
            System.out.println("Data akhir pada Linked Lists adalah: " + dll.getLast());
            System.out.println("Data indeks ke-1 pada Linked Lists adalah: " + dll.get(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
