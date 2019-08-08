package Ex3Encapsulation.Pr4PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        //TO DO
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        //TO DO
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        // TO DO
        this.weight = weight;
    }

    public double calculateCalories (){
        //TO DO
        return 0.00;
    }
}
