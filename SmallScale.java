import java.util.ArrayList;
import java.util.Collections;
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
        //int number1  = random.nextInt((int) totalProbChance) + 1;
        int number1 = random.nextInt((int) totalProbChance) + 1;
        int number2 = random.nextInt((int) totalProbChance) + 1;
        int number3 = random.nextInt((int) totalProbChance) + 1;
        int number4 = random.nextInt((int) totalProbChance) + 1;
        int number5 = random.nextInt((int) totalProbChance) + 1;

        int winningNumber = (number1 + number2 + number3 + number4 + number5) / 5;
        //System.out.println(winningNumber);

        ArrayList<String> list = new ArrayList<>();
        list.add("Pistons");
        list.add("Spurs");
        list.add("Rockets");
        list.add("Hornets");
        list.add("Trailblazers");
        list.add("Magic");
        list.add("Pacers");
        list.add("Wizards");
        list.add("Jazz");
        list.add("Mavericks");
        list.add("Bulls");
        list.add("Thunder");
        list.add("Raptors");
        list.add("Pelicans");

        double winningTeamProb = 0;
        String firstDraftTeam = null;
        int firstDraftPosition = 0;
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
                firstDraftPosition = 0;
                firstDraftTeam = team;
                //System.out.println("The " + winningTeam + " has won the first pick in the NBA Draft Lottery!!");

            }
        }
        //System.out.println("The total probability was " + totalProbChance + " and now the winning teams chance was : " + winningTeam + " : " + winningTeamProb);
        teamMap.remove(winningTeam);
        totalProbChance -= winningTeamProb;
        //System.out.println("This mean the new total probable chance is " + totalProbChance);
        //System.out.println("And the new set of teams are " + teamMap + "\n");
        //System.out.println(totalProbChance);
        int secondPlaceNumRandNum = random.nextInt((int) totalProbChance) + 1;
        //System.out.println(secondPlaceNumRandNum + "\n");


        //System.out.println("This is the second iteration for second place\n");
        // run for loop for secondPlaceNum
        Double secondPlaceTeamProb = null;
        String secondDraftTeam = null;
        int secondDraftPosition = 0;
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
                secondPick = team;
                secondPlaceTeamProb = prob;
                secondDraftPosition = 1;
                secondDraftTeam = team;
               // System.out.println("The " + secondPick + " has Second pick in the NBA Draft Lottery!!");
            }
        }
        //System.out.println("The total probability was " + totalProbChance + " and now the winning teams chance was : " + secondPick + " : " + secondPlaceTeamProb);
        teamMap.remove(secondPick);
        totalProbChance -= secondPlaceTeamProb;
        //System.out.println("This mean the new total probable chance is " + totalProbChance);
        //System.out.println("And the new set of teams are " + teamMap);
        //System.out.println(totalProbChance);
        int thirdPlaceNumRandNum = random.nextInt((int) totalProbChance) + 1;
        //System.out.println(thirdPlaceNumRandNum + "\n");


        // third iteration loop
       // System.out.println("This is the third iteration for second place\n");
        // run for loop for thirdPlaceNum
        Double thirdPlaceTeamProb = null;
        String thirdDraftTeam = null;
        int thirdDraftPosition = 0;
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
                thirdPick = team;
                thirdPlaceTeamProb = prob;
                thirdDraftPosition = 2;
                thirdDraftTeam = team;
                //System.out.println("The " + thirdPick + " has Third pick in the NBA Draft Lottery!!");
            }
        }
       // System.out.println("The total probability was " + totalProbChance + " and now the winning teams chance was : " + thirdPick + " : " + thirdPlaceTeamProb);
        teamMap.remove(thirdPick);
        totalProbChance -= thirdPlaceTeamProb;
        //System.out.println("This mean the new total probable chance is " + totalProbChance);
       // System.out.println("And the new set of teams are " + teamMap + "\n\n");
        //System.out.println(totalProbChance);
        int fourthPlaceNumRandNum = random.nextInt((int) totalProbChance) + 1;
        //System.out.println(thirdPlaceNumRandNum + "\n");


        String fourthPick = null;
        Double fourthPlaceTeamProb = null;
        String fourthDraftTeam = null;
        int fourthDraftPosition = 0;
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
                fourthPick = team;
                fourthPlaceTeamProb = prob;
                fourthDraftPosition = 3;
                fourthDraftTeam = team;
                //System.out.println("The " + fourthPick + " has Fourth pick in the NBA Draft Lottery!!");
            }
        }
        //System.out.println("The total probability was " + totalProbChance + " and now the winning teams chance was : " + fourthPick + " : " + fourthPlaceTeamProb);
        teamMap.remove(fourthPick);
        totalProbChance -= fourthPlaceTeamProb;
        //System.out.println("This mean the new total probable chance is " + totalProbChance);
        //System.out.println("And the new set of teams are " + teamMap);
        //System.out.println(totalProbChance);

        list.remove(firstDraftTeam);
        list.add(firstDraftPosition, firstDraftTeam);

        list.remove(secondDraftTeam);
        list.add(secondDraftPosition, secondDraftTeam);

        list.remove(thirdDraftTeam);
        list.add(thirdDraftPosition, thirdDraftTeam);

        list.remove(fourthDraftTeam);
        list.add(fourthDraftPosition, fourthDraftTeam);

        //System.out.println(list);
        Collections.reverse(list);

        int i = list.size();
        for (String element : list) {
            System.out.println(i + ". " + element);
            i--;
            if (i >= 5) {
                try {
                    Thread.sleep(1000);  // Sleep for 1000 milliseconds (1 second)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (i < 5) {
                try {
                    Thread.sleep(1500);  // Sleep for 1000 milliseconds (1 second)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        //System.out.println(list);
        //System.out.println(list.size());


    } // end of sim method
}
