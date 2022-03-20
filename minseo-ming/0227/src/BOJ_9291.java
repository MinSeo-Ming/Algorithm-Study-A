import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9291 {
    public static void main(String[] args)throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        String check;
        for (int tc = 1; tc <= T; tc++) {
            int arr[][]= new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int  j=0;
                while (st.hasMoreTokens())
                    arr[i][j++] = Integer.parseInt(st.nextToken());
            }
            if(tc!=T) br.readLine();
            if(row(arr) &&col(arr)&&box(arr)){
                check ="CORRECT";
            } else {check = "INCORRECT";}
            sb.append("Case ").append(tc).append(": ").append(check).append("\n");

        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean box(int[][] arr) {
        boolean[] visited;
        int[] dx = {0,0,0,3,3,3,6,6,6};
        int[] dy = {0,3,6,0,3,6,0,3,6};
        for (int i = 0; i < 9; i++) {
            visited = new boolean[10];
            for (int j = dx[i]; j <dx[i]+3 ; j++) {
                for (int k = dy[i]; k < dy[i]+3; k++) {
                    if(visited[arr[j][k]])
                        return false;

                    visited[arr[j][k]] = true;
                }
            }
        }

        return true;
    }

    static boolean row (int arr[][]){
        for (int i = 0; i < 9; i++) {
            int sum =45;
            for (int a: arr[i] ) sum-=a;

            if(sum!=0) return false;
        }
        return true;
    }
    static boolean col (int arr[][]){
        for (int i = 0; i < 9; i++) {
            int sum =45;
            for (int j = 0; j < 9; j++) sum-=arr[j][i];
            if(sum!=0) return false;
        }
        return true;
    }
}
