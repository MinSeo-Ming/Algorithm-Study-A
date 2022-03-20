import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_13904 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int[num][2];

        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] =Integer.parseInt(st.nextToken());
            arr[i][1] =Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]) !=0 ? Integer.compare(o1[0],o2[0]): Integer.compare(o2[1],o1[1]);
            }
        });
        int count = arr[0][1];
        int d=arr[0][0];
        for(int i =1; i<num; i++){
            if(d<arr[i][0]){
                d = arr[i][0];
                count+=arr[i][1];
            }
        }
        System.out.println(count);
    }
}
