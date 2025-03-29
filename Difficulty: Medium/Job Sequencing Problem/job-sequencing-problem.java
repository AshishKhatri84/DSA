//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

import java.util.*;

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];

        // Create job objects and store them in an array
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = Arrays.stream(deadline).max().getAsInt();
        int[] slots = new int[maxDeadline + 1]; // Track available slots (1-based index)
        Arrays.fill(slots, -1); // Initialize slots as empty

        int totalProfit = 0, jobCount = 0;

        // Schedule jobs
        for (Job job : jobs) {
            // Find the latest available slot before or at the deadline
            for (int t = Math.min(job.deadline, maxDeadline); t > 0; t--) {
                if (slots[t] == -1) { // If slot is empty
                    slots[t] = job.profit;
                    totalProfit += job.profit;
                    jobCount++;
                    break; // Move to the next job
                }
            }
        }

        return new ArrayList<>(Arrays.asList(jobCount, totalProfit));
    }
}

// Job class to store deadline and profit
class Job {
    int deadline, profit;

    public Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends