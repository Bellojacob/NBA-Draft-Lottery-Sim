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
        ArrayList<Integer> thirdPlaceNums = new ArrayList<>();
        ArrayList<Integer> fourthPlaceNums = new ArrayList<>();

        double spursProb = 14.0 * 10;
        teamMap.put("Spurs", spursProb);
        double pistonsProb = 14.0 * 10;
        teamMap.put("Pistons", pistonsProb);
        double rocketsProb = 14.0 * 10;
        teamMap.put("Rockets", rocketsProb);
        double hornetsProb = 12.5 * 10;
        teamMap.put("Hornets", hornetsProb);
        double blazersProb = 10.5 * 10;
        teamMap.put("Trailblazers", blazersProb);
        double magicProb = 9.0 * 10;
        teamMap.put("Magic", magicProb);
        double pacersProb = 6.8 * 10;
        teamMap.put("Pacers", pacersProb);
        double wizProb = 6.7 * 10;
        teamMap.put("Wizards", wizProb);
        double jazzProb = 4.5 * 10;
        teamMap.put("Jazz", jazzProb);
        double mavsProb = 3.0 * 10;
        teamMap.put("Mavericks", mavsProb);
        double bullsProb = 1.8 * 10;
        teamMap.put("Bulls", bullsProb);
        double thunderProb = 1.7 * 10;
        teamMap.put("Thunder", thunderProb);
        double raptorsProb = 1.0 * 10;
        teamMap.put("Raptors", raptorsProb);
        double pelicansProb = 0.5 * 10;
        teamMap.put("Pelicans", pelicansProb);
        double totalProbChance = spursProb + pistonsProb + rocketsProb + hornetsProb + blazersProb + magicProb + pacersProb + wizProb + jazzProb + mavsProb + bullsProb + thunderProb + raptorsProb + pelicansProb;
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
        System.out.println("And the new set of teams are " + teamMap + "\n");
        //System.out.println(totalProbChance);
        int secondPlaceNumRandNum = random.nextInt((int) totalProbChance) + 1;
        //System.out.println(secondPlaceNumRandNum + "\n");


        System.out.println("This is the second iteration for second place\n");
        // run for loop for secondPlaceNum
        Double secondPlaceTeamProb = null;
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
                secondPlaceTeamProb = prob;
                System.out.println("The " + secondPick + " has Second pick in the NBA Draft Lottery!!");
            }
        }
        System.out.println("The total probability was " + totalProbChance + " and now the winning teams chance was : " + secondPick + " : " + secondPlaceTeamProb);
        teamMap.remove(secondPick);
        totalProbChance -= secondPlaceTeamProb;
        System.out.println("This mean the new total probable chance is " + totalProbChance);
        System.out.println("And the new set of teams are " + teamMap);
        //System.out.println(totalProbChance);
        int thirdPlaceNumRandNum = random.nextInt((int) totalProbChance) + 1;
        //System.out.println(thirdPlaceNumRandNum + "\n");


        // third iteration loop
        System.out.println("This is the third iteration for second place\n");
        // run for loop for thirdPlaceNum
        Double thirdPlaceTeamProb = null;
        for (String i : teamMap.keySet()) {
            String team = i;
            Double prob = teamMap.get(i);
            ArrayList<Integer> teamNums = new ArrayList<>();
            //System.out.println("The team is " + team);
            //System.out.println("The prob is " + value);
            Double targetSize = prob;

            while (teamNums.size() < targetSize) {
                int newRandNum = random.nextInt((int) totalProbChance) + 1;
                if (!teamNums.contains(newRandNum) && (!thirdPlaceNums.contains(newRandNum))) {
                    teamNums.add(newRandNum);
                    thirdPlaceNums.add(newRandNum);
                }
            }
            if (teamNums.contains(thirdPlaceNumRandNum)) {
                // if the current arraylist has the random number that is the winning number, then assign this team as the
                // winning team, announce the winning team, then we need to remove the winning team from the team Map and
                // subtract their probability from the possible winning numbers. Then rerun the program again with the teams
                // remaining and find the second place winning number in the arraylist.
                thirdPick = team;
                thirdPlaceTeamProb = prob;
                System.out.println("The " + thirdPick + " has Third pick in the NBA Draft Lottery!!");
            }
        }
        System.out.println("The total probability was " + totalProbChance + " and now the winning teams chance was : " + thirdPick + " : " + thirdPlaceTeamProb);
        teamMap.remove(thirdPick);
        totalProbChance -= thirdPlaceTeamProb;
        System.out.println("This mean the new total probable chance is " + totalProbChance);
        System.out.println("And the new set of teams are " + teamMap + "\n\n");
        //System.out.println(totalProbChance);
        int fourthPlaceNumRandNum = random.nextInt((int) totalProbChance) + 1;
        //System.out.println(thirdPlaceNumRandNum + "\n");


        String fourthPick = null;
        Double fourthPlaceTeamProb = null;
        for (String i : teamMap.keySet()) {
            String team = i;
            Double prob = teamMap.get(i);
            ArrayList<Integer> teamNums = new ArrayList<>();
            //System.out.println("The team is " + team);
            //System.out.println("The prob is " + value);
            Double targetSize = prob;

            while (teamNums.size() < targetSize) {
                int newRandNum = random.nextInt((int) totalProbChance) + 1;
                if (!teamNums.contains(newRandNum) && (!fourthPlaceNums.contains(newRandNum))) {
                    teamNums.add(newRandNum);
                    fourthPlaceNums.add(newRandNum);
                }
            }
            if (teamNums.contains(fourthPlaceNumRandNum)) {
                // if the current arraylist has the random number that is the winning number, then assign this team as the
                // winning team, announce the winning team, then we need to remove the winning team from the team Map and
                // subtract their probability from the possible winning numbers. Then rerun the program again with the teams
                // remaining and find the second place winning number in the arraylist.
                fourthPick = team;
                fourthPlaceTeamProb = prob;
                System.out.println("The " + fourthPick + " has Fourth pick in the NBA Draft Lottery!!");
            }
        }
        System.out.println("The total probability was " + totalProbChance + " and now the winning teams chance was : " + fourthPick + " : " + fourthPlaceTeamProb);
        teamMap.remove(fourthPick);
        totalProbChance -= fourthPlaceTeamProb;
        System.out.println("This mean the new total probable chance is " + totalProbChance);
        System.out.println("And the new set of teams are " + teamMap);
        //System.out.println(totalProbChance);
    }
}
