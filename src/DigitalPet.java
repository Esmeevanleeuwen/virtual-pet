public class DigitalPet {
    private String name;
    private int hunger;
    private int boredom;
    private int tiredness;
    private boolean asleep;
    private Mood mood;

    // Definieer de verschillende stemmingen van het huisdier
    public enum Mood {
        HAPPY, SAD, TIRED, ENERGETIC, NEUTRAL
    }
    

    public DigitalPet(String name) {
        this.name = name;
        this.hunger = 50; // Een middenwaarde om mee te beginnen
        this.boredom = 50; // Een middenwaarde om mee te beginnen
        this.tiredness = 50; // Een middenwaarde om mee te beginnen
        this.asleep = false;
        this.mood = Mood.NEUTRAL; // Begin met een neutrale stemming
    }

    public void feed() {
        if (asleep) {
            System.out.println(name + " is sleeping and cannot be fed right now.");
            mood = Mood.SAD; // Negatieve reactie op verstoring tijdens slaap
            return;
        }
        if (hunger < 5) {
            System.out.println(name + " is not hungry.");
            return;
        }
        hunger = Math.max(hunger - 5, 0);
        System.out.println(name + " has been fed.");
        mood = Mood.HAPPY; // Voeden verbetert de stemming
    }

    public void play() {
        if (asleep) {
            System.out.println(name + " is sleeping and cannot play right now.");
            mood = Mood.SAD; // Stemming verslechtert als het huisdier gestoord wordt
            return;
        }
        if (boredom < 10) {
            System.out.println(name + " doesn't feel like playing right now.");
            mood = Mood.TIRED; // Moe of ongeïnteresseerd
            return;
        }
        boredom = Math.max(boredom - 30, 0);
        System.out.println(name + " is playing and having fun!");
        mood = Mood.ENERGETIC; // Spelen verhoogt energie en geluk
    }

    public void sleep() {
        if (asleep) {
            System.out.println(name + " is already sleeping.");
            return;
        }
        if (tiredness < 5) {
            System.out.println(name + " is not tired.");
            return;
        }
        asleep = true;
        tiredness = 0;
        mood = Mood.TIRED; // Slapen verbetert de vermoeidheid
        System.out.println(name + " is now sleeping.");
    }

    public void wakeUp() {
        if (!asleep) {
            System.out.println(name + " is not sleeping.");
            return;
        }
        asleep = false;
        System.out.println(name + " is now awake.");
        mood = Mood.ENERGETIC; // Wakker worden brengt energie
    }

    public String getStatus() {
        return String.format(
            "Status of %s:\n- Hunger: %s\n- Boredom: %s\n- Tiredness: %s\n- Asleep: %s\n- Mood: %s", 
            name, 
            describeLevel(hunger), 
            describeLevel(boredom), 
            describeLevel(tiredness), 
            asleep ? "Yes" : "No",
            mood
        );
    }

    private String describeLevel(int level) {
        if (level < 20) return "Low";
        else if (level < 50) return "Moderate";
        else return "High";
    }

    public void passTime() {
        if (!asleep) {
            hunger = Math.min(hunger + 1, 100);
            boredom = Math.min(boredom + 1, 100);
            tiredness = Math.min(tiredness + 1, 100);
            if (hunger > 80 || boredom > 80 || tiredness > 80) {
                mood = Mood.SAD; // Negatieve stemmingen als behoeften niet worden vervuld
            }
        } else {
            tiredness = Math.max(tiredness - 2, 0);
            hunger = Math.min(hunger + 1, 100);
            boredom = Math.min(boredom + 1, 100);
        }
    }

    public String getName() {
        return name;
    }
}
