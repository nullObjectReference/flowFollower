import java.util.Arrays;
import java.util.Objects;

public class Robot {
    public static Position position;
    public int[][] directions = new int[][] {{0,0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private Main op;

    public Robot (Position startingPos, Main op){
        position = startingPos;
        this.op = op;
    }
    public int followFlow(int flow){
        int[] error = new int[] {Math.max(Math.min(Main.target[0] - position.x, 1), -1) , Math.max(Math.min(Main.target[1] - position.y, 1), -1)};

        if (flow > 0 && op.map.distance < 2) {
            position.x += directions[flow][0];
            position.y += directions[flow][1];
        } else {
                if(op.map.distance > 1) {
                    position.x += (error[0] + directions[flow][0]);
                    position.y += error[1] + directions[flow][1];
                }

        }
        return (int)Math.hypot(error[0], error[1]);
    }

}
