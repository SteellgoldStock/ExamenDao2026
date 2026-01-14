package validation;

import model.Order;
import model.Customer;
import model.Dish;
import model.EAllergen;
import java.util.List;

public class AllergenValidation extends ValidationHandler {

		@Override
		public boolean validate(Order order, Customer customer) {
				List<EAllergen> customerAllergies = customer.getAllergies();

				if (customerAllergies.isEmpty()) {
						if (nextHandler != null) {
								return nextHandler.validate(order, customer);
						}

						return true;
				}

				for (Dish dish : order.getDishes()) {
						for (EAllergen allergen : dish.getAllergens()) {
								if (customerAllergies.contains(allergen)) {
										order.setConclusion("Refusé car allergène détecté (" + allergen + " - " + dish.getName() + ")");
										order.setStatus(false);
										return false;
								}
						}
				}

				if (nextHandler != null) {
						return nextHandler.validate(order, customer);
				}

				return true;
		}
}