import java.io.*;
import java.util.*;
 
class Note
{
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private int middle;
     
    public Note(int middle){
        this.middle  = middle;
    }
    public void insert(int a, int b){
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        if(middle < a){
            maxHeap.add(middle);
            minHeap.add(a);
            minHeap.add(b);
            middle = minHeap.poll();
        }
        else if(b < middle){
            minHeap.add(middle);
            maxHeap.add(a);
            maxHeap.add(b);
            middle = maxHeap.poll();
        }
        else{
            maxHeap.add(a);
            minHeap.add(b);
        }
    }
    public int getMiddle(){
        return middle;   
    }
}
 
 
class Solution
{
     
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
    public static void main(String args[]) throws Exception
    {
 
        int T;
        T=Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            Note note = new Note(Integer.parseInt(line[1]));
             
            int sum = 0;
            for(int i = 0; i < n; i++){
                line = br.readLine().split(" ");
                note.insert(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
                sum += note.getMiddle();
                sum %= 20171109;
            }
            bw.write("#"+test_case+" "+sum+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
