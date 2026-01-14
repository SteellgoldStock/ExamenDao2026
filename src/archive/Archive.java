package archive;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    private List<String> orderHistory;

    public Archive() {
        this.orderHistory = new ArrayList<>();
    }

    public void addOrder(String orderDetails) {
        orderHistory.add(orderDetails);
    }

    public void displayHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("Aucune commande");
            return;
        }
        
        System.out.println("Historique des commandes");

        for (int i = 0; i < orderHistory.size(); i++) {
            System.out.println((i + 1) + ". " + orderHistory.get(i));
        }

        System.out.println("---");
    }

    public List<String> getOrderHistory() {
        return orderHistory;
    }
}
