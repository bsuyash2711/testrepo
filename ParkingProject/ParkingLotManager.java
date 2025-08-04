import java.util.*;

public class ParkingLotManager {
    private List<ParkingSpot> spots = new ArrayList<>();
    private Map<String, ParkingTransaction> activeTransactions = new HashMap<>();
    private FeePolicy feePolicy;

    public ParkingLotManager() {
        this.feePolicy = new DefaultFeePolicy();

        // Ground Floor - BUS
        for (int i = 1; i <= 5; i++) spots.add(new ParkingSpot(i, VehicleType.BUS, 0));

        // First Floor - CAR
        for (int i = 6; i <= 10; i++) spots.add(new ParkingSpot(i, VehicleType.CAR, 1));

        // Second Floor - MOTORCYCLE
        for (int i = 11; i <= 15; i++) spots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE, 2));
    }

    public ParkingSpot allocateSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.getType() == vehicle.getType() && spot.isAvailable()) {
                spot.occupy();
                return spot;
            }
        }
        return null;
    }

    public void checkIn(Vehicle vehicle) {
        if (activeTransactions.containsKey(vehicle.getLicensePlate())) {
            System.out.println("Vehicle already checked in.");
            return;
        }

        ParkingSpot spot = allocateSpot(vehicle);
        if (spot == null) {
            System.out.println("No available spot for " + vehicle.getType() + ". Parking is full.");
            return;
        }

        ParkingTransaction transaction = new ParkingTransaction(vehicle, spot, feePolicy);
        activeTransactions.put(vehicle.getLicensePlate(), transaction);
        System.out.println("Checked in: " + vehicle.getLicensePlate() + " to spot " + spot.getId() + " on floor " + spot.getFloor());
    }

    public void simulateCheckOut(String licensePlate, long durationInMinutes) {
        ParkingTransaction transaction = activeTransactions.remove(licensePlate);
        if (transaction == null) {
            System.out.println("Vehicle not found or not checked in.");
            return;
        }

        transaction.simulateCheckout(durationInMinutes);
        transaction.getSpot().vacate();
        System.out.println(transaction.summary());
    }

    public void showStatus() {
        System.out.println("\n--- Parking Lot Status ---");
        for (VehicleType type : VehicleType.values()) {
            long available = spots.stream()
                .filter(s -> s.getType() == type && s.isAvailable())
                .count();
            System.out.println(type + ": " + available + " spots available");
        }

        System.out.println("\nDetailed Spot Info:");
        for (ParkingSpot spot : spots) {
            System.out.println(spot);
        }
    }
}
