package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class StoreActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private LinearLayout cab, mobile, metro, grocery, shopping, movie, DTH, Flight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_store);

        intIds();
        performActions();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        cab = findViewById(R.id.cab);
        mobile = findViewById(R.id.mobile);
        metro = findViewById(R.id.metro);
        grocery = findViewById(R.id.grocery);
        shopping = findViewById(R.id.shopping);
        movie = findViewById(R.id.movie);
        DTH = findViewById(R.id.DTH);
        Flight = findViewById(R.id.Flight);
    }

    private void performActions(){
        bar_name.setText("Store");
        back.setOnClickListener(this);
        cab.setOnClickListener(this);
        mobile.setOnClickListener(this);
        metro.setOnClickListener(this);
        grocery.setOnClickListener(this);
        shopping.setOnClickListener(this);
        movie.setOnClickListener(this);
        DTH.setOnClickListener(this);
        Flight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.mobile:
                startActivity(new Intent(StoreActivity.this, MobileRechargeActivity.class));
                break;

            case R.id.cab:
                startActivity(new Intent(StoreActivity.this, CabActivity.class));
                break;

            case R.id.metro:
                startActivity(new Intent(StoreActivity.this, MetroActivity.class));
                break;

            case R.id.grocery:
                startActivity(new Intent(StoreActivity.this, GroceryActivity.class));
                break;

            case R.id.shopping:
                startActivity(new Intent(StoreActivity.this, ShoppingActivity.class));
                break;

            case R.id.DTH:
                startActivity(new Intent(StoreActivity.this, DTHselectProvider.class));
                break;

            case R.id.movie:
                startActivity(new Intent(StoreActivity.this, BookMoviesTickets.class));
                break;

            case R.id.Flight:
                startActivity(new Intent(StoreActivity.this, FlightActivity.class));
                break;
        }
    }
}