package org.binar;

import java.util.Scanner;

public class CreditCard implements methodPay{
    private Scanner input;

    public CreditCard(Scanner input) {
        this.input = input;
    }
    @Override
    public void pay(String order, int total) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nKonfirmasi dan Bayar (Pembayaran via kartu kredit)");
        System.out.println("Detail Pesanan:");
        System.out.println(order);
        System.out.println("Total Harga: " + total);

        // Simulasi pembayaran dengan kartu kredit
        System.out.print("Masukkan nomor kartu kredit: ");
        String creditCardNumber = input.next();

        // Anda juga bisa meminta tanggal kedaluwarsa, nama pemilik, dan CVV jika diperlukan
        // String tanggalKedaluwarsa = input.next();
        // String namaPemilik = input.next();
        // int cvv = input.nextInt();

        // Verifikasi kartu kredit (ini hanya simulasi)
        if (verificationCreditCard(creditCardNumber)) {
            // Lakukan langkah-langkah pembayaran dengan kartu kredit di sini
            System.out.println("Pembayaran dengan kartu kredit berhasil!");
            // Anda dapat menambahkan langkah lain seperti mencetak struk atau mengupdate inventori di sini.
        } else {
            System.out.println("Pembayaran dengan kartu kredit gagal. Nomor kartu kredit tidak valid.");
        }

        input.close();
    }

    // Simulasi verifikasi kartu kredit (contoh sederhana)
    private boolean verificationCreditCard(String nomorKartu) {
        // Simulasi: Nomor kartu kredit harus memiliki 16 digit
        return nomorKartu.length() == 16;
    }
}
