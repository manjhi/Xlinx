package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class MobileNumberActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout NextLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_mobile_number);
        intIds();
        performActions();
    }

    private void intIds(){
        NextLayout = findViewById(R.id.NextLayout);
    }

    private void performActions(){
        NextLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.NextLayout:
                startActivity(new Intent(MobileNumberActivity.this, VerificationActivity.class));
                break;
        }
    }
}
