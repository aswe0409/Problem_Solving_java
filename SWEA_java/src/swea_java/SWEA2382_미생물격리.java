package swea_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA2382_미생물격리 {
    static class Virus {
        int row, col, cnt, dir;

        Virus(int row, int col, int cnt, int dir) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    static int di[] = {0, -1, 1, 0, 0}; // 상 하 좌 우
    static int dj[] = {0, 0, 0, -1, 1};
    static int n, m, k;
    static ArrayList<Virus> virusList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            virusList = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                virusList.add(new Virus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            for (int time = 0; time < m; time++) {
                moveVirus();
                mergeVirus();
            }

            int sum = 0;
            for (Virus v : virusList) {
                sum += v.cnt;
            }

            System.out.println("#" + test + " " + sum);
        }
    }
// 바이러스 이동
    private static void moveVirus() {
        for (Virus virus : virusList) {
            int newi = virus.row + di[virus.dir];
            int newj = virus.col + dj[virus.dir];

            // 끝에 닿음
            if (newi == 0 || newi == n - 1 || newj == 0 || newj == n - 1) {
                virus.cnt /= 2;
                if(virus.dir == 1) virus.dir =2;
                else if(virus.dir == 2) virus.dir = 1;
                else if (virus.dir == 3) virus.dir = 4;
                else virus.dir = 3;
            }

            virus.row = newi;
            virus.col = newj;
        }
    }

    private static void mergeVirus() {
        Collections.sort(virusList, new Comparator<Virus>() {
            @Override
            public int compare(Virus v1, Virus v2) {
                if (v1.row == v2.row && v1.col == v2.col) {
                    return v2.cnt - v1.cnt;
                }
                return (v1.row * n + v1.col) - (v2.row * n + v2.col);
            }
        });

        ArrayList<Virus> mergedList = new ArrayList<>();
        Virus current = virusList.get(0);
        for (int i = 1; i < virusList.size(); i++) {
            Virus next = virusList.get(i);
            if (current.row == next.row && current.col == next.col) {
                current.cnt += next.cnt;
            } else {
                mergedList.add(current);
                current = next;
            }
        }
        mergedList.add(current);

        virusList = mergedList;
    }

}

