package com.example.lab05_01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab05_01.R;

/**
 * @author Amir
 * @version 1
 */
public class MainActivity extends AppCompatActivity {
    /**this hold text at the center */
    private TextView tv=null;
    /** this is for our password */
    private TextView tv2=null;
    /**this is for our login */
    private Button btn=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.password);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            String password = tv2.getText().toString();
            boolean isComplex = checkPasswordComplexity(password);
            if (isComplex) {
                tv.setText("Your password meets the requirements");
            } else {
                tv.setText("You shall not pass!");
            }
        });
    }
    /**
     * This function is for checking the password
     * @param pw the password to be checked
     * @return true if password meets all complexity requirements, false otherwise.
     */
    boolean checkPasswordComplexity(String pw){
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;

        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }

            if (foundUpperCase && foundLowerCase && foundNumber && foundSpecial) {
                return true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "Your password does not have an upper case letter", Toast.LENGTH_SHORT).show();
        } else if (!foundLowerCase) {
            Toast.makeText(this, "Your password does not have a lower case letter", Toast.LENGTH_SHORT).show();
        } else if (!foundNumber) {
            Toast.makeText(this, "Your password does not have a number", Toast.LENGTH_SHORT).show();
        } else if (!foundSpecial) {
            Toast.makeText(this, "Your password does not have a special symbol", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    /**
     * This method checks if the character is a special character.
     *
     * @param c The character to be checked.
     * @return true if the character is a special character, false otherwise.
     */
    boolean isSpecialCharacter(char c){
        switch(c) {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}
