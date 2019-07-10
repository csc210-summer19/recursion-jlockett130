/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Jake Lockett
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (n < k) {
			return 0;
		} else if (n == k) {
			return 1;
		} else if (k == 1) {
			return n;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String strNum = "" + n;
		String toReturn = "";
		if (n < 1000) {
			return strNum;
		} else {
			int div = (int) Math.pow(10, strNum.length() - strNum.length() + 3);
			if (n % div < 100) {
				toReturn += "0";
			}
			if (n % div < 10) {
				toReturn += "0";
			}
			toReturn = toReturn + n % div;
			return intWithCommas(n / div) + "," + toReturn;
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		len = len - 1;
		if (index < len) {
			int hold = x[len];
			x[len] = x[index];
			x[index] = hold;
			index += 1;
			reverseArray(x, index, len);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return helpRange(a, a[0], a[0], 0);
	}

	private int helpRange(int[] a, int min, int max, int index) {
		if (index < a.length) {
			if (a[index] < min) {
				min = a[index];
			}
			if (a[index] > max) {
				max = a[index];
			}
			index += 1;
			return helpRange(a, min, max, index);
		} else {
			return max - min;
		}
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		return helpSorted(0, nums);
	}

	private boolean helpSorted(int index, int[] nums) {
		if (index == nums.length) {
			return true;
		} else {
			if (index == 0) {
				index += 1;
				return helpSorted(index, nums);
			} else {
				if (nums[index - 1] > nums[index]) {
					return false;
				} else {
					index += 1;
					return helpSorted(index, nums);
				}
			}
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return helpFound(search, 0, strs);
	}

	private boolean helpFound(String search, int index, String[] strs) {
		if (strs.length == index) {
			return false;
		} else {
			if (strs[index].contentEquals(search)) {
				return true;
			} else {
				index += 1;
				return helpFound(search, index, strs);
			}
		}
	}
}
