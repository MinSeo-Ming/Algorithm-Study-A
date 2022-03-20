
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17140 {
    static int [][] map =new int[101][101]; //100번째를 초과하는 줄은 무시하므로.
    static int r,c,k,count=0;
    static int max_r=3, max_c=3; //가로 세로 제한 처음엔 3*3 으로 고정 값이니
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        r = Integer.parseInt(st.nextToken())-1; // 인덱스가 1부터 시작하므로 -1
        c = Integer.parseInt(st.nextToken())-1; // 인덱스가 1부터 시작하므로 -1
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine()," ");
            map[i][0]=Integer.parseInt(st.nextToken());
            map[i][1]=Integer.parseInt(st.nextToken());
            map[i][2]=Integer.parseInt(st.nextToken());
        }

        while(map[r][c]!=k){ //만약 값이 맞으면 탈출
            count++;
            if(max_r>=max_c)//가로가 세로보다 같거나 긴경우
                map=R_cal();
            else            //세로가 긴경우
                map=C_cal();
            if(count>100)break; //100회가 넘으면
        }
        if(count<=100) //100회 미만이면
            System.out.println(count);
        else
            System.out.println(-1);
    }
    static int[][] R_cal(){
        int[][] arr = new int[101][101];    //값을 집어 넣기 위한 임시 저장소
        for (int i=0; i<101; i++) {
            if(i==max_r) break;                                 //최대  가로 수면 탈출
            Map<Integer,Integer> temp = new TreeMap<>();        // 빈도수 세기 위한 map

            for (int j =0; j<101; j++) {
                int val = map[i][j];
                temp.put(val,temp.getOrDefault(val,0)+1); // 만약 아무것도 없으면 0을 가져오기
            }

            List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(temp.entrySet());
            entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if(o1.getValue()==o2.getValue())    //만약 빈도수가 동일하면
                        return o1.getKey()-o2.getKey(); //나온 숫자 오름 차순
                    else
                        return o1.getValue()- o2.getValue();    //빈도수로 오름 차순
                }
            });

            int idx =0;                             //정렬한거 집어 넣는거
            for (Map.Entry<Integer, Integer> entry : entryList) {
                if(idx>=100)break;                  // 100을 초과 하면 pass
                if(entry.getKey()==0) continue;     //idx가 0이 존재하면 pass
                arr[i][idx++] = entry.getKey();
                arr[i][idx++] = entry.getValue();
            }
            if(idx >max_c) max_c =idx;              //정렬후에 idx가 현 map의 최대 열 보다 크면 변환
        }
        return arr;
    }

    //로직은 동일 -> 열대로 정렬
    static int[][] C_cal(){
        int[][] arr = new int[101][101];
        for (int i=0; i<101; i++) {//세로 대로 진행해야 하므로
            if(i==max_c) break;
            Map<Integer,Integer> temp = new TreeMap<>();

            for (int j =0; j<101; j++) {
                int val = map[j][i];
                temp.put(val,temp.getOrDefault(val,0)+1); // 만약 아무것도 없으면 0을 가져오기
            }

            List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(temp.entrySet());
            entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if(o1.getValue()==o2.getValue())
                        return o1.getKey()-o2.getKey();
                    else
                        return o1.getValue()- o2.getValue();
                }
            });

            int idx =0;
            for (Map.Entry<Integer, Integer> entry : entryList) {
                if(idx>=100)break;
                if(entry.getKey()==0) continue;
                arr[idx++][i] = entry.getKey();
                arr[idx++][i] = entry.getValue();
            }
            if(idx >max_r) max_r =idx;
        }
        return arr;
    }
}
