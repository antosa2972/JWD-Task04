package by.tc.task04.socket.server.text_operations.impl;
import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;
import by.tc.task04.socket.server.text_operations.MakeOperation;
import java.util.ArrayList;
public class Operation14 implements MakeOperation {
    @Override
    public Text makeOperation(Text text) {
        int length=0;
        TextParser textParser = new TextParser();
        ArrayList<Sentence> allSentencesFromText= textParser.parseTextToSentences(text);
        ArrayList<Sentence> result = new ArrayList<>();
        result.add(new Sentence(""));
        for(Sentence sentence: allSentencesFromText){
            String sContent= sentence.getContent();
            int j=0;
            for(int i =0;i<sContent.length()-1;i++,j++){
                if(i>=sContent.length()-1-j)
                    break;
                String toCheck=sContent.substring(i,sContent.length()-1-j);
                StringBuffer sb = new StringBuffer(toCheck);
                String reverse = sb.reverse().toString();
                if(toCheck.equals(reverse) && toCheck.length()> length){
                    length=toCheck.length();
                    result.set(0,new Sentence("Longest palindrome: " + toCheck +
                            ", length: "+ length));
                }
            }
        }
        if(length==0) result.set(0,new Sentence("No palindromes"));
        return new Text(result);
    }
}
