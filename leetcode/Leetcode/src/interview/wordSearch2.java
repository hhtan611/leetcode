package interview;
public class wordSearch2 {
	public static void main(String[] args) {
		String word = "abc";
		char[] wd = word.toCharArray();
		char[][] arr = new char[5][];
		int n = word.length();
	}

	private Boolean search(char[][] arr, char[] wd, int i, int j, int cur,
			boolean[][] visited) {
		if (cur == wd.length)
			return true;
		int n = arr.length, m = arr[0].length;
		if (i < 0 || i >= n || j < 0 || j >= m)
			return false;
		if (wd[cur] != arr[i][j] || visited[i][j] == true)
			return false;
		visited[i][j] =true;
		if(search(arr, wd, cur + 1, i - 1, j - 1, visited)) return true;
		search(arr, wd, cur + 1, i, j - 1, visited);
		search(arr, wd, cur + 1, i - 1, j, visited);
		search(arr, wd, cur + 1, i - 1, j + 1, visited);
		search(arr, wd, cur + 1, i + 1, j + 1, visited);
		search(arr, wd, cur + 1, i, j + 1, visited);
		search(arr, wd, cur + 1, i + 1, j, visited);
		search(arr, wd, cur + 1, i +1, j - 1, visited);
		visited[i][j] = false;
		return false;
	}
}
