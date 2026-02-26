class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] n=new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            n[i]=arr[i];
        }
        Arrays.sort(n,(a,b)->{
            int c1=Integer.bitCount(a);
            int c2=Integer.bitCount(b);
            if(c1==c2){
                return a-b;
            }
            return c1-c2;
        });
        for(int i=0;i<arr.length;i++){
            arr[i]=n[i];
        }
        return arr;
    }
}