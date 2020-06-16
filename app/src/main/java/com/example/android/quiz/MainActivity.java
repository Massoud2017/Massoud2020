package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* when user press sumbit button it shows correct answer and score. */
    public void sumbit(View view) {
        String message = CorrectAnswer();
        displayMessage(message);
        // if the button is checked then we considered true and then we call score method
        RadioButton California = (RadioButton) findViewById(R.id.Californa_checkbox);
        boolean isCalifornia = California.isChecked();
        score(isCalifornia);

        RadioButton president = (RadioButton) findViewById(R.id.Trump_checkbox);
        boolean isPresident = president.isChecked();
        score(isPresident);

        CheckBox neigber = (CheckBox) findViewById(R.id.Oregan_checkbox);
        boolean isNeigber = neigber.isChecked();
        score(isNeigber);

        CheckBox neigberTwo = (CheckBox) findViewById(R.id.Nevada_Id);
        boolean isNeigberTwo = neigberTwo.isChecked();
        score(isNeigberTwo);

        EditText editTextName = (EditText) findViewById(R.id.name_view);
        String isAnswer = editTextName.getText().toString();
        // Here I use if statement to know if the user entered the correct answer
        if (isAnswer.equals("Sacramento")) {
            count += 1;
            displayScore(count);
        }
    }

    // method to find the score
    private void score(boolean result) {
        if (result) {
            count += 1;
            displayScore(count);
        }

    }

    // To see the correct result
    public String CorrectAnswer() {
        String Correct = "Correct answers are:\n";
        Correct += "1. (1 point)  Sacramento\n";
        Correct += "2. (1 point) California\n";
        Correct += "3.(2 points) Orgean, Nevada\n";
        Correct += "4. (1 point) Donald Trump\n";
        return Correct;
    }

    // displaying the score
    private void displayScore(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score_view);
        quantityTextView.setText("" + number);
    }

    //displaying the result
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


}
