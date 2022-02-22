import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14621 {
    static class Edge2 implements Comparable<Edge2> {
        int from, to, weight;
        char gender;

        public Edge2(int from, int to, int weight,char gender) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.gender = gender;
        }

        @Override
        public int compareTo(Edge2 o) {
            return this.weight - o.weight;
        }

    }

    static int N;
    static int parents[];
    static Edge2[] edgeList;

    public static void makeSet() {
        for (int i = 1; i <= N; i++)
            parents[i] = i;
    }

    public static int findSet(int a) {
        if (a == parents[a])
            return a;
        else
            return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());

        int E = Integer.parseInt(st.nextToken());
        char gender []=new char[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1; st.hasMoreTokens(); i++) {
            gender[i]=st.nextToken().charAt(0);
        }


        edgeList = new Edge2[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge2(from, to, weight,gender[from]);
        }
        Arrays.sort(edgeList);
        parents = new int[N+1];

        makeSet();

        int result = 0, cnt = 0;

        for (Edge2 edge: edgeList){
            if (union(edge.from, edge.to)) {
                if(gender[edge.from]==gender[edge.to]) continue;
                else{
                    result += edge.weight;
                    cnt++;
                }
            }
        }
        if(cnt !=N-1) System.out.println(-1);
        else System.out.println(result);

    }

}
