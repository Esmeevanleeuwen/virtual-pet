import java.util.Scanner;

public class GameController {
    private DigitalPet pet;
    private Scanner scanner;

    public GameController(DigitalPet pet) {
        this.pet = pet;
        this.scanner = new Scanner(System.in);
    }

    public void feed() {
        System.out.println("You are feeding " + pet.getName() + ".");
        // Aanroepen van een methode op pet om het te voeden
        pet.feed();
    }

    public void play() {
        System.out.println("You are playing with " + pet.getName() + ".");
        // Aanroepen van een methode op pet om te spelen
        pet.play();
    }

    public void sleep() {
        System.out.println("Putting " + pet.getName() + " to sleep.");
        // Aanroepen van een methode op pet om te slapen
        pet.sleep();
    }

    public void wakeUp() {
        System.out.println(pet.getName() + " is waking up.");
        // Aanroepen van een methode op pet om wakker te worden
        pet.wakeUp();
    }

    public void printStatus() {
        // Afdrukken van de status van het huisdier
        System.out.println(pet.getStatus());
    }

    public void passTime() {
        // Simulatie van tijd die verstrijkt
        pet.passTime();
    }
}
