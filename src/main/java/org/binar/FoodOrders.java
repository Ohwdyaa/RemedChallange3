package org.binar;

import java.util.List;

public abstract class FoodOrders {
    private List<String> foodList;
    private List<String> drinkList;
    private List<Integer> foodPrice;
    private List<Integer> drinkPrice;

    public FoodOrders(List<String> foodList, List<String> drinkList, List<Integer> foodPrice, List<Integer> drinkPrice){
        this.foodList = foodList;
        this.drinkList = drinkList;
        this.foodPrice = foodPrice;
        this.drinkPrice = drinkPrice;
    }

    //method menampilkan menu
    public abstract String showOrders();

    //method pesanan
    public abstract void orders(int menuNumber, int total);


    // Metode abstrak untuk menghitung harga total
    public abstract int calculateTotalPrice();


    // Setter untuk properti foodList
    public List<String> getFoodList(){
        return foodList;
    }
    public void setFoodList(List<String> foodList){
        this.foodList = foodList;
    }
    // Setter untuk properti foodList
    public List<String> getDrinkList(){
        return drinkList;
    }
    public void setDrinkList(List<String> drinkList){
        this.drinkList = drinkList;
    }

    // Setter untuk foodPrice
    public void setFoodPrice(List<Integer> foodPrice) {
        this.foodPrice = foodPrice;
    }
    public List<Integer> getFoodPrice() {
        return foodPrice;
    }

    // Setter untuk drinkPrice
    public void setDrinkPrice(List<Integer> drinkPrice) {
        this.drinkPrice = drinkPrice;
    }
    public List<Integer> getDrinkPrice() {
        return drinkPrice;
    }
}

