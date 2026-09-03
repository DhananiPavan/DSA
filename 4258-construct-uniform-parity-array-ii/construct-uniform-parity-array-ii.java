class Solution {
    public boolean uniformArray(int[] nums1) {
       int min= Integer.MAX_VALUE;
       boolean flag=true;
       for(int x: nums1){
        min=Math.min(x,min);
        if(x%2==1 && flag==true ){
            flag=false;
        }
       } 
       if(min%2==1){
        return true;
       }
       else{
        if((flag)){
            return true;

        }
       }
       return false;
    }
}