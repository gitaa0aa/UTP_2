package utp.lelang;

public class BarangLelang {
    private String namaBarang;
    private double hargaAwal;
    private double penawaranTertinggi;
    private Peserta pemenang;
    private boolean statusLelang;
    
    public BarangLelang(String namaBarang, double hargaAwal) {
        this.namaBarang = namaBarang;
        this.hargaAwal = hargaAwal;
        this.penawaranTertinggi = hargaAwal;
        this.statusLelang = false;
        this.pemenang = null;
    }
    
    public String getNamaBarang() {
        return namaBarang;
    }
    
    public double getHargaAwal() {
        return hargaAwal;
    }
    
    public double getPenawaranTertinggi() {
        return penawaranTertinggi;
    }
    
    public Peserta getPemenang() {
        return pemenang;
    }
    
    public boolean isStatusLelang() {
        return statusLelang;
    }
    
    public void mulaiLelang() {
        System.out.println("Lelang untuk " + namaBarang + " telah dimulai dengan harga awal Rp" + (int) hargaAwal);
        statusLelang = true;
    }

    public void terimaPenawaran(Peserta peserta, double jumlah) {
        if (!statusLelang) {
            System.out.println(peserta.getNama() + " menawar Rp" + (int) jumlah);
            System.out.println("Penawaran tidak valid! Lelang sudah ditutup");
            return;
        }

        if (jumlah <= penawaranTertinggi) {
            System.out.println(peserta.getNama() + " menawar Rp" + (int) jumlah);
            System.out.println("Penawaran tidak valid! penawaran harus lebih tinggi dari Rp" + (int) penawaranTertinggi);
            return;
        }
        
        if (peserta.getSaldo() < jumlah) {
            System.out.println(peserta.getNama() + " menawar Rp" + (int) jumlah);
            System.out.println("Penawaran tidak valid! Saldo " + peserta.getNama() + " tidak mencukupi");
            return;
        }

        System.out.println(peserta.getNama() + " menawar Rp" + (int) jumlah);
        System.out.println("Penawaran disetujui!");
        penawaranTertinggi = jumlah;
        pemenang = peserta;
    }
    
    public void tutupLelang() {
        statusLelang = false;
        if (pemenang != null) {
            System.out.println("Lelang ditutup! " + namaBarang + " terjual dengan harga " + (int) penawaranTertinggi + " kepada " + pemenang.getNama());
            pemenang.setSaldo(pemenang.getSaldo() - penawaranTertinggi);
            System.out.println("Sisa saldo " + pemenang.getNama() + ": Rp" + (int) pemenang.getSaldo());
        } else {
            System.out.println("Lelang ditutup! Tidak ada pemenang.");
        }
    }
}
