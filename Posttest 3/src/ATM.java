import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AkunATM akun = null;
        boolean running = true;

        while (running) {
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
                    String tipe = "";
                    while (true) {
                        System.out.print("Masukkan jenis akun (Reguler/Premium): ");
                        tipe = scanner.nextLine().toLowerCase();
                        if (tipe.equals("reguler") || tipe.equals("premium")) {
                            break;
                        } else {
                            System.out.println("Jenis akun tidak valid. Masukkan hanya 'Reguler' atau 'Premium'.");
                        }
                    }

                    String norek = "";
                    while (true) {
                        System.out.print("Masukkan nomor rekening (hanya angka): ");
                        norek = scanner.nextLine();
                        if (norek.matches("\\d+")) {
                            break;
                        } else {
                            System.out.println("Nomor rekening hanya boleh berupa angka.");
                        }
                    }
                    System.out.print("Masukkan saldo awal(format angka 50.000 / 50000): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Input tidak valid. Masukkan saldo awal dalam angka: ");
                        scanner.nextLine();
                    }
                    double saldoAwal = scanner.nextDouble();
                    scanner.nextLine();
                    if (tipe.equals("reguler")) {
                        akun = new AkunReguler(norek, saldoAwal);
                        ((AkunReguler) akun).infoJenisAkun();
                    } else {
                        akun = new AkunPremium(norek, saldoAwal);
                        ((AkunPremium) akun).infoJenisAkun();
                    }
                    System.out.println("Akun ATM berhasil dibuat.");
                    break;
                case 2:
                    if (akun == null) {
                        System.out.println("Akun belum dibuat.");
                    } else {
                        akun.TampilkanSaldo();
                    }
                    break;
                case 3:
                    if (akun == null) {
                        System.out.println("Akun belum dibuat.");
                    } else {
                        System.out.print("Masukkan jumlah tarik: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.print("Input tidak valid: ");
                            scanner.nextLine();
                        }
                        double jml = scanner.nextDouble();
                        scanner.nextLine();
                        akun.TarikTunai(jml);
                    }
                    break;
                case 4:
                    if (akun == null) {
                        System.out.println("Akun belum dibuat.");
                    } else {
                        System.out.print("Masukkan jumlah setor: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.print("Input tidak valid: ");
                            scanner.nextLine();
                        }
                        double jml = scanner.nextDouble();
                        scanner.nextLine();
                        akun.SetorTunai(jml);
                    }
                    break;
                case 5:
                    if (akun == null) {
                        System.out.println("Akun belum dibuat.");
                    } else {
                        akun.HapusAkun();
                        System.out.println("Akun dihapus.");
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}
