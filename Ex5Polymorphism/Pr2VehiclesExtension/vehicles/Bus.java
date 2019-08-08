package Ex5Polymorphism.Pr2VehiclesExtension.vehicles;
//package vehicles;

public class Bus extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, ADDITIONAL_CONSUMPTION, tankCapacity);
    }
}
