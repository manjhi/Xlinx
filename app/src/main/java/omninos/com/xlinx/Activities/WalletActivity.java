package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class WalletActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private TextView bar_name;
    private LinearLayout transfer, TopUp, scanQR, generateQR, CashOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_wallet);

        intIds();
        performActions();
    }

    private void intIds(){
        back = findViewById(R.id.back);
        bar_name = findViewById(R.id.bar_name);
        transfer = findViewById(R.id.transfer);
        TopUp = findViewById(R.id.TopUp);
        scanQR = findViewById(R.id.scanQR);
        generateQR = findViewById(R.id.generateQR);
        CashOut = findViewById(R.id.CashOut);
    }

    private void performActions(){
        back.setOnClickListener(this);
        transfer.setOnClickListener(this);
        TopUp.setOnClickListener(this);
        scanQR.setOnClickListener(this);
        generateQR.setOnClickListener(this);
        CashOut.setOnClickListener(this);
        bar_name.setText("Wallet");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.transfer:
                startActivity(new Intent(WalletActivity.this, WalletTransferActivity.class));
                break;

            case R.id.TopUp:
//                startActivity(new Intent(WalletActivity.this, WalletTransferActivity.class));
                break;

            case R.id.scanQR:
                startActivity(new Intent(WalletActivity.this, ScanQRActivity.class));
                break;

            case R.id.generateQR:
                startActivity(new Intent(WalletActivity.this, GenerateQRActivity.class));
                break;

            case R.id.CashOut:
//                startActivity(new Intent(WalletActivity.this, WalletTransferActivity.class));
                break;

        }
    }
}
