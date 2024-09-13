import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Virtual Pet Game!");
        System.out.print("Please enter a name for your pet: ");
        String petName = scanner.nextLine();

        DigitalPet pet = new DigitalPet(petName);
        GameController gameController = new GameController(pet);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nWhat would you like to do with " + pet.getName() + "?");
            System.out.println("1. Feed your pet");
            System.out.println("2. Play with your pet");
            System.out.println("3. Put your pet to sleep");
            System.out.println("4. Wake up your pet");
            System.out.println("5. Check pet's status");
            System.out.println("6. Do nothing (wait)");
            System.out.println("0. Exit the game");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();


       
            switch (choice) {
                case 1:
                    gameController.feed();
                    break;
                case 2:
                    gameController.play();
                    break;
                case 3:
                    gameController.sleep();
                    break;
                case 4:
                    gameController.wakeUp();
                    break;
                case 5:
                    gameController.printStatus();
                    break;
                case 6:
                    gameController.passTime();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("That's not a valid choice. Please try again.");
            }
            gameController.passTime(); // bij elke actie gaat er tijd voorbij
        }
        scanner.close();
    }
}
