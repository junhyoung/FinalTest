package github.com.junhyoung.finaltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    ArrayList<Question> questions;
    Button result,next,pre,insert;
    TextView problem;
    EditText answer;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questions=new ArrayList<Question>();
        questions.add(new Question("1. 보기 중 가장 큰 수를 고르시오\n 1)0 2)4 3)50",3));
        questions.add(new Question("2. 보기 중 가장 작은 수를 고르시오\n 1)0 2)4 3)50",1));
        questions.add(new Question("3. 보기 중 음수를 고르시오\n 1)-5 2)4 3)50",1));
        questions.add(new Question("4. 보기 중 알파벳을 고르시오\n 1)0 2)A 3)50",2));
        result=(Button)findViewById(R.id.result);
        next=(Button)findViewById(R.id.next);
        pre=(Button)findViewById(R.id.pre);
        insert=(Button)findViewById(R.id.insert);
        problem=(TextView)findViewById(R.id.problem);
        answer=(EditText)findViewById(R.id.answer);

        problem.setText(questions.get(index).getQuestion());


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),resultActivity.class);
                intent.putExtra("questions", questions);
                startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==questions.size()-1) {
                    Toast toast = Toast.makeText(getApplicationContext(), "현재 마지막 문제입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    index++;
                    problem.setText(questions.get(index).getQuestion());
                }

            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "현재 첫 번째 문제입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    index--;
                    problem.setText(questions.get(index).getQuestion());
                }
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    questions.get(index).setUseranswer(Integer.parseInt(answer.getText().toString()));
                    String temp = (index + 1) + "번 문제" + questions.get(index).useranswer + "보기 선택";
                    Toast toast = Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT);
                    toast.show();
                }catch (Exception e){ // 입력값이 숫자가 아닐때 오류 해결 Not a number
                    Toast toast = Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
