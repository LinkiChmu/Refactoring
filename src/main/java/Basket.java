import java.util.Map;

public class Basket {
    protected Map<String, Integer> prices;
    protected Purchase[] purchases;

    public Basket(Map<String, Integer> prices) {
        this.prices = prices;
        this.purchases = new Purchase[prices.size()];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum() {
        long sum = 0;
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }

    public void printBasket() {
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " +
                    purchase.count + " шт. в сумме " +
                    (purchase.count * prices.get(purchase.title)) + " руб.");
        }
    }

    public void printPrices() {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : prices.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }

}
