package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;
import omninos.com.xlinx.Utils.App;

public class CabActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private EditText src, des;
    private String pick, drop;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_cab);

        intIds();
        performActions();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        src = findViewById(R.id.src);
        des = findViewById(R.id.des);
        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
    }

    private void performActions(){
        bar_name.setText("Cab");
        back.setOnClickListener(this);
        pick = src.getText().toString();
        App.getSinltonPojo().setPickUp(pick);
        drop = des.getText().toString();
        App.getSinltonPojo().setDropOff(drop);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.search:
                startActivity(new Intent(CabActivity.this, CabNextActivity.class));
                break;
        }
    }
}
