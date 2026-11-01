package lw04.prelab;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        // mmbaca input dari file
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        
        // membaca integer N dan N buah nilai stabilitas
        int n = sc.nextInt();
        int[] branches = new int[n];
        for (int i = 0; i < n; i++) {
            branches[i] = sc.nextInt();
        }
        
        // membaca integer M dan M buah nilai target
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();
        
        sort(branches);
        
        printArray(branches);
        
        // linear searchh
        for (int i = 0; i < m; i++) {
            int target = targets[i];
            int index = linearSearch(target, branches);
            
            if (index != -1) {
                System.out.println(target + ": FOUND at index " + index);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }
    }
    
    // modifikasi INSERTION SORT 
    public static void sort (int[] a) {
        // Melakukan iterasi tepat 3 passes (dari index 1 hingga  3)
        for (int nextPos = 1; nextPos <= 3; nextPos++) {
            insert(a, nextPos);
        }
    }
    
    private static void insert (int[] a, int nextPos) {
        int nextVal = a[nextPos];
        // Kondisi diubah menjadi nextVal > a[nextPos-1] untuk mengurutkan secara descending
        // Elemen yg lebih kecil dari key digeser ke kanan
        while (nextPos > 0 && nextVal > a[nextPos-1]){
            a[nextPos] = a[nextPos-1];
            nextPos--;
        }
        a[nextPos] = nextVal; // Menaruh key di posisi yg kosong
    }
    
    // LINEAR SEARCH
    static int linearSearch(int x, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }
    
    // Fungsi bantuan untuk mencetak array (dr metode printArray)
    static void printArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            System.out.print(anArray[i]);
            // Format Exact Behaviour mengharuskan elemen dipisahkan dengan spasi
            if (i < anArray.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}