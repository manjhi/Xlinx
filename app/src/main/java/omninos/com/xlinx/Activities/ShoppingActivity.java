package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.ShoppingItemsAdapter;
import omninos.com.xlinx.R;

public class ShoppingActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView ShoppingItemsCycle;
    private TextView bar_name;
    private ImageView back, WomanWear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_shopping);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds(){
        ShoppingItemsCycle = findViewById(R.id.ShoppingItemsCycle);
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        WomanWear = findViewById(R.id.WomanWear);
    }

    private void performActions(){
        back.setOnClickListener(this);
        WomanWear.setOnClickListener(this);
        bar_name.setText("Shopping");
    }

    private void setAdapter(){
        ShoppingItemsAdapter shoppingItemsAdapter = new ShoppingItemsAdapter(this);
        ShoppingItemsCycle.setAdapter(shoppingItemsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ShoppingItemsCycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.WomanWear:
                startActivity(new Intent(ShoppingActivity.this, ShoppingNextActivity.class));
                break;
        }
    }
}
