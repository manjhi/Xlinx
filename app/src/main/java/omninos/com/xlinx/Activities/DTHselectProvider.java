package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class DTHselectProvider extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private CardView d2h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_dthselect_provider);

        intIds();
        performActions();
    }

    private void intIds(){
        d2h=findViewById(R.id.d2h);
        bar_name=findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
    }

    private void performActions(){
        d2h.setOnClickListener(this);
        bar_name.setText("Select Provider");
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.d2h:
                startActivity(new Intent(DTHselectProvider.this,DTHActivity.class));
                break;

            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
