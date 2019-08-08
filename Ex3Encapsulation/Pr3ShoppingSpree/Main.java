//package Ex3Encapsulation.Pr3ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personsInput = scanner.nextLine().split(";");
        String[] productsInput = scanner.nextLine().split(";");

        Map<String, Person> persons = new LinkedHashMap<>();

        for (int i = 0; i < personsInput.length; i++) {
            String[] tokens = personsInput[i].split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);

            Person person = new Person(name, money);

            persons.put(name, person);
        }

        Map<String, Product> products = new LinkedHashMap<>();

        for (int i = 0; i < productsInput.length; i++) {
            String[] tokens = productsInput[i].split("=");
            String name = tokens[0];
            double cost = Double.parseDouble(tokens[1]);

            Product product = new Product(name, cost);

            products.put(name, product);
        }

        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");

            String person = tokens[0];
            String product = tokens[1];

            persons.get(person).buyProduct(products.get(product));

        }

        for (Map.Entry<String, Person> stringPersonEntry : persons.entrySet()) {
            System.out.println(stringPersonEntry.getValue().toString());
        }
    }
}
