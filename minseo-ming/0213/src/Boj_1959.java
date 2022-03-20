import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_1959 {
    public static void main(String[] args)throws Exception {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st=new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean visited[][] = new boolean[M][N];
        int count =0;
        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};
        int x =0, y =0 ,idx=0;
        int data = M *N-1;
        visited[0][0]=true;

        while(data>0){
            int nx = x +dx[idx];
            int ny = y +dy[idx];
            if(nx>=0&&ny>=0&& nx<M&&ny<N &&!visited[nx][ny]){
                data--;
                visited[nx][ny]=true;
                x= nx;
                y=ny;
            }else {
                count++;
                idx++;
                if(idx>=4)idx = idx%4;
            }
        }
        System.out.println(count);
        System.out.println(++x+" "+(++y));
    }
}


