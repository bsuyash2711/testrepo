public class ParkingSpot {
    private int id;
    private VehicleType type;
    private boolean isOccupied;
    private int floor;

    public ParkingSpot(int id, VehicleType type, int floor) {
        this.id = id;
        this.type = type;
        this.floor = floor;
        this.isOccupied = false;
    }

    public boolean isAvailable() { return !isOccupied; }
    public void occupy() { isOccupied = true; }
    public void vacate() { isOccupied = false; }
    public VehicleType getType() { return type; }
    public int getId() { return id; }
    public int getFloor() { return floor; }

    @Override
    public String toString() {
        return "Spot " + id + " [Floor: " + floor + ", Type: " + type + ", Available: " + isAvailable() + "]";
    }
}
