import java.util.Scanner;
import java.util.ArrayList;
class subway{
    public Scanner input = new Scanner(System.in);
    int M,N,Q;
    int[][] station;
    int[][] map;
    int[] q= new int[2];
    ArrayList<String> steps = new ArrayList<String>();
    subway(){
        int sum=0;
        int e;
        N = input.nextInt();
        M = input.nextInt();
        if(N >1 && N <1000001 && M >0 &&  M <501){
            station = new int[M][];

            while(sum < M){

                e = input.nextInt();
                station[sum] = new int[e];

                for(int k=0;k<e;k++){
                    station[sum][k] = input.nextInt();
                }
                sum++;
            }

            Q = input.nextInt();
            create_map(M,N);

            for(int i = 0;i <Q*2;i++){

                if(i%2!=0){
                    q[1] = input.nextInt();
                    int step_q = find_shortway(find_startpoint(q[0]),q[1],0,create_boolean(N));

                    if(step_q != -1){
                        steps.add(Integer.toString(step_q));
                    }else{
                        steps.add("Impossible");
                    }
                }else{
                    q[0] = input.nextInt();
                }
            }
            for(String stepp: steps){
                System.out.println(stepp);
            }

        }
    }
    public void show_station(){
        System.out.println("station");
        for (int i=0;i<station.length;i++) {
            for (int j = 0; j < station[i].length;j++) {
                System.out.print(station[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void show_map(){
        System.out.println("Map");
        for (int i=0;i<map.length;i++) {
            for (int j = 0; j < map[i].length;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int find_startpoint(int data){
        int index = -1;
        for(int i=0;i<station.length;i++){
            for(int k=0;k<station[i].length;k++){
                if(station[i][k] == data){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    public boolean[] create_boolean(int row){
        boolean[] check = new boolean[row];
        for(int i=0;i<check.length;i++){
            check[i] = false;
        }
        return check;
    }
    public int find_shortway(int row,int des,int step,boolean[] way_pass){
        int a;
        for(int i=0;i<map[row].length;i++){
            if(i == des && map[row][i] == 1){
                return step;
            }else if(map[row][i] == 1){
                way_pass[row] = true;
                for(int j=0;j<map.length;j++){
                    if(map[j][i] == 1 && !way_pass[j]){
                        a= find_shortway(j,des,step+1,way_pass);
                        if(a != -1){
                            return a;
                        }
                    }
                }
            }
        }return -1;
    }

    public void create_map(int row,int column){
        map = new int[row][column+1];
        for(int i=0;i<row;i++){
            for(int k=0;k<column;k++){
                map[i][k] = 0;
            }for(int l=0;l<station[i].length;l++){
                if(station[i][l] < column+1){
                    map[i][station[i][l]]=1;
                }
            }
        }
    }

}
