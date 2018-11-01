import java.util.Random;
class Sort{
    
    static int[] arr = new int[10];
    
    public static void main(String []args){
        fillArray();
        log(arr);
        insertionSort();
        log(arr);
     }
     
     static void fillArray() {
         Random rand = new Random();
         for (int i = 0; i < arr.length; i++) {
             arr[i] = rand.nextInt(500) - 250;
         }
     }
     
     static void swap(int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
     }
     
     static void log(int[] arr) {
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
         System.out.println();

     }
     
     static void bubbleSort() {
         boolean unsorted = true;
         while (unsorted) {
             unsorted = false;
             for (int i = 1; i < arr.length; i++) {
                 if (arr[i] < arr[i - 1]) {
                     swap(i, i - 1);
                     unsorted = true;
                 }
             }
         }
     }
     
     static void insertionSort() {
         int numberToInsert;
         int backwardsCounter;
         boolean sorted = false;
         
         for (int index = 1; index < arr.length; index++) {
             numberToInsert = arr[index];
             backwardsCounter = index - 1;
             log(arr);
             while (backwardsCounter >= 0 && arr[backwardsCounter] > numberToInsert) {
                 arr[backwardsCounter + 1] = arr[backwardsCounter];
                 backwardsCounter--;
             }
             
             arr[backwardsCounter + 1] = numberToInsert;
             
         }
     }
}
