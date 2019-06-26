package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.GroceryItemAdapter;
import omninos.com.xlinx.R;

public class GroceryItemsActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView productsCycle;
    private TextView bar_name;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_grocery_items);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds() {
        productsCycle = findViewById(R.id.productsCycle);
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
    }

    private void performActions(){
        bar_name.setText("Cooking Oils");
        back.setOnClickListener(this);
    }

    private void setAdapter() {
        GroceryItemAdapter groceryItemAdapter = new GroceryItemAdapter(this, new GroceryItemAdapter.ShowDetails() {
            @Override
            public void Show(int position) {
                startActivity(new Intent(GroceryItemsActivity.this, GroceryItemsDetailsActivity.class));
            }
        });
        productsCycle.setAdapter(groceryItemAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        productsCycle.setLayoutManager(linearLayoutManager);
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
