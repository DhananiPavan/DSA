class Solution {
    public void sortColors(int[] arr) {
     int n = arr.length;
     int t1=0,t2=0,t3=0;
     int l=0;
     while(l<arr.length){
        if(arr[l]==0)t1++;
        if(arr[l]==1)t2++;
        if(arr[l]==2)t3++;

        l++;
     }
     for(int i=0;i<arr.length;i++){
        if(t1!=0){
            arr[i]=0;
            t1--;
            continue;
        }
        if(t2!=0){
            arr[i]=1;
            t2--;
            continue;

        }
        arr[i]=2;
        t3--;

     }

        
    }
}