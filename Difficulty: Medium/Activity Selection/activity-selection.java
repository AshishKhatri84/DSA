//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        
        // Create a list of activities (start, finish)
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], finish[i]));
        }

        // Sort activities by their finish time
        activities.sort(Comparator.comparingInt(a -> a.finish));

        // Select activities greedily
        int count = 1; // Select the first activity
        int lastFinishTime = activities.get(0).finish;

        for (int i = 1; i < n; i++) {
            if (activities.get(i).start > lastFinishTime) {  // strictly greater condition
                count++;
                lastFinishTime = activities.get(i).finish;
            }
        }

        return count;
    }

    // Inner class to represent an activity
    static class Activity {
        int start, finish;
        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}
