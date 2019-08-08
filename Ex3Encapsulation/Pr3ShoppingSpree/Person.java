//package Ex3Encapsulation.Pr3ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct (Product product){
        double productCost = product.getCost();

        if (this.money < productCost){
            throw new IllegalArgumentException(String.format("%s can't afford %s%n", this.getName(), product.getName()));
        } else {
            products.add(product);
            this.money -= productCost;
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.getName(), this.products.isEmpty() ? "Nothing bought" : this.products.toString().replaceAll("[\\[\\]]",""));
    }
}
