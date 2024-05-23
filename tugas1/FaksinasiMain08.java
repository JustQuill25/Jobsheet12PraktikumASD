package tugas1;

import java.util.Scanner;

public class FaksinasiMain08 {
    public static void menu() {
        System.out.println("+++++++++++++++++++++++++++++++++++ ");
        System.out.println("PENGANTRI VAKSIN EXTRAVAGANZA BIMA ");
        System.out.println("+++++++++++++++++++++++++++++++++++ ");
        System.out.println();
        System.out.println("1. Tambah Data Penerima Vaksin");
        System.out.println("2. Hapus Data Pengantri Vaksin");
        System.out.println("3. Daftar Penerima Vaksin");
        System.out.println("4. Keluar");
        System.out.println("+++++++++++++++++++++++++++++++++++ ");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DoubleLinkedLists01 dll = new DoubleLinkedLists01();

        int pilih;

        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Masukkan Data Penerima Vaksin");
                    System.out.println("-----------------------------");
                    System.out.print("Nomor Antrian: ");
                    int noAntrian = sc.nextInt();
                    System.out.print("Nama Penerima: ");
                    String nama = sc.next();
                    Faksinasi01 nb = new Faksinasi01(noAntrian, nama);
                    dll.addlast(nb);
                    System.out.println();
                    break;
                case 2:
                    Faksinasi01 penerima = dll.getFirst();
                    System.out.println(penerima.nama + " telah selesain divaksinasi.");
                    dll.removeFirst();
                    break;
                case 3:
                    System.out.println("-----------------------------");
                    System.out.println("Daftar Pengantri Vaksin");
                    System.out.println("-----------------------------");
                    dll.print();
                    System.out.println("Sisa Antrian: " + dll.size());
                    System.out.println();
                    break;
                case 4:
                    return;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4);
    }
}