package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.CabAdapter;
import omninos.com.xlinx.R;
import omninos.com.xlinx.Utils.App;

public class CabNextActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView src_bar_name, des_bar_name;
    private ImageView back;
    private RecyclerView cabCycle;
    private String src, des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_cab_next);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds(){
        src_bar_name = findViewById(R.id.src_bar_name);
        des_bar_name = findViewById(R.id.des_bar_name);
        cabCycle = findViewById(R.id.cabCycle);
        back = findViewById(R.id.back);
    }

    private void performActions(){
        back.setOnClickListener(this);
    }

    private void setAdapter(){
        CabAdapter cabAdapter = new CabAdapter(this, new CabAdapter.Click() {
            @Override
            public void Open(int position) {
                startActivity(new Intent(CabNextActivity.this, CabDetailsActivity.class));
            }
        });
        cabCycle.setAdapter(cabAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        cabCycle.setLayoutManager(gridLayoutManager);
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
