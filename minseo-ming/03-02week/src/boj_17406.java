import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17406 {
    static int [][]arr, spot;
    static int [] co,re;
    static int N,M,K;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; st.hasMoreTokens();  j++) {
                arr[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        spot= new int[K][3];
        co = new int[K];
        re = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            co[i]=i;
            spot[i][0]=Integer.parseInt(st.nextToken());
            spot[i][1]=Integer.parseInt(st.nextToken());
            spot[i][2]=Integer.parseInt(st.nextToken());
        }
        combi(0,0);

        for (int[] ints : list) {
            for (int anInt : ints) {
               int[][] temp= circle(arr,anInt);
                System.out.println("temp = " + temp);
            }
        }

    }
    static int[][] circle(int [][]arr,int i){
        int x = spot[i][0]-1;
        int y = spot[i][1]-1;

        int temp = arr[x-i-1][y-i];
        int temp2 = arr[x-i-1][y-i];
        // 오른쪽에서 왼쪽으로
        for (int j =y+i ; j <y-i+1 ; j--) {
            if(j==y+i)temp = arr[x-i][j];
            arr[x-i][j]=arr[x-i][y-1];
        }
        //
        arr[x-i][y+i]=temp;
        for (int j = x-i+1; j <x+i-1 ; j--) {
            if(j==x-i)temp2 = arr[j][y+i];
            arr[j][y+i]=arr[j-1][y+i];
        }

        for (int j = y-i+1; j < y+i; j++) {
            if(j==y-i+1)temp =arr[x+i][j];
            arr[x+i][j] =arr[x+i][j+1];
        }
        arr[x+i][y+i]=temp2;
        for (int j = x+i-1; j <x+i ; j++) {
            arr[j][y-i]=arr[j+1][y-i];
        }
        arr[x+i][y-i]=temp;

        return arr;
    }
    static void combi(int cnt, int start){
        if(cnt ==K){
            list.add(re);
            return;
        }
        else{
            for (int i = start; i < K; i++) {
                re[cnt]=co[i];
                combi(cnt+1,i+1);
            }
        }
    }
}
