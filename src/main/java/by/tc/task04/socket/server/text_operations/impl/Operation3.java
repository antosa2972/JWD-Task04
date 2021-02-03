package by.tc.task04.socket.server.text_operations.impl;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;

import java.util.ArrayList;

public class Operation3 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
            String uniqueWord = "";
            StringBuilder temp = new StringBuilder();
            TextParser textParser = new TextParser();
            ArrayList<Sentence> allSentencesFromText = textParser.parseTextToSentences(text);
            Sentence firstSentence = allSentencesFromText.get(FIRST);
            ArrayList<String> wordsFromFirstSentence = textParser.parseSentenceToWords(firstSentence);
            ArrayList<Sentence> sentencesExceptFirst = new ArrayList<Sentence>();
            for(int i = 1; i < allSentencesFromText.size(); i++)
                sentencesExceptFirst.add(allSentencesFromText.get(i));
            for(String word : wordsFromFirstSentence) {
                if(!sentencesExceptFirst.toString().contains(word)) {
                    temp.append(word);
                    temp.append(" ");
                }
            }
            uniqueWord=temp.toString();
            return new Text(uniqueWord);
    }
}
