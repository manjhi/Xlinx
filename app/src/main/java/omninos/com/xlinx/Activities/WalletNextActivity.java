package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class WalletNextActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private Button send;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_wallet_next);

        intIds();
        performActions();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        send = findViewById(R.id.send);
        back = findViewById(R.id.back);
    }

    private void performActions(){
        bar_name.setText("Transfer");
        send.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send:
//                startActivity(new Intent(WalletNextActivity.this, ScanQRActivity.class));
                break;

            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
