import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    // Define teams and their probabilities
    static Map<String, Double> teams = new HashMap<>();

    // key-value pairs
    static {
        teams.put("Spurs", 14.0);
        teams.put("Pistons", 14.0);
        teams.put("Rockets", 14.0);
        teams.put("Hornets", 12.5);
        teams.put("Trailblazers", 10.5);
        teams.put("Magic", 9.0);
        teams.put("Pacers", 6.8);
        teams.put("Wizards", 6.7);
        teams.put("Jazz", 4.5);
        teams.put("Mavericks", 3.0);
        teams.put("Bulls", 1.8);
        teams.put("Thunder", 1.7);
        teams.put("Raptors", 1.0);
        teams.put("Pelicans", 0.5);
    }

    // main method to introduce and run simulation
    public static void main(String[] args) {
        System.out.println("Welcome to 2023 NBA Draft Lottery Simulation");
        simulation();
    }

    // simulation method
    public static void simulation() {
        // random method
        Random random = new Random();
        int winningNumber = random.nextInt(1001);

        // declare winningTeam outside the loop
        String winningTeam = null;

        // get team name and number for every team
        for (Map.Entry<String, Double> entry : teams.entrySet()) {
            String team = entry.getKey();
            double probability = entry.getValue();

            // create arraylist for team numbers
            ArrayList<Integer> teamNumbers = new ArrayList<>();

            // generate amount of numbers for each team, dependent on probability
            for (int i = 1; i <= probability * 10; i++) {
                // generating random ints but if int is already in teamnumber is already in the list then skip it
                int randomInt = random.nextInt(1001); // random int from 0 - 100

                if (teamNumbers.contains(randomInt)) {
                    continue;
                } else {
                    teamNumbers.add(randomInt);
                }
            }
            //System.out.println("Team: " + team + ", Numbers: " + teamNumbers);
            if (teamNumbers.contains(winningNumber)) {
                winningTeam = team;
            }
        }
        System.out.println("The " + winningTeam + " have won the NBA Draft Lottery!!");
    }
}
