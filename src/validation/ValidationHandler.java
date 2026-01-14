package validation;

import model.Order;
import model.Customer;

public abstract class ValidationHandler {
		protected ValidationHandler nextHandler;

		public void setNext(ValidationHandler handler) {
				this.nextHandler = handler;
		}

		public abstract boolean validate(Order order, Customer customer);
}