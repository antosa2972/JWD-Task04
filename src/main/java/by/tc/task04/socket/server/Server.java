package by.tc.task04.socket.server;
import by.tc.task04.socket.server.controller.Controller;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.GeneralSockConnection;
import by.tc.task04.socket.server.parse.impl.FileParser;
import by.tc.task04.socket.server.parse.impl.TextParser;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server implements GeneralSockConnection {
    private ServerSocket server;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    @Override
    public void openConnection(){
        try{
         this.server = new ServerSocket(8030);
            this.socket = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void closeConnection(){
        try {
            server.close();
            socket.close();
            objectInputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendData(Text text) {
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int acceptData() {
        Integer num=0;
        objectInputStream = null;
        try{
            if (socket != null) {
                objectInputStream = new ObjectInputStream(socket.getInputStream());
            }
                num = (Integer) objectInputStream.readObject();
        }catch(NullPointerException | IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return num.intValue();
    }
    public Text parse() {
        FileParser fileParser = new FileParser();
        return fileParser.parseFileToText();
    }
}
