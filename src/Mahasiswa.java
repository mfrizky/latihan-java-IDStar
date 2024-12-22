public class Mahasiswa {

    public static void main(String[] args) {
        String nama = "Alung";
        String alamat = "Jl. Jalan";
        String nik = "98949213";
        long id = simpanMhs(nama,alamat,nik);
        System.out.println("id mahasiswa : " + id);
        deleteMhs(id);
    }

    static long simpanMhs(String nama, String alamat, String nik){
        System.out.println("nama mahasiswa : " + nama);
        System.out.println("alamat mahasiswa : " + alamat);
        System.out.println("nik mahasiswa : " + nik);
//        long id = ;
        return 8321931;
    }

    static void deleteMhs(long id){
        System.out.println("data mahasiswa berhasil di delete");
    }
}
