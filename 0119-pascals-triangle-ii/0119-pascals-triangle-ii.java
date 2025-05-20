class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ll=new ArrayList<>();
        long nc=1;
        for(int j=0;j<=rowIndex;j++){
            ll.add((int)(nc));
            nc=((rowIndex-j)*nc)/(j+1);
        }
        return ll;
    }
}