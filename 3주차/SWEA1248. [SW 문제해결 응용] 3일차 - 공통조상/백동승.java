import java.io.*;
import java.util.StringTokenizer;
  
class Node {
    public int level, size, idx;
    public Node left, right, parent;
    Node(int idx){
        this.idx = idx;
    }
    public void setChild(Node child){
        child.parent = this;
        if(this.left == null)
            this.left = child;
        else
            this.right = child;
    }
    public int setState(int level){
        this.level = level;
        this.size = 1;
        if(this.left != null)
            this.size += this.left.setState(level + 1);
        if(this.right != null)
            this.size += this.right.setState(level + 1);
        return this.size;
    }
    public Node findCommonAncestor(Node other){
        Node node1 = this;
        Node node2 = other;
        while(node1 != node2){
            if(node1.level >= node2.level)
                node1 = node1.parent;
            else
                node2 = node2.parent;
        }
        return node1;
    }
}
 
class Solution {
  
    private static final int MAX_NODE = 10001;
    private static Node[] nodes = new Node[MAX_NODE];
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
  
        for (int test_case = 1; test_case <= T; test_case++)
        {
            int v, e;
            Node node1, node2;
            Node parent, child, ances;
            st =new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
             
            for (int i = 1; i <= v; i++) {
                nodes[i] = new Node(i);
            }
            node1 = nodes[Integer.parseInt(st.nextToken())];
            node2 = nodes[Integer.parseInt(st.nextToken())];
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < e; i++) {
                parent = nodes[Integer.parseInt(st.nextToken())];
                child = nodes[Integer.parseInt(st.nextToken())];
                parent.setChild(child);
            }
            nodes[1].setState(0);
            ances = node1.findCommonAncestor(node2);
            bw.write("#" + test_case + " " + ances.idx + " " + ances.size + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
