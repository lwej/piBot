import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class FileReceiver {
    protected static String fileName;

    public static void start(int port) throws IOException {
        int bytesRead;
        ServerSocket server = new ServerSocket(port);
        // FileReceiver.port = port;
        System.out.println("Waiting for connection");
        Socket socket = server.accept();
        System.out.println("Connection established");
        InputStream in = socket.getInputStream();
        DataInputStream inData = new DataInputStream(in);
        fileName = inData.readUTF();
        OutputStream output = new FileOutputStream(fileName);
        long size = inData.readLong();
        byte[] buff = new byte[1024];
        while (size > 0 && (bytesRead = inData.read(buff, 0, (int) Math.min(buff.length, size))) != -1) {
            output.write(buff, 0, bytesRead);
            size -= bytesRead;
        }
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("File received: " + "'" + fileName + "'");
        out.writeUTF("Starting bot in a bit...");
        out.writeUTF("done");
        // Closing the server
        in.close();
        inData.close();
        out.close();
        output.close();
        System.out.println("Received file " + fileName);
    }

}

