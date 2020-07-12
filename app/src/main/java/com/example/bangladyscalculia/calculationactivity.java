package com.example.bangladyscalculia;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class calculationactivity extends AppCompatActivity {

    TextToSpeech mTTS;
    ImageButton home, info, cancel,speakerbtn;
    ImageView mic;
    TextView resulttxt,inputtxt;
    int num,num1,num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculationactivity);
        home = (ImageButton) findViewById(R.id.homebtn);
        info = (ImageButton) findViewById(R.id.infobtn);
        cancel = (ImageButton) findViewById(R.id.cancelbtn);
        mic = (ImageView) findViewById(R.id.microphone);
        inputtxt = (TextView) findViewById(R.id.inpuyTxt);
        resulttxt = (TextView) findViewById(R.id.resultTxt);
        speakerbtn = (ImageButton) findViewById(R.id.speackerBtn);
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
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSpeech();

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
                        speakerbtn.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        speakerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }
    private void speak() {


        String text = resulttxt.getText().toString().trim();
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

        Intent intent5 = new Intent(calculationactivity.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity(){

        Intent intent=new Intent(calculationactivity.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram(){

        finish();
        moveTaskToBack(true);
    }

    void getSpeech(){


        String mom=null;
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    inputtxt.setText(result.get(0));
                }
                break;
        }

        String s = inputtxt.getText().toString().trim();
        Pattern p = Pattern.compile("-?\\d+(,\\d+)*?\\.?\\d+?");
        List<String> numbers = new ArrayList<String>();
        Matcher m = p.matcher(s);
        while (m.find()) {
            numbers.add(m.group());
        }

        if(s.contains("কোসাইন")|| s.contains("কোসাইন্")){

            String con=numbers.get(0);
            num=Integer.parseInt(con);
            Double i= new Double(num);
            i=Math.toRadians(i);
            double x=Math.cos(i);
            String z=new DecimalFormat("##.###").format(x);
            // c=Integer.toString(count);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }

        else if(s.contains("সাইন") || s.contains("সাইন্")){

            String con=numbers.get(0);
            num=Integer.parseInt(con);
            Double i= new Double(num);
            i=Math.toRadians(i);
            double x=Math.sin(i);
            String z=new DecimalFormat("##.###").format(x);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            resulttxt.setText(replacedOne);
            //resultText2.setText(z);
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }

        else if(s.contains("ট্যাঞ্জেন্ট")){

            String con=numbers.get(0);
            num=Integer.parseInt(con);
            Double i= new Double(num);
            i=Math.toRadians(i);
            double x=Math.tan(i);
            String z=new DecimalFormat("##.###").format(x);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //resultText2.setText(z);
            //  Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }


        else if( s.contains("প্রস্থ") && s.contains("দৈর্ঘ্য") && s.contains("ক্ষেত্রফল")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1*num2;
            String z=Integer.toString(num);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //resultText2.setText(""+num);
            // Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if((s.contains("মোট"))){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1+num2;
            String z=Integer.toString(num);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            // resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }


        else if(s.contains("ফেরত")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1-num2;
            String z=Integer.toString(num);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),Math.abs(num)+"",Toast.LENGTH_LONG).show();
        }


        else if(s.contains("গুণ")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1*num2;
            String z=Integer.toString(num);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if(s.contains("যোগ")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1+num2;
            String z=Integer.toString(num);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if(s.contains("বিয়োগ")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1-num2;
            String z=Integer.toString(num);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if(s.contains("ভাগ")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            if(num2==0){
                resulttxt.setText("Can't Divide by Zero");
                //Toast.makeText(getApplicationContext(),"Can't divide by zero",Toast.LENGTH_LONG).show();
            }
            else{
                num=num1/num2;
                String z=Integer.toString(num);
                String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
                //counttxt.setText(replacedOne);
                resulttxt.setText(replacedOne);
                // resultText2.setText(""+num);
                //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
            }

        }

        else if(s.contains("ডিসকাউন্ট")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            Double i1=new Double(num1);
            Double i2=new Double(num2);
            Double x=i1-(i1*i2/100);
            String z=new DecimalFormat("##.###").format(x);
            // String z=Integer.toString(num);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //resultText2.setText(z);
            // Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }

        else if(s.contains("ভ্যাট")){
            //  Toast.makeText(getApplicationContext(),"Inside vat",Toast.LENGTH_LONG).show();
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            Double i1=new Double(num1);
            Double i2=new Double(num2);
            Double x=i1+(i1*(i2/100));
            String z=new DecimalFormat("##.###").format(x);
            //String z=Integer.toString(num);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //resultText2.setText(z);
            // Toast.makeText(getApplicationContext(),con1+" "+con2,Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();


        }

        else{
            String z=numbers.get(0);
            String replacedOne = z.replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");
            //counttxt.setText(replacedOne);
            resulttxt.setText(replacedOne);
            //resultText2.setText(numbers.get(0));
        }
    }
}
