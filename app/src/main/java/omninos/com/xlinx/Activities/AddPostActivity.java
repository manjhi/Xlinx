package omninos.com.xlinx.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class AddPostActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private TextView bar_name, friends, everyone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_add_post);

        intIds();
        performActions();
    }

    private void intIds() {
        back = findViewById(R.id.back);
        bar_name = findViewById(R.id.bar_name);
        friends = findViewById(R.id.friends);
        everyone = findViewById(R.id.everyone);
    }

    private void performActions() {
        back.setOnClickListener(this);
        bar_name.setText("New Post");
        friends.setOnClickListener(this);
        everyone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;

            case R.id.friends:
                friends.setBackgroundColor(Color.parseColor("#949496"));
                everyone.setBackgroundColor(Color.parseColor("#DADADA"));
                break;

            case R.id.everyone:
                friends.setBackgroundColor(Color.parseColor("#DADADA"));
                everyone.setBackgroundColor(Color.parseColor("#949496"));
                break;
        }
    }
}