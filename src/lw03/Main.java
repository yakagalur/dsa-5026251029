package lw03;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        Scanner in2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Scanner in3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        
        List<String> daftarLagu = new ArrayList<>(); 

        while(in1.hasNextLine()) {
            int posisi = -1;
            String operasi = in1.next();
            
            if(operasi.equalsIgnoreCase("insert")) {
                String penunjuk = in1.next();
                posisi = Integer.parseInt(penunjuk);
            }

            String judul = in1.nextLine();
            
            if(operasi.equalsIgnoreCase("add")) {
                daftarLagu.add(judul);
            } 
            else if(operasi.equalsIgnoreCase("insert") && posisi != -1) {
                daftarLagu.add(posisi, judul);
            } 
            else if(operasi.equalsIgnoreCase("remove")) {
                for(int c = 0; c < daftarLagu.size(); c++) {
                    if(daftarLagu.get(c).equals(judul)) {
                        daftarLagu.remove(c);
                        break;
                    }
                }
            }
        }
        
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + daftarLagu.size());
        for(int c = 0; c < daftarLagu.size(); c++) {
            System.out.println((c + 1) + " : " + daftarLagu.get(c));
        }

        List<String> daftarPeserta = new ArrayList<>();
        Set<String> pesertaUnik = new LinkedHashSet<>();
        
        while(in2.hasNext()) {
            String namaOrang = in2.next();
            if(!pesertaUnik.contains(namaOrang)) {
                pesertaUnik.add(namaOrang);
            }
            daftarPeserta.add(namaOrang);
        }
        
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + pesertaUnik.size());
        int nomor = 1;
        for(String p : pesertaUnik) {
            System.out.println(nomor + ". " + p);
            nomor++;
        }
        System.out.println("Duplicate registrations: " + (daftarPeserta.size() - pesertaUnik.size()));

        Map<String, Integer> dataBarang = new LinkedHashMap<>();
        int jualGagal = 0;

        while(in3.hasNext()) {
            String tindakan = in3.next();
            String item = in3.next();
            int kuantitas = Integer.parseInt(in3.next());

            if(tindakan.equalsIgnoreCase("ADD")) {
                if(dataBarang.containsKey(item)) {
                    dataBarang.put(item, dataBarang.get(item) + kuantitas);
                } 
                else {
                    dataBarang.put(item, kuantitas);
                }
            } 
            else if(tindakan.equalsIgnoreCase("SELL")) {
                if(!dataBarang.containsKey(item)) {
                    jualGagal++;
                    continue;
                }
                int sisaStok = dataBarang.get(item);
                if(sisaStok < kuantitas) {
                    jualGagal++;
                } 
                else {
                    dataBarang.put(item, sisaStok - kuantitas);
                }
            }
        }

        System.out.println("===== Problem 3 =====");
        for(Map.Entry<String, Integer> entry : dataBarang.entrySet()) {
            String namaProduk = entry.getKey();
            int jumlahBarang = entry.getValue();
            System.out.println(namaProduk + ": " + jumlahBarang);
        }
        System.out.println("Failed sales: " + jualGagal);
    }
}