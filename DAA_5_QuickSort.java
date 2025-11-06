import java.util.Random;

public class DAA_5_QuickSort {

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    int randomizedPartition(int arr[], int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;
        int temp = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp;
        return partition(arr, low, high);
    }

    void quickSort(int arr[], int low, int high, boolean randomized) {
        if (low < high) {
            int pi = randomized ? randomizedPartition(arr, low, high) : partition(arr, low, high);
            quickSort(arr, low, pi - 1, randomized);
            quickSort(arr, pi + 1, high, randomized);
        }
    }

    void printArray(int arr[]) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        QuickSort qs = new QuickSort();

        System.out.println("Deterministic QuickSort:");
        int arr1[] = arr.clone();
        qs.quickSort(arr1, 0, n - 1, false);
        qs.printArray(arr1);

        System.out.println("Randomized QuickSort:");
        int arr2[] = arr.clone();
        qs.quickSort(arr2, 0, n - 1, true);
        qs.printArray(arr2);
    }
}

/*
Time Complexity:
Best & Average: O(n log n)
Worst: O(n^2)
Space Complexity: O(log n)
*/
