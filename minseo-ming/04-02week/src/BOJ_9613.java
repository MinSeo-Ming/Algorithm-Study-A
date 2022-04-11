import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9613 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int list[] = new int[n];
            for (int j = 0; j < n; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            int result =0;
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if(j!=k) result+=gcd(list[j],list[k]);
                }
            }

            System.out.println(result);

        }
    }
    static int gcd(int first, int second){
        int big,small,temp;
        if(first>second){
            big =first;
            small =second;
        }else {
            big =second;
            small =first;
        }
        while (small!=0){
            temp = big %small;
            big =small;
            small = temp;
        }
        return big;
    }
}
