public class FizzBuzz {
    public static void main(String[] args) {
        jalan(10);
    }

    public static void jalan(int n){
        for (int i=1;i<=n;i++){
            if (i % 3 == 0){
                System.out.println("Fuzz");
            } else if (i % 5 == 0){
                System.out.println("Buzz");
            } else {
                System.out.println(Integer.toString(i));
            }
        }
    }
}
