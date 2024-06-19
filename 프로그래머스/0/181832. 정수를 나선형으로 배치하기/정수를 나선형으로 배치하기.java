class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int x = 0, y = 0;
        int num = 1;
        String direction = "right";

        while (num <= n * n) {
            answer[x][y] = num++;
            
            switch (direction) {
                case "right":
                    if(y == n - 1 || answer[x][y + 1] != 0) {
                        x++;
                        direction = "down";
                    } else {
                        y++;
                    }
                    break;
                case "down":
                    if(x == n - 1 || answer[x + 1][y] != 0) {
                        y--;
                        direction = "left";
                    } else {
                        x++;
                    }
                    break;
                case "left":
                    if(y == 0 || answer[x][y - 1] != 0) {
                        x--;
                        direction = "up";
                    } else {
                        y--;
                    }
                    break;
                case "up":
                    if(x == 0 || answer[x - 1][y] != 0) {
                        y++;
                        direction = "right";
                    } else {
                        x--;
                    }
                    break;
            }
        }

        return answer;
    }
}