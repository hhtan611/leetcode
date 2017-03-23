package Leetcode;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 13, 2014
 Problem:    ZigZag Conversion
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/zigzag-conversion/
 Notes:
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:
 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 Solution: ...
 */

public class ZigZagConversion {
	public static void main(String[] args) {
		ZigZagConversion zz = new ZigZagConversion();
		System.out.println(zz.convert("PAYPALISHIRING", 3));
		printZigzag("PAYPALISHIRING", 3);
	}

	public String convert(String s, int nRows) {
		int n = s.length();
		if (n <= 1 || nRows <= 1)
			return s;
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < nRows; ++i) {
			for (int j = 0; j + i < n; j += 2 * nRows - 2) {
				res.append(s.charAt(j + i));
				if (i == 0 || i == nRows - 1)
					continue;
				if (j + 2 * nRows - 2 - i < n)
					res.append(s.charAt(j + 2 * nRows - 2 - i));
			}
		}
		return res.toString();
	}

	static void printZigzag(String s, int nRows) {
		char[] sc = s.toString().toCharArray();
		if (s.isEmpty() || nRows < 1)
			return;
		if (nRows == 1) {
			return;
		}
		int zigSpan = nRows * 2 - 2;
		int zig = nRows - 2;
		for (int i = 0; i < nRows; i++) {
			for (int j = i; j < s.length(); j += zigSpan) {
				System.out.print(sc[j]); // 注意：推导出zigSpan+j-2i的数学公式，一点都不能错
				if (i != 0 && i != nRows - 1
						&& zigSpan + j - 2 * i < s.length()) {
					for (int r1 = 0; r1 < zig - i; r1++) {
						System.out.print(" ");
					}
					System.out.print(sc[zigSpan + j - 2 * i]);
					for (int r2 = 0; r2 < i - 1; r2++) {
						System.out.print(" System.out.print(");
					}
				} else {
					for (int r = 0; r < zig; r++) {
						System.out.print(" ");
					}
				}

			}
			System.out.println();
		}
	}

}
