import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        bfs(B,A);
    }
    static void bfs(long B, long A){
        Queue<Long>q = new ArrayDeque<>();
        q.offer(B);
        int count =0;
        long temp=0;
        while (!q.isEmpty()){
            temp = q.poll();
            if(temp%10 !=1 && temp%2==1){
                break;
            }
            else {
                if(temp%2==0){
                    temp/=2;
                }else{
                    temp /=10;
                }
                q.offer(temp);
                count++;
                if(temp<=A) break;
            }
        }
        if(temp==A) System.out.println(count+1);
        else System.out.println(-1);
    }
}
