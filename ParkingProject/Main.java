import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLotManager manager = new ParkingLotManager();

        while (true) {
            System.out.println("\n1. Check-In Vehicle");
            System.out.println("2. Check-Out Vehicle");
            System.out.println("3. Show Parking Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter vehicle registration number: ");
                    String regNumber = scanner.nextLine();

                    System.out.println("Select vehicle type:");
System.out.println("1. CAR");
System.out.println("2. BUS");
System.out.println("3. MOTORCYCLE");
System.out.print("Enter your choice (1-3): ");
String typeChoice = scanner.nextLine();

VehicleType type;
switch (typeChoice) {
    case "1":
        type = VehicleType.CAR;
        break;
    case "2":
        type = VehicleType.BUS;
        break;
    case "3":
        type = VehicleType.MOTORCYCLE;
        break;
    default:
        System.out.println("Invalid choice.");
        continue; // skip to next loop iteration
}


                    Vehicle vehicle = new Vehicle(regNumber, type);
                    manager.checkIn(vehicle);
                    break;

                case "2":
                    System.out.print("Enter vehicle registration number to check out: ");
                    String license = scanner.nextLine();

                    System.out.print("Enter parking duration in minutes: ");
                    int duration;
                    try {
                        duration = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid duration entered.");
                        break;
                    }

                    manager.simulateCheckOut(license, duration);
                    break;

                case "3":
                    manager.showStatus();
                    break;

                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
