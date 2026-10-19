public class kadanes {
    public static void kadanes(int numbers[]) {
    int ms = Integer.MIN_VALUE;
    int cs = 0;
    for(int i=0; i<numbers.length; i++) {
      cs = cs+numbers[i];

      if(cs<0) {
        cs = 0;
      }
      ms = Math.max(cs,ms);
    }
    System.out.println("the max sum of the subarray : "+ ms);
  }
    public static void main(String[] args) {
        int numbers[] = {3,5,10,15,17,20,27};

        kadanes(numbers);
    }
}
