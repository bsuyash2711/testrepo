public interface FeePolicy {
    double calculateFee(long durationInMinutes, VehicleType type);
}
