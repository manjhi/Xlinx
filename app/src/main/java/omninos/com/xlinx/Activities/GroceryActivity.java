package omninos.com.xlinx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import omninos.com.xlinx.Adapters.GroceryHotMealsAdapter;
import omninos.com.xlinx.Adapters.GroceryTrendingAdapter;
import omninos.com.xlinx.Adapters.ShopByProductsAdapter;
import omninos.com.xlinx.R;

public class GroceryActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private RecyclerView trending_recycler, hot_deals_recycler, shop_products_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_grocery);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds(){
        back = findViewById(R.id.back);
        trending_recycler = findViewById(R.id.trending_recycler);
        hot_deals_recycler = findViewById(R.id.hot_deals_recycler);
        shop_products_recycler = findViewById(R.id.shop_products_recycler);
    }

    private void performActions(){
        back.setOnClickListener(this);
    }

    private void setAdapter(){
        GroceryTrendingAdapter groceryTrendingAdapter = new GroceryTrendingAdapter(this);
        trending_recycler.setAdapter(groceryTrendingAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        trending_recycler.setLayoutManager(linearLayoutManager);

        GroceryHotMealsAdapter groceryHotMealsAdapter = new GroceryHotMealsAdapter(this);
        hot_deals_recycler.setAdapter(groceryHotMealsAdapter);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        hot_deals_recycler.setLayoutManager(linearLayoutManager1);

        ShopByProductsAdapter shopByProductsAdapter = new ShopByProductsAdapter(this);
        shop_products_recycler.setAdapter(shopByProductsAdapter);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        shop_products_recycler.setLayoutManager(linearLayoutManager2);
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
