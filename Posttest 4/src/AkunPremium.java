public class AkunPremium extends AkunATM {
    public AkunPremium(String nomorRekening, double saldo) {
        super(nomorRekening, saldo);
    }

    public void infoJenisAkun() {
        System.out.println("Jenis Akun: Premium");
    }

    @Override
    public void TampilkanSaldo() {
        System.out.println("Saldo Premium Anda: Rp" + String.format("%,.0f", GetSaldo()));
    }
}
