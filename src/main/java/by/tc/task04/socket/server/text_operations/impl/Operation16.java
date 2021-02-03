package by.tc.task04.socket.server.text_operations.impl;
import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;

import java.util.ArrayList;

public class Operation16 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        int NUM_OF_SENTENCE=3;
        int LENGTH_OF_WORDS_TO_DELETE=7;
        String SUBSTRING = "JWD---Substring long";
        TextParser textParser = new TextParser();
        ArrayList<Sentence> allSentencesFromText= textParser.parseTextToSentences(text);
        ArrayList<String> wordsFromSentence =
                textParser.parseSentenceToWords(allSentencesFromText.get(NUM_OF_SENTENCE-1));
        for(int i=0;i<wordsFromSentence.size();i++){
            if(wordsFromSentence.get(i).length()==LENGTH_OF_WORDS_TO_DELETE){
                wordsFromSentence.set(i,SUBSTRING);
            }
        }
        allSentencesFromText.set(NUM_OF_SENTENCE-1, textParser.getSentenceFromWords(wordsFromSentence));
        return new Text(allSentencesFromText);
    }
}
