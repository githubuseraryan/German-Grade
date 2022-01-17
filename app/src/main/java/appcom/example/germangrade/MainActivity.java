package appcom.example.germangrade;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float ValueOne, ValueTwo, ValueThree,ValueFour,ValueFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar = findViewById(R.id.toolbar);
        final EditText editText1 = findViewById(R.id.editTextNumber);
        final EditText editText2 = findViewById(R.id.editTextNumber2);
        final EditText editText3 = findViewById(R.id.editTextNumber3);
        final Button button=findViewById(R.id.button);
        //setSupportActionBar(toolbar);

        ValueOne = Float.parseFloat(editText1.getText() + "");
        ValueTwo = Float.parseFloat(editText2.getText() + "");
         final String No1 = editText1.getText().toString();
         final String No2 = editText1.getText().toString();
        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               editText1.setTextColor(0xFF06E858 );
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
                if(No1.isEmpty())
                    Toast.makeText(getApplicationContext(),"You have not entered Number Obtained",Toast.LENGTH_SHORT).show();
                else if(No2.isEmpty())
                    Toast.makeText(getApplicationContext(),"You did not entered min Pass Number",Toast.LENGTH_SHORT).show();
                else if(ValueOne>100 || ValueOne<0)
                    Toast.makeText(getApplicationContext(),"Please Enter Your Number within 0 and 100 ",Toast.LENGTH_LONG).show();
                else if(ValueTwo>100 || ValueTwo<0)
                    Toast.makeText(getApplicationContext(),"Please Enter Your Number within 0 and 100 ",Toast.LENGTH_LONG).show();
                else if(ValueOne<100 || ValueOne>0 && ValueTwo<100 || ValueTwo>0)
                    button.setBackgroundColor(0xFF7B241C);
                    GermanGradeFormula();

            }

            });
        }

    private void GermanGradeFormula() {
        final EditText editText3 = findViewById(R.id.editTextNumber3);
        ValueThree = 100 - ValueOne;
        ValueFour = 100 - ValueTwo;
        ValueFive = (ValueThree / ValueFour) * 3;
        editText3.setText(ValueFive + 1 + "");


    };



}