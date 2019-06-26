package omninos.com.xlinx.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class FlightFilterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private Button pricebtn1,pricebtn2,pricebtn3,pricebtn4,stopbtn1,stopbtn2,stopbtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_flight_filter);

        intIds();
        performActions();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        pricebtn1=findViewById(R.id.pricebtn1);
        pricebtn2=findViewById(R.id.pricebtn2);
        pricebtn3=findViewById(R.id.pricebtn3);
        pricebtn4=findViewById(R.id.pricebtn4);
        stopbtn1=findViewById(R.id.stopbtn1);
        stopbtn2=findViewById(R.id.stopbtn2);
        stopbtn3=findViewById(R.id.stopbtn3);
    }

    private void performActions(){
        bar_name.setText("Filter");
        back.setOnClickListener(this);
        pricebtn1.setOnClickListener(this);
        pricebtn2.setOnClickListener(this);
        pricebtn3.setOnClickListener(this);
        pricebtn4.setOnClickListener(this);
        stopbtn1.setOnClickListener(this);
        stopbtn2.setOnClickListener(this);
        stopbtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.pricebtn1:
                pricebtn1.setBackgroundResource(R.drawable.background_blue_button);
                pricebtn1.setTextColor(Color.parseColor("#ffffff"));
                pricebtn2.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn2.setTextColor(Color.parseColor("#000000"));
                pricebtn3.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn3.setTextColor(Color.parseColor("#000000"));
                pricebtn4.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn4.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.pricebtn2:
                pricebtn2.setBackgroundResource(R.drawable.background_blue_button);
                pricebtn2.setTextColor(Color.parseColor("#ffffff"));
                pricebtn1.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn1.setTextColor(Color.parseColor("#000000"));
                pricebtn3.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn3.setTextColor(Color.parseColor("#000000"));
                pricebtn4.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn4.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.pricebtn3:
                pricebtn3.setBackgroundResource(R.drawable.background_blue_button);
                pricebtn3.setTextColor(Color.parseColor("#ffffff"));
                pricebtn1.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn1.setTextColor(Color.parseColor("#000000"));
                pricebtn2.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn2.setTextColor(Color.parseColor("#000000"));
                pricebtn4.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn4.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.pricebtn4:
                pricebtn4.setBackgroundResource(R.drawable.background_blue_button);
                pricebtn4.setTextColor(Color.parseColor("#ffffff"));
                pricebtn1.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn1.setTextColor(Color.parseColor("#000000"));
                pricebtn2.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn2.setTextColor(Color.parseColor("#000000"));
                pricebtn3.setBackgroundResource(R.drawable.background_edit_text);
                pricebtn3.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.stopbtn1:
                stopbtn1.setBackgroundResource(R.drawable.background_blue_button);
                stopbtn1.setTextColor(Color.parseColor("#ffffff"));
                stopbtn2.setBackgroundResource(R.drawable.background_edit_text);
                stopbtn2.setTextColor(Color.parseColor("#000000"));
                stopbtn3.setBackgroundResource(R.drawable.background_edit_text);
                stopbtn3.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.stopbtn2:
                stopbtn2.setBackgroundResource(R.drawable.background_blue_button);
                stopbtn2.setTextColor(Color.parseColor("#ffffff"));
                stopbtn1.setBackgroundResource(R.drawable.background_edit_text);
                stopbtn1.setTextColor(Color.parseColor("#000000"));
                stopbtn3.setBackgroundResource(R.drawable.background_edit_text);
                stopbtn3.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.stopbtn3:
                stopbtn3.setBackgroundResource(R.drawable.background_blue_button);
                stopbtn3.setTextColor(Color.parseColor("#ffffff"));
                stopbtn1.setBackgroundResource(R.drawable.background_edit_text);
                stopbtn1.setTextColor(Color.parseColor("#000000"));
                stopbtn2.setBackgroundResource(R.drawable.background_edit_text);
                stopbtn2.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }
}
