class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length; // size of the array
        //sort the given intervals:
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });// it is ctr a anonymas class that implents the comparator interface ,it take 1st ele in ec row 
         // take list 
        List<List<Integer>> ans=new ArrayList();

        for(int i=0;i<n;i++){
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1) < arr[i][0]){
                ans.add(Arrays.asList(arr[i][0],arr[i][1]));

            }
            else{
               ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),arr[i][1]));
            }
        }
        // Convert List<List<Integer>> to int[][]
        int[][] res = new int[ans.size()][2];
         for(int i = 0; i < ans.size(); i++) {
                     res[i][0] = ans.get(i).get(0);
                     res[i][1] = ans.get(i).get(1);
            }
return res;



        
    }
}