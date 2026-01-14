package model;

import observer.IObserver;
import java.util.ArrayList;
import java.util.List;

public class Order {
    // Pas de texte -> La commande est faisable
    // Du texte -> La commande est non faisable pour x raison
    private String conclusion = "";

    // False = non faite
    // true = faite
    private boolean status = false;

    // La liste des clients à notifier que la commande est faisable
    private List<IObserver> observers = new ArrayList<>();

    // Liste des plats dans la commande
    private List<Dish> dishes = new ArrayList<>();

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        String message = status ? "Validé" : conclusion;

        for (IObserver observer : observers) {
            observer.update(message);
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Commande de " + dishes.size() + " plat - " +
                "Total: " + getTotalPrice() + "€ - " +
                "Statut: " + (status ? "Validé" : conclusion);
    }
}
