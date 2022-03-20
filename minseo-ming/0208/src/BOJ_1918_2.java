import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1918_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char str[] = br.readLine().toCharArray();
        List<Character> list = new ArrayList<>();

        int idx =0;
        for (char c: str) {
            if(c=='('){
                list.add(c);
                idx++;
            }else if(c==')'){
                while(!(list.get(--idx) =='(')){
                    sb.append(list.get(idx));
                    list.remove(idx);
                }
                list.remove(idx);
            }else if(c =='*'||c=='/'){
                if(list.size()==0) {
                    list.add(c);
                    idx++;
                }
                else {
                    if (list.get(idx-1) == '*' || list.get(idx-1) == '/') {
                        --idx;
                        sb.append(list.get(idx));
                        list.remove(idx);
                    }
                    list.add(c);
                    idx++;
                }
            }else if(c =='+'||c=='-'){
                if(list.size()==0) {
                    list.add(c);
                    idx++;
                }
                else if(list.get(idx-1)=='+'||list.get(idx-1)=='-') {
                    --idx;
                    sb.append(list.get(idx));
                    list.remove(idx);
                    list.add(c);
                    idx++;
                }

            }
            else{
                sb.append(c);
            }
        }
        while(!list.isEmpty()){
            sb.append(list.get(idx-1));
            list.remove(idx-1);
            --idx;
        }
        System.out.println(sb);

    }
}
