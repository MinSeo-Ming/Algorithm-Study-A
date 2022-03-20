import java.io.*;
import java.util.*;

public class BOJ_1916 {
    static int city;
    static ArrayList<ArrayList<Vertex>> list;

    public static void main(String[] args)throws Exception,NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        StringTokenizer st ;
       list = new ArrayList<>();

        for (int i = 0; i <= bus; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(from).add(new Vertex(to, weight));
        }
        st = new StringTokenizer(br.readLine()," ");
        int start =Integer.parseInt(st.nextToken());
        int end =Integer.parseInt(st.nextToken());

        br.close();


        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
        bw.write(dijkstra(start,end)+"\n");
        bw.flush();
        bw.close();


    }
    static int dijkstra(int start, int end){
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        int  distance []= new int[city+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start]=0;

        boolean []visited = new boolean[city+1];
        pq.offer(new Vertex(start,distance[start]));

        while(!pq.isEmpty()){
            Vertex cur = pq.poll();
            int idx = cur.end;
            if(!visited[idx]){
                visited[idx]=true;

                for (Vertex link: list.get(idx)) {
                    if(!visited[link.end]&&distance[idx] + link.minDistance < distance[link.end]){
                        distance[link.end]=distance[idx] + link.minDistance;
                        pq.offer(new Vertex(link.end, distance[link.end]));
                    }
                }
            }
        }
        return distance[end];
    }

    static class Vertex implements Comparable<Vertex>{
        int end;
        int minDistance;

        public Vertex(int no, int minDistance) {
            this.end = no;
            this.minDistance = minDistance;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.minDistance-o.minDistance;
        }
    }
}
