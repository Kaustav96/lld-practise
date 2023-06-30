package interview.practise.lld.nullvalues;

public class VehicleFactory {
    static Vehicle getVehicleObject(String vehicleType){
        if("car".equalsIgnoreCase(vehicleType)){
            return new Car();
        }

        return new Null();
    }
}
