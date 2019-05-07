package sg.edu.rp.c346.p03ps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton svc;
    ToggleButton gst;
    Button split;
    Button reset;

    EditText ttamt;
    EditText ttpax;

    TextView ttbill;
    TextView eachpay;

    double Totalbill =0.0;
    int Totalpax =0;
    double each = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ttamt = findViewById(R.id.editTextAmt);
        ttpax = findViewById(R.id.editTextPax);

        ttbill = findViewById(R.id.textViewttbill);
        eachpay = findViewById(R.id.textVieweach);

        svc = findViewById(R.id.toggleButtonsvc);
        gst = findViewById(R.id.toggleButtongst);
        split = findViewById(R.id.buttonsplit);
        reset = findViewById(R.id.buttonreset);


        Totalbill = Double.parseDouble(ttamt.getText().toString());
        Totalpax = Integer.parseInt(ttpax.getText().toString());

        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code for the action

                 if (svc.isChecked()&&gst.isChecked()){
                     Totalbill = Totalbill*1.17;
                 }
                 else if(svc.isChecked()){
                     Totalbill = Totalbill*1.1;
                 }else if(gst.isChecked()){
                     Totalbill = Totalbill*1.07;
                 }else{
                     Totalbill=Totalbill*1;
                 }
                 each = Totalbill/ Totalpax;

                 ttbill.setText(String.format("%.2f",Totalbill));
                 eachpay.setText(String.format("%.2f", each));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View){
                svc.setChecked(false);
                gst.setChecked(false);
                ttpax.setText("");
                ttamt.setText("");
                ttbill.setText("");
                eachpay.setText("");
            }
        });
    }
}
