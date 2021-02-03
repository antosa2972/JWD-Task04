package by.tc.task04.socket.server.text_operations.impl;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;

import java.util.ArrayList;

public class Operation5 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        TextParser textParser = new TextParser();
        ArrayList<Sentence> allSentencesFromText = textParser.parseTextToSentences(text);
        ArrayList<Sentence> result = new ArrayList<Sentence>();
        for(Sentence sentence : allSentencesFromText) {
            ArrayList<String> wordsFromSentence = textParser.parseSentenceToWords(sentence);
            if(wordsFromSentence.size() > 1) {
                String firstWord = wordsFromSentence.get(FIRST);
                String lastWord = wordsFromSentence.get(wordsFromSentence.size() - 1);

                wordsFromSentence.remove(FIRST);
                wordsFromSentence.remove(wordsFromSentence.size() - 1);
                wordsFromSentence.add(FIRST, lastWord);
                wordsFromSentence.add(wordsFromSentence.size(), firstWord);
            }
            result.add(textParser.getSentenceFromWords(wordsFromSentence));
        }
        return new Text(result);
    }
}