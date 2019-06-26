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

public class MetroActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private Button SearchTrains, bookTickets, checkPNR, trainStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_metro);

        intIds();
        performActions();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        SearchTrains = findViewById(R.id.SearchTrains);
        bookTickets = findViewById(R.id.bookTickets);
        checkPNR = findViewById(R.id.checkPNR);
        trainStatus = findViewById(R.id.trainStatus);
    }

    private void performActions(){
        bar_name.setText("Metro");
        back.setOnClickListener(this);
        SearchTrains.setOnClickListener(this);
        bookTickets.setOnClickListener(this);
        checkPNR.setOnClickListener(this);
        trainStatus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.SearchTrains:
                startActivity(new Intent(MetroActivity.this, SearchTrainsActivity.class));
                break;

            case R.id.bookTickets:
                bookTickets.setBackgroundResource(R.drawable.background_blue_button);
                bookTickets.setTextColor(Color.WHITE);
                checkPNR.setBackgroundResource(R.drawable.background_white_button);
                checkPNR.setTextColor(Color.BLACK);
                trainStatus.setBackgroundResource(R.drawable.background_white_button);
                trainStatus.setTextColor(Color.BLACK);
                break;

            case R.id.checkPNR:
                checkPNR.setBackgroundResource(R.drawable.background_blue_button);
                checkPNR.setTextColor(Color.WHITE);
                bookTickets.setBackgroundResource(R.drawable.background_white_button);
                bookTickets.setTextColor(Color.BLACK);
                trainStatus.setBackgroundResource(R.drawable.background_white_button);
                trainStatus.setTextColor(Color.BLACK);
                break;

            case R.id.trainStatus:
                trainStatus.setBackgroundResource(R.drawable.background_blue_button);
                trainStatus.setTextColor(Color.WHITE);
                bookTickets.setBackgroundResource(R.drawable.background_white_button);
                bookTickets.setTextColor(Color.BLACK);
                checkPNR.setBackgroundResource(R.drawable.background_white_button);
                checkPNR.setTextColor(Color.BLACK);
                break;
        }
    }
}
