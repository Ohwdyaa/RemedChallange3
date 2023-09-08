package org.binar;

import java.util.HashMap;
import java.util.List;

public class FoodStalls extends FoodOrders{

    private HashMap<String, Integer> order;
    public FoodStalls(List<String> foodList, List<String> drinkList, List<Integer> foodPrice, List<Integer> drinkPrice) {
        super(foodList, drinkList, foodPrice, drinkPrice);
        order = new HashMap<>();
    }

    @Override
    public String showOrders() {
        System.out.println("Daftar Menu:");
        System.out.println("Makanan:");
        for (int i = 0; i < getFoodList().size(); i++) {
            System.out.println((i + 1) + "." + getFoodList().get(i) + " | " + getFoodPrice().get(i));
        }
        System.out.println("Daftar Minuman:");
        for (int i = 0; i < getDrinkList().size(); i++) {
            System.out.println((i + 1) + "." + getDrinkList().get(i) + " | " + getDrinkPrice().get(i));
        }
        return null;
    }

    @Override
    public void orders(int menuNumber, int total) {
        String menu;
        int price;

        if(menuNumber >= 1 && menuNumber <= getFoodList().size()){
            menu = getFoodList().get(menuNumber - 1);
            price = getFoodPrice().get(menuNumber - 1);
        } else if (menuNumber > getFoodList().size() && menuNumber <= getFoodList().size() + getDrinkList().size()) {
            menu = getDrinkList().get(menuNumber - getFoodList().size() - 1);
            price = getDrinkPrice().get(menuNumber - getFoodList().size() - 1);
        } else {
            System.out.println("Nomor menu tidak valid.");
            return;
        }
        order.put(menu, order.getOrDefault(menu, 0) + total);
    }

    @Override
    public int calculateTotalPrice() {
        int total = 0;
        for (String menu : order.keySet()) {
            int amount = order.get(menu);
            if (getFoodList().contains(menu)) {
                total += (amount * getFoodPrice().get(getFoodList().indexOf(menu)));
            } else if (getDrinkList().contains(menu)) {
                total += (amount * getDrinkPrice().get(getDrinkList().indexOf(menu)));
            }
        }
        return total;
    }
//    public String getDetailPesanan() {
//        // Buat string untuk menyimpan detail pesanan
//        StringBuilder detail = new StringBuilder("Detail Pesanan:\n");
//
//        // Loop melalui daftar pesanan dan tambahkan ke string detail
//        for (int i = 0; i < order.size(); i++) {
//            String item = String.valueOf(order.get(i));
//            int jumlah = orderAmounts.get(i);
//            int harga = calculateItemPrice(item);
//            detail.append(item).append(" (Jumlah: ").append(jumlah).append(", Harga: ").append(harga).append(")\n");
//        }
//
//        return detail.toString();
//    }

}
