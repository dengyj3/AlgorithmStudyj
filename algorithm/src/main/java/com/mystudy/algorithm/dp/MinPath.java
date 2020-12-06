package com.mystudy.algorithm.dp;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

/**
 * 走棋盘/格子取数
 * 给定m*n的矩阵,每个位置是一个非负整数,在左上角放一机器人,它每次只能朝右和下走,直到右下角,求所有路径中,总和最小的那条路径.
 * 状态转移方程:
 * dp(i,0) = SUM(chess[k][0]),k=0,1,...,i
 * dp(j,0) = SUM(chess[0][k]),k=0,1,...,j
 * dp(i,j) = min(dp(i-1,j),dp(i,j-1)) + chess[i][j]
 * <p>
 * 滚动数组:
 * dp(j) = SUM(chess[0][k]), k=0,1,...,j
 * dp(j) = min(dp(j),dp(j-1))+chess[i][j]
 */
public class MinPath {

    private static int M = 10;
    private static int N = 8;

    public static void main(String[] args) {
        Vector<Vector<Integer>> chess = new Vector<>();
        for (int i = 0; i < M; i++) {
            Vector<Integer> column = new Vector<>();
            for (int j = 0; j < N; j++) {
                column.add(j, new Random().nextInt(100));
            }
            chess.add(i, column);
        }

        Enumeration<Vector<Integer>> vEnumeration = chess.elements();
        while (vEnumeration.hasMoreElements()) {
            System.out.print(vEnumeration.nextElement() + " ");
        }
        System.out.println();
        System.out.println(minPath(chess, M, N));
    }

    private static int minPath(Vector<Vector<Integer>> chess, int M, int N) {
        Vector<Integer> pathLength = new Vector<>(N);
        int i, j;
        pathLength.add(0, 0);
        for (j = 1; j < N; j++) {
            pathLength.add(j, pathLength.get(j - 1) + chess.get(0).get(j));
        }
        for (i = 1; i < M; i++) {
            pathLength.add(0, pathLength.get(0) + chess.get(i).get(0));
            for (j = 1; j < N; j++) {
                if (pathLength.get(j - 1) < pathLength.get(j)) {
                    pathLength.add(j, pathLength.get(j - 1) + chess.get(i).get(j));
                } else {
                    pathLength.add(j, pathLength.get(j) + chess.get(i).get(j));
                }
            }
        }
        return pathLength.get(N - 1);
    }

}
