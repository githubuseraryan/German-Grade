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

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edt = (EditText)findViewById(R.id.editTextNumberDecimal);
        final EditText editText2 = (EditText)findViewById(R.id.editTextNumber2);
        final EditText editText3 = findViewById(R.id.editTextNumber3);
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

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid characters detected", Toast.LENGTH_SHORT).show();
                }

                if(ValueOne==0.f)
                    Toast.makeText(getApplicationContext(),"You have not entered Number Obtained",Toast.LENGTH_SHORT).show();
                else if(ValueTwo==0.f)
                    Toast.makeText(getApplicationContext(),"You did not entered min Pass Number",Toast.LENGTH_SHORT).show();
                else if(ValueOne>100.0 || ValueOne<0.0)
                    Toast.makeText(getApplicationContext(),"Please Enter Your Number within 0 and 100 ",Toast.LENGTH_LONG).show();
                else if(ValueTwo>100.0 || ValueTwo<0.0)
                    Toast.makeText(getApplicationContext(),"Please Enter Your Number within 0 and 100 ",Toast.LENGTH_LONG).show();
                else if(ValueOne<100.0 || ValueOne>0.0 && ValueTwo<100.0 || ValueTwo>0.0)

                ValueThree = (float)(100.0 - ValueOne);
                ValueFour = (float)(100.0 - ValueTwo);
                ValueFive = ((float)ValueThree) / ValueFour * 3;
                editText3.setText (Float.toString (ValueFive+1));

            }

            });
        }




    };



