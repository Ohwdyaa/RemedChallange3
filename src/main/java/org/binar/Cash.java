package org.binar;

import java.util.Scanner;

public class Cash implements methodPay{
    private Scanner input;

    public Cash(Scanner input) {
        this.input = input;
    }

    @Override
    public void pay(String order, int total) {
        System.out.println("\nKonfirmasi dan Bayar (Pembayaran Tunai)");
        System.out.println("Detail Pesanan:");
        System.out.println(order);
        System.out.println("Total Harga: " + total);
        System.out.println("\n1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke halaman sebelumnya");
        System.out.print("Pilih: ");

        int choice = input.nextInt();

        if (choice == 1) {
            // Lakukan logika pembayaran tunai di sini
            System.out.print("Masukkan jumlah uang tunai: ");
            int cash = input.nextInt();

            if (cash >= total) {
                int moneyChanges = cash - total;
                System.out.println("Pembayaran berhasil!");
                System.out.println("Kembalian: " + moneyChanges);
                // Anda dapat menambahkan langkah lain seperti mencetak struk atau mengupdate inventori di sini.
            } else {
                System.out.println("Jumlah uang tunai tidak mencukupi.");
            }
        } else if (choice == 2) {
            System.out.println("Kembali ke menu utama.");
        } else {
            System.out.println("Pilihan tidak valid");
        }

        input.close();
    }
}
