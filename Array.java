public class Array {
     public static int binarysearch(int numbers[], int key) {
          int start = 0; int end = numbers.length-1;

          while(start <= end) {
               int mid = (start+end)/2;
               if(numbers[mid] == key) {
                    return mid;
               }
               if(numbers[mid] < key) {
                    start = mid + 1;
               } else {
                    end = mid-1;
               }
          }
          return -1;
     }

     // reverse an array
     public static void reverse(int numbers[]) {
          int first = 0;
          int last = numbers.length-1;

          while(first < last) {
               int temp = numbers[first];
               numbers[first] = numbers[last];
               numbers[last] = temp;
               first++;
               last++;
          }
     }


     // kadanes algorithm
     public static void kadanes(int numbers[]) {
          int ms = Integer.MIN_VALUE;
          int cs = 0;
          for(int i=0; i<numbers.length; i++) {
               cs = cs+numbers[i];

               if(cs < 0) {
                    cs = 0;
               }
               ms = Math.max(cs,ms);
          }
          System.out.println("the max sum of the subarray : " + ms);
     }
     
     // trapping rainwater
     public static int trappedrainwater(int height[]) {
          int n = height.length;
          int leftmax[] = new int[n];
          leftmax[0] = height[0];
          for(int i=1; i<n; i++) {
               leftmax[i] = Math.max(height[i],leftmax[i-1]);
          }
          int rightmax[] = new int[n];
          rightmax[n-1] = height[n-1];
          for(int i=n-2; i>=0; i--) {
               rightmax[i] = Math.max(height[i],rightmax[i+1]);
          }
          int trappedwater = 0;
          for (int i=0; i<n; i++ ) {
               int waterlevel = Math.min(leftmax[i], rightmax[i]);
               trappedwater += waterlevel-height[i];
          }
          return trappedwater;
     }

     // buy & sell stock
     public static int stocks(int prices[]) {
          int buyprices = Integer.MAX_VALUE;
          int maxprofit = 0;

          for(int i=0; i<prices.length; i++) {
               if(buyprices < prices[i]) {
                    int profit = prices[i]-buyprices;
                    maxprofit = Math.max(maxprofit,profit);

               } else {
                    buyprices = prices[i];
               }
          }
          return maxprofit;
     }


     // bubble sort
     public static void bubblesort(int arr[]) {
          for(int turn = 0; turn<arr.length; turn++) {
               for(int j=0; j<arr.length-1-turn; j++) {
                    
                    if(arr[j] > arr[j+1]) {
                         int temp = arr[j];
                         arr[j] = arr[j+1];
                         arr[j+1] = temp;
                    }
               }
          }
     }
     // public static void printarr(int arr[]) {
     //      for(int i=0; i<arr.length; i++) {
     //           System.out.print(arr[i]+" ");
     //      }
     // }

     // selection sort
     public static void selectionsort(int arr[]) {
          for(int i=0; i<arr.length; i++) {
               int minpose = i;

               for(int j = i+1; i<arr.length; j++) {
                    if(arr[minpose] > arr[j]) {
                         minpose = j;
                    }
               }
               int temp = arr[minpose];
               arr[minpose] = arr[i];
               arr[i] = temp;
          }
     }

     // insertion sort
     public static void insertionsort(int arr[]) {
          for(int i=1; i<arr.length; i++) {
               int curr = arr[i];
               int prev = i-1;

               while(prev >= 0 && arr[prev] > curr) {
                    arr[prev+1] = arr[prev];
                    prev--;
               }
               arr[prev+1] = curr;
          }
     }

     
     //  Spiral matrix
       public static void spiralmatrix(int matrix[][]) {
          int startrow = 0;
          int startcol = 0;
          int endrow = matrix.length-1;
          int endcol = matrix[0].length-1;

          while(startrow <= endrow && startcol <= endcol) {
               // top
               for(int j=startrow; j<=endrow; j++) {
                    System.out.print(matrix[startrow][j]+" ");
               }
               // right
               for(int i=startrow+1; i<=endcol; i++) {
                    System.out.print(matrix[i][endcol]+" ");
               }
               // bottom
               for(int j=endcol-1; j>=startcol; j--) {
                   System.out.print(matrix[endrow][j]+" ");
               }
               // left
               for(int i=endrow-1; i>=startrow+1; i--) {
                    System.out.print(matrix[i][startcol]+" ");
               }
               startcol++;
               startrow++;
               endcol--;
               endrow--;
          }
       }

     // diagonal sum
     public static int diagonalsum(int matrix[][]) {
          int sum = 0;
          for(int i=0; i<matrix.length; i++) {
               sum += matrix[i][i];

               if(i != matrix.length-1-i) {
                    sum += matrix[i][matrix.length-1-i];
               }
          }
          return sum;
     }

     // search in sorted matrix
     public static boolean sortedmatrix(int matrix[][], int key) {
          int row = 0;
          int col = matrix[0].length-1;

          while(row < matrix.length && col >= 0) {
               if(matrix[row][col] == key) {
                    System.out.println("the key found at "+"("+row+","+col+")");
                    return true;
               } else if(key < matrix[row][col]) {
                    col--;
               } else {
                    row++;
               }
          }
          System.out.println("key not found!");
          return false;
     }

     // string palindrome
     public static boolean ispalindrome(String str) {
          int n = str.length();
          for(int i=0; i<str.length(); i++) {
               if(str.charAt(i) != str.charAt(n-i-1)) {
                    return false;
               }
          }
          return true;
     }

     public static float getshortestpath(String path) {
          int x = 0;
          int y = 0;
          for(int i=0; i<path.length(); i++) {
               char dir = path.charAt(i);

               if(dir == 'S') {
                    y--;
               } else if(dir == 'N') {
                    y++;
               } else if(dir == 'E') {
                    x++;
               } else {
                    x--;
               }

          }
          int X2 = x*x;
               int Y2 = y*y;
               return (float) Math.sqrt(Y2+X2);

     }


     // RECURSION 
     public static void printdec(int n) {
          if(n == 1) {
               System.out.println(n);
               return;
          }
          System.out.println(n+"");
          printdec(n-1);
     }
     
     // factorial
     public static int fact(int n) {
          if(n == 0) {
               return 1;
          }
          int fmn1 = fact(n-1);
          int factn = n * fact(n-1);
          return factn;
     }

     public static int sumofn(int n) {
          if(n == 0) {
               return 0;
          }
          int fmn1 = sumofn(n-1);
          int factn = n+sumofn(n-1);
          return factn;
     }

     // fibonacci number
     public static int fib(int n) {
          if(n == 0) {
               return 0;
          }
          if(n == 1) {
               return 1;
          }
          int fibnm1 = fib(n-1);
          int fibnm2 = fib(n-2);
          int fibn = fibnm1 + fibnm2;
          return fibn;
     }

     // array is sorted or not
     public static boolean issorted(int arr[], int i) {
          if(arr[i] == arr.length-1) {
               return true;  
          }
          if(arr[i] > arr[i+1]) {
               return false;
          }
          return issorted(arr,i+1);
     }

     // first occurance
     public static int firstoccurance(int arr[], int key, int i) {
          if(i == arr.length) {
               return -1;
          }
          if(arr[i] == key) {
               return i;
          }
          return firstoccurance(arr, key,i+1);
     }

     // last occurance
     public static int lastoccurance(int arr[], int key, int i) {
          if(i == arr.length) {
               return -1;
          }
          int isfound = lastoccurance(arr,key,i+1);
          if(isfound == -1 && arr[i] == key) {
               return i;
          }
          return isfound;
     }

     // power of X
     public static int powerofx(int x, int n) {
          if(n == 0) {
               return 1;
          }
          int pow1 = x;
          int pow2 = powerofx(x,n-1);
          int powofx = pow1 * pow2;
          return powofx;
     }

     // tiling problem
     public static int tilingproblem(int n) {
          if(n==0 ||n==1) {
               return 1;
          }
          int fmn1 = tilingproblem(n-1);
          int fmn2 = tilingproblem(n-2);
          int totalways = fmn1 + fmn2;
          return totalways;
     }

     // remove duplicates in a string
     public static void removeduplicates(String str,int idx, StringBuilder newStr,boolean map[]) {
          if(idx == str.length()) {
            System.out.println(newStr);
            return;
          }
          char currchar = str.charAt(idx);
          if(map[currchar -'a'] == true) {
               removeduplicates(str, idx+1, newStr,map);
          } else {
               map[currchar -'a'] = true;
               removeduplicates(str, idx+1, newStr.append(currchar),map);
          }
     }

     // friends pairing problem
     public static int friendspairing(int n) {
          if(n==1 || n==2) {
               return n;
          }
          int fnm1 = friendspairing(n-1);
          int fnm2 = friendspairing(n-2);
          int pairways = (n-1) * fnm2;
          int totalways = fnm1 + pairways;
          return totalways;
     }

     // Binary Strings
     public static void printbinarystring(int n,int lastspace,String str) {
          if(n == 0) {
               System.out.println(str);
               return;
          }
          printbinarystring(n-1, 0, str+"0");
          if(lastspace == 0) {
               printbinarystring(n-1,1, str+"1");
          }
     } 

     // merge sort
     // public static void printarr(int arr[]) {
     //      for(int i=0; i<=arr.length; i++) {
     //           System.out.print(arr[i]+" ");
     //      }
     //      System.out.println();
     // }
     public static void mergesort(int arr[], int si, int ei) {
          if(si >= ei) {
               return;
          }
          int mid = (si+ei)/2;
          mergesort(arr, si,mid);
          mergesort(arr,mid+1,ei);
          merge(arr,si,mid,ei);
     }
     public static void merge(int arr[], int si, int mid, int ei) {
          int temp[] = new int[ei-si+1];
          int i = si;
          int j = mid + 1;
          int k = 0;

          while(i<=mid && j<=ei) {
               if(arr[i] < arr[j]) {
                    temp[k] = arr[i];
                    i++;
               } else {
                    temp[k] = arr[j];
                    j++;
               }
               k++;
          }
          while(i <= mid) {
               temp[k++] = arr[i++];
          }

          while(j <= ei) {
               temp[k++] = arr[j++];
          }

          for(k=0, i=si; k<temp.length;  k++, i++) {
               temp[k] = arr[i];
          }
     }

     public static void printarr(int arr[]) {
          for(int i=0; i<=arr.length; i++) {
               System.out.print(arr[i]+" ");
          }
          System.out.println();
     }
     public static void quicksort(int arr[],int si,int ei) {
          if(si >= ei) {
               return;
          }
          int pIdx = partition(arr,si,ei);
          quicksort(arr, si, pIdx-1);
          quicksort(arr, pIdx+1, ei);
     }
     public static int  partition(int arr[], int si, int ei) {
          int pivot = arr[ei];
          int i = si-1;

          for(int j = si; j<ei; j++) {
               if(arr[j] <= pivot) {
                    i++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
               }
          }
          i++;
          int temp = pivot;
           arr[ei] = arr[i];
           arr[i] = temp;

     }
     public static void main(String[] args) {
         int arr[] = {2,4,3,5,6,9,7};
         mergesort(arr,0,arr.length-1);
}
}