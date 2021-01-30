package by.tc.task04.socket.client;

public class ClientRunner {
    public static void main(String []args){
    Client client = new Client();
    int num;
    do {
        client.openConnection();
        client.showMenu();
        num = client.enterNumber();
        client.sendData(num);
        client.acceptData();
        //client.closeConnection();
    }while(num!=0);
    client.closeConnection();
    }
}
