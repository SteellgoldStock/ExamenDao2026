package restaurant;

import model.Dish;
import model.Order;
import model.Customer;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Dish> dishList = new ArrayList<>();

    public void addDish(Dish item) {}

    public void processOrder(Order order, Customer customer) {
        // Envoyer la commande dans le pattern chain of responsability

        // Si la commande est faisable, mettre à jour le statut de la commande
    }
}
