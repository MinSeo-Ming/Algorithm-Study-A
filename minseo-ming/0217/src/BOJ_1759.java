import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static int L,C;
    static char input[],result[];
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; st.hasMoreTokens(); i++) {
            input[i] = st.nextToken().charAt(0);
        }
        result = new char[L];
        Arrays.sort(input);
        make(0,0);

    }

    static void make(int cnt , int start){
        if(cnt ==L){
            int count=0,vol=0;
            StringBuilder sb = new StringBuilder();

            for (char c : result) {
                sb.append(c);
                switch (c){
                    case'a':
                    case'e':
                    case'i':
                    case'o':
                    case'u':
                        ++vol;
                        break;
                    default:
                        ++count;
                        break;
                }
            }
            if(vol>=1&&count>=2) System.out.println(sb);

            return;
        }
        else{
            for(int i=start; i<C; i++){
                result[cnt]= input[i];
                make(cnt+1,i+1);
            }
        }
    }
}
