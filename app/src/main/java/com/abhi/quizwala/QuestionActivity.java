package com.abhi.quizwala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private TextView question,noIndicator;
    private FloatingActionButton bookmarkBtn;
    private LinearLayout optionsContainer;
    private Button shareBtn, nextBtn;
    private int count =0;
    private List<QuestionModel> list;
    private  int position =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        question = findViewById(R.id.question);
        noIndicator = findViewById(R.id.no_indicator);
        bookmarkBtn = findViewById(R.id.bookmark_btn);
        optionsContainer = findViewById(R.id.options_container);
        shareBtn = findViewById(R.id.start_btn);
        nextBtn = findViewById(R.id.next_btn);

         list = new ArrayList<>();
        list.add(new QuestionModel("question 1","a","b","c","d","c"));
        list.add(new QuestionModel("question 2","a","b","c","d","c"));
        list.add(new QuestionModel("question 3","a","b","c","d","a"));
        list.add(new QuestionModel("question 4","a","b","c","d","b"));
        list.add(new QuestionModel("question 5","a","b","c","d","c"));
        list.add(new QuestionModel("question 6","a","b","c","d","d"));
        list.add(new QuestionModel("question 7","a","b","c","d","a"));
        list.add(new QuestionModel("question 8","a","b","c","d","d"));
        list.add(new QuestionModel("question 9","a","b","c","d","a"));
        list.add(new QuestionModel("question 10","a","b","c","d","b"));

        for (int i=0; i<4; i++){
            optionsContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                playAnim(question,0,list.get(position).getQuestion());
            }
        });

    }
    private void playAnim(final View view, final int value,final String data){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (value==0){
                    String option="";
                    if (count == 0){
                        option = list.get(position).getOptionA();
                    } else if (count==1){
                        option = list.get(position).getOptionB();
                    } else if (count==2){
                        option = list.get(position).getOptionC();
                    } else if (count==3){
                        option = list.get(position).getOptionD();
                    }
                    playAnim(optionsContainer.getChildAt(count), 0,option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ((TextView)view).setText(data);
                if (value==0){
                    playAnim(view,1,data);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}