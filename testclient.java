package TCP;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class testclient {

    public static void main(String[] args) throws IOException {
        String time = null;
        String name = null;
        String data = null;
        String host = null;
        int port = 0;


        Client(host, port);
        write(time, name, data, host, port);
        imp();

    }

    public static void Client(String host, int port) throws IOException{

        host = "localhost";
        port = 4999;

       //Socket s = new Socket(host,port);
        //PrintWriter pr = new PrintWriter(s.getOutputStream());

    }




    public static void write(String time, String name, String data, String host, int port) throws IOException {


      Socket s = new Socket(host, port);
        PrintWriter pr = new PrintWriter(s.getOutputStream());

        // three example data sets
        String sensorName = "MyGoodOldSensor"; // does not change

        long timeStamps[] = new long[3];
        timeStamps[0] = System.currentTimeMillis();
        timeStamps[1] = timeStamps[0] + 1; // milli sec later
        timeStamps[2] = timeStamps[1] + 1000; // second later

        float[] daten1 = {1.5f};
        float[] daten2 = {0.7f, 1.2f, 2.1f};
        float[] daten3 = {0.7f, 1.2f};

        float[][] datenArray = new float[3][];
        datenArray[0] = daten1;
        datenArray[1] = daten2;
        datenArray[2] = daten3;




        //Datei eröffnen
        OutputStream os = null;
        //InputStream is = null;
        DataOutputStream dos = null;
        DataInputStream dis = null;

        try {
            String filename = "testStream.txt";
            //OutputStream os = new FileOutputStream(filename);
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0); // brutal exception handling
        }

        //Text eintragen Input
        //Uhrzeit
        time = (String.valueOf(timeStamps[0])).toString();
        time = time + "  ";
        name = sensorName + "  ";
        for (int i = 0; i < datenArray.length; i++) {
            data = (Arrays.toString(datenArray[i]));
            data = data + "\n";

            byte[] textAsByte1 = name.getBytes();
            byte[] textAsByte2 = time.getBytes();
            //byte[] textAsByte3 = data.getBytes();
            try {
                os.write(textAsByte1);
                os.write(textAsByte2);

            } catch (IOException ex) {
                System.err.println("couldn’t write data (fatal)");
                System.exit(0);
            }


            byte[] textAsByte3 = data.getBytes();
            try {
                os.write(textAsByte3);
            } catch (IOException ex) {
                System.err.println("couldn’t write data (fatal)");
                System.exit(0);
            }
            pr.println(time);
            pr.print(name);
            pr.print(data);
            pr.flush();
        }






    }

    public static void imp() {
        //Imput Start
        InputStream is = null;
        try {
            is = new FileInputStream("testStream.txt");
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal is");
            System.exit(0);
        }

        byte[] readBuffer = new byte[500];
        try {
            is.read(readBuffer);
        } catch (IOException ex) {
            System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }


        String readString = new String(readBuffer);
        System.out.println("Datensatz1: " + readString);


    }




}