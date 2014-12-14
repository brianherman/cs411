package Project1;

import java.util.TreeMap;

public class d {
	public static double DamerauLevenshteinDistance(String source, String target) {
		if (source.equals(null)){
			if (target.equals(null)){
				return 0;
			} else {
				return target.length();
			}
		} else if (target.equals(null)) {
			return source.length();
		}

		int[][] score = new int[source.length() + 2][target.length() + 2];

		int INF = source.length() + target.length();
		score[0][0] = INF;
		for (int i = 0; i <= source.length(); i++) {
			score[i + 1][1] = i;
			score[i + 1][0] = INF;
		}
		for (int j = 0; j <= target.length(); j++) {
			score[1][j + 1] = j;
			score[0][j + 1] = INF;
		}

		TreeMap<Character, Integer> sd = new java.util.TreeMap<Character, Integer>();
		String s = source + target;
		for (char letter : s.toCharArray()) {
			if (!sd.containsKey(letter)) {
				sd.put(letter, 0);
			}
		}

		for (int i = 1; i <= source.length(); i++) {
			int DB = 0;
			for (int j = 1; j <= target.length(); j++) {
				int i1 = sd.get(target.charAt(j - 1));
				int j1 = DB;

				if (source.charAt(i - 1) == target.charAt(j - 1)) {
					score[i + 1][j + 1] = score[i][j];
					DB = j;
				} else {
					score[i + 1][j + 1] = Math.min(score[i][j],
							Math.min(score[i + 1][j], score[i][j + 1])) + 1;
				}

				score[i + 1][j + 1] = Math.min(score[i + 1][j + 1],
						score[i1][j1] + (i - i1 - 1) + 1 + (j - j1 - 1));
			}

			sd.put(source.charAt(i - 1), i);
		}

		return score[source.length() + 1][target.length() + 1];
	}

}
