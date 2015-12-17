package github.com.junhyoung.finaltest;

import java.io.Serializable;

/**
 * Created by 준형 on 2015-12-17.
 */
public class Question implements Serializable {//객체를 intent로 전달하기위해 인터페이스 Serializable 구현
    String question;
    int correctAnswer;
    int useranswer;

    public Question(String q,int answer){
        question=q;
        correctAnswer=answer;
        useranswer=-1;

    }
    public boolean isCorrect(){
        if(correctAnswer==useranswer)
            return true;
        else
            return false;
    }
    public String getQuestion(){
        return question;
    }
    public void setUseranswer(int answer){
        useranswer=answer;
    }
    public void resetAnswer(){
        useranswer=-1;
    }
}
