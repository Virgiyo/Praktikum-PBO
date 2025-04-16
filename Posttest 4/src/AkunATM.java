public class AkunATM {
    private String NomorRekening;    
    private double saldo;           
    protected String NamaPemilik;   
    String bank;                  

    public AkunATM(String NomorRekening, double saldo) {
        this.NomorRekening = NomorRekening;
        this.saldo = saldo;
    }

    public String GetNomorRekening() {
        return NomorRekening;
    }

    public void SetNomorRekening(String NomorRekening) {
        this.NomorRekening = NomorRekening;
    }

    public double GetSaldo() {
        return saldo;
    }

    public void SetSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String GetNamaPemilik() {
        return NamaPemilik;
    }

    public void SetNamaPemilik(String NamaPemilik) {
        this.NamaPemilik = NamaPemilik;
    }

    public String GetBank() {
        return bank;
    }

    public void SetBank(String bank) {
        this.bank = bank;
    }

    // Dapat dioverride
    public void TampilkanSaldo() {
        System.out.println("Saldo Anda saat ini: Rp" + String.format("%,.0f", saldo));
    }

    public boolean TarikTunai(double jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Penarikan berhasil: Rp" + String.format("%,.0f", jumlah));
            return true;
        } else {
            System.out.println("Saldo tidak cukup.");
            return false;
        }
    }

    // Overloading SetorTunai: menerima String
    public void SetorTunai(double jumlah) {
        saldo += jumlah;
        System.out.println("Penyetoran berhasil: Rp" + String.format("%,.0f", jumlah));
    }

    public void SetorTunai(String jumlahStr) {
        try {
            double jumlah = Double.parseDouble(jumlahStr);
            SetorTunai(jumlah);
        } catch (NumberFormatException e) {
            System.out.println("Format jumlah tidak valid.");
        }
    }

    public void HapusAkun() {
        NomorRekening = null;
        saldo = 0;
        NamaPemilik = null;
        bank = null;
    }
}
