package TCP;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("client connected");

       InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);


try {
    String line = bf.readLine();
    while (line != null) {
        System.out.println(line);
        // read next line
        line = bf.readLine();
    }
    //bf.close();
} catch (IOException e){
    //e.printStackTrace();
    System.out.println("End of documentation");
}
ss.setSoTimeout(10000);



    }
}
