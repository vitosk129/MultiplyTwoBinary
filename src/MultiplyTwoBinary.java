import java.util.Scanner;

public class MultiplyTwoBinary {
    public static void main(String[] args) {
        long binary1, binary2, multiply = 0;
        int digit, factor = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("First binary number: ");
        binary1 = scanner.nextInt();

        System.out.print("Second binary number: ");
        binary2 = scanner.nextInt();

        while (binary2 != 0) {
            digit = (int) (binary2 % 10);
            if (digit == 1) {
                binary1 = binary1 * factor;
                multiply = binaryProduct((int) binary1, (int) multiply);
            } else {
                binary1 = binary1 * factor;
            }
            binary2 = binary2 / 10;
            factor = 10;
        }

        System.out.println("Product of two binary numbers: "+multiply +"\n");
    }


    private static int binaryProduct(int binary1, int binary2) {
        int i = 0, remainder = 0;
        int[] sum = new int[20];
        int binaryProdResult = 0;

        while (binary1 != 0 || binary2 != 0) {
            sum[i++] = (binary1 % 10 + binary2 %10 + remainder) % 2;
            remainder = (binary1 % 10 + binary2 % 10 + remainder) / 2;
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }

        if (remainder != 0) {
            sum[i++] = remainder;
        }

        --i;

        while (i >= 0) {
            binaryProdResult = binaryProdResult * 10 + sum[i--];
        }

        return binaryProdResult;
    }
}
