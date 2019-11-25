package skrudra.alads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestCereal {

	public static void main(String[] args) {

		int x = 1;
		int best = 0;
		List<Integer> input = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			input.add(i);
		}

		for (int j = 0; j < input.size() - x + 1; j++) {
			int temp = Collections.min(input.subList(j, j + x));
			if (best < temp) {
				best = temp;
			}
		}
		System.out.println(best);

	}
}
