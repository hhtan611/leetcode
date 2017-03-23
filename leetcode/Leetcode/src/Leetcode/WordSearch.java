package Leetcode;

import java.util.Collections;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Word Search
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/word-search/
 Notes:
 Given a 2D board and a word, find if the word exists in the grid.
 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are 
 those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 For example,
 Given board =
 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 Solution: DFS.
 */
public class WordSearch {
	public static void main(String[] args) {
		char[][] board = new char[3][4];
		board[0] = "ABCE".toCharArray();
		board[1] = "SFCS".toCharArray();
		board[2] = "ADEE".toCharArray();
		String word = "ABCCED";
		System.out.print(exist(board, word));
	}

	public static boolean exist(char[][] board, String word) {
		char[] w = word.toCharArray();
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (exist(board, y, x, w, 0))
					return true;
			}
		}
		return false;
	}

	private static boolean exist(char[][] board, int y, int x, char[] word,
			int i) {
		if (i == word.length)
			return true;
		if (y < 0 || x < 0 || y == board.length || x == board[y].length)
			return false;
		if (board[y][x] != word[i])
			return false;
		board[y][x] ^= 256;
		boolean exist = exist(board, y, x + 1, word, i + 1)
				|| exist(board, y, x - 1, word, i + 1)
				|| exist(board, y + 1, x, word, i + 1)
				|| exist(board, y - 1, x, word, i + 1);
		board[y][x] ^= 256;
		return exist;
	}

	public static boolean exist2(char[][] board, String word) {
		int m = board.length;
		if (m == 0)
			return false;
		int n = board[0].length;
		if (n == 0)
			return false;
		if (word.length() == 0)
			return true;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (board[i][j] == word.charAt(0)
						&& existRe(board, i, j, word, 0, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean existRe(char[][] board, int i, int j, String word,
			int cur, boolean[][] visited) {
		if (cur == word.length())
			return true;
		int m = board.length;
		int n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n)
			return false;
		if (visited[i][j] == true || (board[i][j] != word.charAt(cur)))
			return false;
		visited[i][j] = true;
		if (existRe(board, i + 1, j, word, cur + 1, visited))
			return true;
		if (existRe(board, i - 1, j, word, cur + 1, visited))
			return true;
		if (existRe(board, i, j + 1, word, cur + 1, visited))
			return true;
		if (existRe(board, i, j - 1, word, cur + 1, visited))
			return true;
		visited[i][j] = false;
		return false;
	}

	public static boolean exist1(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		if (n == 0 || m == 0)
			return false;
		boolean[][] visited = new boolean[n][m];
		if (word.length() == 0)
			return true;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (board[i][i] == word.charAt(0)
						&& existR(board, i, j, word, 0, visited))
					return true;
			}
		}
		return false;
	}

	public static boolean existR(char[][] board, int i, int j, String word,
			int cur, boolean[][] visited) {
		if (cur == word.length())
			return true;
		int n = board.length, m = board[0].length;
		if (i < 0 || i >= n || j < 0 || j >= m)
			return false;
		if ((visited[i][j] || board[i][j] != word.charAt(cur)))
			return false;

		visited[i][j] = true;
		if (existR(board, i + 1, j, word, cur + 1, visited))
			return true;
		if (existR(board, i - 1, j, word, cur + 1, visited))
			return true;
		if (existR(board, i, j + 1, word, cur + 1, visited))
			return true;
		if (existR(board, i, j - 1, word, cur + 1, visited))
			return true;
		visited[i][j] = false;
		return false;
	}
}
