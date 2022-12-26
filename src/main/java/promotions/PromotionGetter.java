package promotions;


import java.util.Scanner;

public class PromotionGetter {
    private static final Scanner scanner = new Scanner(System.in);

    public String getPromotionCode() {
        System.out.println("Please provide a promotion code if you have one: ");
        return scanner.nextLine()
                .trim();
    }
}
