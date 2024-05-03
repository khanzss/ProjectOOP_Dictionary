package main;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String content;
    private List<String> choices = new ArrayList<>();
    private String answer;

    public Question(String content, String answer) {
        this.content = content;
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void addChoice(String a, String b, String c, String d) {
        choices.add(a);
        choices.add(b);
        choices.add(c);
        choices.add(d);
    }
}
