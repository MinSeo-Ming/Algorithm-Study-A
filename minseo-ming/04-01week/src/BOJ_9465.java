import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    static int N;
    static int [][]arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[2][N];

        for (int tc = 0; tc < testcase; tc++) {
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; st.hasMoreTokens(); j++) {
                    arr[i][j] =Integer.parseInt(st.nextToken());
                }
            }
        }

    }
}
