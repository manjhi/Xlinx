package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import omninos.com.xlinx.R;
import omninos.com.xlinx.Utils.App;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView bar_name, logoutTextView, appLanguageTextView;
    private ImageView back;
    private RelativeLayout Account, Privacy, Stickers, Notifications, Chat, AppTheme, AppLanguage, security, Logout;
    private View view;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_settings);

        intIds();
        performActions();

        view = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.select_app_language, null);
        alertDialog = new AlertDialog.Builder(SettingsActivity.this).create();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        Account = findViewById(R.id.Account);
        Privacy = findViewById(R.id.Privacy);
        Stickers = findViewById(R.id.Stickers);
        Notifications = findViewById(R.id.Notification);
        Chat = findViewById(R.id.Chats);
        AppLanguage = findViewById(R.id.AppLanguage);
        AppTheme = findViewById(R.id.AppTheme);
        Logout = findViewById(R.id.Logout);
        security = findViewById(R.id.security);
        logoutTextView = findViewById(R.id.logout_text_view);
        appLanguageTextView = findViewById(R.id.app_language_text_view);
    }

    private void performActions(){
        bar_name.setText("Settings");
        back.setOnClickListener(this);
        Account.setOnClickListener(this);
        Privacy.setOnClickListener(this);
        Stickers.setOnClickListener(this);
        Notifications.setOnClickListener(this);
        AppTheme.setOnClickListener(this);
        AppLanguage.setOnClickListener(this);
        logoutTextView.setOnClickListener(this);
        Logout.setOnClickListener(this);
        appLanguageTextView.setOnClickListener(this);
        security.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.Account:
                startActivity(new Intent(SettingsActivity.this, AccountActivity.class));
                break;

            case R.id.Privacy:
                startActivity(new Intent(SettingsActivity.this, PrivacyActivity.class));
                break;

            case R.id.Stickers:
                startActivity(new Intent(SettingsActivity.this, StickersActivity.class));
                break;

            case R.id.Notification:
                startActivity(new Intent(SettingsActivity.this, NotificationsActivity.class));
                break;

            case R.id.AppTheme:
                startActivity(new Intent(SettingsActivity.this, AppThemeActivity.class));
                break;

            case R.id.Logout:
                Intent loginIntent = new Intent(SettingsActivity.this, MobileNumberActivity.class);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(loginIntent);
                finishAffinity();
                break;

            case R.id.AppLanguage:
                alertDialog.setView(view);
                alertDialog.show();
                break;
        }
    }
}
