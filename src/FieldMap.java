public class FieldMap {
    public int[][] map = { //1 = up, 2 = down, 3 = left, 4 = right
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

    private int scanRadius = 3;
    public int distance = 0;
    public int direction = 0;
    public int[][] scanOrder = new int[][] {{1,0}, {0,1}, {-1,0}, {0, -1}, {1,1}, {-1,-1}, {-1, 1}, {1,-1}};


    public FieldMap (Main op){

    }

    public int getVectorEffect(){
        int effect = 0;

        for (int i = 1; i < scanRadius; i++){
            for (int j = 0; j < scanOrder.length; j++) {
                int scannedTileValue = map[Math.max(Math.min(Robot.position.x + 6 + (scanOrder[j][0] * i), 11), 0)][Math.max(Math.min(Robot.position.y + 6 + (scanOrder[j][0] * i), 11), 0)];
                if ( scannedTileValue > 0 && scannedTileValue < 5){
                    effect = scannedTileValue;
                    distance = i;
                    direction = j;
                    break;
                }
            }
//            if(map[Robot.position.x + i + 6][Robot.position.y + 6] > 0){
//                effect = new int[]{-1, 0};;
//                break;
//            }
//            if(map[Robot.position.x + 6][Robot.position.y - i + 6] > 0){
//                effect = new int[]{0, 1};
//                break;
//            }
//            if(map[Robot.position.x + 6][Robot.position.y + i + 6] > 0){
//                effect = new int[]{0, -1};
//                break;
//            }
//            if(map[Robot.position.x - i + 6][Robot.position.y - i + 6] > 0){
//                effect = new int[]{1, 0};
//                break;
//            }
//            if(map[Robot.position.x + i + 6][Robot.position.y + i + 6] > 0){
//                effect = 1;
//                break;
//            }
//            if(map[Robot.position.x + i + 6][Robot.position.y - i + 6] > 0){
//                effect = 1;
//                break;
//            }
//            if(map[Robot.position.x - i + 6][Robot.position.y + i + 6] > 0){
//                effect = 1;
//                break;
//            }
        }
        return effect;
    }
}
