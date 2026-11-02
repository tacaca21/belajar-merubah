
import java.util.ArrayList;
import java.util.Scanner;

public class SaldoArrayList {
    public static void main(String[] args) {
        Scanner inputx = new Scanner(System.in);

        int balance = 2000000;
        ArrayList<Integer> transactions = new ArrayList<>();
        int nav;

        System.out.println("\nPilih Menu");
        System.out.println("1. Penarikan");
        System.out.println("2. Menyimpan");
        System.out.println("3. Lihat Saldo");
        System.out.println("4. Total Uang Masuk");
        System.out.println("5. Total Uang Keluar");
        System.out.println("0. Exit");

        do {
            System.out.print("\nPilih Menu: ");
            nav = inputx.nextInt();

            if ((nav == 1 || nav == 2) && transactions.size() == 5) {
                System.out.println("Data Transaksi sudah penuh");
                continue;
            }

            if (nav == 0) {
                break;
            }

            if (nav == 1) {
                if (balance == 0) {
                    System.out.println("Saldo anda 0");
                    continue;
                }

                System.out.print("Jumlah yang ditarik: ");
                int amount = inputx.nextInt();

                if (amount <= 0) {
                    System.out.println("Jumlah harus lebih dari 0");
                    continue;
                }

                if (amount > balance) {
                    System.out.println("Saldo anda kurang, hanya " + balance);
                    continue;
                }

                transactions.add(-amount);
                balance -= amount;

            } else if (nav == 2) {
                System.out.print("Jumlah yang disimpan: ");
                int amounts = inputx.nextInt();

                if (amounts <= 0) {
                    System.out.println("Jumlah harus lebih dari 0");
                    continue;
                }

                transactions.add(amounts);
                balance += amounts;

            } else if (nav == 3) {
                System.out.println("Saldo Anda : " + balance);

            } else if (nav == 4) {
                int total = 0;

                for (int x : transactions) {
                    if (x > 0) {
                        total += x;
                    }
                }

                System.out.println("Total Uang Masuk : " + total);

            } else if (nav == 5) {
                int total = 0;

                for (int x : transactions) {
                    if (x < 0) {
                        total += x;
                    }
                }

                System.out.println("Total Uang Keluar : " + (total * -1));

            } else {
                System.out.println("Menu tidak tersedia");
            }

        } while (true);

        inputx.close();
    }
}
