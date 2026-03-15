import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public  Main op = this;
    public  FieldMap map;
    public  Robot robot;
    public  boolean done = false;
    public  Scanner scan = new Scanner(System.in);
    public static int[] target = new int[] {-5, -1};

    public void main(String[] args) throws IOException {
        map = new FieldMap(op);
        robot = new Robot(new Position(3, 0), op);

        while (!done){
            int flow = map.getVectorEffect();

            System.out.println(flow + " Do you want to accept?");

                map.map[Robot.position.x + 6][Robot.position.y + 6] = 5;

                for(int i = 0; i < 12; i++) {
                        System.out.println(Arrays.toString(map.map[i]));
                }
               // map.map[Robot.position.x + 6][Robot.position.y + 6] = 0;
                done = robot.followFlow(flow) < 1;



        }
    }
}

