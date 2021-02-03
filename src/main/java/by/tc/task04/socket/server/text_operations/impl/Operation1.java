package by.tc.task04.socket.server.text_operations.impl;
import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;
import java.util.ArrayList;

public class Operation1 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        TextParser textParser = new TextParser();
        ArrayList<Sentence> allSentencesFromText= textParser.parseTextToSentences(text);
        ArrayList<Sentence> sentencesWithRepetitiveWords = new ArrayList<Sentence>();
        for(Sentence sentence: allSentencesFromText) {
            ArrayList<String> wordsFromSentence = textParser.parseSentenceToWords(sentence);
            for(int i = 0; i < wordsFromSentence.size(); i++) {
                for(int j = i + 1; j < wordsFromSentence.size(); j++) {
                    if(wordsFromSentence.get(i).equals(wordsFromSentence.get(j))) {
                        if(!sentencesWithRepetitiveWords.contains(sentence))
                            sentencesWithRepetitiveWords.add(sentence);
                    }
                }
            }
        }
        return new Text(sentencesWithRepetitiveWords);
    }
}
