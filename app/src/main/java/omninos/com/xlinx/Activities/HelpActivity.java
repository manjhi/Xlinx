package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView FAQ, ContactUs, TermsAndConditions, PrivacyPolicy, AppInfo, bar_name;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_help);

        intIds();
        performActions();
    }

    private void intIds(){
        FAQ = findViewById(R.id.FAQ);
        ContactUs = findViewById(R.id.ContactUs);
        TermsAndConditions = findViewById(R.id.TermsAndConditions);
        PrivacyPolicy = findViewById(R.id.PrivacyPolicy);
        AppInfo = findViewById(R.id.AppInfo);
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
    }

    private void performActions(){
        FAQ.setOnClickListener(this);
        ContactUs.setOnClickListener(this);
        TermsAndConditions.setOnClickListener(this);
        PrivacyPolicy.setOnClickListener(this);
        AppInfo.setOnClickListener(this);
        back.setOnClickListener(this);
        bar_name.setText("Help");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ContactUs:
                startActivity(new Intent(HelpActivity.this, ContactUsActivity.class));
                break;

            case R.id.TermsAndConditions:
                startActivity(new Intent(HelpActivity.this, TermsAndConditionsActivity.class));
                break;

            case R.id.PrivacyPolicy:
                startActivity(new Intent(HelpActivity.this, PrivacyPolicyActivity.class));
                break;

            case R.id.AppInfo:
                startActivity(new Intent(HelpActivity.this, AppInfoActivity.class));
                break;

            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
