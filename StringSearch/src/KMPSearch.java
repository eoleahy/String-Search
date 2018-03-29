
public class KMPSearch {

	/*
	 * Bus Service Questions:
	 *
	 * 1. How many total vehicles is there information on? 
	 * 		A: 987
	 *
	 * 2. Does the file contain information about the vehicle number 16555? 
	 * 		A: Yes
	 *
	 * 3. Locate the first record about a bus heading to HAMPTON PARK 
	 * 		A: Data starts at index 19605
	 *
	 * 4. Does the file contain information about the vehicle number 9043409? 
	 * 		A: The file contains no information about this vehicle.
	 */

	/*
	 * Skeleton for this code taken from 
	 *  https://tekmarathon.com/2013/05/14/algorithm-to-find-substring-in-a-string-kmp-algorithm/
	 * 
	 * 
	 * The method checks whether a pattern pat occurs at least once in String
	 * txt.
	 *
	 */
	public static boolean contains(String txt, String pat) {

		if (KMPsearch(txt, pat) == -1 || txt.length() == 0 || pat.length() == 0)
			return false;
		else
			return true;
	}

	private static int[] dfa(String pat) {

		int i = 0;
		int j = -1;

		int M = pat.length();

		int[] dfa = new int[M + 1];

		dfa[i] = j;

		while (i < M) {
			while (j >= 0 && pat.charAt(i) != pat.charAt(j)) {
				j = dfa[j];
			}
			i++;
			j++;
			dfa[i] = j;
		}
		return dfa;
	}

	public static int KMPsearch(String txt, String pat) {

		if (txt.length() == 0 || pat.length() == 0)
			return -1;
		int i = 0;
		int j = 0;

		int N = txt.length();
		int M = pat.length();

		int[] dfa = dfa(pat);

		while (i < N) {
			while (j >= 0 && txt.charAt(i) != pat.charAt(j)) {
				j = dfa[j];
			}
			i++;
			j++;

			if (j == M)
				return (i - M);

		}
		return -1;
	}

	/*
	 * The method returns the index of the first ocurrence of a pattern pat in
	 * String txt. It should return -1 if the pat is not present
	 */
	public static int searchFirst(String txt, String pat) {

		if (txt.length() == 0 || pat.length() == 0)
			return -1;
		int i = 0;
		int j = 0;

		int N = txt.length();
		int M = pat.length();

		int[] dfa = dfa(pat);

		while (i < N) {
			while (j >= 0 && txt.charAt(i) != pat.charAt(j)) {
				j = dfa[j];
			}
			i++;
			j++;

			if (j == M)
				return (i - M);

		}
		return -1;
	}

	/*
	 * The method returns the number of non-overlapping occurences of a pattern
	 * pat in String txt.
	 */
	public static int searchAll(String txt, String pat) {

		if (txt.length() == 0 || pat.length() == 0)
			return 0;
		int txtCount = 0;
		int i = 0;
		int index;
		String subStr = txt;

		while (i < txt.length()) {
			index = KMPsearch(subStr, pat);
			if (index != -1) {
				txtCount++;
				subStr = subStr.substring(index + pat.length());

			} else
				i++;
		}
		System.out.println("Total Count " + txtCount);
		return txtCount;
	}
}
