package by.tc.task04.socket.server.text_operations.impl;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;

import java.util.ArrayList;

public class Operation12 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        int LENGTH=5;
        String FIRST_LETTER = "^(?ui:[^аеёиоуыэюя]).*";
        TextParser textParser = new TextParser();
        ArrayList<Sentence> newSentences = new ArrayList<>();
        ArrayList<Sentence> allSentencesFromText= textParser.parseTextToSentences(text);
        for(Sentence sentence: allSentencesFromText){
            ArrayList<String> wordsFromSentence=textParser.parseSentenceToWords(sentence);
            for(int i = 0;i<wordsFromSentence.size();i++){
                if(wordsFromSentence.get(i).length()==LENGTH&& wordsFromSentence.get(i).matches(FIRST_LETTER)){
                    wordsFromSentence.remove(i);
                }
            }
            newSentences.add(textParser.getSentenceFromWords(wordsFromSentence));
        }
        return new Text(newSentences);
    }
}