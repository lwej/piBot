import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Maze extends FileReceiver {

    public static char[] path() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(FileReceiver.fileName));
        String str;
        List<String> list = new ArrayList<String>();
        while ((str = in.readLine()) != null) {
            System.out.println("Processing file...");
            list.add(str.replace("0", ""));
        }
        char[] reversedPath = list.toString().toCharArray();
        int x = 0;
        char[] path = new char[reversedPath.length];
        for (int i = reversedPath.length - 1; i >= 0; i--) {
            path[x] = reversedPath[i];
            x++;
        }
        System.out.println("File processed, path returned");
        return path;
    }


}
