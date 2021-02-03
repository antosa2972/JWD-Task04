package by.tc.task04.socket.server.text_operations;
import by.tc.task04.entity.Text;

public interface MakeOperation {
    String QUESTION_MARK = "?";
    int FIRST = 0;
    String SPACE = " ";
    Text makeOperation(Text text);
}
