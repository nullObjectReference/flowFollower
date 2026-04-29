public class FlowField {
    public int[][] flowField;

    private final int SCAN_RADIUS = 3;
    public int distance = 0;
    public int direction = 0;

    public int[][] scanOrder = new int[][] {{0, 0},
            {1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {1, 1}, {-1, -1}, {-1, 1}, {1, -1},
            {2, 0}, {0, 2}, {-2, 0}, {0, -2},
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {2, 2}, {-2, 2}, {-2, -2}, {2, -2}};
    //^ - Order surrounding tiles are scanned

    public FlowField(Main op){
        flowField = new int[][] { //1 = up, 2 = down, 3 = left, 4 = right, 0 = no effect
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0},
                {0, 0, 0, 3, 3, 3, 4, 4, 0 ,0 ,0 ,0},
                {0, 0, 0, 3, 0, 0, 0, 4, 0 ,0 ,0 ,0},
                {0, 0, 0, 3, 0, 0, 0, 4, 0 ,0 ,0 ,0},
                {0, 0, 0, 3, 0, 0, 0, 4, 0 ,0 ,0 ,0},
                {0, 0, 0, 3, 3, 4, 4, 4, 0 ,0 ,0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0}
        };

    }

    public int getVectorEffect(){ //Find effect flow vectors have
        int effect = 0;

        //  v - Nested for loops used to iterate through all surrounding tiles within scan distance
        for (int i = 1; i < SCAN_RADIUS ; i++){
            for (int j = 1; j <= 8 * i; j++) {
                int scannedTileValue = flowField[Math.max(Math.min(Robot.position.x + 5 + (scanOrder[j + ((i - 1) * 8)][0]), 11), 0)][Math.max(Math.min(Robot.position.y + 5 + (scanOrder[j +((i - 1) * 8)][1]), 11), 0)];
                //^ used to find the next tile's vector effect
                System.out.println("searched grid value x: " + (scanOrder[j + ((i - 1) * 8)][0]) + " searched grid value y: " + (scanOrder[j +((i - 1) * 8)][1]));
                System.out.println("flow " + scannedTileValue);
                System.out.println("robot x: " + Robot.position.x + " robot y: " +  Robot.position.y);

                if (scannedTileValue > 0 && scannedTileValue < 5){ //If the tile has a valid vector effect
                    effect = scannedTileValue;
                    distance = i;
                    direction = j + ((i - 1) * 8);
                    System.out.println("foundTile" + " j: " + j + " i: " + i);
                    break; //Break when a vector effect is detected
                } else { //If not it also has no direction
                    System.out.println("foundNoTile" + " j: " + j + " i: " + i);
                    direction = 0;
                    distance = 0;
                }
            }
            if (distance > 0){
                break;
            }
        }
        return effect;
    }
}
