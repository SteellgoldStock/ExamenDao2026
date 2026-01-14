package restaurant;

import model.Dish;
import model.Order;
import model.Customer;
import validation.ValidationHandler;
import validation.AllergenValidation;
import validation.BalanceValidation;
import archive.ArchiveSingleton;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
		private List<Dish> dishList = new ArrayList<>();

		public void addDishes(List<Dish> items) {
				dishList.addAll(items);
		}

		public void processOrder(Order order, Customer customer) {
				ValidationHandler allergenCheck = new AllergenValidation();
				ValidationHandler balanceCheck = new BalanceValidation();

				allergenCheck.setNext(balanceCheck);

				boolean isValid = allergenCheck.validate(order, customer);

				if (isValid) {
						order.setStatus(true);
						order.setConclusion("Validé");
				}

				order.notifyObservers();

				String orderDetails = "Client: " + customer.getName() + " - " + order;
				ArchiveSingleton.getInstance().addOrder(orderDetails);
		}

		public List<Dish> getDishList() {
				return dishList;
		}
}