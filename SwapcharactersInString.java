// Given a String S of length N, two integers B and C, the task is to traverse 
// characters starting from the beginning, swapping a character with the character 
// after C places from it, i.e. swap characters at position i and (i + C)%N. Repeat 
// this process B times, advancing one position at a time. Your task is to find the final String after B swaps.

// Input : S = "ABCDEFGH", B = 4, C = 3;
// Output:  DEFGBCAH
// Explanation:
//          after 1st swap: DBCAEFGH
//          after 2nd swap: DECABFGH
//          after 3rd swap: DEFABCGH
//          after 4th swap: DEFGBCAH

// Input : S = "ABCDE", B = 10, C = 6;
// Output : ADEBC


class SwapcharactersInString {
	String swapChars(String s, int c, int b) {
		int n = s.length();
		c = c % n;
		if (c == 0) {
			return s;
		}
		int f = b / n;
		int r = b % n;
		String p1 = rotateLeft(s.substring(0, c), ((n % c) * f) % c);

		String p2 = rotateLeft(s.substring(c), ((c * f) % (n - c)));

		char a[] = (p1 + p2).toCharArray();

		for (int i = 0; i < r; i++) {

			char temp = a[i];
			a[i] = a[(i + c) % n];
			a[(i + c) % n] = temp;
		}

		return new String(a);
	}

	String rotateLeft(String s, int p) {
		return s.substring(p) + s.substring(0, p);
	}

	public static void main(String args[])	{
		String s1 = "ABCDEFGHIJK";
		int b = 1000;
		int c = 3;
		String s2 = new GFG().swapChars(s1, c, b);
		System.out.println(s2);
	}
}
