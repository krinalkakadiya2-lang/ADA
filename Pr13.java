import java.util.*;
public class Pr13
{
 public static void main(String args[])
 {
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter first string:");
 String s1 = sc.nextLine();
 System.out.println("Enter second string:");
 String s2 = sc.nextLine();
 int m = s1.length();
 int n = s2.length();
 int dp[][] = new int[m+1][n+1];
 for(int i = 1; i <= m; i++)
 {
 for(int j = 1; j <= n; j++)
 {
 if(s1.charAt(i-1) == s2.charAt(j-1))
 dp[i][j] = 1 + dp[i-1][j-1];
 else
 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
 }
 }
 int i = m, j = n;
 String scs = "";
 while(i > 0 && j > 0)
 {
 if(s1.charAt(i-1) == s2.charAt(j-1))
 {
 scs = s1.charAt(i-1) + scs;
 i--;
 j--;
 }
 else if(dp[i-1][j] > dp[i][j-1])
 {
 scs = s1.charAt(i-1) + scs;
 i--;
 }
 else
 {
 scs = s2.charAt(j-1) + scs;
 j--;
 }
 }
 while(i > 0)
 {
 scs = s1.charAt(i-1) + scs;
 i--;
 }
 while(j > 0)
 {
 scs = s2.charAt(j-1) + scs;
 j--;
 }
   System.out.println("\nShortest Common Supersequence: " + scs);
 System.out.println("Length: " + scs.length());
 }
}
   
