class Solution {
    public List<Integer> majorityElement(int[] n) {
        List<Integer> l=new ArrayList();
        int c1=0,c2=0;
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;
        for(int i=0;i<n.length;i++){
            if(c1==0&&n[i]!=e2){
                c1++;
                e1=n[i];

            }else if(c2==0&&n[i]!=e1){
                 c2++;
                e2=n[i];

            }

            else if(e1==n[i]){
                c1++;
            }
            else if(e2==n[i]){
                c2++;
            }
            else{
                c1--;c2--;
            }


        }
        c1=0;c2=0;
        int min =(int)(n.length/3)+1;
        for(int i=0;i<n.length;i++)
        {
            if(e1==n[i]){
                c1++;
            }
            if(e2==n[i]){
                c2++;
            }
        }
        if(c1>=min){
            l.add(e1);
        }
        if(c2>=min){
            l.add(e2);
        }
        return l;

        
    }
}