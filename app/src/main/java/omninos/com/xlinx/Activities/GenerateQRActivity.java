package omninos.com.xlinx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class GenerateQRActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private Button GenerateQR;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_generate_qr);

        intIds();
        performActions();
    }

    private void intIds() {
        GenerateQR = findViewById(R.id.GenerateQR);
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
    }

    private void performActions() {
        bar_name.setText("Transfer");
        GenerateQR.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
