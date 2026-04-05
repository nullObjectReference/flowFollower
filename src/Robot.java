public class Robot {
    public static Position position;
    public int[][] directions = new int[][] {{0,0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public String[] displayDirections = new String[] {"0", "^", "v", "<", ">"};
    private Main op;

    public Robot (Position startingPos, Main op){
        position = startingPos;
        this.op = op;
    }

    //Move robot towards target
    public boolean followFlow(int flow){
        //Normalize error to be within 1 to stop teleportation
        int[] error = new int[] {Math.max(Math.min(Main.target[0] - position.x, 1), -1) , Math.max(Math.min(Main.target[1] - position.y, 1), -1)};

        if (flow > 0 && op.flowField.distance < 3 && Math.abs(error[0]) > 0) { //If the robot is close enough to the flow field that it should be effected
            //^ - No effect if the X direction is fulfilled (to be improved and fixed later)
            if(op.flowField.distance < 2) { //If the robot is close enough to the flow field that it should be moved away
                System.out.println("flowed");
                position.x += directions[flow][0];
                position.y += directions[flow][1];
            } else { //If the robot is close enough to the flow field that it should keep its distance
                System.out.println("sustained distance");
                position.x += (directions[flow][0] - op.flowField.scanOrder[op.flowField.direction][0]);
                position.y += (directions[flow][1] - op.flowField.scanOrder[op.flowField.direction][1]);
            }
        } else { //If the robot can move freely
            position.x += (error[0]);
            position.y += error[1];
        }
        return Math.abs(error[0]) < 1 && Math.abs(error[1]) < 1 && flow == 0;
    }

}
