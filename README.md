

# 🚗 Parking Lot Management System

A Java-based console application that simulates a multi-floor parking lot with dynamic fee calculation and vehicle management.

## 🧰 Functionalities

### 1. **Vehicle Check-In**
- Users can check in a vehicle by entering its registration number and selecting its type (Car, Bus, Motorcycle).
- The system allocates a parking spot based on vehicle type and availability.
- Each vehicle type is assigned to a specific floor:
  - **Ground Floor**: Buses (5 spots)
  - **First Floor**: Cars (5 spots)
  - **Second Floor**: Motorcycles (5 spots)

### 2. **Vehicle Check-Out**
- Users can check out a vehicle by entering its registration number and parking duration (in minutes).
- The system calculates the parking fee based on the duration and vehicle type.
- The parking spot is marked as available after checkout.

### 3. **Parking Status Display**
- Shows the number of available spots for each vehicle type.
- Displays detailed information about each parking spot, including floor, type, and availability.

### 4. **Fee Calculation**
- Fees are calculated using a flexible policy interface (`FeePolicy`).
- Default rates:
  - **Motorcycle**: ₹0.50 per minute
  - **Car**: ₹1.00 per minute
  - **Bus**: ₹2.00 per minute
- Easily extendable by implementing custom fee policies.

### 5. **Spot Allocation Logic**
- Spots are allocated based on vehicle type and availability.
- Prevents duplicate check-ins for the same vehicle.




