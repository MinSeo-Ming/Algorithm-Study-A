import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1614 {
    public static void main(String[] args)throws  Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        long finger = Integer.parseInt(br.readLine());
        long num = Integer.parseInt(br.readLine());
        if(finger==1 ||finger==5) System.out.println((long)(finger-1+num*8));
        else System.out.println((long) 4*num +1 +((num%2==1) ? 4-finger: finger-2));

    }
}
