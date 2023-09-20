import java.util.Random;

public class LightBoard {
    private boolean[][] lights;

    public LightBoard(int numRows, int numCols) {
        lights = new boolean[numRows][numCols];
        Random rand = new Random();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                lights[i][j] = rand.nextInt(10) <= 4;
            }
        }
    }

    public void setLights(boolean[][] lights) {
        this.lights = lights;
    }

    public boolean evaluateLight(int row, int col) {
        if(lights[row][col]) {
            int temp = 0;
            for(int i = 0; i < row; i++) {
                if (lights[i][col]) temp++;
            }
            if(temp % 2 == 0) return false;
        }

        else if(!lights[row][col]){
            int temp = 0;
            for (int i = 0; i < row; i++) {
                if (lights[i][col]) temp++;
            }
            if (temp % 3 == 0) return true;
        }
        return lights[row][col];
    }

    public boolean[][] getLights() {
        return lights;
    }
}