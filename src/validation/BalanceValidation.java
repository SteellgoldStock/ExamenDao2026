package validation;

import model.Order;
import model.Customer;

public class BalanceValidation extends ValidationHandler {

		@Override
		public boolean validate(Order order, Customer customer) {
				double totalPrice = order.getTotalPrice();
				double availableMoney = customer.getAvailableMoney();

				if (availableMoney < totalPrice) {
						order.setConclusion("Refusé car solde insuffisant (bsn de " + (availableMoney - totalPrice) + "€)");
						order.setStatus(false);
						return false;
				}

				if (nextHandler != null) {
						return nextHandler.validate(order, customer);
				}

				return true;
		}
}