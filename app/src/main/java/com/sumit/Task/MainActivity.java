package com.sumit.Task;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//  Variables Declaration and initialization
    String typingString = "";
    String keyboardWord1[] = {"1","A","B","C","a","b","c"};
    String keyboardWord2[] = {"2","D","E","F","d","e","f"};
    String keyboardWord3[] = {"3","G","H","I","g","h","i"};
    String keyboardWord4[] = {"4","J","K","L","j","k","l"};
    String keyboardWord5[] = {"5","M","N","O","m","n","o"};
    String keyboardWord6[] = {"6","P","Q","R","p","q","r"};
    String keyboardWord7[] = {"7","S","T","U","s","t","u"};
    String keyboardWord8[] = {"8","V","W","X","v","w","x"};
    String keyboardWord9[] = {"9","Y","Z","y","z"};
    CountDownTimer mCountDownTimer;
    int keyIndex1 = 0,keyIndex2 = 0, keyIndex3 = 0,keyIndex4 = 0,keyIndex5 = 0,keyIndex6 = 0,keyIndex7 = 0,
    keyIndex8 = 0,keyIndex9 = 0;
    int lastKey = 0;
//    UI Widgets declaration
    Button key1,key2,key3,key4,key5,key6,key7,key8,key9,deleteChar;
    EditText nameEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initialization TextViews and Buttons
        key1 = (Button) findViewById(R.id.key_1);
        key2 = (Button) findViewById(R.id.key_2);
        key3 = (Button) findViewById(R.id.key_3);
        key4 = (Button) findViewById(R.id.key_4);
        key5 = (Button) findViewById(R.id.key_5);
        key6 = (Button) findViewById(R.id.key_6);
        key7 = (Button) findViewById(R.id.key_7);
        key8 = (Button) findViewById(R.id.key_8);
        key9 = (Button) findViewById(R.id.key_9);
        deleteChar = (Button) findViewById(R.id.delete);
        nameEt = (EditText) findViewById(R.id.name_et);

//        Handling OnClickListners of Buttons
        key1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                check if already timer is already on if yes stop the last one and start new
                if (mCountDownTimer!= null){
                    mCountDownTimer.cancel();
                }
                keyIndex1++;
                typeInWord(keyboardWord1, keyIndex1,1);
            }
        });
        key2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!= null){
                    mCountDownTimer.cancel();
                }
                keyIndex2++;
                typeInWord(keyboardWord2, keyIndex2,2);
            }
        });
        key3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!= null){
                    mCountDownTimer.cancel();
                }
                keyIndex3++;
                typeInWord(keyboardWord3, keyIndex3,3);
            }
        });
        key4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!= null){
                    mCountDownTimer.cancel();
                }
                keyIndex4++;
                typeInWord(keyboardWord4, keyIndex4,4);
            }
        });
        key5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!= null){
                    mCountDownTimer.cancel();
                }
                keyIndex5++;
                typeInWord(keyboardWord5, keyIndex5,5);
            }
        });
        key6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!= null){
                    mCountDownTimer.cancel();
                }
                keyIndex6++;
                typeInWord(keyboardWord6, keyIndex6,6);
            }
        });
        key7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!= null){
                    mCountDownTimer.cancel();
                }
                keyIndex7++;
                typeInWord(keyboardWord7, keyIndex7,7);
            }
        });
        key8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!= null){
                    mCountDownTimer.cancel();
                }
                keyIndex8++;
                typeInWord(keyboardWord8, keyIndex8,8);
            }
        });
        key9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!= null){
                    mCountDownTimer.cancel();
                }
                keyIndex9++;
                typeInWord(keyboardWord9, keyIndex9,9);
            }
        });
        deleteChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typingString = removeLastChar(typingString);
                nameEt.setText(typingString);
            }
        });
    }

//    Private function to append text to EditText
    private void typeInWord(final String[] alphabetArray, final int index, int key) {
//        If lastKey is same as currentKey ie Same button is clicked so remove last char and append
//        new char from the same array otherwise append char without removing last char
        if (lastKey == key) {
            typingString = removeLastChar(typingString);
            int tempKey = index%alphabetArray.length;
            typingString = typingString + alphabetArray[tempKey];
            nameEt.setText(typingString);
        } else {
            initializeVariables();
            int tempKey = index%alphabetArray.length;
            typingString = typingString + alphabetArray[tempKey];
            nameEt.setText(typingString);
        }
//          initialization of Countdown
        mCountDownTimer =  new CountDownTimer(1000, 100) {

            public void onTick(long millisUntilFinished) {
                Log.i("seconds remaining: " + millisUntilFinished / 1000,"time");
            }

            public void onFinish() {
                int key = index%alphabetArray.length;
                Log.i("" + key,"finalIndex");
                initializeVariables();
                lastKey = 0;
                Log.i("done!","" + alphabetArray[key]);
            }
        };
//        Starting timer to decide which char has to add from the button
        mCountDownTimer.start();
        lastKey = key;
    }
//    Function to remove last char from the given string
    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
//    reinitialization of variables in case of other button pressed or timer Finish
    private void initializeVariables() {
        keyIndex1 = 0 ;
        keyIndex2 = 0;
        keyIndex3 = 0;
        keyIndex4 = 0;
        keyIndex5 = 0;
        keyIndex6 = 0;
        keyIndex7 = 0;
        keyIndex8 = 0;
        keyIndex9 = 0;
    }
}
