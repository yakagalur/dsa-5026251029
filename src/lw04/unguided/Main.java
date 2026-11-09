package lw04.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args ) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int cardCount = sc.nextInt();
        int[] cardValue = new int[cardCount];

        for (int i = 0; i < cardCount; i++) {
            cardValue[i] = sc.nextInt();
        }
        
        int numOfTargets = sc.nextInt();
        int[] targetCards = new int[numOfTargets];
        for (int i = 0; i < numOfTargets; i++) {
            targetCards[i] = sc.nextInt();
        } sc.close();

        // Slection sort (ascending)
        for (int i = 0; i < 2; i++) {
            int minCard = cardValue[i];
            int minIndex = i;
            for (int j = i; j < cardCount; j++) {
                if (cardValue[j] < minCard) {
                    minCard = cardValue[j];
                    minIndex = j;
                }
            }
            cardValue[minIndex] = cardValue[i];
            cardValue[i] = minCard;
        }

        for (int i : cardValue) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Linear search
        for (int target : targetCards) {
            boolean found = false;
            for (int i = 0; i < cardCount; i++) {
                if (cardValue[i] == target) {
                    System.out.println(target + ": FOUND at index " + i);
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println(target + ": NOT FOUND");
        }
    }
}