package omninos.com.xlinx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Fragments.ConfirmFlightPaymentFragment;
import omninos.com.xlinx.R;

public class ConfirmFlightActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;

    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_confirm_flight);

        intIds();
        performActions();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        proceedButton = findViewById(R.id.proceed_to_book_button);
    }

    private void performActions(){
        back.setOnClickListener(this);
        proceedButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.proceed_to_book_button:
                ConfirmFlightPaymentFragment confirmFlightPaymentFragment = new ConfirmFlightPaymentFragment();
                confirmFlightPaymentFragment.show(getSupportFragmentManager(), "Confirm payment");
                break;
        }
    }
}
