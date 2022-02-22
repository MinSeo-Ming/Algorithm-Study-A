import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_16398 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int [][]adjMatrix = new int[N][N];
        int [] minEdge = new int[N];
        boolean visited[] = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j =0; j<N; j++)
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());

            minEdge[i]=Integer.MAX_VALUE;
        }

        long result = 0;
        minEdge[0]=0;

        for (int c = 0; c < N; c++) {

            int min = Integer.MAX_VALUE;
            int minVertex = 0;
            for (int i = 0; i < N; i++) {
                if(!visited[i] &&min>minEdge[i]) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }
            visited[minVertex]=true;
            result  += min;

            for (int i = 0; i < N; i++) {
                if(!visited[i] && adjMatrix[minVertex][i]!=0&& minEdge[i] > adjMatrix[minVertex][i]) {
                    minEdge[i] = adjMatrix[minVertex][i];
                }
            }
        }

        System.out.println(result);

    }
}
