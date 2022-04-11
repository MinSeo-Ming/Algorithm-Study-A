import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {
    static int k,w,h;
    static int[][]map;
    static int [] dx ={-1,1,0,0},dy={0,0,-1,1};
    static int [] horse_x={-2,-2,-1,-1,
                            1,1,2,2},
                horse_y={-1,1,-2,2,
                        -2,2,-1,1};
    public static void main(String[] args)  throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        for (int i = 0; i <h ; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; st.hasMoreTokens() ; j++) {
                map[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,k,0});

        boolean visited [][][] = new boolean[h][w][k+1];
        visited[0][0][0]=true;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int k_m = temp[2];
            int mv = temp[3];
            if(x==h-1 &&y==w-1) {
                System.out.println(mv);
                return;
            }
            if(check(x,y))continue;
            if(map[x][y]==1)continue;
            if(visited[x][y][k_m])continue;
            visited[x][y][k_m] =true;
            if(k_m!=0){
                for (int i = 0; i < 8; i++) {
                    int nx = x+horse_x[i];
                    int ny = y+horse_y[i];

                    q.offer(new int[]{nx,ny,k_m-1,mv+1});

                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                q.offer(new int[]{nx,ny,k_m,mv+1});

            }

        }
        System.out.println(-1);
        return;
    }
    static boolean check(int x, int y){
        if(x>=0&&y>=0&&x<h&&y<w){
            return false;
        }
        else return true;
    }
}


