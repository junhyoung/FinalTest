package github.com.junhyoung.finaltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class resultActivity extends AppCompatActivity  {

    TextView result;
    Button cancle;
    int correct=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result=(TextView)findViewById(R.id.result);
        cancle=(Button)findViewById(R.id.cancle);

        Intent intent = getIntent();
        final ArrayList<Question> questions  = (ArrayList<Question>)intent.getSerializableExtra("questions");
        String temp="";
        for(int i=0;i<questions.size();i++){
            if(questions.get(i).isCorrect()) {
                temp += ((i + 1) + "번 문제 맞음");
                correct++;
            }
           else
                temp+=((i+1)+"번 문제 틀림");
            temp+="\n";
        }
        result.setText(temp);

        Toast toast = Toast.makeText(getApplicationContext(),"현재 맞힌 갯수는 "+correct+"개 입니다.",Toast.LENGTH_SHORT);
        toast.show();


        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
