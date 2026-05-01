import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public Main op = this;
    public FlowField flowField;
    public Robot robot;
    public boolean done = false;
    public Scanner scan = new Scanner(System.in);

    public static int[] target = new int[]{-5, 6};
    public int moves = 0;

    public void main(String[] args) throws IOException {
        flowField = new FlowField(op);
        robot = new Robot(new Position(-4, 2), op);

        System.out.println("Enter the target x (a whole number between -5 and 6)");
        try {
            target[0] = scan.nextInt();
            if(target[1] < -5 || target[1] > 6){
                throw new RuntimeException("out of bounds");
            }
        } catch (Exception e){
            System.out.println("Whoops that's an invalid input, I'll default to -5 (the left edge of the screen) for you");
        }

        System.out.println("Enter the target y (a whole number between -5 and 6)");
        try {
            target[1] = scan.nextInt();
            if(target[1] < -5 || target[1] > 6){
                throw new RuntimeException("out of bounds");
            }
        } catch (Exception e){
            System.out.println("Whoops that's an invalid input, I'll default to -5 (the left edge of the screen) for you");
        }

        flowField.flowField[target[0] + 5][target[1] + 5] = 8; //Mark target position with an 8

        while (!done) {
            moves += 1;
            flowField.flowField[Robot.position.x + 5][Robot.position.y + 5] = 5; //Mark previous position with a 5

            int vectorEffect = flowField.getVectorEffect();
            done = robot.followFlow(vectorEffect); // complete actual movement and evaluate if target is reached
            flowField.flowField[Robot.position.x + 5][Robot.position.y + 5] = 7; //Mark the current position with a 7

            System.out.println("vectorEffect: " + vectorEffect + " vectorDistance: " + flowField.distance);

            for (int i = 0; i < 12; i++) { //Print full field with robot movement for debugging
                System.out.println(Arrays.toString(flowField.flowField[i]));
            }

            if (moves > 35){
                System.out.println("Robot trapped (cannot get closer to target), Ending program...");
                break;
            }
        }
        System.out.println("Finished move!");
    }
}

