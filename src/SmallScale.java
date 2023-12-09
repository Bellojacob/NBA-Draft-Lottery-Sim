import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SmallScale {

    public static void main(String[] args) {
        welcome();

    }

    public static void welcome() {
        System.out.println("Welcome to NBA Draft Lottery");
        sim();
    }

    public static void sim() {
        String winningTeam = null;
        String secondPick = null;
        String thirdPick = null;
        //String fourthPick = null;

        //while (winningTeam != null && secondPick != null && thirdPick != null) {

        Random random = new Random();
        HashMap<String, Double> teamMap = new HashMap<String, Double>();
        ArrayList<Integer> allNums = new ArrayList<>();
        ArrayList<Integer> secondPlaceNums = new ArrayList<>();
        double spursProb = 15.0;
        teamMap.put("Spurs", spursProb);
        double lakersProb = 10.0;
        teamMap.put("Lakers", lakersProb);
        double heatProb = 5.0;
        teamMap.put("Heat", heatProb);
        double totalProbChance = spursProb + lakersProb + heatProb;
        int winningNumber = random.nextInt((int) totalProbChance) + 1;
        //System.out.println(winningNumber);

        double winningTeamProb = 0;
        for (String i : teamMap.keySet()) {
            String team = i;
            Double prob = teamMap.get(i);
            ArrayList<Integer> teamNums = new ArrayList<>();
            //System.out.println("The team is " + team);
            //System.out.println("The prob is " + value);
            Double targetSize = prob;

            while (teamNums.size() < targetSize) {
                int newRandNum = random.nextInt((int) totalProbChance) + 1;
                if (!teamNums.contains(newRandNum) && (!allNums.contains(newRandNum))) {
                    teamNums.add(newRandNum);
                    allNums.add(newRandNum);
                }

            }
            //System.out.println("The " + team + " numbers are " + teamNums);
            //System.out.println(teamNums.size());

            if (teamNums.contains(winningNumber)) {
                // if the current arraylist has the random number that is the winning number, then assign this team as the
                // winning team, announce the winning team, then we need to remove the winning team from the team Map and
                // subtract their probability from the possible winning numbers. Then rerun the program again with the teams
                // remaining and find the second place winning number in the arraylist.
                winningTeam = team;
                winningTeamProb = prob;
                System.out.println("The " + winningTeam + " has won the first pick in the NBA Draft Lottery!!");

            }
        }
        System.out.println("The total probability was " + totalProbChance + " and now the winning teams chance was : " + winningTeam + " : " + winningTeamProb);
        teamMap.remove(winningTeam);
        totalProbChance -= winningTeamProb;
        System.out.println("This mean the new total probable chance is " + totalProbChance);
        System.out.println("And the new set of teams are " + teamMap);
        //System.out.println(totalProbChance);
        int secondPlaceNumRandNum = random.nextInt((int) totalProbChance) + 1;
        System.out.println(secondPlaceNumRandNum);



        // run for loop for secondPlaceNum
        for (String i : teamMap.keySet()) {
            String team = i;
            Double prob = teamMap.get(i);
            ArrayList<Integer> teamNums = new ArrayList<>();
            //System.out.println("The team is " + team);
            //System.out.println("The prob is " + value);
            Double targetSize = prob;

            while (teamNums.size() < targetSize) {
                int newRandNum = random.nextInt((int) totalProbChance) + 1;
                if (!teamNums.contains(newRandNum) && (!secondPlaceNums.contains(newRandNum))) {
                    teamNums.add(newRandNum);
                    secondPlaceNums.add(newRandNum);
                }
            }
            if (teamNums.contains(secondPlaceNumRandNum)) {
                // if the current arraylist has the random number that is the winning number, then assign this team as the
                // winning team, announce the winning team, then we need to remove the winning team from the team Map and
                // subtract their probability from the possible winning numbers. Then rerun the program again with the teams
                // remaining and find the second place winning number in the arraylist.
                secondPick = team;
                Double secondPlaceTeamProb = prob;
                System.out.println("The " + secondPick + " has Second pick in the NBA Draft Lottery!!");
            }
//}
        }
    }
}