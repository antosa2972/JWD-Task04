package by.tc.task04.socket.server.text_operations.impl;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;

import java.util.*;

public class Operation2 implements MakeOperation {
    private HashMap<Sentence, Integer> sortByValue(HashMap<Sentence, Integer> hm) {
        List<Map.Entry<Sentence, Integer> > list = new LinkedList<Map.Entry<Sentence, Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Sentence, Integer> >() {
            public int compare(Map.Entry<Sentence, Integer> o1,
                               Map.Entry<Sentence, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Sentence, Integer> temp = new LinkedHashMap<Sentence, Integer>();
        for (Map.Entry<Sentence, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public Text makeOperation(Text text) {
        TextParser textParser = new TextParser();
        ArrayList<Sentence> allSentencesFromText = textParser.parseTextToSentences(text);
        ArrayList<Sentence> sentencesSortedBySize= new ArrayList<Sentence>();
        HashMap<Sentence, Integer> sentencesAndSizesMap = new HashMap<Sentence, Integer>();
        for(Sentence sentence : allSentencesFromText)
            sentencesAndSizesMap.put(sentence, textParser.parseSentenceToWords(sentence).size());
        sentencesAndSizesMap = sortByValue(sentencesAndSizesMap);
        for(Sentence sentence : sentencesAndSizesMap.keySet())
            sentencesSortedBySize.add(sentence);
        return new Text(sentencesSortedBySize);
    }
}
