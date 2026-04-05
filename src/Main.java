import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public Main op = this;
    public FlowField flowField;
    public Robot robot;
    public boolean done = false;
    public Scanner scan = new Scanner(System.in);
    public static int[] target = new int[]{-4, 5};

    public void main(String[] args) throws IOException {
        flowField = new FlowField(op);
        robot = new Robot(new Position(3, -5), op);
        flowField.flowField[Robot.position.x + 6][Robot.position.y + 6] = 5; //Map previous position with a 5


        while (!done) {
            flowField.flowField[Robot.position.x + 6][Robot.position.y + 6] = 5; //Map previous position with a 5

            int vectorEffect = flowField.getVectorEffect();
            done = robot.followFlow(vectorEffect); // complete actual movement and evaluate if target is reached
            flowField.flowField[Robot.position.x + 6][Robot.position.y + 6] = 7; //Mark the current position with a 7

            System.out.println("vectorEffect: " + vectorEffect + " vectorDistance: " + flowField.distance);

            for (int i = 0; i < 12; i++) { //Print full field with robot movement for debugging
                System.out.println(Arrays.toString(flowField.flowField[i]));
            }
        }
    }
}

