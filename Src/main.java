import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
    public class Main {

        public void main(String[] args) {
            while (true) {
                System.out.println("Hello! Make your order.");
                DrinksMachine drinksMachine = new DrinksMachine();
                drinksMachine.start();
                drinksMachine.process();
                System.out.println("GOD-BAYE!");
            }
        }

    }


    public static class DrinksMachine {

        private double totalCost = 0.0;

        private List<Drink> drinks = new ArrayList<>();

        public void start() {

            try (Scanner scanner = new Scanner(System.in)) {

                System.out.println("Please enter the name of the drink or press Enter to complete the order : "
                        + Arrays.toString(Drink.values()));

                while (true) {
                    String userInput = scanner.nextLine().trim().toUpperCase();
                    if (userInput.isEmpty()) break;
                    try {
                        Drink drink = Drink.valueOf(userInput);
                        this.drinks.add(drink);
                        this.totalCost += drink.getCost();
                    } catch (IllegalArgumentException e) {
                        System.out.println("You entered the wrong drink name. try again.");
                    }
                }
            }
        }

        public void process() {
            for (Drink drink : drinks) {
                System.out.println("Take your " + drink.getTitle());
                System.out.println("Price: " + drink.getCost());
            }
            System.out.println("Number of drinks: " + this.drinks.size());
            System.out.println("TOTAL COST : " + this.totalCost);
        }

        public double getTotalCost() {
            return totalCost;
        }

        public List<Drink> getDrinks() {
            return drinks;
        }

    }

    public enum Drink {

        COFFEE("Cofe", DrinkCost.COFFEE),
        TEA("tea", DrinkCost.TEA),
        LEMONADE("limonad", DrinkCost.LEMONADE),
        MOJITO("mohito", DrinkCost.MOJITO),
        MINERAL("minerals", DrinkCost.MINERAL),
        COLA("coca-cola", DrinkCost.COLA);

        private final String title;
        private final double cost;

        private Drink(String title, double cost) {
            this.title = title;
            this.cost = cost;
        }

        public String getTitle() {
            return title;
        }

        public double getCost() {
            return cost;
        }

    }

    public class DrinkCost {
        public final static double COFFEE = 5.90;
        public final static double TEA = 3.99;
        public final static double LEMONADE = 6.00;
        public final static double MOJITO = 9.50;
        public final static double MINERAL = 5.00;
        public final static double COLA = 7.00;
    }
}
