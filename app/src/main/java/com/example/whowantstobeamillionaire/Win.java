package com.example.whowantstobeamillionaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Win extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_win);
  }

  public void backHome(View view) {
    finish();
  }
}
