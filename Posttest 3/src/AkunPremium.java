public class AkunPremium extends AkunATM {
    public AkunPremium(String nomorRekening, double saldo) {
        super(nomorRekening, saldo);
    }

    public void infoJenisAkun() {
        System.out.println("Jenis Akun: Premium");
    }
}
