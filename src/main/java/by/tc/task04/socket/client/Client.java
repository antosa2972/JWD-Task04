package by.tc.task04.socket.client;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.GeneralSockConnection;
import by.tc.task04.socket.client.print.TextPrinter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements GeneralSockConnection {
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    public void acceptData()  {
        objectInputStream = null;
        try{
        if (socket != null) {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        }
            assert objectInputStream != null;
            Text text = (Text) objectInputStream.readObject();
            TextPrinter.printResult(text.operationResult());
        }catch(NullPointerException | IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    @Override
    public void openConnection() {
        try {
            socket = new Socket("127.0.0.1", 8030);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void closeConnection(){
        try {
            socket.close();
            objectInputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendData(Integer num) {
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(num);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int enterNumber(){
        Scanner in = new Scanner(System.in);
        int number;
        do{
            number= in.nextInt();
        }while(number<0||number>16);
        return number;
    }
}
