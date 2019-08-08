package Ex5Polymorphism.Pr2VehiclesExtension;

import Ex5Polymorphism.Pr2VehiclesExtension.vehicles.Car;
import Ex5Polymorphism.Pr2VehiclesExtension.vehicles.Truck;
import Ex5Polymorphism.Pr2VehiclesExtension.vehicles.Vehicle;
import Ex5Polymorphism.Pr2VehiclesExtension.vehicles.Bus;

/*import vehicles.Car;
import vehicles.Truck;
import vehicles.Vehicle;
import vehicles.Bus;*/

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("all")

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = produceVehicle(scanner.nextLine().split("\\s+"));
        Vehicle truck = produceVehicle(scanner.nextLine().split("\\s+"));
        Vehicle bus = produceVehicle(scanner.nextLine().split("\\s+"));

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String output = null;

            String command = tokens[0];
            String vehicle = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            if (command.equals("Drive")) {
                output = vehicles.get(vehicle).drive(value);
            } else if (command.equals("DriveEmpty")) {
                vehicles.get(vehicle).setAirConditionIsOn(false);
                output = vehicles.get(vehicle).drive(value);
            } else if (command.equals("Refuel")) {
                vehicles.get(vehicle).setAirConditionIsOn(true);
                vehicles.get(vehicle).reFuel(value);
            }

            if (output != null) {
                System.out.println(output);
            }
        }

        vehicles.forEach((key, value) -> {
            System.out.println(value);
        });
    }

    public static Vehicle produceVehicle(String[] data) {

        Vehicle vehicle = null;

        if (data[0].equals("Car")) {
            vehicle = new Car(
                    Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
        } else if (data[0].equals("Truck")) {
            vehicle = new Truck(
                    Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
        } else if (data[0].equals("Bus")){
            vehicle = new Bus(
                    Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
        }
        return vehicle;
    }
}
