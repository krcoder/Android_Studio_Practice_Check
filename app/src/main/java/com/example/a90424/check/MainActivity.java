package com.example.a90424.check;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText)findViewById(R.id.editText);
        EditText editText2 = (EditText)findViewById(R.id.editText2);

        findViewById(R.id.button).setOnClickListener(mClickListener);
        findViewById(R.id.button2).setOnClickListener(mClickListener);
        findViewById(R.id.button3).setOnClickListener(mClickListener);


    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            int a1[] = new int[6];
            int b1[] = new int[7];
            String sen="";
            String sen2="";
            int cnt=0;
            int cnt2=0;

            TextView text = (TextView)findViewById(R.id.textView2);
            TextView text3 = (TextView)findViewById(R.id.textView3);
            EditText editText = (EditText)findViewById(R.id.editText);
            EditText editText2 = (EditText)findViewById(R.id.editText2);

            switch (v.getId()) {

                case R.id.button:

                    String text1 = editText.getText().toString();
                    String text2 = editText2.getText().toString();

                    for(int i=0;i<6;i++){
                        String cut = text1.substring(i,(i+1));
                        a1[i] = Integer.parseInt(cut);
                    }

                    for(int i=0;i<7;i++){
                        String cut=text2.substring(i,(i+1));
                        b1[i] = Integer.parseInt(cut);
                    }

                    cnt = (a1[0]*2) + (a1[1]*3) + (a1[2]*4) + (a1[3]*5) + (a1[4]*6) + (a1[5]*7) +
                            (b1[0]*8) + (b1[1]*9) + (b1[2]*2) + (b1[3]*3) + (b1[4]*4) + (b1[5]*5);

                    cnt2 = cnt%11;

                    cnt = 11-cnt2;

                    if(cnt==10){
                        cnt2=0;
                    }
                    else if(cnt==11){
                        cnt2=1;
                    }
                    else{
                        cnt2=cnt;
                    }


                    if(b1[6] == cnt2){
                        text3.setText("Rignt Number! Good!!");
                    }
                    else if(b1[6] != cnt2){
                        text3.setText("Wrong Number! Bad...");
                    }

                    for(int i=0;i<6;i++){
                        sen += a1[i];
                    }
                    for(int i=0;i<6;i++){
                        sen += b1[i];
                    }




                    text.setText(sen + " 의 계산값 = " + cnt2);

                    break;

                case R.id.button2:
                    text.setText("Ready to check");
                    text3.setText("");

                    break;

                case R.id.button3:

                    //onDestroy();
                    break;


            }

        }
    };

}
