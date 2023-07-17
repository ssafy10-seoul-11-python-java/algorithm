import java.io.*;
 
class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Node[] nodes;
    
    private static boolean checkIsOp(char data){
        return (data == '+' || data == '-' || data == '*' || data == '/');
    }
     
    private static class Node{
        public boolean isOp;
        public char op;
        public double num;
        public int left, right;
        Node(boolean isOp, char op, double num, int left, int right){
            this.isOp = isOp;
            this.op = op;
            this.num = num;
            this.left = left;
            this.right = right;
        }
         
        public double cal(){
            if(!isOp) return num;
             
            switch(this.op){
                case '+': return nodes[left].cal() + nodes[right].cal();
                case '-': return nodes[left].cal() - nodes[right].cal();
                case '*': return nodes[left].cal() * nodes[right].cal();
                case '/': return nodes[left].cal() / nodes[right].cal();
            }
            return 0;
        }
         
    }
     
    public static void main(String args[]) throws Exception
    {
 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            nodes = new Node[n+1];
            for(int i = 0; i < n; i++){
                String[] line = br.readLine().split(" ");
                int idx = Integer.parseInt(line[0]);
                boolean isOp = checkIsOp(line[1].charAt(0));
                 
                if(isOp){
                    char op = line[1].charAt(0);
                    int left = Integer.parseInt(line[2]);
                    int right = Integer.parseInt(line[3]);
                    nodes[idx] = new Node(isOp, op, 0, left, right);
                }
                else nodes[idx] = new Node(isOp, '_', Double.valueOf(line[1]), 0, 0);
            }
            bw.write("#"+test_case+" "+Math.round(nodes[1].cal())+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
