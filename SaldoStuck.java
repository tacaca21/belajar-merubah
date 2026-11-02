
import java.util.Stack;
import java.util.Scanner;

public class SaldoStuck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> transactions = new Stack<>();
        int balance = 2000000, nav;

        do {
            System.out.println("\n1.Penarikan\n2.Menyimpan\n3.Lihat Saldo\n4.Total Uang Masuk\n5.Total Uang Keluar\n0.Exit");
            System.out.print("Pilih Menu: ");
            nav = input.nextInt();

            if ((nav == 1 || nav == 2) && transactions.size() == 5) {
                System.out.println("Data Transaksi penuh");
                continue;
            }

            if (nav == 1) {
                System.out.print("Jumlah ditarik: ");
                int amount = input.nextInt();
                if (amount > balance) continue;
                transactions.push(-amount);
                balance -= amount;
            } else if (nav == 2) {
                System.out.print("Jumlah disimpan: ");
                int amount = input.nextInt();
                transactions.push(amount);
                balance += amount;
            } else if (nav == 3) {
                System.out.println("Saldo: " + balance);
            } else if (nav == 4 || nav == 5) {
                int total = 0;
                for (int x : transactions) {
                    if ((nav == 4 && x > 0) || (nav == 5 && x < 0))
                        total += x;
                }
                System.out.println("Total: " + Math.abs(total));
            }
        } while (nav != 0);

        input.close();
    }
}