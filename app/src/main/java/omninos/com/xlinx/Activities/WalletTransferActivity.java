package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.TransferPagerAdapter;
import omninos.com.xlinx.R;

public class WalletTransferActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private Button next;
    private ImageView back;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_transfer_wallet);

        intIds();
        performActions();
        setups();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
//        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        viewPager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tabLayout);
    }

    private void performActions(){
        bar_name.setText("Transfer");
//        next.setOnClickListener(this);
        back.setOnClickListener(this);
        tabLayout.addTab(tabLayout.newTab().setText("Transfer between Users"));
        tabLayout.addTab(tabLayout.newTab().setText("Bank Transfer"));
    }

    private void setups() {
        TransferPagerAdapter adapter=new TransferPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.d( "onTabSelected: ", String.valueOf(tab.getPosition()));


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next:
//                startActivity(new Intent(WalletTransferActivity.this, WalletNextActivity.class));
                break;

            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
