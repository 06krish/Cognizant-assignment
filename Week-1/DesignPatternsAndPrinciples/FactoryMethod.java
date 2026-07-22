import java.util.*;
interface Vehicle{
    void started();
}
class Car implements Vehicle{
    @Override
    public void started(){
        System.out.println("Car started");
    }
}

class Bike implements Vehicle{
    @Override
    public void started(){
        System.out.println("Bike started");
    }
}
// responsible for creating object.
class vehicalfactory{
    
    public Vehicle getVehicle(String vehicleType){
        if(vehicleType == null){
            return null;
        }
        if(vehicleType.equalsIgnoreCase("Car")){
            return new Car();
        } else if(vehicleType.equalsIgnoreCase("Bike")){
            return new Bike();
        }
        return null;
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        vehicalfactory vehicleFactory = new vehicalfactory();

        Vehicle vehicle1 = vehicleFactory.getVehicle("Car");
        vehicle1.started();

        Vehicle vehicle2 = vehicleFactory.getVehicle("Bike");
        vehicle2.started();
    }
}
