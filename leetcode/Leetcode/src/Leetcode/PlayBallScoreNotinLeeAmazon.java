package Leetcode;

import java.util.Stack;
import java.util.regex.Pattern;

/*发一个亚麻社招 OA 的面经，OA是在amcat上做的，包括75 min Coding + 15 min Culture + 5 min Feedback，其实开始做coding之后时间有90min
 Q1 丢棒球砸砖块，貌似是地里没有出现过的题，
 输入是一个字符串数组，每一个值可能是一个整数，或者Z，或者X，或者+。整数代表现在拿的分，
 X代表当前成绩是前一个分数Double，+代表当前成绩是前两个的和，Z代表移除前一个成绩，然后要求的是最后的总成绩
 例子： 输入 ["5", "-2", "4", "Z", "X", 9, "+", "+"]
 输出 27
 5 : sum = 5
 -2 : sum = 5 + 2 = 7
 4 : sum = 7 + 4 = 11
 Z : sum = 11 - 4 = 7
 X : sum = 7 + 2 * 2 = 11(因为4被移除了，前一个成绩是-2)
 9 : sum = 11 + 9 = 20
 + : sum = 8 + 9 - 4 = 13 (前两个成绩是9和-4)
 + : sum = 13 + 9 + 5 = 27 (前两个成绩是5 和 9)

 用一个stack就可以秒掉*/
public class PlayBallScoreNotinLeeAmazon {
	public static void main(String[] args) {
		char[] arr = { '5', '2', '4', 'Z', 'X', '9', '+', '+' };
		decodeString(arr);
	}

	public static int decodeString(char[] s) {
		Stack<Integer> sStack = new Stack<>();
		Stack<Integer> inStack = new Stack<>();
		for (char c : s) {
			if (Character.isDigit(c)) {
				if (!inStack.isEmpty()) {
					int a = inStack.pop();
					inStack.push(c - '0');
					inStack.push(a + (c - '0'));
				} else {
					inStack.push(c - '0');
				}
			} else if (c == 'Z') {
				int a = inStack.pop();
				int b = inStack.pop();
				inStack.push(a + b);
			} else if (c == 'X') {
				int a = inStack.pop();
				int b = inStack.peek();
				inStack.push(a + b * 2);
			} else if (c == '+') {
				int a = inStack.pop();
				int b = inStack.pop();
				int d = inStack.peek();
				inStack.push(b);
				inStack.push(a + b + d);
			}
		}
		return 0;
	}

	// 判断字符串是否为数字：
	// 1分解法
	public static boolean isNumeric1(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// 2>用正则表达式
	public static boolean isNumeric2(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	// 3>用ascii码
	public static boolean isNumeric3(String str) {
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				return false;
		}
		return true;
	}

	boolean isNum(String str) {
		return str.matches("\\d+");
	}
}
