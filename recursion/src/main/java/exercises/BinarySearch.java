package exercises;

/**
 * Binary Search (Recursive) on a sorted array.
 *
 * ALGORITHM (explain to students):
 * - Precondition: the array is sorted in non-decreasing order.
 * - Idea: Compare target with the middle element:
 *     * If target == midVal -> found (return index).
 *     * If target < midVal  -> search left half.
 *     * If target > midVal  -> search right half.
 * - Each step halves the search range (log2(n) steps).
 *
 * RECURSION DESIGN:
 * - Base cases:
 *     1) If lo > hi -> not found (return -1).
 *     2) If a[mid] == target -> return mid.
 * - Recursive cases:
 *     * target < a[mid]  -> search(lo, mid - 1)
 *     * target > a[mid]  -> search(mid + 1, hi)
 *
 * COMPLEXITY:
 * - Time: O(log n)
 * - Space: O(log n) due to recursion depth (or O(1) if you write it iteratively)
 */
public class BinarySearch {

    /**
     * Public entry point. Students: validate input if desired (null/empty).
     */
    public static int binarySearch(int[] a, int target) {
        if (a == null || a.length == 0) return -1;
        return search(a, target, 0, a.length - 1);
    }

    // TODO: Implement recursively. DO NOT convert to a loop.
    private static int search(int[] a, int target, int lo, int hi) {
        if (lo > hi) {
            return -1; // Base case 1: not found
        }
        if (lo == hi) {
            return a[lo] == target ? lo : -1; // Base case 2: single element
        }
        if (lo + 1 == hi) {
            if (a[lo] == target) {
                return lo; // Check left
            } else if (a[hi] == target) {
                return hi; // Check right
            } else {
                return -1; // Not found
            }
        }
        int mid = (lo + hi) / 2;
        if (a[mid] == target) {
            return mid; // Found at mid
        } else if (a[mid] > target) {
            return search(a, target, lo, mid - 1); // Search left half
        } else {
            return search(a, target, mid + 1, hi); // Search right half
        } 
    }
}
