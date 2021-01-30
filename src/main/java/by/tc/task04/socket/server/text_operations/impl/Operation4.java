package by.tc.task04.socket.server.text_operations.impl;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.impl.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;

import java.util.ArrayList;

public class Operation4 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        int wordLength = 7;
        TextParser textParser = new TextParser();
        ArrayList<Sentence> allSentencesFromText = textParser.parseTextToSentences(text);
        ArrayList<String> resultWords = new ArrayList<String>();
        ArrayList<Sentence> questionSentences = new ArrayList<Sentence>();

        for(Sentence sentence : allSentencesFromText)
        {
            if(sentence.getContent().contains(QUESTION_MARK))
                questionSentences.add(sentence);
        }

        for(Sentence sentence : questionSentences)
        {
            ArrayList<String> wordsFromSentence = textParser.parseSentenceToWords(sentence);

            for(String word : wordsFromSentence)
            {
                if(word.length() == wordLength && !resultWords.contains(word))
                    resultWords.add(word);

            }
        }

        StringBuilder allResultWords = new StringBuilder();

        for(String word : resultWords)
        {
            allResultWords.append(word);
            allResultWords.append(SPACE);
        }

        return new Text(allResultWords.toString());
    }
}
