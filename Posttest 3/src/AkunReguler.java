public class AkunReguler extends AkunATM {
    public AkunReguler(String nomorRekening, double saldo) {
        super(nomorRekening, saldo);
    }

    public void infoJenisAkun() {
        System.out.println("Jenis Akun: Reguler");
    }
}
