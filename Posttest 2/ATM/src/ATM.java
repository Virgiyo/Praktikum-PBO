import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AkunATM akun = null;
        boolean running = true;

        while (running) {
            System.out.println("\n");
            System.out.println("\nMenu ATM:");
            System.out.println("1. Buat Akun ATM");
            System.out.println("2. Cek Saldo ATM");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Setor Tunai");
            System.out.println("5. Hapus Akun ATM");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nomor rekening (format = 1234): ");
                    String nomorRekening = scanner.nextLine();
                    System.out.print("Masukkan saldo awal (format angka 50.000 / 50000): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Input tidak valid. Masukkan saldo awal dalam angka: ");
                        scanner.nextLine();
                    }
                    double SaldoAwal = scanner.nextDouble();
                    scanner.nextLine();
                    akun = new AkunATM(nomorRekening, SaldoAwal);
                    System.out.println("Akun ATM berhasil dibuat.");
                    break;

                case 2:
                    if (akun == null) {
                        System.out.println("Akun belum dibuat. Pilih menu 1 terlebih dahulu.");
                    } else {
                        akun.TampilkanSaldo();
                    }
                    break;

                case 3:
                    if (akun == null) {
                        System.out.println("Akun belum dibuat. Pilih menu 1 terlebih dahulu.");
                    } else {
                        System.out.print("Masukkan jumlah yang ingin ditarik: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.print("Input tidak valid. Masukkan jumlah uang dalam angka: ");
                            scanner.nextLine();
                        }
                        double JumlahTarik = scanner.nextDouble();
                        scanner.nextLine();
                        akun.TarikTunai(JumlahTarik);
                    }
                    break;

                case 4:
                    if (akun == null) {
                        System.out.println("Akun belum dibuat. Pilih menu 1 terlebih dahulu.");
                    } else {
                        System.out.print("Masukkan jumlah yang ingin disetorkan: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.print("Inputan tidak valid. Masukkan jumlah uang dalam angka: ");
                            scanner.nextLine();
                        }
                        double JumlahSetor = scanner.nextDouble();
                        scanner.nextLine();
                        akun.SetorTunai(JumlahSetor);
                    }
                    break;

                case 5:
                    if (akun == null) {
                        System.out.println("Akun belum dibuat. Pilih menu 1 terlebih dahulu.");
                    } else {
                        akun.HapusAkun();
                        System.out.println("Akun ATM berhasil dihapus.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Terima kasih.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }
}
