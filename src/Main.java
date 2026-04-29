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
        robot = new Robot(new Position(3, -3), op);
        flowField.flowField[target[0] + 5][target[1] + 5] = 8; //Mark target position with an 8


        while (!done) {
            flowField.flowField[Robot.position.x + 5][Robot.position.y + 5] = 5; //Mark previous position with a 5

            int vectorEffect = flowField.getVectorEffect();
            done = robot.followFlow(vectorEffect); // complete actual movement and evaluate if target is reached
            flowField.flowField[Robot.position.x + 5][Robot.position.y + 5] = 7; //Mark the current position with a 7

            System.out.println("vectorEffect: " + vectorEffect + " vectorDistance: " + flowField.distance);

            for (int i = 0; i < 12; i++) { //Print full field with robot movement for debugging
                System.out.println(Arrays.toString(flowField.flowField[i]));
            }
        }
    }
}

