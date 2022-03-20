import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3085 {
    static char arr[][];
    static int dx[] ={1,0};
    static int dy[] ={0,1};
    static int max=Integer.MIN_VALUE,N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr  = new char[N][N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<N-1; i++){
            for(int j =0; j<N-1; j++){
                if(arr[i][j]!=arr[i+1][j] ){
                    swap(i,j,i+1,j);
                    add_h(i,j);
                    add_w(i,j);
                    swap(i+1,j,i,j);
                }else if(arr[i][j]!=arr[i][j+1]){
                    swap(i,j,i,j+1);
                    add_h(i,j);
                    add_w(i,j);
                    swap(i,j+1,i,j);
                }

            }
        }
        System.out.println(max);
    }

    static void  swap(int x1,int y1, int x2,int y2){
        char temp = arr[x1][y1];
        arr[x1][y1] =arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static void add_w(int i,int j){
        int x=i, y =j;
        int count =1;
        while(true){
            int nx = x+1;
            int ny = y;
            if(nx>=0&&ny>=0&& nx<N &&ny<N&&arr[i+1][j]==arr[nx][ny]){
                count++;
                x=nx;
                y=ny;
            }else break;
        }
        max = Math.max(max,count);

    }
    static void add_h(int i,int j){
        int x=i, y =j;
        int count =1;
        while(true){
            int nx = x;
            int ny = y+1;
            if(nx>=0&&ny>=0&& nx<N &&ny<N&&arr[i][j+1]==arr[nx][ny]){
                count++;
                x=nx;
                y=ny;
            }else break;
        }
        max = Math.max(max,count);
    }

}
