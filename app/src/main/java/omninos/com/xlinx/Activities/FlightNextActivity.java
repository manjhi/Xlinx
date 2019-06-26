package omninos.com.xlinx.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.FlightAdapter;
import omninos.com.xlinx.R;

public class FlightNextActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private RecyclerView filterrv;
    private RelativeLayout Filter, Sort;
    private TextView flightSortTextView;
    private View view;
    private AlertDialog alertDialog;
    private Button MostPopular, CheapestRate, HighlyRated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_flight_next);

        intIds();
        performActions();
        setAdapter();
        openDialog();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        filterrv = findViewById(R.id.filterrv);
        Filter = findViewById(R.id.Filter);
        Sort = findViewById(R.id.Sort);
        flightSortTextView = findViewById(R.id.flight_sort_text_view);
    }

    private void performActions(){
        bar_name.setText("Delhi to Mumbai ");
        back.setOnClickListener(this);
        Filter.setOnClickListener(this);
        Sort.setOnClickListener(this);
    }

    private void openDialog(){
        view = LayoutInflater.from(FlightNextActivity.this).inflate(R.layout.flight_sort_dialog, null);
        alertDialog = new AlertDialog.Builder(FlightNextActivity.this).create();
        Window window = alertDialog.getWindow();
//        window.setGravity(Gravity.TOP | Gravity.RIGHT);

        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = (display.getWidth());

        window.setGravity(Gravity.TOP | Gravity.RIGHT);

        lp.x = -10;
        lp.y = 180;

        window.setAttributes(lp);

//        window.findViewById(R.id.MostPopular);
//        window.findViewById(R.id.CheapestRate);
//        window.findViewById(R.id.HighlyRated);
//
//        MostPopular.setOnClickListener(this);
//        CheapestRate.setOnClickListener(this);
//        HighlyRated.setOnClickListener(this);
    }

    private void setAdapter(){
        FlightAdapter flightAdapter = new FlightAdapter(this, new FlightAdapter.FlightDetails() {
            @Override
            public void Show(int position) {
                startActivity(new Intent(FlightNextActivity.this, FlightDetailsActivity.class));
            }
        });
        filterrv.setAdapter(flightAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        filterrv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.Filter:
                startActivity(new Intent(FlightNextActivity.this, FlightFilterActivity.class));
                break;

            case R.id.Sort:
                alertDialog.setView(view);
                alertDialog.show();
                break;

//            case R.id.MostPopular:
//                MostPopular.setBackground(getDrawable(R.drawable.background_blue_button));
//                MostPopular.setTextColor(Color.parseColor("#ffffff"));
//                CheapestRate.setBackground(getDrawable(R.drawable.background_blue_outline_white_background));
//                CheapestRate.setTextColor(Color.parseColor("#000000"));
//                HighlyRated.setBackground(getDrawable(R.drawable.background_blue_outline_white_background));
//                HighlyRated.setTextColor(Color.parseColor("#000000"));
//                break;
//
//            case R.id.CheapestRate:
//                CheapestRate.setBackground(getDrawable(R.drawable.background_blue_button));
//                CheapestRate.setTextColor(Color.parseColor("#ffffff"));
//                MostPopular.setBackground(getDrawable(R.drawable.background_blue_outline_white_background));
//                MostPopular.setTextColor(Color.parseColor("#000000"));
//                HighlyRated.setBackground(getDrawable(R.drawable.background_blue_outline_white_background));
//                HighlyRated.setTextColor(Color.parseColor("#000000"));
//                break;
//
//            case R.id.HighlyRated:
//                HighlyRated.setBackground(getDrawable(R.drawable.background_blue_button));
//                HighlyRated.setTextColor(Color.parseColor("#ffffff"));
//                CheapestRate.setBackground(getDrawable(R.drawable.background_blue_outline_white_background));
//                CheapestRate.setTextColor(Color.parseColor("#000000"));
//                MostPopular.setBackground(getDrawable(R.drawable.background_blue_outline_white_background));
//                MostPopular.setTextColor(Color.parseColor("#000000"));
//                break;
        }
    }
}
