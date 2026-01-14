import model.Customer;
import model.Dish;
import model.Order;
import model.EAllergen;
import restaurant.Restaurant;
import archive.ArchiveSingleton;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
				// On remplis la liste des plats du restaurant

        Dish pizza = new Dish.DishBuilder()
                .name("Pizza Margherita")
                .price(12.50)
                .addIngredient("Tomate")
                .addIngredient("Mozzarella")
                .addIngredient("Basilic")
                .addAllergen(EAllergen.CELERY)
                .build();

        Dish salade = new Dish.DishBuilder()
                .name("Salade César")
                .price(8.00)
                .addIngredient("Laitue")
                .addIngredient("Poulet")
                .addIngredient("Parmesan")
                .addAllergen(EAllergen.MUSTARD)
                .build();

        Dish burger = new Dish.DishBuilder()
                .name("Burger Cacahuète")
                .price(15.00)
                .addIngredient("Pain")
                .addIngredient("Steak")
                .addIngredient("Sauce cacahuète")
                .addAllergen(EAllergen.PEANUT)
                .build();

        Dish dessert = new Dish.DishBuilder()
                .name("Tiramisu")
                .price(6.50)
                .addIngredient("Mascarpone")
                .addIngredient("Café")
                .build();

        restaurant.addDishes(Arrays.asList(pizza, salade, burger, dessert));

        // S1: Client sans allergie avec assez d'argent
        System.out.println("- Scénario 1: Commande valide");
        Customer client1 = new Customer.CustomerBuilder().name("Jean").money(50.0).build();
				duplicatedCode(restaurant, pizza, dessert, client1);

				// S2: Client avec allergie aux cacahuètes
        System.out.println("- Scénario 2: Commande avec allergène");
        Customer client2 = new Customer.CustomerBuilder().name("Marie").money(30.0).addAllergy(EAllergen.PEANUT).build();
				duplicatedCode(restaurant, burger, salade, client2);

				// S3: Client sans argent suffisant
        System.out.println("- Scénario 3: Solde insuffisant");
        Customer client3 = new Customer.CustomerBuilder().name("Paul").money(10.0).build();
				duplicatedCode(restaurant, pizza, burger, client3);

				// Historique
        System.out.println("- Historique complet");
        ArchiveSingleton.getInstance().displayHistory();
    }

		private static void duplicatedCode(Restaurant restaurant, Dish pizza, Dish dessert, Customer client) {
				Order order = new Order();
				order.addDishes(Arrays.asList(pizza, dessert));

				order.addObserver(client);

				restaurant.processOrder(order, client);
				System.out.println("Résultat: " + client.getMyOrder());
				System.out.println();
		}
}
