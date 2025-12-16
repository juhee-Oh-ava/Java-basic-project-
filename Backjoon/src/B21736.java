import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21736 {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static char[][] arry;
    static boolean[][] v;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arry = new char[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++){
            String line = br.readLine();
            for (int j = 0; j < M; j++){
                arry[i][j] = line.charAt(j);
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(arry[i]));
//        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (arry[i][j] == 'I'){
                    int ans = BFS(i, j, arry, N, M);
                    if (ans == 0){
                        System.out.println("TT");
                    }else{
                        System.out.println(ans);
                    }

                }

            }
        }

    }
    public static int BFS(int r, int c, char[][] map, int N, int M) {
        Queue<Point> q = new LinkedList<>();
        v[r][c] = true;
        q.offer(new Point(r, c));

        while (!q.isEmpty()){
            Point cur = q.poll();
            int cr = cur.r;
            int cc = cur.c;

            for (int d = 0; d < 4; d++){
                int nr = cr + dx[d];
                int nc = cc + dy[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (v[nr][nc]) continue;
                if (map[nr][nc] == 'X') continue;

                if (map[nr][nc] == 'P') {
                    count++;
                }

                v[nr][nc] = true;
                q.offer(new Point(nr, nc));

            }

        }
        return count;
    }

    static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
