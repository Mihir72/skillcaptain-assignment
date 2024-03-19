public class Solution2{

     static int[] productArray(int[] arr){
             if(arr.length == 0)
                 return arr;

                 int n = arr.length;
            
            int[] left = new int[arr.length];
            int[] right = new int[arr.length];
            int[] product = new int[arr.length];

            left[0] = 1;
            right[n-1] = 1;

            for(int i = 1; i < n; ++i){
                left[i] = left[i-1] * arr[i-1];
            }

            for(int i = n-2; i >= 0; --i){
                right[i] = right[i+1] * arr[i+1];
            }

            for(int i = 0; i < n; ++i){
                product[i] = left[i] * right[i];
            }
            return product;
     }

    public static void main(String[] args){
        int arr[] = {1,2,3,4};
       arr = productArray(arr);
       for(int element : arr){
        System.out.print(element + " ");
       }
    }
}