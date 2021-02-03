package by.tc.task04.socket.server.text_operations.impl;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;

import java.util.ArrayList;

public class Operation15 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        TextParser textParser = new TextParser();
        ArrayList<Sentence> allSentencesFromText= textParser.parseTextToSentences(text);
        for(int j=0;j<allSentencesFromText.size();j++){
            ArrayList<String> wordsFromSentence=textParser.parseSentenceToWords(allSentencesFromText.get(j));
            for(int k=0;k<wordsFromSentence.size();k++){
                for(int i=1;i<wordsFromSentence.get(k).length();i++){
                    if(wordsFromSentence.get(k).charAt(0)==wordsFromSentence.get(k).charAt(i)){
                        StringBuilder stringBuilder = new StringBuilder(wordsFromSentence.get(k));
                        stringBuilder.deleteCharAt(i);
                        wordsFromSentence.set(k,stringBuilder.toString());
                    }
                }
            }
            allSentencesFromText.set(j,textParser.getSentenceFromWords(wordsFromSentence));
        }
        return new Text(allSentencesFromText);
    }
}