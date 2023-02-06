
import java.util.*;

public class FindMedianAfterMergingTwoSortedArrays {
    public static int median(int arr1[], int arr2[], int n) {
        int low = (int) -1e9, high = (int) 1e9;

        int pos = n;
        double ans = 0.0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            // total number of elements in arrays which are
            // less than mid
            int ub = upperBound(arr1, mid)
                    + upperBound(arr2, mid);

            if (ub <= pos)
                low = mid + 1;
            else
                high = mid - 1;
        }

        ans = low;
        pos--;
        low = (int) -1e9;
        high = (int) 1e9;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int ub = upperBound(arr1, mid)
                    + upperBound(arr2, mid);

            if (ub <= pos)
                low = mid + 1;
            else
                high = mid - 1;
        }

        ans = (ans + low * 1.0) / 2;

        return (int) ans;
    }
    public static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] <= key)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println(median(arr1, arr2, n));
    }
}
