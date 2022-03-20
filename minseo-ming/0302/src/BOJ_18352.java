import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352 {
    static ArrayList<ArrayList<Integer>> city = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," " );
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N ; i++) {
            city.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine()," ");
            city.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }


    }
    static void bfs(int start, int len){
        Queue<Integer>q = new ArrayDeque<>();
        q.offer(start);
        while (--len<0){
            ArrayList<Integer> temp = city.get(q.poll());
        }
    }
}
