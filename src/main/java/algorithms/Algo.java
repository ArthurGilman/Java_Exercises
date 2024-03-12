package algorithms;

import java.util.List;

public class Algo {

    public boolean oN (List<Integer> list, int find) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == find) {
                return true;
            }
        }
        return false;
    }

    public long oN2 (List<Integer> list) {
         long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list.size(); k++) {
                int a = list.get(i);
                int b = list.get(k);
                sum += a + b;
            }
        }
        return sum;
    }

    public boolean oLogN(List<Integer> list, int find) {
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
    public long memoryON(List<Integer> list) {
         long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            // Суммируем текущий элемент с оставшимися элементами списка
            for (int j = i + 1; j < list.size(); j++) {
                sum += list.get(i) + list.get(j);
            }
        }
        return sum;
    }
    public long memoryON2(List<Integer> list) {
         long[][] matrix = new long[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                // Вычисляем произведение пары элементов и сохраняем в массиве
                matrix[i][j] = (long) list.get(i) * list.get(j);
            }
        }
         return 0;
    }

    public boolean memoryOLogN(List<Integer> list, int find) {
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
