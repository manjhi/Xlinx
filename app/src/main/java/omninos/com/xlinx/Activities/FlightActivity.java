package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class FlightActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private Button searchflights, roundtripbtn,onewaybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_flight);

        intIds();
        performActions();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        searchflights = findViewById(R.id.searchflights);
        roundtripbtn=findViewById(R.id.roundtrip);
        onewaybtn=findViewById(R.id.oneway);
    }

    private void performActions(){
        bar_name.setText("Flight");
        back.setOnClickListener(this);
        searchflights.setOnClickListener(this);
        roundtripbtn.setOnClickListener(this);
        onewaybtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.searchflights:
                startActivity(new Intent(FlightActivity.this, FlightNextActivity.class));
                break;

            case R.id.roundtrip:
                roundtripbtn.setBackgroundResource(R.drawable.background_blue_button);
                roundtripbtn.setTextColor(Color.parseColor("#ffffff"));
                onewaybtn.setBackgroundResource(R.drawable.shape);
                onewaybtn.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.oneway:
                onewaybtn.setBackgroundResource(R.drawable.background_blue_button);
                onewaybtn.setTextColor(Color.parseColor("#ffffff"));
                roundtripbtn.setBackgroundResource(R.drawable.shape);
                roundtripbtn.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }
}
