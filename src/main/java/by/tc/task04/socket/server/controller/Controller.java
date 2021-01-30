package by.tc.task04.socket.server.controller;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.Server;
import by.tc.task04.socket.server.text_operations.MakeOperation;
import by.tc.task04.socket.server.text_operations.impl.*;

public class Controller {
    private Server server;
    public Controller(Server server){
        this.server=server;
    }
    public void chooseOperation(int value) {
        MakeOperation makeOperation;
        Text text = server.parse();
        switch (value){
            case 1:
                makeOperation=new Operation1();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 2:
                break;
            case 3:
                makeOperation=new Operation3();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 4:
                makeOperation = new Operation4();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 5:
                makeOperation=new Operation5();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 6:
                makeOperation = new Operation6();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
        }
    }
}
