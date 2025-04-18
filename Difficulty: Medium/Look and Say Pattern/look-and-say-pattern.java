//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        
System.out.println("~");
}
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String lookandsay(int n) {
        String s = "1";
        for(int i=2; i<= n; i++){
            s = countandAdd(s);
        }
        return s;
    }
    String countandAdd(String s){
        StringBuilder currString = new StringBuilder();
        char ch = s.charAt(0);
        int count = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == ch){
                count++;
            }
            else{
                currString.append(count);
                currString.append(ch);
                ch = s.charAt(i);
                count = 1;
            }
        }
        currString.append(count);
        currString.append(ch);
        return currString.toString();
    }
}