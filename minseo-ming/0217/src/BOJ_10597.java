import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BOJ_10597 {
    static String str;
    static boolean [] check = new boolean[51];
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        find(0,0,"");


    }
    static void find(int idx,int max,String temp){
        if(idx==str.length()){
            for (int i = 1; i <= max; i++) {
                if(!check[i]) return;
            }
            System.out.println(temp.trim());
            System.exit(0);
            return;
        }
        int ch =Integer.parseInt(str.substring(idx,idx+1));

        if(!check[ch]){           // 이전에 등록한적이 있는 배열인지.
            check[ch]=true;
            find(idx+1,(max<ch)? ch:max,temp+" "+ch);
            check[ch]=false;
        }
        if(idx<str.length()-1){
            ch = Integer.parseInt(str.substring(idx,idx+2));
            if(ch<=50&&!check[ch]){
                check[ch] =true;
                find(idx+2,(max<ch)? ch:max,temp+" "+ch);
                check[ch] =false;

            }

        }


    }
}
//155987643211011121314