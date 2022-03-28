import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    static int N,S;
    static int[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        list = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; st.hasMoreTokens(); i++) {
            list[i]=Integer.parseInt(st.nextToken());
        }

        int re = solution();
        if(re==Integer.MAX_VALUE){
            System.out.println(0);
        }else System.out.println(re);
    }
    static int solution(){
        int lt=0 ,answer =Integer.MAX_VALUE;
        int sum =0;
        for (int rt = 0; rt < N; rt++) {
            sum += list[rt];

            while (sum>=S){


                if(answer > (rt-lt+1)) {
                    answer=rt-lt+1;
                }
                sum-=list[lt++];
            }
        }

        return answer;
    }
}
