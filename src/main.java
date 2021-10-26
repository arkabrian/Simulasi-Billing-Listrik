import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;

public class main {
    static Scanner bro = new Scanner(System.in);
    static String pilihan;

    static String username;
    static String password;
    static String filepath;
    static boolean lanjut;

    static void logIn(){
        String path = "database//";
        File pathAsFile = new File(path);
        if(!Files.exists(Paths.get(path))){
            pathAsFile.mkdir();
        }

        File member = new File("database//members.txt");
        if(!member.exists()){
            try{
                member.createNewFile();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        String pilihan;
        System.out.println("Pilihan Menu:");
        System.out.println("""
                1. LOG IN
                2. REGISTER
                3. BANTUAN""");
        System.out.print("Anda memilih: ");
        pilihan = bro.nextLine();
        lanjut = true;

        switch (pilihan){
            case "1":
                System.out.println("Username : ");
                username = bro.nextLine();
                System.out.println("Password : ");
                password = bro.nextLine();

                byte[] encodePass = Base64.getEncoder().encode(password.getBytes());
                String passS = new String(encodePass);

                filepath = "database//members.txt";
                boolean found = false;
                String tempName = "";
                byte[] decryptPass = Base64.getDecoder().decode(passS);
                String tempPass = new String(decryptPass);

                try{
                    Scanner sis = new Scanner(new File(filepath));
                    sis.useDelimiter("[,\n]");

                    while(sis.hasNext() && !found){
                        tempName = sis.next();
                        tempPass = sis.next();

                        if(tempName.trim().equals(username.trim()) && tempPass.trim().equals(passS.trim())){
                            found = true;
                        }
                    }
                    if(found){
                        System.out.println("Halo, " + username);
                    }
                    else {
                        System.err.println("Pengguna tidak dikenal.\nSilakan register terlebih dahulu");
                        System.exit(0);
                    }
                    sis.close();

                }
                catch (Exception e){
                    System.err.println("Error");
                }
                break;
            case "2":
                System.out.println("Masukkan username yang akan anda gunakan");
                username = bro.nextLine();
                System.out.println("Masukkan password yang akan anda gunakan");
                password = bro.nextLine();
                System.out.println("Pengguna baru ditambahkan\n");
                try{
                    FileWriter data = new FileWriter("database//members.txt",true);

                    byte[] encoded = Base64.getEncoder().encode(password.getBytes());
                    String pass = new String(encoded);

                    data.write(username + "," + pass);
                    data.write(System.getProperty("line.separator"));
                    data.flush();
                    data.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                logIn();
                break;
            case "3":
                System.out.println();
                System.out.println(
                        """
                        Aplikasi ini berguna untuk mensimulasikan estimasi penggunaan listrik anda.
                        Dalam aplikasi ini, terdapat 2 kategori barang elektronik, yaitu PERABOTAN dan GADGET.
                        Perabotan adalah barang elektronik yang akan selalu digunakan tanpa diputus dari sumber listrik.
                        Sementara itu, Gadget adalah barang elektronik yang hanya digunakan secara insidental.
                        Dalam program ini, diasumsikan jam pemakaian sebuah Gadget adalah 2 jam. Jam pemakaian ini dapat
                        berupa waktu digunakan, atau 
                        
                        
                        Sebelum menggunakan aplikasi ini, anda harus mempunyai akun terlebih dahulu.
                        Silakan lakukan pendaftaran dengan memilih menu REGISTER.
                        Jika sudah mempunyai akun, silakan LOG IN dan selamat menikmati aplikasi ini""");
                System.out.println();
                logIn();
                break;
            default:
                System.err.println("Milih apaan sih");
                logIn();
                break;
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Selamat Datang di Aplikasi Simulasi Billing Listrik!");
        logIn();
        lanjut = true;

        while(lanjut) {
            data.addToArraylistElektronik();
            data.addToArraylistGadget();
            System.out.println("========================================================================");
            System.out.println("Ada yang bisa kami bantu?");
            System.out.println("""
                            1. Simulasi listrik
                            2. Lihat daftar elektronik
                            3. Daftarkan elektronik baru
                            4. Edit data elektronik
                            5. Hapus data elektronik
                            
                            0. Keluar aplikasi 
                            """);
            System.out.print("Pilihan anda : ");
            pilihan = bro.nextLine();

            switch (pilihan){
                case "1":
                    data.mulaiSimulasi();
                    break;
                case "2":
                    System.out.print("Data apa yang mau dilihat?\n1. Elektronik\n2. Gadget\n: ");
                    String pilihDataLihat = bro.nextLine();
                    switch (pilihDataLihat.toLowerCase()) {
                        case "1","elektronik" -> data.tampilDataElektronik();
                        case "2","gadget" -> data.tampilDataGadget();
                        default -> System.err.println("Input yang anda masukkan salah");
                    }
                    break;
                case "3":
                    data.tambahData();
                    break;
                case "4":
                    System.out.print("Data apa yang mau anda edit?\n1. Elektronik\n2. Gadget\n: ");
                    String pilihDataEdit = bro.nextLine();
                    switch (pilihDataEdit.toLowerCase()) {
                        case "1","elektronik" -> data.editDataElektronik();
                        case "2","gadget" -> data.editDataGadget();
                        default -> System.err.println("Input yang anda masukkan salah");
                    }
                    break;
                case "5":
                    System.out.println("Data apa yang mau dihapus? ");
                    System.out.print("\n1. Elektronik \n2. Gadget\n: ");
                    String pilihDataHapus = bro.nextLine();
                    switch (pilihDataHapus.toLowerCase()) {
                        case "1","elektronik" -> data.hapusDataElektronik();
                        case "2","gadget" -> data.hapusDataGadget();
                        default -> System.err.println("Input yang anda masukkan salah");
                    }
                    break;
                case "0":
                    boolean keluar = data.getYesorNo("Yakin untuk keluar dari aplikasi ini ");
                    if(keluar){
                        System.out.println("Terima kasih sudah menggunakan aplikasi ini :)");
                        System.exit(0);
                    }
                default:
                    System.err.println("Input yang anda masukkan salah");
            }
            boolean terus = data.getYesorNo("Apakah anda ingin melanjutkan?");
            if(!terus){
                System.out.println("Terima kasih sudah menggunakan aplikasi ini :)");
                lanjut = false;
            }

        }

    }
}