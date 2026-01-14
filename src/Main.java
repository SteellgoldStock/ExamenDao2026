public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        // On remplis la liste des plats du restaurant

        // On créer un client, avec un builder
        Customer customer = new Customer();

        // Composition de la commande via un builder
        Order order = new Order();

        // On essaie de traiter la commande
        restaurant.processOrder(order, customer);

        // On affiche le statut de la commande, depuis le client
        System.out.println(customer.getOrderStatus());
    }
}
