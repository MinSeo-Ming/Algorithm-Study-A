import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //읽어 들이기 위한 작업
        StringBuilder sb = new StringBuilder(); //한번에 출력하기 위한 변수
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //출력하기 위한 작업
        StringTokenizer st;


        int N, X, K; //각각 순서대로 종이컵의 수, 처음 간식이 들어있는 위치, 컵의 위치를 바꾸는 횟수
        int A,B;	//컵의 위치를 바꿀 각각의 위치


        st = new StringTokenizer(br.readLine()); //한줄로 입력을 받고
        N = Integer.parseInt(st.nextToken()); //종이컵의 수
        X = Integer.parseInt(st.nextToken()); //간식이 들어간 컵의 위치
        K = Integer.parseInt(st.nextToken()); // 컵의 위치를 바꾸는 횟수

        for(int i =0; i<K; i++) { //컵을 바꾸는  반복문
            st = new StringTokenizer(br.readLine()); //한줄로 입력 받고
            A = Integer.parseInt(st.nextToken()); //각컵의 위치
            B = Integer.parseInt(st.nextToken());//각컵의 위치
            if(A==X) {//만약 둘 중 하나라고 간식을 갖고 있는 컵이면 간식의 위치를 다른 컵을 옴기기에 변경
                X = B;
            }else if(B==X) {
                X = A;
            }

        }

        sb.append(X+"\n");// 한번에 출력하기 위해서 테스트 케이스 마다 마지막에 간식이 있는 컵의 위치추가

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }


}
