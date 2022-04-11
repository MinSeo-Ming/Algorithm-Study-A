import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4105 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        double spots [] = new double[12];
        while (true){
            String read = br.readLine();
            if(read.equals("0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0")){
                break;
            }
            int idx;
            double [][]tri = new double[3][2];
            st = new StringTokenizer(read," ");
            for (int i = 0; i < 12; i++) {
                spots[i] =Double.parseDouble(st.nextToken());
                if(i >=7){
                    idx = i-7;
                    tri[idx/2][idx%2] = spots[i];
                }
            }
            tri[1][0] -= tri[0][0];
            tri[1][1] -= tri[0][1];
            tri[2][0] -= tri[0][0];
            tri[2][1] -= tri[0][1];

            double triArea = Area(tri)/2;
            double new_a_x = spots[0]-spots[2];
            double new_a_y = spots[1]-spots[3];
            double new_c_x = spots[4]-spots[2];
            double new_c_y = spots[5]-spots[3];


            double x=0.0,y=0.0;
            int t;
            for(t =-1000; t<=1000; t++){
                x = new_a_x + (1-t) * new_c_x;
                y = new_a_y + (1-t) * new_c_y;
                x=x+spots[2] ;
                y=y+spots[3];
                double tempArea = Area(new double[][]{{},{x-spots[0],y-spots[1]},{spots[2],spots[3]}});
                if(tempArea==triArea) break;
            }
            double g_x ,g_y;
            g_x = (spots[0] + spots[4] *(1-t) -x)/(1-t);
            g_y = (spots[1] + spots[5] *(1-t) -y)/(1-t);
            System.out.printf(g_x+" "+g_y+" "+(x+spots[2])+" "+(y+spots[3]));

        }
    }
    static  double Area(double[][] tri){

        double up=0,down=0;

        up  = tri[1][0] * tri[2][1];
        down  = tri[1][1] * tri[2][0];

        double area = Math.abs(up-down);
        return area;
    }

    static double[] line(double x1,double y1,double x2,double y2){
        double a = (y2-y1)/(x2-x1);
        double b = y1-(a * x1);

        return new double[]{a,b};
    }


}
