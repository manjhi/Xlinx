package omninos.com.xlinx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class SecurityActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private TextView bar_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_security);

        intIds();
        performActions();
    }

    private void intIds(){
        back = findViewById(R.id.back);
        bar_name = findViewById(R.id.bar_name);
    }

    private void performActions(){
        back.setOnClickListener(this);
        bar_name.setText("Security");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
