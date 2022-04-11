import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {
    static int num,price;
    static int[] coin,ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        num = Integer.parseInt(st.nextToken());
        price = Integer.parseInt(st.nextToken());

        coin = new int[num];
        for (int i = 0; i < num; i++) {
            coin[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);

        ans = new int[price+1];

        for (int i = 1; i <=price ; i++) {
            ans[i] =Integer.MAX_VALUE-1;
        }
        ans[0] =0;

        for (int i = 0; i < num; i++) {
            for (int j = coin[i]; j <= price ; j++) {
                ans[j] = Math.min(ans[j], ans[j - coin[i]] + 1);
            }
        }

        System.out.println(ans[price] ==(Integer.MAX_VALUE-1)? -1:ans[price]);
    }

}

/*

18 52
25
15
17
14
8
30
27
11
20
6
13
13
8
9
19
15
29
30

출처: https://joey09.tistory.com/97 [joie de vivre]


8 17
13
1
10
11
1
8
14
12
 */