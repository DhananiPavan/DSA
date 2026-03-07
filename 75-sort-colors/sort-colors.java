class Solution {
    public void sortColors(int[] arr) {
               int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // After each pass, the largest element moves to the end
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}