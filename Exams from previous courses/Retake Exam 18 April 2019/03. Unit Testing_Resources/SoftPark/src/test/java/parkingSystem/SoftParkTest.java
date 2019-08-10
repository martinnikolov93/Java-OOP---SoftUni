package parkingSystem;


import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SoftParkTest {


    @Test(expected = UnsupportedOperationException.class)
    public void getParkingShouldThrowUnsupportedOperationExceptionIfTriedToBeModified () {

        SoftPark softPark = new SoftPark();

        softPark.getParking().remove("A1");
    }

    @Test
    public void getParkingShouldReturnUnmodifiableCollection () {
        SoftPark softPark = new SoftPark();

        Map<String, Car> parking;

        parking = new HashMap<>();

        parking.put("A1", null);
        parking.put("A2", null);
        parking.put("A3", null);
        parking.put("A4", null);
        parking.put("B1", null);
        parking.put("B2", null);
        parking.put("B3", null);
        parking.put("B4", null);
        parking.put("C1", null);
        parking.put("C2", null);
        parking.put("C3", null);
        parking.put("C4", null);

        Assert.assertEquals(softPark.getParking(), Collections.unmodifiableMap(parking));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowIAExceptionIfParkingSlotDoesntExist (){

        SoftPark softPark = new SoftPark();
        Car car = new Car("VW","PK1999SA");

        softPark.parkCar("Gosho", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowIAExceptionIfParkingSpotAlreadyTaken (){
        SoftPark softPark = new SoftPark();
        Car car = new Car("VW","PK1999SA");
        Car car2 = new Car("VW","PK1999SA");

        softPark.parkCar("A1",car);
        softPark.parkCar("A1",car2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowIAExceptionIfCarIsAlreadyParked (){
        SoftPark softPark = new SoftPark();
        Car car = new Car("VW","PK1999SA");

        softPark.parkCar("A1",car);
        softPark.parkCar("A1",car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowIAExceptionIfParkingSlotDoesntExist (){
        SoftPark softPark = new SoftPark();
        Car car = new Car("VW","PK1999SA");

        softPark.removeCar("6B", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removerCarShouldThrowIAExceptionIfCarDoesntExistInTheParkingSlot (){
        SoftPark softPark = new SoftPark();
        Car car = new Car("VW","PK1999SA");
        Car car2 = new Car("VW","PK1999SA");

        softPark.parkCar("A1",car);

        softPark.removeCar("A1", car2);
    }

    @Test
    public void parkCarShouldAddCarProperly (){
        SoftPark softPark = new SoftPark();
        Car car = new Car("VW","PK1999SA");

        softPark.parkCar("A1",car);

        Assert.assertEquals(car, softPark.getParking().get("A1"));


    }

    @Test
    public void removeCarShouldShouldSetCollectionValueToNull (){
        SoftPark softPark = new SoftPark();
        Car car = new Car("VW","PK1999SA");

        softPark.parkCar("A1",car);

        softPark.removeCar("A1", car);

        Assert.assertNull(softPark.getParking().get("A1"));
    }

}