package by.tc.task04.entity;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Text implements Serializable {
    private String content;
    public Text(String content)
    {
        this.content = content;
    }
    public Text(ArrayList<Sentence> sentences) {
        StringBuilder allSentences = new StringBuilder();
        for(Sentence sentence : sentences) {
            allSentences.append(sentence.getContent());
        }
        this.content = allSentences.toString();
    }
    public Text(HashMap<Sentence,Integer> sentences) {
        StringBuilder allSentences = new StringBuilder();
        this.content = allSentences.toString();
    }
    @Override
    public String toString() {
        return "Text{" +
                "content='" + content + '\'' +
                '}';
    }
    public String operationResult() throws IOException {
        return "\nResult of operation: "+ content+'\n';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(content, text.content);
    }
    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
}
