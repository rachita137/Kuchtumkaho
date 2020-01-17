package tatastrive.application.kuchtumkaho;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final int req_code_speech_code = 100;
    TextView t1, t2;

    @Override
    //ctrl+o
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if(requestCode==req_code_speech_code)
        {
            if (resultCode==RESULT_OK && null!=data)
            {
                ArrayList<String>result=data.getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS );
                t1.setText(result.get( 0));

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        t1 = findViewById( R.id.Voiceinput );
        t2 = findViewById( R.id.btnspeak );
        t2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rachita = new Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH );
                rachita.putExtra( RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM );
                rachita.putExtra( RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault() );
                rachita.putExtra( RecognizerIntent.EXTRA_PROMPT, "hi sundari" );
                startActivityForResult( rachita, req_code_speech_code );

            }
        } );


    }
}
