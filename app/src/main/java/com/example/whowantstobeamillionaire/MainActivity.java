package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


  TextView question_ref;
  Helper query = new Helper();
  RadioGroup radioGroup;
  Button btn;
  RadioButton answer;
  RadioButton[] radios;
  String[] choices;
  int n;
  int cash;
  TextView reward;
  DecimalFormat decimalFormat;
  String pattern;


  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //
    pattern = "$###,###.###";
    decimalFormat = new DecimalFormat(pattern);
    //


    n = 0;
    cash = 0;
    radioGroup = findViewById(R.id.radioGroup);
    question_ref = findViewById(R.id.question);
    btn = findViewById(R.id.next);
    reward = findViewById(R.id.reward);
    setRadios();
    setUp(n);
  }

  public void btnPressed(View v) {
    int radioID = radioGroup.getCheckedRadioButtonId();
    answer = findViewById(radioID);

    if (query.checkAnswer(n, answer.getText().toString())) {
      cash = query.calculateAnswer(n, cash);
      Toast.makeText(this, "Correct! " + cash, Toast.LENGTH_SHORT).show();
      n++;
      radioGroup.clearCheck();
      setUp(n);
    } else {
      startActivity(new Intent(this, GameOver.class));
      n = 0;
      cash = 0;
      radioGroup.clearCheck();
      setUp(0);
    }

  }

  private void setUp(int index) {
    question_ref.setText(query.getQuestion(index));
    choices = query.getChoices(index);
    reward.setText(decimalFormat.format(cash));
    for (int i = 0; i < radios.length; i++) {
      radios[i].setText(choices[i]);
    }
  }

  private void setRadios() {
    radios = new RadioButton[4];
    radios[0] = findViewById(R.id.option_1);
    radios[1] = findViewById(R.id.option_2);
    radios[2] = findViewById(R.id.option_3);
    radios[3] = findViewById(R.id.option_4);
  }

}
