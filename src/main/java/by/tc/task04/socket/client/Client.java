package by.tc.task04.socket.client;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.GeneralSockConnection;
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
            System.out.println(text.operationResult());
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
    public void showMenu(){
        System.out.println("1.Найти наибольшее количество предложений текста, в которых есть одинаковые слова.\n" +
                "2.Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.\n" +
                "3.Найти такое слово в первом предложении, которого нет ни в предложений. одном из остальных.\n" +
                "4.Во всех вопросительных предложениях текста найти и напечатать без повторений слова заданной длины.\n" +
                "5.Вкаждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.\n" +
                "6.Напечатать слова текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки.\n" +
                "7.Рассортировать слова текста по возрастанию доли гласных гласных к общему количеству букв в слове).\n" +
                "8.Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.\n" +
                "9.Все слова текста рассортировать по возрастанию количества заданной буквы в слове. Слова с одинаковым количеством букв расположить в алфавитном порядке.\n" +
                "10.Существует текст и список слов. Для каждого слова из заданного списка найти, сколько раз оно встречается в каждом предложении, и рассортировать слова по\n" +
                "убыванию общего количества вхождений.\n" +
                "11.В каждом предложении текста исключить подстроку максимальной длины, начинающуюся и заканчивающуюся заданными символами.\n" +
                "12.Из текста удалить все слова заданной длины, начинающиеся на согласную букву.\n" +
                "13.Отсортировать слова в тексте по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.\n" +
                "14.В заданном тексте найти подстроку максимальной длины, являющуюся палиндромом, т.е. читающуюся слева направо и справа налево одинаково.\n" +
                "15.В заданном тексте найти подстроку максимальной длины, являющуюся палиндромом, т.е. читающуюся слева направо и справа налево одинаково.\n" +
                "16.В некотором предложении текста слова заданной длины заменить подстрокой, длина которой может не совпадать с длиной слова. указанной.\n" +
                "0.Выйти из программы.");

    }
    public int enterNumber(){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        while(number>16&&number<0) {
        }
        return number;
    }
}
