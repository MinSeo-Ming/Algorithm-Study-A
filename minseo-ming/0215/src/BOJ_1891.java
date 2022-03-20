import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1891 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        char cur []= st.nextToken().toCharArray();
        int dist_y[] ={0,2,1,4,3};
        int dist_x[] ={0,4,3,2,1};

        st =new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int len = cur.length;
        int temp = cur[len-1]-'0';
        int c_y =
        if(len >1&&temp>0){
        }

    }
}
