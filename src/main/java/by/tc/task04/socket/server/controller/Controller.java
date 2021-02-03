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
                makeOperation = new Operation2();
                server.sendData(makeOperation.makeOperation(text));
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
                makeOperation= new Operation7();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 8:
                server.sendData(new Text("OPERATION IS NOT READY"));
                break;
            case 9:
                server.sendData(new Text("OPERATION IS NOT READY"));
                break;
            case 10:
                server.sendData(new Text("OPERATION IS NOT READY"));
                break;
            case 11:
                makeOperation = new Operation11();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 12:
                makeOperation = new Operation12();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 13:
                server.sendData(new Text("NO OPERATION IS NOT READY"));
                break;
            case 14:
                makeOperation = new Operation14();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 15:
                makeOperation = new Operation15();
                server.sendData(makeOperation.makeOperation(text));
                break;
            case 16:
                makeOperation= new Operation16();
                server.sendData(makeOperation.makeOperation(text));
                break;
        }
    }
}
