import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

        Basket basket = new Basket(products);
        basket.printPrices();

        System.out.println("Введите два слова: название товара и количество. Или end");

        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            basket.addPurchase(product, count);
        }
        basket.printBasket();
        long sum = basket.sum();
        System.out.println("ИТОГО: " + sum);
    }
}
