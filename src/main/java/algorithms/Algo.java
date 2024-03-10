package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algo {
    static final List<Integer> list = Arrays.asList(1, 2, 3, 4, 4, 6, 7, 8, 9, 10);

    public boolean oN (int find) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == find) {
                return true;
            }
        }
        return false;
    }

    public boolean oN2 (int find) {
        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list.size(); k++) {
                if (list.get(i) + list.get(k) == find) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean oLogN(int find) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int value = list.get(mid);

            if (value < find) {
                low = mid + 1;
            } else if (value > find) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    // --------------------------------------------
    public boolean binarySearchLogNRecursive(int find) {
        return binarySearchRecursive(list, find, 0, list.size() - 1);
    }

    private boolean binarySearchRecursive(List<Integer> list, int find, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = (low + high) / 2;
        int value = list.get(mid);

        if (value < find) {
            return binarySearchRecursive(list, find, mid + 1, high);
        } else if (value > find) {
            return binarySearchRecursive(list, find, low, mid - 1);
        } else {
            return true;
        }
    }



}
