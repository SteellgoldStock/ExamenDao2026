package model;

import observer.IObserver;
import java.util.ArrayList;
import java.util.List;

public class Customer implements IObserver {
    private String name;
    private double availableMoney;
    private List<EAllergen> allergies = new ArrayList<>();
    private String myOrder = "";

    // Constructeur privé pour forcer l'utilisation du Builder
    private Customer() {}

    public String getName() {
        return name;
    }

    public double getAvailableMoney() {
        return availableMoney;
    }

    public List<EAllergen> getAllergies() {
        return allergies;
    }

    public String getMyOrder() {
        return myOrder;
    }

    public void setMyOrder(String myOrder) {
        this.myOrder = myOrder;
    }

    @Override
    public void update(String message) {
        this.myOrder = message;
        System.out.println("Notif de " + name + ": " + message);
    }

    // Builder patern pour créer des clients
    public static class CustomerBuilder {
        private Customer customer;

        public CustomerBuilder() {
            this.customer = new Customer();
        }

        public CustomerBuilder name(String name) {
            customer.name = name;
            return this;
        }

        public CustomerBuilder money(double money) {
            customer.availableMoney = money;
            return this;
        }

        public CustomerBuilder addAllergy(EAllergen allergy) {
            customer.allergies.add(allergy);
            return this;
        }

        public Customer build() {
            return customer;
        }
    }
}
