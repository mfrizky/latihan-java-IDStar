import java.io.*;
import java.util.*;
import java.util.Scanner;

public class NilaiSiswa {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Aplikasi Pengolah Nilai Siswa");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Letakkan file csv dengan nama file data_sekolah di direktori berikut: C:/temp/direktori");
            System.out.println("");
            System.out.println("pilih menu :");
            System.out.println("1. Generate txt untuk menampilkan frequency");
            System.out.println("2. Generate txt untuk menampilkan mean, median, modus");
            System.out.println("3. Generate kedua file");
            System.out.println("0. Exit");
            System.out.println("Masukkan pilihan:");
            int pilihan = scanner.nextInt();

            switch (pilihan){
                case 1:
                    generateFrequency();
                    fileGenerated();
                    break;
                case 2:
                    generateMeanMedianModus();
                    fileGenerated();
                    break;
                case 3:
                    generateFrequency();
                    generateMeanMedianModus();
                    fileGenerated();
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan anda tidak ditemukan");
            }
        }
    }

    private static List<Integer> readFile(){
        String fileName = "C:/temp/direktori/data_sekolah.csv";
        List<Integer> nilai = new ArrayList<>();

        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
            String line = null;
            while((line = inputStream.readLine()) != null){
                String[] values = line.split(";");
                for (int i = 1; i < values.length; i++) { // Skip the class name
                    try {
                        nilai.add(Integer.parseInt(values[i]));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score: " + values[i]);
                    }
                }
            }
        }
        catch (IOException e){
            fileNotFound();
        }

        return nilai;
    }

    static void fileNotFound(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Aplikasi Pengolah Nilai Siswa");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("File tidak ditemukan");
            System.out.println("");
            System.out.println("0. Exit");
            System.out.println("1. Kembali ke utama");
            System.out.println("Masukkan pilihan:");
            int pilihan = scanner.nextInt();
            switch (pilihan){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    mainMenu();
                default:
                    System.out.println("pilihan anda salah");
            }
        }
    }

    private static Map<String, Integer> calculateFrequencies() {
        List<Integer> nilai = readFile();
        Map<String, Integer> frequencies = new HashMap<>();
        for (int n : nilai) {
            if (n<6){
                frequencies.put("kurang dari 6", frequencies.getOrDefault("kurang dari 6", 0) + 1);
            }else {
                String key = String.valueOf(n);
                frequencies.put(key, frequencies.getOrDefault(key, 0) + 1);
            }
        }
        return frequencies;
    }

    private static double calculateMean(List<Integer> scores) {
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    private static double calculateMedian(List<Integer> scores) {
        Collections.sort(scores);
        int size = scores.size();
        if (size % 2 == 0) {
            return (scores.get(size / 2 - 1) + scores.get(size / 2)) / 2.0;
        } else {
            return scores.get(size / 2);
        }
    }

    private static List<Integer> calculateMode(List<Integer> scores) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int score : scores) {
            frequencyMap.put(score, frequencyMap.getOrDefault(score, 0) + 1);
        }

        int maxFrequency = Collections.max(frequencyMap.values());
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }
        return modes;
    }

    public static void generateFrequency(){
        Map<String, Integer> frequencies = calculateFrequencies();
        if (frequencies.isEmpty()) return;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/temp/direktori/data-frequency.txt"))) {
            writer.write("Berikut Hasil Pengolahan Nilai:\n");
            writer.write("\n");
            writer.write("Nilai\t\t\t\t| Frekuensi\n");
            for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
                String key = entry.getKey();
                if (key == "kurang dari 6"){
                    writer.write( key+ "\t\t| " + entry.getValue() + "\n");
                }else {
                    writer.write(entry.getKey() + "\t\t\t\t\t| " + entry.getValue() + "\n");
                }
            }
//            System.out.println("Frequencies file generated: frequencies.txt");
//            System.exit(0);
        } catch (IOException e) {
            fileNotFound();
        }
    }

    private static void generateMeanMedianModus() {
        List<Integer> nilai = readFile();
        if (nilai.isEmpty()) return;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/temp/direktori/data-statistics.txt"))) {
            writer.write("Berikut Hasil Pengolahan Nilai:\n");
            writer.write("\n");
            writer.write("Mean: " + calculateMean(nilai) + "\n");
            writer.write("Median: " + calculateMedian(nilai) + "\n");
            writer.write("Modus: " + calculateMode(nilai).get(0) + "\n");
//            System.out.println("Statistics file generated: statistics.txt");
        } catch (IOException e) {
            fileNotFound();
        }
    }

    public static void fileGenerated(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Aplikasi Pengolah Nilai Siswa");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("File telah di generate di C:/temp/direktori");
            System.out.println("silahkan di cek");
            System.out.println("");
            System.out.println("0. Exit");
            System.out.println("1. Kembali ke utama");
            System.out.println("Masukkan pilihan:");
            int pilihan = scanner.nextInt();
            switch (pilihan){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    mainMenu();
                default:
                    System.out.println("pilihan anda salah");
            }
        }
    }
}
