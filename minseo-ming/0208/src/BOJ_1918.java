import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class BOJ_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char str[] = br.readLine().toCharArray();
        List<Character> list = new ArrayList<>();

        int idx =0;
        for(char c : str){
            switch (c){
                case '(':
                    if(list.isEmpty()||list.get(idx-1)=='+'||
                            list.get(idx-1)=='-'|| list.get(idx-1)=='*'
                            ||list.get(idx-1)=='/') {
                        idx++;
                        list.add(c);
                    }
                case '*':
                case '/':
                    if(list.isEmpty()||list.get(idx-1)=='+'||list.get(idx-1)=='-') {
                        idx++;
                        list.add(c);
                    }else if(list.get(idx-1)=='*'||list.get(idx-1)=='/'){
                        --idx;
                        sb.append(list.get(idx));
                        list.remove(idx);
                    }
                    break;
                case'+':
                case'-':
                    if(list.isEmpty()) {
                        idx++;
                        list.add(c);
                    }
                    break;
                case')':
                    while (true){
                        --idx;
                        if(list.get(idx)=='(') {
                            list.remove(idx);
                            break;
                        }
                        sb.append(list.get(idx));
                        list.remove(idx);
                        if(list.size()==0)  break;
                    }
                    break;
                default:
                    sb.append(c);
//                    if(!list.isEmpty()) {
//                    --idx;
//                    sb.append(list.get(idx));
//                    list.remove(idx);
                    break;
                //}

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
