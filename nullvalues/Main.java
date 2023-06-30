package interview.practise.lld.nullvalues;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("Null");
        printVehicleDetails(vehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Seating - "+vehicle.getSeatCapacity());
        System.out.println("Tank - "+vehicle.getTankCapacity());
    }
}
