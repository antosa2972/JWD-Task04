package by.tc.task04.socket.server;
import by.tc.task04.socket.server.controller.Controller;

public class ServerRunner {
    public static void main(String []args){
        Server server = new Server();
        while (true) {
            server.openConnection();
            Controller controller = new Controller(server);
            controller.chooseOperation(server.acceptData());
            server.closeConnection();
        }
    }
}
