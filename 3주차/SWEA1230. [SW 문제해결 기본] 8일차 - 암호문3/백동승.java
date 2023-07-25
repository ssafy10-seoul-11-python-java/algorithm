import java.io.*;
import java.util.StringTokenizer;

class LinkedList{
	class Node{
    	int data;
        Node nxt;
        Node(int data, Node nxt){
        	this.data = data;
            this.nxt = nxt;
        }
    }
    Node head, tail;
    int size;
    /*
    class NodePool{
        private static Node[] nodes = new Node[1000000];
        static{
         	   for(int i =0; i<nodes.length; ++i){
                   nodes[i] = new Node();
               }
        }
        private static int cnt;
        public static init(){
        	cnt = 0;
        }
        public static getNode(int data, Node nxt){
        	Node newNode = node[cnt++];
            newNode.data = data;
            newNode.nxt = nxt;
            return newNode;
        }
    }
    */
    public LinkedList(){
    	head = tail = new Node(-1, null);
        size = 0;
    }
    
    public void insert(int x, int y, int[] s){
        if(size == x) {
        	add(y, s);
            return;
        }
    	Node cur = head;
        while(x-- != 0) cur = cur.nxt;
        for(int i = 0; i < y; i++){
            cur.nxt = new Node(s[i], cur.nxt);
            cur = cur.nxt;
        }
        size += y;
    }
    public void delete(int x, int y){
    	Node from = head;
        while(x-- != 0) from = from.nxt;
        Node to = from;
        while(y-- != 0) to = to.nxt;
        from.nxt = to;
    }
    public void add(int y, int[] s){
    	Node cur = tail;
        for(int i = 0; i < y; i++){
            cur.nxt = new Node(s[i], null);
            cur = cur.nxt;
        }
        tail = cur;
        size += y;
    }
    public void printTen(int test_case, BufferedWriter bw) throws Exception{
        Node cur = head.nxt;
        bw.write("#"+test_case);
    	for(int i = 0; i < 10; i++){
            bw.write(" "+cur.data);
            cur = cur.nxt;
        }
        bw.write("\n");
    }
}

class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer stk;
    private static LinkedList list;
	public static void main(String args[]) throws Exception
	{

		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            list = new LinkedList();
            
			int n = Integer.parseInt(br.readLine().trim());
            int[] s = new int[n];
			stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(stk.nextToken());
            }
			list.add(n,s);
            
            int m = Integer.parseInt(br.readLine().trim());
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                char command = stk.nextToken().charAt(0);
                int x, y;
                switch(command){
                    case 'I':
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        s = new int[y];
                        for(int i = 0; i < y; i++) s[i] = Integer.parseInt(stk.nextToken());
                        list.insert(x,y,s);
                        break;
                    case 'D':
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        list.delete(x,y);
                        break;
                    case 'A':
                        y = Integer.parseInt(stk.nextToken());
                        s = new int[y];
                        for(int i = 0; i < y; i++) s[i] = Integer.parseInt(stk.nextToken());
                        list.add(y,s);
                        break;
                }
                
            }
            list.printTen(test_case, bw);
            
		}
        bw.flush();
        bw.close();
        br.close();
	}
}
