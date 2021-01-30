package by.tc.task04.socket.server.text_operations.impl;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.impl.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;

import java.util.ArrayList;
import java.util.Collections;

public class Operation6 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        TextParser textParser = new TextParser();
        ArrayList<String> allWordsFromText = new ArrayList<>();
        ArrayList<Sentence> sentenceArrayList = textParser.parseTextToSentences(text);
        for (Sentence sentence:sentenceArrayList){
            allWordsFromText.addAll(textParser.parseSentenceToWords(sentence));
        }
        ArrayList<String> wordsToSort = new ArrayList<String>();
        wordsToSort.addAll(allWordsFromText);

        Collections.sort(wordsToSort);

        StringBuilder content = new StringBuilder();
        for(int i = 0; i < wordsToSort.size(); i++)
        {
            if( i != 0 && wordsToSort.get(i).charAt(0) != wordsToSort.get(i - 1).charAt(0))
                content.append("\n\t");

            content.append(wordsToSort.get(i) + SPACE);
        }

        return new Text(content.toString());
    }
}