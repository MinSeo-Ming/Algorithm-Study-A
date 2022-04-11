import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jol1082 {
    static int r,c,ans=0;
    static spot D,S;
    static char[][] map;
    static int []dx={-1,1,0,0},dy={0,0,-1,1};
    static boolean[][] visited,rock,fire;
    static Queue<spot> f = new ArrayDeque<>();
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        fire = new boolean[r][c];
        visited = new boolean[r][c];
        rock = new boolean[r][c];
        D = new spot();
        S = new spot();
        for (int i = 0; i < r; i++) {
            char []tm = br.readLine().toCharArray();
            for (int j = 0; j<c; j++) {
                char temp = tm[j];
                if(temp=='D') {
                    D.x=i;
                    D.y=j;
                    rock[i][j]=true;

                }else if(temp=='S') {
                    S.x=i;
                    S.y=j;
                    D.min = 1;
                }else if(temp=='*') {
                    f.offer(new spot(i,j));
                    fire[i][j]=true;
                }else if(temp=='X') {
                    rock[i][j]=true;
                }
            }

        }
        solution();
    }
    static void solution(){
        Queue<spot> q = new ArrayDeque<>();
        q.offer(S);
        visited[S.x][S.y] =true;
        while(!q.isEmpty()){
            spot temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int min  = temp.min;

            if(!f.isEmpty()) {
                ArrayList<spot> list = new ArrayList<>();
                ArrayList<spot> re_list = new ArrayList<>();
                while (!f.isEmpty()){
                    list.add(f.poll());
                }
                for (spot f_temp : list) {
                    int f_x = f_temp.x;
                    int f_y = f_temp.y;

                    for (int i = 0; i < 4; i++) {
                        int f_nx = f_x + dx[i];
                        int f_ny = f_y + dy[i];
                        if (f_nx >= 0 && f_ny >= 0 && f_nx < r && f_ny < c&&!rock[f_nx][f_ny]&&!fire[f_nx][f_ny]) {
                            fire[f_nx][f_ny] = true;
                            re_list.add(new spot(f_nx,f_ny));
//                            f.offer(new spot(f_nx,f_ny));
                        }
                    }
                }
                for (spot spot : re_list) {
                    f.offer(spot);
                }

            }
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0&&ny>=0&&nx<r&&ny<c&&!fire[nx][ny]&&!visited[nx][ny]&&!rock[nx][ny]){

                    visited[nx][ny]=true;
                    ans = Math.max(min+1,ans);
                    if(nx==D.x && ny==D.y){
                        System.out.println(ans);
                        return;
                    }
                    q.offer(new spot(nx,ny,min+1));
                }
            }
        }
        System.out.println("impossible");
        return;

    }

}
class spot{
    int x;
    int y;
    int min;

    public spot() {
    }public spot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public spot(int x, int y, int min) {
        this.x = x;
        this.y = y;
        this.min = min;
    }
}