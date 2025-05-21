class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public String getLicensePlate() { return licensePlate; }
    public String getOwnerName() { return ownerName; }
    public int getHoursParked() { return hoursParked; }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }
}

class ParkingLot {
    private Vehicle[] vehicles;
    private int count;

    public ParkingLot() {
        vehicles = new Vehicle[5];
        count = 0;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (count < 5) {
            vehicles[count] = vehicle;
            count++;
            System.out.println("Vehicle parked successfully!");
        } else {
            System.out.println("Parking lot is full!");
        }
    }

    public void removeVehicle(String licensePlate) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                found = true;
                for (int j = i; j < count - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[count - 1] = null;
                count--;
                System.out.println("Vehicle removed successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle not found!");
        }
    }

    public void displayAllVehicles() {
        System.out.println("\nCurrent vehicles in parking lot:");
        if (count == 0) {
            System.out.println("The parking lot is empty.");
            return;
        }
        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            System.out.println("License: " + v.getLicensePlate() +
                               ", Owner: " + v.getOwnerName() +
                               ", Hours: " + v.getHoursParked());
        }
    }
}

public class MainApp2 {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        parkingLot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        parkingLot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        parkingLot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        parkingLot.removeVehicle("XYZ789");

        parkingLot.displayAllVehicles();

        Vehicle v = new Vehicle("TEST", "Test Owner", 0);
        v.setLicensePlate("NEW123");
        v.setOwnerName("New Owner");
        v.setHoursParked(3);
    }
}
