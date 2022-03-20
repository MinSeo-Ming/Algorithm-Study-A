import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136 {
    static int arr[][] = new int[10][10],result =0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        for(int i=0; i<10; i++){
            st= new StringTokenizer(br.readLine());
            for(int j =0; st.hasMoreTokens(); j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    static void find(int r,int c, int width){
        if(arr[r][c]==1){

        }
    }
}
