public class MoveZeroes{

    static void moveZeroesToEnd(int arr[]){

        int count = 0;
        for(int i = 0; i < arr.length; ++i){
             if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
             }
        }
    }

    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number");
         int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; ++i){
            arr[i] = s.nextInt();
        }

        moveZeroesToEnd(arr);
        for(int element : arr){
            System.out.print(element + " ");
        }
    }
}