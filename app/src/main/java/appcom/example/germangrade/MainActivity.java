package appcom.example.germangrade;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputType;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float ValueOne, ValueTwo, ValueThree,ValueFour,ValueFive;
    //String[] No1 = new String[]{"0"};
    //String[] No2 = new String[]{"0"};

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar = findViewById(R.id.toolbar);
        final EditText edt = (EditText)findViewById(R.id.editTextNumber);
        final EditText editText2 = (EditText)findViewById(R.id.editTextNumber2);
        final EditText editText3 = findViewById(R.id.editTextNumber3);
        final Button button=findViewById(R.id.button);
        //editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
        //editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
        //setSupportActionBar(toolbar);

        //ValueOne = Float.parseFloat(editText1.getText().toString());
        //ValueTwo = Float.parseFloat(editText2.getText().toString());
         final String No1 = edt.getText().toString();
          final String No2 = editText2.getText().toString();
         ValueOne= Float.parseFloat(No1.trim().isEmpty()?"0":No1);
         ValueTwo= Float.parseFloat(No2.trim().isEmpty()?"0":No1);
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               edt.setTextColor(0xFF06E858 );
            }
        });
        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText2.setTextColor(0xFF06E858 );
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(No1.equals(null))
                    Toast.makeText(getApplicationContext(),"You have not entered Number Obtained",Toast.LENGTH_SHORT).show();
                else if(ValueTwo==0)
                    Toast.makeText(getApplicationContext(),"You did not entered min Pass Number",Toast.LENGTH_SHORT).show();
                else if(ValueOne>100 || ValueOne<0)
                    Toast.makeText(getApplicationContext(),"Please Enter Your Number within 0 and 100 ",Toast.LENGTH_LONG).show();
                else if(ValueTwo>100 || ValueTwo<0)
                    Toast.makeText(getApplicationContext(),"Please Enter Your Number within 0 and 100 ",Toast.LENGTH_LONG).show();
                else if(ValueOne<100 || ValueOne>0 && ValueTwo<100 || ValueTwo>0)
                    button.setBackgroundColor(0xFF7B241C);
                ValueThree = (float)(100 - ValueOne);
                ValueFour = (float)(100 - ValueTwo);
                ValueFive = ((float)ValueThree) / ValueFour * 3;
                editText3.setText(No2 +1 );

            }

            });
        }

   /*public void GermanGradeFormula() {
        final EditText editText3 = findViewById(R.id.editTextNumber3);
        ValueThree = (float)(100 - ValueOne);
        ValueFour = (float)(100 - ValueTwo);
        ValueFive = ((float)ValueThree) / ValueFour * 3;
        editText3.setText(ValueOne +1 + "");*/


    };



