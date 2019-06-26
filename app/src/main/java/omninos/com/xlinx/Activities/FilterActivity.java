package omninos.com.xlinx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import omninos.com.xlinx.R;

public class FilterActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_filter);

        intIds();
        performActions();
    }

    private void intIds(){
        back = findViewById(R.id.back);
    }

    private void performActions(){
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
