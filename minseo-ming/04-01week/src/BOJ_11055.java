import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11055 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int idx =0, max = 0;
        int arr[] = new int[A];
        int LIS[] = new int[A];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < A; i++) {
            for (int j = 0; j < LIS.length; j++) {
                if(arr[j]<arr[i] ){
                    LIS[i]= Math.max(LIS[i],LIS[j]+arr[i]);
                }
            }

        }
        Arrays.sort(LIS);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(LIS[A-1]+"");
        bw.flush();
        bw.close();
    }

}
