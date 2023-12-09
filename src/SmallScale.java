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
        Random random = new Random();
        HashMap<String, Double> teamMap = new HashMap<String, Double>();
        ArrayList<Integer> allNums = new ArrayList<>();
        teamMap.put("Spurs", 15.0);
        teamMap.put("Lakers", 10.0);
        teamMap.put("Heat", 5.0);
        int winningNumber = random.nextInt(30)+1;
        //System.out.println(winningNumber);

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
            System.out.println("The " + team + " has won the first pick in the NBA Draft Lottery!!");
        } else {
            continue;
        }
        }




    }
}
