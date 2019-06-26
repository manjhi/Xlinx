package omninos.com.xlinx.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class VerificationActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout NextLayout;
    private TextView bar_name;
    private EditText ed1, ed2, ed3, ed4;
    private String otp_1, otp_2, otp_3, otp_4;
    private View view1, view2, view3, view4;
    private ImageView back;
    private VerificationActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_verification);

        intIds();
        performActions();
    }

    private void intIds(){
        activity = VerificationActivity.this;
        NextLayout = findViewById(R.id.NextLayout);
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
    }

    private void performActions(){
        NextLayout.setOnClickListener(this);
        bar_name.setText("Verification");
        back.setOnClickListener(this);
        ed1.addTextChangedListener(generalTextWatcher);
        ed2.addTextChangedListener(generalTextWatcher);
        ed3.addTextChangedListener(generalTextWatcher);
        ed4.addTextChangedListener(generalTextWatcher);
    }

    TextWatcher generalTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (ed1.getText().hashCode() == editable.hashCode()) {
                otp_1 = ed1.getText().toString().trim();
                if (!otp_1.equalsIgnoreCase("")) {
                    ed2.requestFocus();
                    view1.setBackgroundColor(Color.BLACK);
                }else {
                    view1.setBackgroundColor(Color.GRAY);
                }

            } else if (ed2.getText().hashCode() == editable.hashCode()) {
                otp_2 = ed2.getText().toString().trim();
                if (!otp_2.equalsIgnoreCase("")) {
                    ed3.requestFocus();
                    view2.setBackgroundColor(Color.BLACK);
                } else {
                    ed1.requestFocus();
                    view2.setBackgroundColor(Color.GRAY);
                }

            } else if (ed3.getText().hashCode() == editable.hashCode()) {
                otp_3 = ed3.getText().toString().trim();
                if (!otp_3.equalsIgnoreCase("")) {
                    ed4.requestFocus();
                    view3.setBackgroundColor(Color.BLACK);
                } else {
                    ed2.requestFocus();
                    view3.setBackgroundColor(Color.GRAY);
                }
            } else if (ed4.getText().hashCode() == editable.hashCode()) {
                otp_4 = ed4.getText().toString().trim();
                if (!otp_4.equalsIgnoreCase("")) {
                    hideKeyboard(activity);
                    view4.setBackgroundColor(Color.BLACK);
                } else {
                    ed3.requestFocus();
                    view4.setBackgroundColor(Color.GRAY);
                }
            }
        }
    };

    //hide keyboard
    public static void hideKeyboard(Activity activity) {
        View view = activity.findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.NextLayout:
                startActivity(new Intent(VerificationActivity.this, UserNameActivity.class));
                break;

            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
