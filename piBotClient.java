import java.net.*;
import java.io.*;
import java.util.Scanner;

public class piBotClient {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter host: ");
        String host = input.nextLine();
        System.out.println("Enter port: ");
        int port = input.nextInt();
        Socket socket = new Socket(host, port);
        System.out.println("Enter filename: ");
        File fileName = new File(input.nextLine());
        System.out.println("Sending file " + fileName);

        byte[] bytes = new byte[(int) fileName.length()];

        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        dis.readFully(bytes, 0, bytes.length);
        OutputStream os = socket.getOutputStream();

        //Sending file name and size to rPi
        DataOutputStream output = new DataOutputStream(os);
        output.writeUTF(fileName.getName());
        output.writeLong(bytes.length);
        output.write(bytes, 0, bytes.length);
        output.flush();
        DataInputStream read = new DataInputStream(socket.getInputStream());
        String pi;
        do {
            pi = read.readUTF();
            System.out.println(pi);
        }while(!pi.equals("done"));

        socket.close();
    }
}