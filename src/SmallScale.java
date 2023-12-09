import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SmallScale {

    public static void main(String[] args) {
        welcome();

    }

    public static void welcome(){
        System.out.println("Welcome to NBA Draft Lottery");
        sim();
    }

    public static void sim(){
        String winningTeam = null;
        String secondPick = null;
        String thirdPick = null;
        //String fourthPick = null;

        //while (winningTeam != null && secondPick != null && thirdPick != null) {

        Random random = new Random();
        HashMap<String, Double> teamMap = new HashMap<String, Double>();
        ArrayList<Integer> allNums = new ArrayList<>();
        double spursProb = 15.0;
        teamMap.put("Spurs", spursProb);
        double lakersProb = 10.0;
        teamMap.put("Lakers", lakersProb);
        double heatProb = 5.0;
        teamMap.put("Heat", heatProb);
        double totalProbChance = spursProb + lakersProb + heatProb;
        int winningNumber = random.nextInt((int) totalProbChance)+1;
        System.out.println(winningNumber);

        for (String i : teamMap.keySet()) {
            String team = i;
            Double prob = teamMap.get(i);
            ArrayList<Integer> teamNums = new ArrayList<>();
            //System.out.println("The team is " + team);
            //System.out.println("The prob is " + value);
            Double targetSize = prob;

            while (teamNums.size() < targetSize) {
                int newRandNum = random.nextInt(30) + 1;
                if (!teamNums.contains(newRandNum) && (!allNums.contains(newRandNum))) {
                    teamNums.add(newRandNum);
                    allNums.add(newRandNum);
                }

            }
        System.out.println("The " + team + " numbers are " + teamNums);
            System.out.println(teamNums.size());

        if (teamNums.contains(winningNumber)){
            // if the current arraylist has the random number that is the winning number, then assign this team as the
            // winning team, announce the winning team, then we need to remove the winning team from the team Map and
            // subtract their probability from the possible winning numbers. Then rerun the program again with the teams
            // remaining and find the second place winning number in the arraylist.
            winningTeam = team;
            double winningTeamProb = prob;
            System.out.println("The " + winningTeam + " has won the first pick in the NBA Draft Lottery!!");

                }
            }
        }
    }
//}
