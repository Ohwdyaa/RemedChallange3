package org.binar;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> foodMenu = new ArrayList<>();
        foodMenu.add("Nasi Goreng");
        foodMenu.add("Mie Ayam");
        foodMenu.add("Ayam Bakar");

        List<String> drinkMenu = new ArrayList<>();
        drinkMenu.add("Teh Manis");
        drinkMenu.add("Jus Jeruk");
        drinkMenu.add("Air Mineral");

        List<Integer> foodPrices = new ArrayList<>();
        foodPrices.add(15000);
        foodPrices.add(13000);
        foodPrices.add(18000);

        List<Integer> drinkPrices = new ArrayList<>();
        drinkPrices.add(3000);
        drinkPrices.add(5000);
        drinkPrices.add(2000);

        FoodStalls foodStalls = new FoodStalls(foodMenu, drinkMenu, foodPrices, drinkPrices);
        foodStalls.showOrders();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pesan item (Masukkan nomor menu atau '0' untuk selesai):");
        int item;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            try {
                item = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Masukkan nomor yang valid atau '0' untuk selesai.");
                continue;
            }
            System.out.print("Jumlah: ");
            int amount = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            foodStalls.orders(item, amount);
        }
        int total = foodStalls.calculateTotalPrice();
        System.out.println("Total Pesanan: " + total);

        Cash cashPayment = new Cash(scanner);
        CreditCard creditCardPayment = new CreditCard(scanner);
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Pembayaran Tunai");
        System.out.println("2. Pembayaran Kartu Kredit");
        System.out.print("Pilih metode pembayaran: ");
        int payment = input.nextInt();

        methodPay metode;
        if (input.hasNextInt()) {
            payment = input.nextInt();

            if (payment == 1) {
                metode = cashPayment;
            } else if (payment == 2) {
                metode = creditCardPayment;
            } else {
                System.out.println("Metode pembayaran tidak valid.");
                return;
            }
        } else {
            System.out.println("Metode pembayaran tidak valid.");
            return;
        }
        metode.pay(foodStalls.showOrders(), total);

        // Setelah selesai pembayaran dengan metode pembayaran yang dipilih

//
// Simpan struk pembayaran ke dalam file
        String strukPembayaran = foodStalls.showOrders() + "\nTotal Harga: " + total;
        FileUtil.simpanStruk(strukPembayaran);
    }
}