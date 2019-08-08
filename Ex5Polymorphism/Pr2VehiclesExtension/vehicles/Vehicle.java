package Ex5Polymorphism.Pr2VehiclesExtension.vehicles;
//package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private boolean airConditionIsOn;
    private double fuelConsumption;
    private double additionalConsumption;
    private double tankCapacity;

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected Vehicle(double fuelQuantity, double fuelConsumption, double additionalConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setAirConditionIsOn(true);
        this.additionalConsumption = additionalConsumption;
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    protected void setFuelConsumption(double fuelConsumption) {
        if (airConditionIsOn) {
            this.fuelConsumption = fuelConsumption + additionalConsumption;
        }else {
            this.fuelConsumption = fuelConsumption;
        }
    }

    public void setAirConditionIsOn(boolean namaikati) {
            this.airConditionIsOn = namaikati;
    }

    public String drive(double distance) {
        String output = null;
        double fuelNeeded = distance * this.fuelConsumption;

        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;

            DecimalFormat format =
                    new DecimalFormat("#.##");

            output = String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    format.format(distance));
        } else {
            output = String.format("%s needs refueling",
                    this.getClass().getSimpleName());
        }

        return output;

    }

    public void reFuel(double fuel) {
        if (fuel < 1){
            System.out.println("Fuel must be a positive number");
        } else if (fuel > this.tankCapacity - this.fuelQuantity){
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += fuel;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
