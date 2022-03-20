import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15683 {
    static int max = Integer.MIN_VALUE;
    static int input[];
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int len = Integer.parseInt(br.readLine());
        input = new int[len];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            input[i] =Integer.parseInt(st.nextToken());
        }
        br.close();
        subset(0,0);
        System.out.println(max);
    }
    static void subset(int cnt, int sum){
        if(cnt == input.length){
            max = Math.max(max,sum);
        }else {
            subset(cnt + 1, sum + input[cnt]);
            subset(cnt + 1, sum);
        }
    }
}
