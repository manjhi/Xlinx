package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class ScanQRActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private Button scanQR;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_scan_qr);

        intIds();
        performActions();
    }

    private void intIds(){
        scanQR = findViewById(R.id.scanQR);
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
    }

    private void performActions(){
        bar_name.setText("Transfer");
        scanQR.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scanQR:
//                startActivity(new Intent(ScanQRActivity.this, GenerateQRActivity.class));
                break;

            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
