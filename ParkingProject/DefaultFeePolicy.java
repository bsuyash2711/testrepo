public class DefaultFeePolicy implements FeePolicy {
    @Override
    public double calculateFee(long minutes, VehicleType type) {
        double rate;
        switch (type) {
            case MOTORCYCLE: rate = 0.5; break;
            case CAR: rate = 1.0; break;
            case BUS: rate = 2.0; break;
            default: rate = 1.0;
        }
        return minutes * rate;
    }
}
