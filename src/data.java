import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class data {
    static Scanner bro;
    static ArrayList<elektronik> elektron = new ArrayList<>();
    static ArrayList<gadget> gadgets = new ArrayList<>();

    static LinkedList<elektronik> elektro = new LinkedList<>();
    static LinkedList<gadget> gadot = new LinkedList<>();

    static ArrayList<Double> hasil = new ArrayList<>();
    //static LinkedList<Double> hasill = new ArrayList<>();

    public static boolean getYesorNo(String pesan){
        bro = new Scanner(System.in);
        System.out.print("\n" + pesan + " (y/n)? ");
        String pilihan = bro.next();

        while(!pilihan.equalsIgnoreCase("y") && !pilihan.equalsIgnoreCase("n")){
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n" + pesan + " (y/n)? ");
            pilihan = bro.next();
        }

        return pilihan.equalsIgnoreCase("y");
    }

    public static void mulaiSimulasi() throws IOException{
        boolean mulai = true;
        while(mulai){
            File dbRabot = new File("database//elektronik.txt");
            FileReader fileInputelektronik = new FileReader(dbRabot);
            BufferedReader bufferInputelektronik = new BufferedReader(fileInputelektronik);
            File dbRabot2 = new File("database//elektronik.txt");
            FileReader fileInputelektronik2 = new FileReader(dbRabot2);
            BufferedReader bufferInputelektronik2 = new BufferedReader(fileInputelektronik2);

            File dbGadget = new File("database//gadget.txt");
            FileReader fileInputGadget = new FileReader(dbGadget);
            BufferedReader bufferInputGadget = new BufferedReader(fileInputGadget);
            File dbGadget2 = new File("database//gadget.txt");
            FileReader fileInputGadget2 = new FileReader(dbGadget2);
            BufferedReader bufferInputGadget2 = new BufferedReader(fileInputGadget2);

            bro = new Scanner(System.in);
            System.out.print("\nApa yang akan anda lakukan?\n1. Tambah elektronik\n2. Tambah Gadget\n3. Hitung Simulasi\n: ");
            String dataSimulasi = bro.nextLine();
            String nama, watt, jam, rupiah, kali;
            double perHari, biaya;
            int nomorData;
            String data, datum;
            switch (dataSimulasi.toLowerCase()){
                case "1":
                    nomorData = 0;
                    data = bufferInputelektronik.readLine();

                    while (data != null) {
                        nomorData++;
                        StringTokenizer token = new StringTokenizer(data, ",");
                        nama = token.nextToken();
                        watt = token.nextToken();
                        jam = token.nextToken();
                        perHari = elektron.get(nomorData - 1).perHari();
                        biaya = perHari * 1325;
                        rupiah = elektron.get(nomorData - 1).rupiah();


                        System.out.println(nomorData);
                        System.out.println("Nama                           : " + nama);
                        System.out.println("Watt                           : " + watt + " Watt");
                        System.out.println("Jam Pemakaian                  : " + jam + " jam");
                        System.out.println("Pemakaian WATT dalam satu hari : " + perHari + " kWh");
                        System.out.println("Biaya dalam satu hari          : " + rupiah);
                        System.out.println();
                        data = bufferInputelektronik.readLine();

                    }

                    nomorData = 0;
                    datum = bufferInputelektronik2.readLine();
                    System.out.print("Nomor berapa yang ingin anda tambahkan?");
                    int tambahRabot = bro.nextInt();

                    boolean ketemu = false;
                    while (datum != null) {
                        nomorData++;
                        StringTokenizer token = new StringTokenizer(datum, ",");

                        nama = token.nextToken();
                        watt = token.nextToken();
                        jam = token.nextToken();
                        perHari = elektron.get(nomorData - 1).perHari();
                        biaya = perHari * 1325;
                        rupiah = elektron.get(nomorData - 1).rupiah();


                        if (tambahRabot == nomorData) {
                            ketemu = true;
                            boolean isTambah = getYesorNo("Apakah anda akan menambahkan " + nama + " ke dalam simulasi ini?");
                            if (isTambah) {
                                System.out.println("Ada berapa jumlahnya?");
                                int jumlah = bro.nextInt();
                                double buatKeArraylist = biaya * jumlah;
                                hasil.add(buatKeArraylist);
                                System.out.println(nama + " berhasil ditambahkan");

                            }

                        }

                        datum = bufferInputelektronik2.readLine();

                    }
                    if(!ketemu){
                        System.err.println("Tidak ada data tersebut.");
                    }
                    break;
                case "2":
                    nomorData = 0;
                    data = bufferInputGadget.readLine();

                    while(data != null){
                        nomorData++;
                        StringTokenizer token = new StringTokenizer(data,",");
                        nama = token.nextToken();
                        watt = token.nextToken();
                        kali = token.nextToken();
                        perHari = gadgets.get(nomorData-1).perHari();
                        biaya = perHari*1325;
                        rupiah = gadgets.get(nomorData - 1).rupiah();

                        System.out.println(nomorData);
                        System.out.println("Nama                            : " + nama);
                        System.out.println("Watt                            : " + watt + " Watt");
                        System.out.println("Kali Pemakaian                  : " + kali + " kali");
                        System.out.println("Pemakaian WATT dalam satu hari  : " + perHari + " kWh");
                        System.out.println("Biaya dalam satu hari           : " + rupiah);
                        System.out.println();
                        data = bufferInputGadget.readLine();

                    }

                    nomorData = 0;
                    datum = bufferInputGadget2.readLine();
                    System.out.print("Nomor berapa yang ingin anda tambahkan?");
                    int tambahGads = bro.nextInt();

                    boolean ketemu2 = false;
                    while(datum != null){
                        nomorData++;
                        StringTokenizer token = new StringTokenizer(datum,",");

                        nama = token.nextToken();
                        watt = token.nextToken();
                        kali = token.nextToken();
                        perHari = gadgets.get(nomorData-1).perHari();
                        biaya = perHari*1325;
                        rupiah = gadgets.get(nomorData - 1).rupiah();

                        if(tambahGads == nomorData){
                            boolean isTambah = getYesorNo("Apakah anda akan menambahkan " + nama + " ke dalam simulasi ini?");
                            if(isTambah){
                                ketemu2 = true;
                                System.out.println("Ada berapa jumlahnya?");
                                int jumlah = bro.nextInt();
                                double buatKeArraylist = biaya*jumlah;
                                hasil.add(buatKeArraylist);
                                System.out.println(nama + " berhasil ditambahkan");
                            }
                        }
                        datum = bufferInputGadget2.readLine();
                    }
                    if(!ketemu2){
                        System.err.println("Tidak ada data tersebut");
                    }
                    break;
                case "3":
                    double sum = 0;
                    for (int i = 0; i < hasil.size(); i++) {
                        sum += hasil.get(i);
                    }
                    double total = sum*30;
                    NumberFormat rupiahTotal = NumberFormat.getInstance(Locale.GERMAN);
                    String biayaTotal = rupiahTotal.format(total);

                    System.out.println("Biaya konsumsi listrik anda selama satu bulan adalah Rp. " + biayaTotal);
                    break;
                default:
                    System.err.println("Input yang anda masukkan salah");
            }
            boolean apakah = getYesorNo("Apakah ingin melanjutkan simulasi ini?");
            if (!apakah){
                mulai = false;
            }
            fileInputelektronik.close();
            fileInputelektronik2.close();
            fileInputGadget.close();
            fileInputGadget2.close();
            bufferInputelektronik.close();
            bufferInputelektronik2.close();
            bufferInputGadget.close();
            bufferInputGadget2.close();
        }


    }

    public static void hapusDataElektronik() throws IOException{
        tampilDataElektronik();
        File database = new File("database//elektronik.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        File tempDB = new File("database//tempPerabot.txt");
        FileWriter fileOut = new FileWriter(tempDB);
        BufferedWriter bufferOutput = new BufferedWriter(fileOut);
        System.out.println();


        bro = new Scanner(System.in);
        System.out.println("\n\n Nomor berapa yang akan dihapus?");
        int hapus = bro.nextInt();

        int counter = 0;
        String data = bufferInput.readLine();

        boolean ketemu = false;
        while(data != null){
            counter++;
            boolean isDelete = false;

            StringTokenizer token = new StringTokenizer(data,",");

            if(hapus == counter){
                System.out.println("Data yang akan dihapus adalah ");
                System.out.println("==============================");
                System.out.println("Nama           : " + token.nextToken());
                System.out.println("Watt           : " + token.nextToken() + " Watt");
                System.out.println("Jam penggunaan : " + token.nextToken() + " jam");

                isDelete = getYesorNo("Apakah anda yakin untuk menghapus barang ini?");
            }
            if (isDelete){
                ketemu = true;
                System.out.println("Data berhasil dihapus");
            }
            else {
                bufferOutput.write(data);
                bufferOutput.newLine();
            }

            data = bufferInput.readLine();

        }

        if(!ketemu){
            System.err.println("Tidak ada data tersebut");
        }
        //Tutup data
        bufferOutput.close();
        bufferInput.close();
        fileInput.close();
        fileOut.close();

        //Delete file ori
        database.delete();

        //rename temp ke database
        tempDB.renameTo(database);

    }

    public static void hapusDataGadget() throws IOException{
        tampilDataGadget();
        File database = new File("database//gadget.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        File tempDB = new File("database//tempGadget.txt");
        FileWriter fileOut = new FileWriter(tempDB);
        BufferedWriter bufferOutput = new BufferedWriter(fileOut);

        bro = new Scanner(System.in);
        System.out.println("\n\n Nomor berapa yang akan dihapus?");
        int hapus = bro.nextInt();

        int counter = 0;
        String data = bufferInput.readLine();

        boolean ketemu = false;
        while(data != null){
            counter++;
            boolean isDelete = false;

            StringTokenizer token = new StringTokenizer(data,",");

            if(hapus == counter){
                System.out.println("Data yang akan dihapus adalah ");
                System.out.println("==============================");
                System.out.println("Nama            : " + token.nextToken());
                System.out.println("Watt            : " + token.nextToken() + " Watt");
                System.out.println("Jam Pemakaian   : " + token.nextToken() + " jam");
                System.out.println("Kali penggunaan : " + token.nextToken() + " kali");

                isDelete = getYesorNo("Apakah anda yakin untuk menghapus barang ini?");
            }
            if (isDelete){
                ketemu = true;
                System.out.println("Data berhasil dihapus");
            }
            else{
                bufferOutput.write(data);
                bufferOutput.newLine();
            }

            data = bufferInput.readLine();

        }
        if(!ketemu){
            System.err.println("Tidak ada data tersebut");
        }
        //Tutup data
        bufferOutput.close();
        bufferInput.close();
        fileInput.close();
        fileOut.close();

        //Delete file ori
        database.delete();

        //rename temp ke database
        tempDB.renameTo(database);
    }

    public static void addToArraylistElektronik() throws IOException{
        elektron.clear();
        FileReader read;
        BufferedReader bufferRead;

        try{
            read = new FileReader("database//elektronik.txt");
            bufferRead = new BufferedReader(read);
        }
        catch (Exception e){
            System.err.println("Data elektronik tidak ditemukan\n");
            return;
        }

        String data = bufferRead.readLine();
        while(data != null){
            StringTokenizer token = new StringTokenizer(data,",");
            String nama = token.nextToken();
            String watt = token.nextToken();
            String jam = token.nextToken();

            elektron.add(new elektronik(nama,watt,jam));
            data = bufferRead.readLine();
        }
        bufferRead.close();
        read.close();
    }

    public static void addToArraylistGadget() throws IOException{
        gadgets.clear();
        FileReader read;
        BufferedReader bufferRead;

        try{
            read = new FileReader("database//gadget.txt");
            bufferRead = new BufferedReader(read);
        }
        catch (Exception e){
            System.err.println("Data elektronik tidak ditemukan");
            System.err.println("");
            return;
        }

        String data = bufferRead.readLine();
        while(data != null){
            StringTokenizer token = new StringTokenizer(data,",");
            String nama = token.nextToken();
            String watt = token.nextToken();
            String jam = token.nextToken();
            String kali = token.nextToken();

            gadgets.add(new gadget(nama,watt,jam,kali));
            data = bufferRead.readLine();
        }
        bufferRead.close();
        read.close();
    }

    public static void tampilDataElektronik() throws IOException{
        addToLinkedListElektronik();
        FileReader fileInput;
        BufferedReader bufferInput;

        try{
            fileInput = new FileReader("database//elektronik.txt");
            bufferInput = new BufferedReader(fileInput);
        }
        catch (Exception e){
            System.err.println("Data elektronik tidak ditemukan");
            System.err.println("");
            return;
        }

        String data = bufferInput.readLine();
        int nomorData = 0;
        try {
            while (data != null) {
                nomorData++;

                StringTokenizer token = new StringTokenizer(data, ",");
                System.out.println(nomorData);
                System.out.println("Nama                           : " + token.nextToken());
                System.out.println("Watt                           : " + token.nextToken() + " Watt");
                System.out.println("Jam Pemakaian                  : " + token.nextToken() + " jam");
                System.out.println("Pemakaian WATT dalam satu hari : " + elektron.get(nomorData - 1).perHari() + " kWh");
                System.out.println("Biaya dalam satu hari          : " + elektron.get(nomorData - 1).rupiah());
                System.out.println("Alamat penyimpanan             : @" + Integer.toHexString(elektro.get(nomorData - 1).hashCode()));
                System.out.println();
                data = bufferInput.readLine();

            }
            fileInput.close();
            bufferInput.close();
        }
        catch (Exception e){
            System.err.println("Ada yg error");
            return;
        }


    }

    public static void tampilDataGadget() throws IOException{
        addToLinkedListGadget();
        FileReader fileInput;
        BufferedReader bufferInput;

        try{
            fileInput = new FileReader("database//gadget.txt");
            bufferInput = new BufferedReader(fileInput);
        }
        catch (Exception e){
            System.err.println("Data elektronik tidak ditemukan");
            System.err.println("");
            return;
        }

        String data = bufferInput.readLine();
        int nomorData = 0;
        try {
            while (data != null) {
                nomorData++;

                StringTokenizer token = new StringTokenizer(data, ",");
                System.out.println(nomorData);
                System.out.println("Nama                           : " + token.nextToken());
                System.out.println("Watt                           : " + token.nextToken() + " Watt");
                System.out.println("Jam Pemakaian                  : " + token.nextToken() + " jam");
                System.out.println("Kali Pemakaian                 : " + token.nextToken() + " kali");
                System.out.println("Pemakaian WATT dalam satu hari : " + gadgets.get(nomorData - 1).perHari() + " kWh");
                System.out.println("Biaya dalam satu hari          : " + gadgets.get(nomorData - 1).rupiah());
                System.out.println("Alamat penyimpanan             : @" + Integer.toHexString(gadot.get(nomorData - 1).hashCode()));
                System.out.println();
                data = bufferInput.readLine();
            }
            fileInput.close();
            bufferInput.close();
        }
        catch (Exception e){
            System.out.println("Ada yg error");
            return;
        }

    }

    public static void tambahData() throws IOException{
        bro = new Scanner(System.in);

        System.out.print("Masukkan nama barang elektronik yang akan ditambahkan : ");
        String nama = bro.nextLine();
        System.out.print("Masukkan nilai WATT dari barang tersebut : ");
        String watt = bro.nextLine();
        System.out.println("Apakah barang ini merupakan ELEKTRONIK atau GADGET?");
        String jenis = bro.nextLine();


        if (jenis.equalsIgnoreCase("elektronik")){
            System.out.print("Berapa jam pemakaiannya?");
            String jamPemakaian = bro.nextLine();

            elektron.add(new elektronik(nama,watt,jamPemakaian));
            FileWriter dataRabot = new FileWriter("database//elektronik.txt",false);
            for (int i = 0; i < elektron.size(); i++) {
                dataRabot.write(elektron.get(i).getNama() + "," +
                        elektron.get(i).getWatt() + "," +
                        elektron.get(i).getJamPemakaian());
                dataRabot.write(System.getProperty("line.separator"));
            }
            System.out.println(nama + " berhasil ditambahkan!");
            elektro.add(new elektronik(nama,watt,jamPemakaian));

            dataRabot.flush();
            dataRabot.close();
        }
        else if (jenis.equalsIgnoreCase("gadget")){
            System.out.print("Berapa jam penggunaannya dalam satu hari? ");
            String jamPemakaian = bro.nextLine();
            System.out.print("Berapa kali penggunaannya selama satu hari? ");
            String kaliPenggunaan = bro.nextLine();

            gadgets.add(new gadget(nama,watt,jamPemakaian,kaliPenggunaan));
            FileWriter dataGads = new FileWriter("database//gadget.txt",false);
            for (int i = 0; i < gadgets.size(); i++) {
                dataGads.write(gadgets.get(i).getNama() + "," +
                        gadgets.get(i).getWatt() + "," +
                        gadgets.get(i).getJamPemakaian() + "," +
                        gadgets.get(i).getKaliPemakaian());
                dataGads.write(System.getProperty("line.separator"));

            }
            System.out.println(nama + " berhasil ditambahkan!");
            gadot.add(new gadget(nama,watt,jamPemakaian,kaliPenggunaan));

            dataGads.flush();
            dataGads.close();
        } else System.err.println("Jenis tidak tersedia \n");
    }

    public static void editDataElektronik() throws IOException{
        tampilDataElektronik();

        File database = new File("database//elektronik.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        File tempDB = new File("database//tempPerabot.txt");
        FileWriter fileOut = new FileWriter(tempDB);
        BufferedWriter bufferOutput = new BufferedWriter(fileOut);

        bro = new Scanner(System.in);
        System.out.println("\nNomor berapa yang akan diedit?");
        int edit = bro.nextInt();

        int counterr = 0;
        String data = bufferInput.readLine();

        boolean ketemu = false;
        while(data != null){
            counterr++;
            StringTokenizer token = new StringTokenizer(data,",");

            if(edit == counterr) {
                System.out.println("Data yang akan anda edit adalah:");
                System.out.println("================================");
                System.out.println("Nama          : " + token.nextToken());
                System.out.println("Watt          : " + token.nextToken());
                System.out.println("Jam pemakaian : " + token.nextToken());

                String[] field = {"nama", "watt", "jam pemakaian"};
                String[] tempData = new String[3];

                token = new StringTokenizer(data, ",");

                for (int i = 0; i < field.length; i++) {
                    boolean isUpdate = getYesorNo("Apakah anda ingin merubah " + field[i] + "?");
                    String dataOri = token.nextToken();
                    if (isUpdate){
                        bro = new Scanner(System.in);
                        System.out.println("\nMasukkan " + field[i] + " baru");
                        tempData[i] = bro.nextLine();
                    }
                    else tempData[i] = dataOri;
                }
                token = new StringTokenizer(data,",");
                System.out.println("\nData tersebut akan berubah menjadi");
                System.out.println("===================================");
                System.out.println("Nama          : " + token.nextToken() + " --> " + tempData[0]);
                System.out.println("Watt          : " + token.nextToken() + " --> " + tempData[1]);
                System.out.println("Jam pemakaian : " + token.nextToken() + " --> " + tempData[2]);

                boolean isUpdate = getYesorNo("Apakah anda yakin ingin merubah data ini?");

                if(isUpdate){
                    ketemu = true;
                    bufferOutput.write(tempData[0] + "," + tempData[1] + "," + tempData[2]);
                }
                else bufferOutput.write(data);

            } else bufferOutput.write(data);
            bufferOutput.newLine();
            data = bufferInput.readLine();
        }
        if(!ketemu){
            System.err.println("Tidak ada data tersebut");
        }

        bufferOutput.close();
        bufferInput.close();
        fileInput.close();
        fileOut.close();

        database.delete();
        tempDB.renameTo(database);
    }

    public static void editDataGadget() throws IOException{
        tampilDataGadget();

        File database = new File("database//gadget.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        File tempDB = new File("database//tempGadget.txt");
        FileWriter fileOut = new FileWriter(tempDB);
        BufferedWriter bufferOutput = new BufferedWriter(fileOut);

        bro = new Scanner(System.in);
        System.out.println("\nNomor berapa yang akan diedit?");
        int edit = bro.nextInt();

        int counterr = 0;
        String data = bufferInput.readLine();

        boolean ketemu = false;
        while(data != null){
            counterr++;
            StringTokenizer token = new StringTokenizer(data,",");

            if(edit == counterr) {
                System.out.println("Data yang akan anda edit adalah:");
                System.out.println("================================");
                System.out.println("Nama           : " + token.nextToken());
                System.out.println("Watt           : " + token.nextToken());
                System.out.println("Jam Pemakaian  : " + token.nextToken());
                System.out.println("Kali pemakaian : " + token.nextToken());

                String[] field = {"nama", "watt", "jam pemakaian", "kali pemakaian"};
                String[] tempData = new String[4];

                token = new StringTokenizer(data, ",");

                for (int i = 0; i < field.length; i++) {
                    boolean isUpdate = getYesorNo("Apakah anda ingin merubah " + field[i] + "?");
                    String dataOri = token.nextToken();
                    if (isUpdate){
                        bro = new Scanner(System.in);
                        System.out.println("\nMasukkan " + field[i] + " baru");
                        tempData[i] = bro.nextLine();
                    }
                    else tempData[i] = dataOri;
                }
                token = new StringTokenizer(data,",");
                System.out.println("\nData tersebut akan berubah menjadi");
                System.out.println("===================================");
                System.out.println("Nama           : " + token.nextToken() + " --> " + tempData[0]);
                System.out.println("Watt           : " + token.nextToken() + " --> " + tempData[1]);
                System.out.println("Jam Pemakaian  : " + token.nextToken() + " --> " + tempData[2]);
                System.out.println("Kali Pemakaian : " + token.nextToken() + " --> " + tempData[3]);

                boolean isUpdate = getYesorNo("Apakah anda yakin ingin merubah data ini?");

                if(isUpdate){
                    ketemu = true;
                    bufferOutput.write(tempData[0] + "," + tempData[1] + "," + tempData[2] + "," + tempData[3]);
                }
                else bufferOutput.write(data);

            } else bufferOutput.write(data);
            bufferOutput.newLine();
            data = bufferInput.readLine();
        }
        if(!ketemu){
            System.err.println("Tidak ada data tersebut");
        }

        bufferOutput.close();
        bufferInput.close();
        fileInput.close();
        fileOut.close();

        database.delete();
        tempDB.renameTo(database);

    }

    public static void addToLinkedListElektronik() throws IOException{
        FileReader read;
        BufferedReader bufferRead;

        try{
            read = new FileReader("database//elektronik.txt");
            bufferRead = new BufferedReader(read);
        }
        catch (Exception e){
            System.err.println("Data elektronik tidak ditemukan\n");
            return;
        }

        String data = bufferRead.readLine();
        while(data != null){
            StringTokenizer token = new StringTokenizer(data,",");
            String nama = token.nextToken();
            String watt = token.nextToken();
            String jam = token.nextToken();

            elektro.add(new elektronik(nama,watt,jam));
            data = bufferRead.readLine();
        }
        bufferRead.close();
        read.close();

    }

    public static void addToLinkedListGadget() throws IOException{
        FileReader read;
        BufferedReader bufferRead;

        try{
            read = new FileReader("database//gadget.txt");
            bufferRead = new BufferedReader(read);
        }
        catch (Exception e){
            System.err.println("Data elektronik tidak ditemukan");
            System.err.println("");
            return;
        }

        String data = bufferRead.readLine();
        while(data != null){
            StringTokenizer token = new StringTokenizer(data,",");
            String nama = token.nextToken();
            String watt = token.nextToken();
            String jam = token.nextToken();
            String kali = token.nextToken();

            gadot.add(new gadget(nama,watt,jam,kali));
            data = bufferRead.readLine();
        }
        bufferRead.close();
        read.close();
    }
}