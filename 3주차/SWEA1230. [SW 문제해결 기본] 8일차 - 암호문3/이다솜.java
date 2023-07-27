import java.io.*;
import java.util.StringTokenizer;

class Node {
    Node next;
    int value;

    Node(int value) {
        this.value = value;
    }

    Node( Node next, int value) {
        this.value = value;
        this.next = next;
    }
}

class LinkedList {
    Node first;
    Node last;

    LinkedList(Node n) {
        first = n;
        last = n;
    }

    Node getNodeByIndex(int index) {
        Node n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    void insert(int start, int count, int[] arr) {
        // a의 뒤에 넣어야 함
        Node a = getNodeByIndex(start);

        for(int i=0; i<arr.length ; i++){
            Node n = new Node(arr[i]);
            Node tmp = a.next;
            a.next = n;
            n.next = tmp;
            a = n;
        }
    }

    void delete(int start, int count) {
        Node a = getNodeByIndex(start);
        Node b = getNodeByIndex(start+count+1);
        a.next = b;
    }

    void add(Node n) {
        last.next = n;
        last = n;
    }

}


public class S1230 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int tc = 1 ; tc<= 10; tc++){

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 첫번째 패딩 노드 추가
            LinkedList list = new LinkedList(new Node(-1));

            //암호문 저장하여 초기 링크드 리스트 생성
            for (int i = 0; i < N; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                list.add(new Node(tmp));
            }

            st = new StringTokenizer(br.readLine());
            int change = Integer.parseInt(st.nextToken());
            String oper;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<change; i++){
                oper = st.nextToken();
                if (oper.equals("I")){
                    int start = Integer.parseInt(st.nextToken());
                    int cnt =Integer.parseInt(st.nextToken());
                    int [] arr = new int[cnt];
                    for(int j=0; j<cnt; j++){
                        arr[j] = Integer.parseInt(st.nextToken());
                    }
                    list.insert(start, cnt, arr);
                }else if(oper.equals("A")){
                    int cnt =Integer.parseInt(st.nextToken());
                    for(int j =0; j<cnt; j++){
                        list.add(new Node(Integer.parseInt(st.nextToken())));
                    }
                }else if(oper.equals("D")){
                    int start =Integer.parseInt(st.nextToken());
                    int cnt =Integer.parseInt(st.nextToken());
                    list.delete(start,cnt);
                }
            }
// 출력
            bw.write("#"+tc);
            Node n = list.first.next;
            for (int i = 0; i < 10; i++) {
                bw.write(" " +n.value);
                n = n.next;
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
