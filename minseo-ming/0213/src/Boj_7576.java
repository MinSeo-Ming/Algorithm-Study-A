import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_7576 {
    static int map[][],all;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int dx []={1,-1,0,0};
        int dy []={0,0,1,-1};

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        ArrayList<Integer> start_x = new ArrayList<>();
        ArrayList<Integer>start_y =new ArrayList<>();
        int  count =1;
        int all =0;
        all= y*x-1; //존재하는 토마토 개수
        map = new int[x][y];
        visited = new boolean[x][y];

        for(int i=0; i<x; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; st.hasMoreTokens(); j++){
                int c =Integer.parseInt(st.nextToken());
                if (c==1) {
                    start_x.add(i);
                    start_y.add(j);
                }else if(c==-1)
                    all--;
                map[i][j] =c;
            }
        }
        br.close();

        for(int i=0; i<start_x.size(); i++){
            bfs(start_x.get(i),start_y.get(i));
        }


        if(all>0)System.out.println("-1");
        else System.out.println(count);

    }
    static void bfs(int x,int y){

    }
}
