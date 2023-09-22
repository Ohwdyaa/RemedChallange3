import org.binar.FoodStalls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodStallsTest {
    private FoodStalls foodStalls;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        // Persiapan objek FoodStalls
        List<String> foodList = Arrays.asList("Nasi Goreng", "Mie Ayam", "Ayam Bakar");
        List<String> drinkList = Arrays.asList("Teh Manis", "Jus Jeruk", "Air Mineral");
        List<Integer> foodPrice = Arrays.asList(17000, 15000, 20000);
        List<Integer> drinkPrice = Arrays.asList(5000, 7000, 3000);

        foodStalls = new FoodStalls(foodList, drinkList, foodPrice, drinkPrice);

        // Mengalihkan output ke ByteArrayOutputStream untuk pengujian showOrders
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

//    @Test
//    public void testShowOrders() {
//        // Memanggil metode showOrders
//        foodStalls.showOrders();
//
//        // Mendapatkan output dari System.out
//        String consoleOutput = outputStream.toString();
//
//        // Memeriksa apakah output sesuai dengan yang diharapkan
//        String expectedOutput = "Daftar Menu:\n" +
//                "Daftar Makanan:\n" +
//                "1.Nasi Goreng | 17000\n" +
//                "2.Mie Ayam | 15000\n" +
//                "3.Ayam Bakar | 20000\n" +
//                "Daftar Minuman:\n" +
//                "1.Teh Manis | 5000\n" +
//                "2.Jus Jeruk | 7000\n" +
//                "3.Air Mineral | 3000\n";
//        assertEquals(expectedOutput, consoleOutput);
//    }

    @Test
    public void testOrders() {
        // Memanggil metode orders
        foodStalls.orders(3, 2); // Pesan 2 Nasi Goreng

        // Mendapatkan order
        List<String> orders = foodStalls.getOrder().entrySet().stream()
                .map(entry -> entry.getKey() + " (" + entry.getValue() + " pesanan)")
                .collect(Collectors.toList());

        // Memeriksa apakah order sesuai dengan yang diharapkan
        List<String> expectedOrders = Arrays.asList("Ayam Bakar (2 pesanan)");
        assertEquals(expectedOrders, orders);
    }

    @Test
    public void testCalculateTotalPrice() {
        // Menambahkan beberapa pesanan
        foodStalls.orders(1, 2); // Pesan 2 Nasi Goreng

        // Menghitung total harga pesanan
        int total = foodStalls.calculateTotalPrice();

        // Memeriksa apakah total harga sesuai dengan yang diharapkan
        int expectedTotal = (2 * 17000); // (2 Nasi Goreng * Harga Nasi Goreng)
        assertEquals(expectedTotal, total);
    }
}
