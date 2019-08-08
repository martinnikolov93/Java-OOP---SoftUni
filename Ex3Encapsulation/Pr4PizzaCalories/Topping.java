package Ex3Encapsulation.Pr4PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        //TO DO
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        //TO DO
        this.weight = weight;
    }

    public double calculateCalories (){
        //TO DO
        return 0.00;
    }
}
