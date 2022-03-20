import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026 {
    static int n,dx[]={-1,1,0,0}, dy[]={0,0,-1,1};
    static char[][]arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i]= br.readLine().toCharArray();
        }
        System.out.println(normal()+" "+c_blind());
    }

    private static int c_blind() {
        int section=0;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    section++;
                    visited[i][j] = true;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    char color = arr[i][j];
                    while (!q.isEmpty()) {
                        int[] temp = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = temp[0] + dx[k];
                            int ny = temp[1]+ dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                            if (check(color,arr[nx][ny]) && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return section;

    }
    private static boolean check(char c_1, char c_2){
        if(c_1=='R'&&c_2=='G'||c_1=='G'&&c_2=='R') return true;
        return c_1==c_2;
    }
    private static int normal() {
        int section=0;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    section++;
                    visited[i][j] = true;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    char color = arr[i][j];
                    while (!q.isEmpty()) {
                        int[] temp = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = temp[0] + dx[k];
                            int ny = temp[1]+ dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                            if (color==arr[nx][ny] && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
    
        return section;
    }
}

