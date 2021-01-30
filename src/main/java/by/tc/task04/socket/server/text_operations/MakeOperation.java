package by.tc.task04.socket.server.text_operations;
import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.impl.TextParser;

import java.util.ArrayList;

public interface MakeOperation {
    static final String QUESTION_MARK = "?";
    static final int FIRST = 0;
    static final String SPACE = " ";
    public Text makeOperation(Text text);
}
