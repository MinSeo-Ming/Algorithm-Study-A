import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;

public class PRO_2022_kakao_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new StringReader(src));

        String temp [] =br.readLine().split(", ");
        int fees[] = new int[temp.length];
        int idx =0;
        for (String s : temp) {
            fees[idx++] = Integer.parseInt(s);
        }
        String records[]= br.readLine().split(", ");





        String new_records [][] = new String[records.length][3];
        HashMap<String,ArrayList<String >> Map_in = new LinkedHashMap<>();
        HashMap<String, ArrayList<String >> Map_out = new LinkedHashMap<>();

        idx =0;
        for (String record : records) {
            new_records[idx]  = record.split(" ");

            if(new_records[idx][2].equals("IN")) {
                ArrayList<String > list_in=Map_in.getOrDefault(new_records[idx][1], new ArrayList<String>());
                list_in.add(new_records[idx][0]);
                Map_in.put(new_records[idx][1],list_in);
            }
            else if(new_records[idx][2].equals("OUT")) {
                ArrayList<String > list_out=Map_out.getOrDefault(new_records[idx][1], new ArrayList<String>());
                list_out.add(new_records[idx][0]);
                Map_out.put(new_records[idx][1],list_out);
            }
            idx++;
        }



        ArrayList<String> key_list = new ArrayList<> (Map_in.keySet());
        Collections.sort(key_list);



        int answer[] =new int[key_list.size()];

        idx =0;
        for (String s : key_list) {
            if(s.equals("0"))break;

            ArrayList<String> in = Map_in.get(s);

            ArrayList<String> out = new ArrayList<>();
            if(Map_out.isEmpty()) out.add("23:59");
            else {
                out= Map_out.get(s);
            }
            if(out.size()<in.size()) out.add("23:59");

            int time =0;
            int cal =0;
            for (int i = 0; i < in.size(); i++) {
                String in_temp[] = in.get(i).split(":");
                String out_temp[] = out.get(i).split(":");
                int h =Integer.parseInt(out_temp[0]) -Integer.parseInt(in_temp[0]);
                int min =Integer.parseInt(out_temp[1]) -Integer.parseInt(in_temp[1]);
                time +=h *60 + min;
            }
            time -=fees[0];
            cal += fees[1];
            if(time>0){

                if(time>0) {
                    cal += (int) Math.ceil((double) time / fees[2]) * fees[3];
                }
            }
            answer[idx++]=cal;

        }

        for (int i : answer) {
            System.out.println(i);
        }



    }
    static String src3 ="180, 5000, 10, 600\n" +
            "05:34 5961 IN, 06:00 0000 IN, 06:34 0000 OUT, 07:59 5961 OUT, 07:59 0148 IN, 18:59 0000 IN, 19:09 0148 OUT, 22:59 5961 IN, 23:00 5961 OUT\n";

    static String src2 ="120, 0, 60, 591\n" +
            "[ryan con,ryan con,ryan con,ryan con\n" ;
    static String src5 ="1, 461, 1, 10\n" +
            "00:00 1234 IN\n" ;
    static String src ="180, 5000, 10, 600\n" +
            "05:34 5961 IN, 06:34 5961 OUT, 07:34 5961 IN, 08:34 5961 OUT, 09:34 5961 IN, 10:34 5961 OUT, 11:34 5961 IN, 12:34 5961 OUT\n" ;
}
/*
 [180, 5000, 10, 600],
    ["05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT"]
  )
 */