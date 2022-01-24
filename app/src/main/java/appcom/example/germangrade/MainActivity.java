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
    float ValueOne, ValueTwo, ValueThree,ValueFour,ValueFive, TotalValue;

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edt = (EditText)findViewById(R.id.editTextNumberDecimal);
        final EditText editText2 = (EditText)findViewById(R.id.editTextNumber2);
        final EditText editText3 = findViewById(R.id.editTextNumber3);
        final EditText editText4 = findViewById(R.id.editTextNumberDecimal2);
        final Button button=findViewById(R.id.button);
        


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
                try{ ValueOne = Float.parseFloat(edt.getText().toString());
                     ValueTwo = Float.parseFloat(editText2.getText().toString());
                     TotalValue= Float.parseFloat(editText4.getText().toString());

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid characters detected", Toast.LENGTH_SHORT).show();
                }

                if(ValueOne==0.f)
                    Toast.makeText(getApplicationContext(),"You have not entered Number Obtained",Toast.LENGTH_SHORT).show();
                else if(ValueTwo==0.f)
                    Toast.makeText(getApplicationContext(),"You did not entered min Pass Number",Toast.LENGTH_SHORT).show();
                else if(TotalValue==0.f)
                    Toast.makeText(getApplicationContext(),"You did not entered Total value of Exam",Toast.LENGTH_SHORT).show();
                else if(ValueOne>TotalValue)
                    Toast.makeText(getApplicationContext(),"Marks Obtained cannot be grater then Full marks ",Toast.LENGTH_LONG).show();
                else if(ValueTwo>TotalValue)
                    Toast.makeText(getApplicationContext(),"Pass marks cannot be grater then Full marks ",Toast.LENGTH_LONG).show();
                else if(ValueOne<TotalValue && ValueTwo<TotalValue)

                ValueThree = (float)(TotalValue - ValueOne);
                ValueFour = (float)(TotalValue - ValueTwo);
                ValueFive = ((float)ValueThree) / ValueFour * 3;
                editText3.setText (Float.toString (ValueFive+1));

            }

            });
        }




    };



