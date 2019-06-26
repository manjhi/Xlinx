package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class PrivacyActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private LinearLayout blockedContacts;
    private Button proPicFriends, proPicContacts, proPicEveryone, lastSeenFriends, lastSeenContacts, lastSeenNobody, aboutFriends, aboutEveryone, aboutNobody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_privacy);

        intIds();
        performActions();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        proPicFriends = findViewById(R.id.proPicFriends);
        proPicContacts = findViewById(R.id.proPicContacts);
        proPicEveryone = findViewById(R.id.proPicEveryone);
        lastSeenFriends = findViewById(R.id.lastSeenFriends);
        lastSeenContacts = findViewById(R.id.lastSeenContacts);
        lastSeenNobody = findViewById(R.id.lastSeenNobody);
        aboutFriends = findViewById(R.id.aboutFriends);
        aboutEveryone = findViewById(R.id.aboutEveryone);
        aboutNobody = findViewById(R.id.aboutNobody);
        blockedContacts = findViewById(R.id.blockedContacts);
    }

    private void performActions(){
        bar_name.setText("Privacy");
        back.setOnClickListener(this);
        proPicFriends.setOnClickListener(this);
        proPicContacts.setOnClickListener(this);
        proPicEveryone.setOnClickListener(this);
        lastSeenFriends.setOnClickListener(this);
        lastSeenContacts.setOnClickListener(this);
        lastSeenNobody.setOnClickListener(this);
        aboutFriends.setOnClickListener(this);
        aboutEveryone.setOnClickListener(this);
        aboutNobody.setOnClickListener(this);
        blockedContacts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.blockedContacts:
                startActivity(new Intent(PrivacyActivity.this, BlockedContactsActivity.class));
                break;

            case R.id.proPicFriends:
                proPicFriends.setBackgroundResource(R.drawable.bg_btn_blue_round_corners);
                proPicFriends.setTextColor(Color.WHITE);
                proPicContacts.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                proPicContacts.setTextColor(Color.GRAY);
                proPicEveryone.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                proPicEveryone.setTextColor(Color.GRAY);
                break;

            case R.id.proPicContacts:
                proPicContacts.setBackgroundResource(R.drawable.bg_btn_blue_round_corners);
                proPicContacts.setTextColor(Color.WHITE);
                proPicFriends.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                proPicFriends.setTextColor(Color.GRAY);
                proPicEveryone.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                proPicEveryone.setTextColor(Color.GRAY);
                break;

            case R.id.proPicEveryone:
                proPicEveryone.setBackgroundResource(R.drawable.bg_btn_blue_round_corners);
                proPicEveryone.setTextColor(Color.WHITE);
                proPicFriends.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                proPicFriends.setTextColor(Color.GRAY);
                proPicContacts.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                proPicContacts.setTextColor(Color.GRAY);
                break;

            case R.id.lastSeenFriends:
                lastSeenFriends.setBackgroundResource(R.drawable.bg_btn_blue_round_corners);
                lastSeenFriends.setTextColor(Color.WHITE);
                lastSeenContacts.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                lastSeenContacts.setTextColor(Color.GRAY);
                lastSeenNobody.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                lastSeenNobody.setTextColor(Color.GRAY);
                break;

            case R.id.lastSeenContacts:
                lastSeenContacts.setBackgroundResource(R.drawable.bg_btn_blue_round_corners);
                lastSeenContacts.setTextColor(Color.WHITE);
                lastSeenFriends.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                lastSeenFriends.setTextColor(Color.GRAY);
                lastSeenNobody.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                lastSeenNobody.setTextColor(Color.GRAY);
                break;

            case R.id.lastSeenNobody:
                lastSeenNobody.setBackgroundResource(R.drawable.bg_btn_blue_round_corners);
                lastSeenNobody.setTextColor(Color.WHITE);
                lastSeenContacts.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                lastSeenContacts.setTextColor(Color.GRAY);
                lastSeenFriends.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                lastSeenFriends.setTextColor(Color.GRAY);
                break;

            case R.id.aboutFriends:
                aboutFriends.setBackgroundResource(R.drawable.bg_btn_blue_round_corners);
                aboutFriends.setTextColor(Color.WHITE);
                aboutEveryone.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                aboutEveryone.setTextColor(Color.GRAY);
                aboutNobody.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                aboutNobody.setTextColor(Color.GRAY);
                break;

            case R.id.aboutEveryone:
                aboutEveryone.setBackgroundResource(R.drawable.bg_btn_blue_round_corners);
                aboutEveryone.setTextColor(Color.WHITE);
                aboutFriends.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                aboutFriends.setTextColor(Color.GRAY);
                aboutNobody.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                aboutNobody.setTextColor(Color.GRAY);
                break;

            case R.id.aboutNobody:
                aboutNobody.setBackgroundResource(R.drawable.bg_btn_blue_round_corners);
                aboutNobody.setTextColor(Color.WHITE);
                aboutFriends.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                aboutFriends.setTextColor(Color.GRAY);
                aboutEveryone.setBackgroundResource(R.drawable.bg_btn_grey_round_corners);
                aboutEveryone.setTextColor(Color.GRAY);
                break;
        }
    }
}
