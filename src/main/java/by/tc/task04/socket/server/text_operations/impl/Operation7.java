package by.tc.task04.socket.server.text_operations.impl;
import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;
import by.tc.task04.socket.server.text_operations.word_operator.WordOperator;

import java.util.ArrayList;

public class Operation7 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        TextParser textParser = new TextParser();
        WordOperator wordOperator = new WordOperator();
        ArrayList<Sentence> allSentencesFromText= textParser.parseTextToSentences(text);
        ArrayList<String> allWordsFromText = new ArrayList<>();
        for(Sentence sentence: allSentencesFromText){
            allWordsFromText.addAll(textParser.parseSentenceToWords(sentence));
        }
        StringBuilder content = new StringBuilder();
        ArrayList<String> wordsToSort = new ArrayList<String>();
        wordsToSort.addAll(allWordsFromText);
        String[] wordsToSortArr = new String[wordsToSort.size()];
        for(int i = 0; i < wordsToSort.size(); i++)
            wordsToSortArr[i] = wordsToSort.get(i);
        for(int i = 0; i < wordsToSortArr.length; i++) {
            for(int j = 1; j < wordsToSortArr.length; j++) {
                if(wordOperator.vowelRatio(wordsToSortArr[j - 1]) > wordOperator.vowelRatio(wordsToSortArr[j])) {
                    String temp = wordsToSortArr[j- 1];
                    wordsToSortArr[j - 1] = wordsToSortArr[j];
                    wordsToSortArr[j] = temp;
                }
            }
        }
        for(int i = 0; i < wordsToSortArr.length; i++) {
            content.append(wordsToSortArr[i] + SPACE);
        }
        return new Text(content.toString());
    }
}