package omninos.com.xlinx.Activities;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import omninos.com.xlinx.Fragments.VideoCallFragment;
import omninos.com.xlinx.Fragments.VoiceCallFragment;
import omninos.com.xlinx.R;

public class CallActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout CallLayout, videoCallLayout;
    private TextView CallTV, videoCallTV;
    private FragmentManager fm;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_call);

        intIds();

        fm= getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.CallFrame, new VoiceCallFragment()).commit();
    }

    private void intIds() {
        CallLayout = findViewById(R.id.CallLayout);
        videoCallLayout = findViewById(R.id.videoCallLayout);
        CallTV = findViewById(R.id.CallTV);
        videoCallTV = findViewById(R.id.videoCallTV);
        back = findViewById(R.id.back);

        back.setOnClickListener(this);
        CallLayout.setOnClickListener(this);
        videoCallLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.CallLayout:
                CallLayout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background_blue_button));
                videoCallLayout.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.background_white_button));
                CallTV.setTextColor(Color.parseColor("#ffffff"));
                videoCallTV.setTextColor(Color.GRAY);
                fm.beginTransaction().replace(R.id.CallFrame, new VoiceCallFragment()).commit();
                break;

            case R.id.videoCallLayout:
                CallLayout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background_white_button));
                videoCallLayout.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.background_blue_button));
                videoCallTV.setTextColor(Color.parseColor("#ffffff"));
                CallTV.setTextColor(Color.GRAY);
                fm.beginTransaction().replace(R.id.CallFrame, new VideoCallFragment()).commit();
                break;

            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
