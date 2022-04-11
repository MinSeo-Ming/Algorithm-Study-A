import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class PRO_2022_kakao {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new StringReader(src));
        String id_list[]= br.readLine().split(", ");
        String report[] =br.readLine().split(",");;
        int k =Integer.parseInt(br.readLine());


        int results[] =new int[id_list.length];

        HashMap<String,Integer> map = new LinkedHashMap<>();
        for (String s : id_list) {
            map.put(s,0);
        }


        int idx =0;
        String temp[];

        HashMap<String, ArrayList<String>>name = new LinkedHashMap<>();

        for (String s : report) {
            temp = s.split(" ");
            ArrayList<String> in =name.getOrDefault(temp[0],new ArrayList<>());

            if(in.contains(temp[1])) continue;

            in.add(temp[1]);
            name.put(temp[0],in);
            map.put(temp[1], map.getOrDefault(temp[1],0)+1);
        }
        idx =0;
        for (String s : id_list) {
            ArrayList<String> get = name.get(s);
            if(get==null){
                ++idx;
                continue;//신고한게 없는경우.
            }
            for (String s1 : get) {
                int cnt = map.get(s1);
                if(cnt>=k)results[idx]++;
            }
            ++idx;
        }


    }
    static String src ="muzi, frodo, apeach, neo\n" +
            "muzi frodo,apeach frodo,frodo neo,muzi neo,apeach muzi\n" +
            "2";
    static String src2 ="con, ryan\n" +
            "[ryan con,ryan con,ryan con,ryan con\n" +
            "3";
}
