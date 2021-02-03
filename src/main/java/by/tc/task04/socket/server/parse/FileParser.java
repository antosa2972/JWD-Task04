package by.tc.task04.socket.server.parse;

import by.tc.task04.entity.Text;

import java.io.*;

public class FileParser {
    private File fileToParse;
    private static final String PATH = "src\\main\\resources\\Learning Java.txt";
    public FileParser()
    {
        fileToParse = new File(PATH);
    }
    public Text parseFileToText() {
        Text text = null;
        StringBuilder textContent = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(fileToParse);
            BufferedReader reader = new BufferedReader(fileReader);
            String lineToRead = reader.readLine();
            while(lineToRead != null) {
                textContent.append(lineToRead);
                lineToRead = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        text = new Text(textContent.toString());
        return text;
    }
}
