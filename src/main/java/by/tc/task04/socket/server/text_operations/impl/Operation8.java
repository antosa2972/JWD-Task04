package by.tc.task04.socket.server.text_operations.impl;
import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;
import by.tc.task04.socket.server.text_operations.word_operator.WordOperator;

import java.util.ArrayList;

public class Operation8 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        String FIRST_LETTER = "^(?ui:[аеёиоуыэюя]).*";
        TextParser textParser = new TextParser();
        WordOperator wordOperator = new WordOperator();
        ArrayList<Sentence> allSentencesFromText= textParser.parseTextToSentences(text);
        ArrayList<String> allWordsFromText = new ArrayList<>();
        ArrayList<String> sortedWords=new ArrayList<>();
        for(Sentence sentence: allSentencesFromText){
            allWordsFromText.addAll(textParser.parseSentenceToWords(sentence));
        }
        //for(int i=0;i<allSentencesFromText.size();i++){
            //if(allWordsFromText.get(i).matches(FIRST_LETTER)&&allWordsFromText.get(i).indexOf('a')){
            //}
        //}
        return null;
    }
}
