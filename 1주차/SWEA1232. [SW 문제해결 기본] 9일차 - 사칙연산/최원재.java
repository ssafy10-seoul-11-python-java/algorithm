import java.util.Scanner;
import java.io.FileInputStream;
 
class Node{
    char oper = ' ';
    double value = -1;
    Node left, right;
     
    public double get_value() {
        if(oper == '+') {
            return this.left.get_value() + this.right.get_value();
        }
        else if (oper == '-') {
            return this.left.get_value() - this.right.get_value();
        }
        else if (oper == '*') {
            return this.left.get_value() * this.right.get_value();
        }
        else if (oper == '/') {
            return this.left.get_value() / this.right.get_value();
        }
        else {
            return this.value;
        }
    }
}
     
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            Node[] arr = new Node[n+1];
            for (int i = 1; i<=n ;i++) {
                arr[i] = new Node();
            }
            int curr;
            String line;
            char val;
            for(int i = 1; i <= n; ++i) {
                curr = sc.nextInt();
                line = sc.next();
                val = line.charAt(0);
                if(val == '+' || val == '-' || val == '*' || val == '/' ) {
                    arr[i].left = arr[sc.nextInt()];
                    arr[i].right = arr[sc.nextInt()];
                    arr[i].oper = val;
                }
                else {
                    arr[i].value = Integer.parseInt(line);
                }
            }
            System.out.println("#" + test_case + " " + (int)arr[1].get_value());
        }
    }
}
