import java.text.DecimalFormat;
import java.util.Scanner;

class AkunATM {
    private String nomorRekening;
    private double saldo;

    // Konstruktor untuk menginisialisasi objek AkunATM dengan nomor rekening dan
    // saldo
    public AkunATM(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening; // Menetapkan nilai parameter nomorRekening ke atribut objek
        this.saldo = saldo; // Menetapkan nilai parameter saldo ke atribut objek
    }

    // Getter untuk nomor rekening, mengembalikan nilai nomor rekening dari objek
    // AkunATM
    public String getNomorRekening() {
        return nomorRekening; // Mengembalikan nilai atribut nomorRekening
    }

    // Getter untuk saldo, mengembalikan nilai saldo dari objek AkunATM
    public double getSaldo() {
        return saldo; // Mengembalikan nilai atribut saldo
    }

    // Setter untuk menetapkan nilai saldo pada objek AkunATM
    public void setSaldo(double saldo) {
        this.saldo = saldo; // Menetapkan nilai parameter saldo ke atribut saldo objek
    }

    // Method menampilkan saldo dengan format Rupiah
    public void tampilkanSaldo() {
        DecimalFormat formatRupiah = new DecimalFormat("###,###"); // Membuat format angka dengan pemisah ribuan
        System.out.println("Saldo Anda saat ini: Rp" + formatRupiah.format(saldo)); // Menampilkan saldo dengan format
                                                                                    // Rupiah
    }

    // Method untuk melakukan penarikan tunai jika saldo cukup
    public boolean tarikTunai(double jumlah) {
        if (jumlah <= saldo) { // Mengecek apakah jumlah yang ditarik tidak melebihi saldo
            saldo -= jumlah; // Mengurangi saldo dengan jumlah yang ditarik
            DecimalFormat formatRupiah = new DecimalFormat("###,###"); // Membuat format angka dengan pemisah ribuan
            System.out.println("Penarikan berhasil: Rp" + formatRupiah.format(jumlah)); // Menampilkan informasi
                                                                                        // penarikan
            return true; // Mengembalikan nilai true jika penarikan berhasil
        } else {
            System.out.println("Saldo tidak cukup untuk penarikan."); // Menampilkan pesan jika saldo tidak cukup
            return false; // Mengembalikan nilai false jika penarikan gagal
        }
    }

    // Method untuk melakukan penyetoran
    public void setorTunai(double jumlah) {
        saldo += jumlah; // Menambah saldo dengan jumlah yang disetor
        DecimalFormat formatRupiah = new DecimalFormat("###,###"); // Membuat format angka dengan pemisah ribuan
        System.out.println("Penyetoran berhasil: Rp" + formatRupiah.format(jumlah)); // Menampilkan informasi penyetoran
    }

    // Method untuk menghapus akun ATM
    public void hapusAkun() {
        this.nomorRekening = null; // Menghapus nomor rekening
        this.saldo = 0; // Mengatur saldo menjadi 0
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek scanner untuk membaca input dari pengguna
        AkunATM akun = null; // Mendeklarasikan variabel akun dengan nilai null, untuk menyimpan objek
                             // AkunATM
        boolean running = true; // Menetapkan variabel running sebagai true untuk menjaga agar program tetap
                                // berjalan

        while (running) { // Perulangan untuk menampilkan menu hingga pengguna memilih keluar
            System.out.println("\n"); // Memberikan space
            System.out.println("\nMenu ATM:");
            System.out.println("1. Buat Akun ATM");
            System.out.println("2. Cek Saldo ATM");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Setor Tunai");
            System.out.println("5. Hapus Akun ATM");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer setelah pembacaan input integer

            switch (pilihan) {
                case 1:
                    // Buat akun ATM
                    System.out.print("Masukkan nomor rekening (format = 1234): ");
                    String nomorRekening = scanner.nextLine();
                    System.out.print("Masukkan saldo awal (format angka 50.000 / 50000): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Input tidak valid. Masukkan saldo awal dalam angka: ");
                        scanner.nextLine(); // Membersihkan buffer setelah pembacaan input integer
                    }
                    double saldoAwal = scanner.nextDouble();
                    scanner.nextLine(); // Membersihkan buffer setelah pembacaan input integer

                    akun = new AkunATM(nomorRekening, saldoAwal);
                    System.out.println("Akun ATM berhasil dibuat.");
                    break;

                case 2:
                    // Cek saldo
                    if (akun == null) {
                        System.out.println("Akun belum dibuat. Pilih menu 1 terlebih dahulu.");
                    } else {
                        akun.tampilkanSaldo();
                    }
                    break;

                case 3:
                    // Tarik tunai
                    if (akun == null) {
                        System.out.println("Akun belum dibuat. Pilih menu 1 terlebih dahulu.");
                    } else {
                        System.out.print("Masukkan jumlah yang ingin ditarik: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.print("Input tidak valid. Masukkan jumlah uang dalam angka: ");
                            scanner.nextLine(); // Membersihkan buffer setelah pembacaan input integer
                        }
                        double jumlahTarik = scanner.nextDouble();
                        scanner.nextLine(); // Membersihkan buffer setelah pembacaan input integer

                        akun.tarikTunai(jumlahTarik);
                    }
                    break;

                case 4:
                    // Setor tunai
                    if (akun == null) {
                        System.out.println("Akun belum dibuat. Pilih menu 1 terlebih dahulu.");
                    } else {
                        System.out.print("Masukkan jumlah yang ingin disetorkan: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.print("Inputan tidak valid. Masukkan jumlah uang dalam angka: ");
                            scanner.nextLine(); // Membersihkan buffer setelah pembacaan input integer
                        }
                        double jumlahSetor = scanner.nextDouble();
                        scanner.nextLine(); // Membersihkan buffer setelah pembacaan input integer

                        akun.setorTunai(jumlahSetor);
                    }
                    break;

                case 5:
                    // Hapus akun ATM
                    if (akun == null) {
                        System.out.println("Akun belum dibuat. Pilih menu 1 terlebih dahulu.");
                    } else {
                        akun.hapusAkun();
                        System.out.println("Akun ATM berhasil dihapus.");
                    }
                    break;

                case 6:
                    // Keluar
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
