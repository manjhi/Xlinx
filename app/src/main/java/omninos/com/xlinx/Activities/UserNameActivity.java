package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class UserNameActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout NextLayout;
    private TextView bar_name;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_user_name);

        intIds();
        performActions();
    }

    private void intIds() {
        NextLayout = findViewById(R.id.NextLayout);
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
    }

    private void performActions() {
        NextLayout.setOnClickListener(this);
        back.setOnClickListener(this);
        bar_name.setText("Username");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.NextLayout:
                startActivity(new Intent(UserNameActivity.this, HomeActivity.class));
                finishAffinity();
                break;

            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
