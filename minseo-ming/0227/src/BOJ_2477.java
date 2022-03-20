import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2477 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int arr [] = new int[6];

        int x=0,y=0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int direction = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());
            arr[i]=move;
            if(direction<=2) x = Math.max(x,move);
            else  y = Math.max(y,move);
        }

        int minus =0;
        for(int i=0; i<5; i++){
            minus+= arr[i] * arr[i+1];
        }
        minus+= arr[0]*arr[5];
        int result = x*y -(x*y*3 - minus);
        System.out.println(result*num);


    }
}
