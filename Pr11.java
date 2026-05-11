import java.util.*;
public class Pr11
{
 public static void main(String args[])
 {
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter number of matrices:");
 int n = sc.nextInt();
 int p[] = new int[n+1];
 System.out.println("Enter dimensions array:");
 for(int i = 0; i <= n; i++)
 p[i] = sc.nextInt();
 int m[][] = new int[n+1][n+1];
 int s[][] = new int[n+1][n+1];
 for(int d = 1; d < n; d++)
 {
 for(int i = 1; i <= n-d; i++)
 {
 int j = i + d;
 m[i][j] = 999999;
 for(int k = i; k < j; k++)
 {
 int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
 if(q < m[i][j])
 {
 m[i][j] = q;
 s[i][j] = k;
 }
 }
 }
 }
 System.out.println("\nCost Table (m):");
 for(int i = 1; i <= n; i++)
 {
 for(int j = 1; j <= n; j++)
 {
 if(i > j)
 System.out.print("-\t");
 else
 System.out.print(m[i][j] + "\t");
 }
 System.out.println();
 }
 System.out.println("\nSplit Table (s):");
 for(int i = 1; i <= n; i++)
 {
 for(int j = 1; j <= n; j++)
 {
 if(i >= j)
 System.out.print("-\t");
 else
 System.out.print(s[i][j] + "\t");
 }
 System.out.println();
    }
 System.out.println("\nMinimum cost: " + m[1][n]);
 System.out.print("Optimal Parenthesization: ");
 printOptimal(s, 1, n);
 }
 static void printOptimal(int s[][], int i, int j)
 {
 if(i == j)
 {
 System.out.print("A" + i);
 }
 else
 {
 System.out.print("(");
 printOptimal(s, i, s[i][j]);
 printOptimal(s, s[i][j] + 1, j);
 System.out.print(")");
 }
 }
}
