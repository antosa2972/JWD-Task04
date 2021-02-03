package by.tc.task04.socket.server.text_operations.impl;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;

import java.util.ArrayList;

public class Operation11 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        TextParser textParser = new TextParser();
        ArrayList<Sentence> allSentencesFromText = textParser.parseTextToSentences(text);
        char first = '(',second = ')';
        for(int i=0;i<allSentencesFromText.size();i++){
            int firstIndex=allSentencesFromText.get(i).getContent().indexOf(first)+1;
            int secondIndex = allSentencesFromText.get(i).getContent().lastIndexOf(second);
            if(firstIndex>=0&&secondIndex>=0) {
                String substring = allSentencesFromText.get(i).getContent().substring(firstIndex, secondIndex);
                allSentencesFromText.set(i,new Sentence(allSentencesFromText.get(i).
                       getContent().replace(substring, "")));
            }
        }
        return new Text(allSentencesFromText);
    }
}
