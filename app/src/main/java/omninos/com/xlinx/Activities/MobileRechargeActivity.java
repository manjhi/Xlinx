package omninos.com.xlinx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.MobileRechargeAdapter;
import omninos.com.xlinx.R;

public class MobileRechargeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private CheckBox express, recurring;
    private EditText mobileNumber, operator, amount;
    private RecyclerView MobileRechargeCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_mobile_recharge);

        intIds();
        performActions();
        setAdapter();

//        express.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
////                if (!recurring.isChecked() && !express.isChecked()) {
////                    recurring.setChecked(true);
////                }
//                express.setChecked(true);
//                recurring.setChecked(false);
//
//            }
//        });
//        recurring.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
////                if (!express.isChecked() && !recurring.isChecked()) {
////                    express.setChecked(true);
////                }
//                recurring.setChecked(true);
//                express.setChecked(false);
//            }
//        });
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        express = findViewById(R.id.express);
        recurring = findViewById(R.id.recurring);
        mobileNumber = findViewById(R.id.mobileNumber);
        operator = findViewById(R.id.operator);
        amount = findViewById(R.id.amount);
        MobileRechargeCycle = findViewById(R.id.MobileRechargeCycle);
    }

    private void performActions(){
        bar_name.setText("Mobile Recharge");
        back.setOnClickListener(this);
    }

    private void setAdapter(){
        MobileRechargeAdapter mobileRechargeAdapter = new MobileRechargeAdapter(this);
        MobileRechargeCycle.setAdapter(mobileRechargeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        MobileRechargeCycle.setLayoutManager(linearLayoutManager);
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
