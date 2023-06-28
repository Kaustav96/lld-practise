package interview.practise.lld.parkingLot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Driver {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("practise/lld/parkingLot/input.txt"));
        PrintStream out = new PrintStream(new FileOutputStream("practise/lld/parkingLot/output.txt"));
        System.setOut(out);
        String[] input;
        input = reader.readLine().trim().split("\\s+");
        ParkingLot parkingLot = null;
        while (!input[0].equals("exit")) {
            switch (input[0]) {
                case "create_parking_lot":
                    parkingLot = new ParkingLot(input[1], Integer.parseInt(input[2]),Integer.parseInt(input[3]));
                    break;
                case "display":
                    switch (input[1]) {
                        case "free_count":
                            if(parkingLot != null) {
                                parkingLot.displayFreeCount(input[2]);
                            }
                            break;
                        case "free_slots":
                            if(parkingLot != null) {
                                parkingLot.displayFreeSlots(input[2]);
                            }
                            break;
                        case "occupied_slots":
                            if(parkingLot != null) {
                                parkingLot.displayOccupiedSlots(input[2]);
                            }
                            break;
                        default:
                            System.out.println("Invalid input. Try again");
                            break;
                    }
                    break;
                case "park_vehicle":
                    Vehicle vehicle = new Vehicle(input[2], input[3], input[1]);
                    if(parkingLot != null) {
                        parkingLot.parkVehicle(vehicle);
                    }
                    break;
                case "unpark_vehicle":
                    if(parkingLot != null) {
                        parkingLot.unparkVehicle(input[1]);
                    }
                    break;
                default:
                    System.out.println("Invalid input. Try again");
                    break;
            }
            input = reader.readLine().trim().split("\\s+");
        }
    }
}
