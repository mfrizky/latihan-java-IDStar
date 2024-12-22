public class AkarKuadrat {
    public static void main(String[] args) {
        System.out.println("akar kuadrat 25 adalah " +AkarKuadrat(30));
    }

    public static double AkarKuadrat(int n){
        double temp;
        double sqrt = n/2;
        do {
            temp = sqrt;
            sqrt = (temp+(n/temp))/2;
        }while ((temp-sqrt)!=0);
        return sqrt;
    }
}
