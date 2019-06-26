package omninos.com.xlinx.Activities;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class CabDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView oriPrice;
    private TextView cab_name;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_cab_details);

        intIds();
        performActions();
    }

    private void intIds(){
        cab_name = findViewById(R.id.cab_name);
        back = findViewById(R.id.back);
        oriPrice = findViewById(R.id.oriPrice);
    }

    private void performActions(){
        oriPrice.setPaintFlags(oriPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
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
