public class CekNilai {
    public static void main(String[] args) {
        tentukan(84);
    }

    static void tentukan(Integer nilai){
        if (nilai >= 85){
            System.out.println("Anda lulus");
        } else {
            System.out.println("Anda tidak lulus");
        }
    }
}
