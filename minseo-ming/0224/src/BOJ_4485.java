import java.io.*;
import java.util.*;

public class BOJ_4485 {
    static int N, arr[][] , dx[]={-1,1,0,0},dy[]={0,0,-1,1},distance[][];

    public static void main(String[] args) throws Exception, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {

            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            StringTokenizer st;
            arr = new int[N][N];
            distance = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; st.hasMoreTokens(); j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] =Integer.MAX_VALUE;
                }
            }
            sb.append("Problem ").append(tc).append(": ").append(dijkstra()).append("\n");
            tc++;
        }
        System.out.println(sb.toString());

    }

    static int dijkstra(){
        PriorityQueue <Vertex> pq = new PriorityQueue<>();
        distance[0][0] =arr[0][0];
        pq.offer(new Vertex(0,0,arr[0][0]));
        while(!pq.isEmpty()){
            Vertex temp = pq.poll();

            if(temp.black>distance[temp.x][temp.y] )continue;

            for(int i=0; i<4; i++){
                int nx = temp.x+dx[i];
                int ny = temp.y+dy[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<N){
                    if(distance[nx][ny]> distance[temp.x][temp.y]+arr[nx][ny]){
                        distance[nx][ny]= distance[temp.x][temp.y]+arr[nx][ny];
                        pq.offer(new Vertex(nx,ny, distance[nx][ny]));
                    }
                }
            }
        }
        return distance[N-1][N-1];
    }

    static class Vertex implements Comparable<Vertex>{
        int x;
        int y;
        int black;

        public Vertex(int x, int y, int black) {
            this.x = x;
            this.y = y;
            this.black = black;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.black- o.black;
        }
    }

}