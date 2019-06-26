package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private TextView ChangeNumber, ChangePassword, RequestAccInfo, DeleteAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_account);

        intIds();
        performActions();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        ChangeNumber = findViewById(R.id.ChangeNumber);
        ChangePassword = findViewById(R.id.ChangePassword);
        RequestAccInfo = findViewById(R.id.RequestAccInfo);
        DeleteAcc = findViewById(R.id.DeleteAcc);
    }

    private void performActions(){
        bar_name.setText("Account");
        back.setOnClickListener(this);
        ChangeNumber.setOnClickListener(this);
        ChangePassword.setOnClickListener(this);
        RequestAccInfo.setOnClickListener(this);
        DeleteAcc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.ChangeNumber:
                startActivity(new Intent(AccountActivity.this, ChangeNumberActivity.class));
                break;

            case R.id.ChangePassword:
                startActivity(new Intent(AccountActivity.this, ChangePasswordActivity.class));
                break;

            case R.id.RequestAccInfo:
                startActivity(new Intent(AccountActivity.this, RequestAccountInfo.class));
                break;

            case R.id.DeleteAcc:
                startActivity(new Intent(AccountActivity.this, DeleteMyAccount.class));
                break;
        }
    }
}
