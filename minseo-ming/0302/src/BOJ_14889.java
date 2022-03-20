import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14889 {
    static int N,result=Integer.MAX_VALUE;
    static int arr[][];
    static boolean get[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N][N];
        get =new boolean[N];



        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; st.hasMoreTokens(); j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        combi(0,0);
        System.out.println(result);


    }
    static int cal_a(){
        int sum=0;
        for (int i = 0; i < N; i++) {
            if(get[i]) continue;
            for (int j = 0; j < N; j++) {
                if(i==j)continue;
                if(!get[i]&&!get[j]){
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }
    static int cal_b(){
        int sum=0;
        for (int i = 0; i < N; i++) {
            if(!get[i]) continue;
            for (int j = 0; j < N; j++) {
                if(i==j)continue;
                if(get[i]&&get[j]){
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }
    static void combi(int start,int cnt){
        if(cnt==N/2) {
            result = Math.min(result, Math.abs(cal_a()-cal_b()));
        }
        for (int i = start; i < N; i++) {
            if(!get[i]) {
                get[i] = true;
                combi(i + 1, cnt+1);
                get[i] = false;
            }
        }
    }

}
