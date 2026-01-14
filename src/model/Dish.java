package model;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private double price;
    private List<String> ingredients = new ArrayList<>();
    private List<EAllergen> allergens = new ArrayList<>();

    // Constructeur privé pour forcer l'utilisation du Builder
    private Dish() {}

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<EAllergen> getAllergens() {
        return allergens;
    }

    @Override
    public String toString() {
        return name + " - " + price + "€ (allergenes: " + allergens + ")";
    }

    // Builder pattern pour créer des plats
    public static class DishBuilder {
        private Dish dish;

        public DishBuilder() {
            this.dish = new Dish();
        }

        public DishBuilder name(String name) {
            dish.name = name;
            return this;
        }

        public DishBuilder price(double price) {
            dish.price = price;
            return this;
        }

        public DishBuilder addIngredient(String ingredient) {
            dish.ingredients.add(ingredient);
            return this;
        }

        public DishBuilder addAllergen(EAllergen allergen) {
            dish.allergens.add(allergen);
            return this;
        }

        public Dish build() {
            return dish;
        }
    }
}
