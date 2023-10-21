import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MazeSolver {
    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // เครื่องหมายถนน: ระบุเครื่องหมายถนนแต่ละตัว (เลขหนึ่งและเลขศูนย์) สำหรับการเคลื่อนที่ทั้งหมด

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt(); // จำนวนแถว
        int N = scanner.nextInt(); // จำนวนหลัก
        scanner.nextLine();

        int startRow = scanner.nextInt(); // แถวเริ่มต้น
        int startCol = scanner.nextInt(); // หลักเริ่มต้น
        scanner.nextLine();

        int endRow = scanner.nextInt(); // แถวทางออก
        int endCol = scanner.nextInt(); // หลักทางออก
        scanner.nextLine();

        int[][] maze = new int[M][N];

        // อ่านข้อมูลแผนที่เขาวงกต
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        scanner.close();

        int minExplosions = findShortestPath(maze, startRow, startCol, endRow, endCol);
        System.out.println(minExplosions);
    }

    private static int findShortestPath(int[][] maze, int startRow, int startCol, int endRow, int endCol) {
        int M = maze.length;
        int N = maze[0].length;
        startRow-=1;
        startCol-=1;
        endCol-=1;
        endRow-=1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];

        queue.add(new int[]{startRow, startCol, 0}); // ตำแหน่งแถว, ตำแหน่งหลัก, จำนวนระเบิดที่ใช้
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int explosionsUsed = current[2];

            if (row == endRow && col == endCol) {
                return explosionsUsed;
            }

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isValid(newRow, newCol, M, N) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;

                    if (maze[newRow][newCol] == 1) {
                        queue.add(new int[]{newRow, newCol, explosionsUsed });
                    } else {
                        queue.add(new int[]{newRow, newCol, explosionsUsed+1});
                    }
                }
            }
        }

        return -1; // ไม่สามารถเดินไปยังทางออกได้
    }

    private static boolean isValid(int row, int col, int M, int N) {
        return row >= 0 && row < M && col >= 0 && col < N;
    }
}