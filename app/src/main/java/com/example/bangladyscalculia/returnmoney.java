package com.example.bangladyscalculia;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class returnmoney extends AppCompatActivity {

    ImageButton home, info, cancel;
    TextView returncounttxt2,returntxt2;
    String c;
    Button returnokbtn,checkbtn;
    ImageButton returntk2,returntk5,returntk10,returntk20,returntk50,returntk100,returntk500,returntk1000,returnonetkcoin,returntwotkcoin,returnfivetkcoin;
    int returncount=0,num=0,diff=0;
    ImageButton speackerretuncounttxt2Btn,speackerreturntxt2Btn;

    TextToSpeech mTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returnmoney);

        home=(ImageButton) findViewById(R.id.homebtn);
        info=(ImageButton) findViewById(R.id.infobtn);
        cancel=(ImageButton) findViewById(R.id.cancelbtn);

        returncounttxt2= (TextView) findViewById(R.id.returncounttxt2);
        returntxt2=(TextView)findViewById(R.id.returntxt2);
        returnokbtn=(Button) findViewById(R.id.returnokbtn);
        returntk2=(ImageButton) findViewById(R.id.returntk2);
        returntk5=(ImageButton) findViewById(R.id.returntk5);
        returntk10=(ImageButton) findViewById(R.id.returntk10);
        returntk20=(ImageButton) findViewById(R.id.returntk20);
        returntk50=(ImageButton) findViewById(R.id.returntk50);
        returntk100=(ImageButton) findViewById(R.id.returntk100);
        returntk500=(ImageButton) findViewById(R.id.returntk500);
        returntk1000=(ImageButton) findViewById(R.id.returntk1000);
        returnonetkcoin=(ImageButton) findViewById(R.id.returnonetkcoin);
        returntwotkcoin=(ImageButton) findViewById(R.id.returntwotkcoin);
        returnfivetkcoin=(ImageButton) findViewById(R.id.returnfivetkcoin);
        speackerretuncounttxt2Btn=(ImageButton) findViewById(R.id.speackerretuncounttxt2Btn);
        speackerreturntxt2Btn=(ImageButton) findViewById(R.id.speackerreturntxt2Btn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gohomeActivity();

            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goinfoActivity();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelprogram();

            }
        });

        checkbtn=(Button) findViewById(R.id.checkokbtn);

        final String s=getIntent().getStringExtra("giventk");
        //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();


        returnonetkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+1;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
              //  returncounttxt2.setText(""+returncount);
            }
        });


        returntwotkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+2;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
              //  returncounttxt2.setText(""+returncount);
            }
        });


        returnfivetkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+5;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
                //returncounttxt2.setText(""+returncount);
            }
        });



        returntk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+2;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
                //returncounttxt2.setText(""+returncount);
            }
        });

        returntk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+5;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
                //returncounttxt2.setText(""+returncount);
            }
        });

        returntk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+10;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
                //returncounttxt2.setText(""+returncount);
            }
        });

        returntk20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+20;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
               // returncounttxt2.setText(""+returncount);
            }
        });

        returntk50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+50;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
                //returncounttxt2.setText(""+returncount);
            }
        });

        returntk100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+100;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
                //returncounttxt2.setText(""+returncount);
            }
        });

        returntk500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+500;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
                //returncounttxt2.setText(""+returncount);
            }
        });

        returntk1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returncount= returncount+1000;
                c=Integer.toString(returncount);
                String replacedOne = c.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                returncounttxt2.setText(replacedOne);
               // returncounttxt2.setText(""+returncount);
            }
        });


        returnokbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num=Integer.parseInt(s);
                //Toast.makeText(getApplicationContext(),"Num: "+num+" returncount: "+returncount, Toast.LENGTH_LONG).show();
                diff=num-returncount;
                String nop=Integer.toString(diff);
                Toast.makeText(getApplicationContext(),"Num: "+num+" returncount: "+returncount+" Diff: "+diff, Toast.LENGTH_LONG).show();
                String replacedOne = nop.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                //returncounttxt2.setText(replacedOne);
                returntxt2.setText(replacedOne);
            }
        });

        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),diff+"",Toast.LENGTH_LONG).show();
                Intent i= new Intent(returnmoney.this,rrmoney.class);
                String str=Integer.toString(diff);
                i.putExtra("difftk",str);
                startActivity(i);
            }
        });


        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.getDefault());

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        speackerretuncounttxt2Btn.setEnabled(true);
                        speackerreturntxt2Btn.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        speackerretuncounttxt2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak1();
            }
        });
        speackerreturntxt2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak2();
            }
        });

    }


    private void speak1() {


        String text = returncounttxt2.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    private void speak2() {


        String text = returntxt2.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }





    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }

    void gohomeActivity(){

        Intent intent5 = new Intent(returnmoney.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity(){

        Intent intent=new Intent(returnmoney.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram(){

        finish();
        moveTaskToBack(true);
    }

}
