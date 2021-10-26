import java.text.NumberFormat;
import java.util.Locale;

public class elektronik implements biaya {
    private String nama;
    private String watt;
    private String jamPemakaian;

    public elektronik(String nama, String watt, String jamPemakaian) {
        this.nama = nama;
        this.watt = watt;
        this.jamPemakaian = jamPemakaian;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getWatt() { return watt; }
    public void setWatt(String watt) { this.watt = watt; }

    public String getJamPemakaian() { return jamPemakaian; }
    public void setJamPemakaian(String jamPemakaian) { this.jamPemakaian = jamPemakaian; }

    @Override
    public double perHari(){
        double wattAsli = Double.parseDouble(getWatt());
        double jam = Double.parseDouble(getJamPemakaian());
        return (wattAsli/1000) * jam;
    }

    @Override
    public String rupiah() {
        NumberFormat rupiah = NumberFormat.getInstance(Locale.GERMAN);
        double uang = perHari() * 1325;
        return "Rp " + rupiah.format(uang);
    }

}