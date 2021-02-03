package by.tc.task04.socket.client;

import by.tc.task04.socket.client.print.TextPrinter;

public class ClientRunner {
    public static void main(String []args){
    Client client = new Client();
    int num;
    do {
        client.openConnection();
        TextPrinter.printMenu();
        num = client.enterNumber();
        client.sendData(num);
        client.acceptData();
    }while(num!=0);
    client.closeConnection();
    }
}
