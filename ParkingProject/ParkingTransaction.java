import java.time.LocalDateTime;

public class ParkingTransaction {
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private FeePolicy feePolicy;

    public ParkingTransaction(Vehicle vehicle, ParkingSpot spot, FeePolicy feePolicy) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.feePolicy = feePolicy;
        this.entryTime = LocalDateTime.now();
    }

    public void simulateCheckout(long durationInMinutes) {
        this.exitTime = entryTime.plusMinutes(durationInMinutes);
    }

    public long getDurationInMinutes() {
        return java.time.Duration.between(entryTime, exitTime).toMinutes();
    }

    public double calculateFee() {
        return feePolicy.calculateFee(getDurationInMinutes(), vehicle.getType());
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public String summary() {
        return "Vehicle: " + vehicle.getLicensePlate() +
               ", Spot: " + spot.getId() +
               ", Floor: " + spot.getFloor() +
               ", Duration: " + getDurationInMinutes() + " mins" +
               ", Fee: $" + calculateFee();
    }
}
