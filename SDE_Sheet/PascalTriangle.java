class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>>res = new  ArrayList();
        
        // list of current row;
        List<Integer>row;

        //List of Previous row;
        List<Integer>prev = null;

        for(int i=0;i<n;i++){
            row = new ArrayList();
            for(int j=0;j<=i;j++){

                // add 1 to the row if j is at terminals
                if(j==0 || j==i)row.add(1);

                // or else add the prev row j-1_th and j_th index elements
                else row.add(prev.get(j-1)+prev.get(j));
            }

            // storing current row into previous row
            prev = row;


            // adding the row to the result;
            res.add(row);
        }
        return res;
    }
}