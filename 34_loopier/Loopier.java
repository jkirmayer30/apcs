import java.util.*;

public class Loopier {
	public static int[] slice (int[] array, int begin, int end) {
		int[] ans = new int[end - begin];
		for (int idx = begin; idx < end; idx++ ) {
			ans[idx - begin] = array[idx];
		}
		return ans;
	}
	
	public static int[] init (int[] array) {
		int l = array.length;
		for (int x = 0; x < l; x++) {
			array[x] = (int) (Math.random() * 69420);
		}
		return array;
	}
	
	public static String toString (int[] array) {
		String ans = "[";
		int l = array.length;
		for (int x = 0; x < l; x++) {
			int b = array[x];
			ans += Integer.toString(b);
			if (!(x == l - 1)) {
				ans += ", ";
			}
		}
		ans += "]";
		return ans;
	}
	
	public static int linSearch (int[] array, int target) {
		int l = array.length;
		for (int x = 0; x < l; x++) {
			if (array[x] == target) {
				return x;
			}
		}
		return -1;
	}
	
	public static int linSearchR (int[] array, int target) {
		if (array[0] == target) {
			return 0;
		}	
		else {
			if (array.length == 1) {
				return -1;
			}
			else {
				array = slice(array, 1,array.length);
				return linSearchR(array, target)+1;
			}
		}
	}

	public static int freq (int[] array, int target) {
		int l = array.length;
		int count = 0;
		for (int x = 0; x < l; x++) {
			if (array[x] == target) {
				count++;
			}
		}
		return count;
	}

	public static int freqR (int[] array, int target) {
		if (array.length==0){return 0;}
		if (array[0] == target) {
			array = slice(array, 1,array.length);
			return freqR(array, target)+1;
		}
		else {
			array = slice(array, 1,array.length);
			return freqR(array, target);
		}	
	}
	
	public static void main (String[] args) {
		int[] test = new int[3];
		
		System.out.println(toString(init(test)));	
		
		int[] test1 = {5, 11, 9, 11};
		
		System.out.println(linSearchR(test1, 11));
		System.out.println(freqR(test1, 11));
		System.out.println(linSearch(test1, 11));
		System.out.println(freq(test1, 11));
	}
}
