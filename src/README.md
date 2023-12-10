# NBA Draft Lottery Simulator

This Java program simulates the NBA Draft Lottery, determining the draft order for the top four picks. The lottery odds are based on the actual probabilities assigned to each team.

## How to Use

1. **Run the Program:**
   - Execute the `main` method in the `SmallScale` class.
   - The program will welcome you to the NBA Draft Lottery and proceed to simulate the lottery.

2. **Simulation Results:**
   - The program will display the winning team for the first pick, second pick, third pick, and fourth pick in the NBA Draft Lottery.
   - The total probability and updated team probabilities will be printed after each pick.

## Lottery Odds

The lottery odds for each team are set according to the NBA rules. The program uses these probabilities to simulate the lottery process.

## Simulating the Lottery

The lottery simulation is performed in three iterations:
1. **First Pick:**
   - Randomly selects a winning team based on their assigned probabilities.
   - Removes the winning team from consideration for subsequent picks.

2. **Second Pick:**
   - Repeats the process for the second pick, considering the remaining teams.
   - Displays the team that gets the second pick.

3. **Third Pick:**
   - Similar process for the third pick.
   - Displays the team that gets the third pick.

4. **Fourth Pick:**
   - Final iteration for the fourth pick.
   - Displays the team that gets the fourth pick.

## Note
- The program utilizes Java's `Random` class to generate random numbers for the lottery simulation.
- The simulation assumes that no two teams can have the same pick in the draft.

Feel free to modify the program or integrate it into your projects as needed. Happy drafting!
