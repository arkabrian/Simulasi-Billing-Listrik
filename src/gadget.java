import java.text.NumberFormat;
import java.util.Locale;

public class gadget extends elektronik implements biaya{
    private String kaliPemakaian;

    public gadget(String nama, String watt,String jamPemakaian, String kaliPemakaian) {
        super(nama, watt, jamPemakaian);
        this.kaliPemakaian = kaliPemakaian;
    }

    public String getKaliPemakaian() { return kaliPemakaian; }
    public void setKaliPemakaian(String kaliPemakaian) { this.kaliPemakaian = kaliPemakaian; }

    @Override
    public double perHari(){
        double wattAsli = Double.parseDouble(getWatt());
        double pemakaian = Double.parseDouble(getKaliPemakaian());
        double jam = Double.parseDouble(getJamPemakaian());
        return (wattAsli/1000) * (jam * pemakaian);
    }

    @Override
    public String rupiah() {
        NumberFormat rupiah = NumberFormat.getInstance(Locale.GERMAN);
        double uang = perHari() * 1325;
        return "Rp " + rupiah.format(uang);
    }
}