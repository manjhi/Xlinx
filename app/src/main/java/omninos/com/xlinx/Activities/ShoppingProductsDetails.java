package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.ColorsAdapter;
import omninos.com.xlinx.R;

public class ShoppingProductsDetails extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private TextView bar_name, smallSize, mediumSize, largeSize, xlargeSize, xxlargeSize;
    private RecyclerView colorsCycle;
    private Button AddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_shopping_products_details);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        colorsCycle = findViewById(R.id.colorsCycle);
        AddToCart = findViewById(R.id.AddToCart);
        smallSize = findViewById(R.id.smallSize);
        mediumSize = findViewById(R.id.mediumSize);
        largeSize = findViewById(R.id.largeSize);
        xlargeSize = findViewById(R.id.xlargeSize);
        xxlargeSize = findViewById(R.id.xxlargeSize);
    }

    private void performActions(){
        back.setOnClickListener(this);
        AddToCart.setOnClickListener(this);
        smallSize.setOnClickListener(this);
        mediumSize.setOnClickListener(this);
        largeSize.setOnClickListener(this);
        xlargeSize.setOnClickListener(this);
        xxlargeSize.setOnClickListener(this);
        bar_name.setText("Product Details");
    }

    private void setAdapter(){
        ColorsAdapter colorsAdapter = new ColorsAdapter(this);
        colorsCycle.setAdapter(colorsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        colorsCycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.AddToCart:
                startActivity(new Intent(ShoppingProductsDetails.this, ShoppingCartDetails.class));
                break;

            case R.id.smallSize:
                smallSize.setTextColor(Color.parseColor("#ffffff"));
                smallSize.setBackground(getResources().getDrawable(R.drawable.background_bluee_circle));
                mediumSize.setTextColor(Color.parseColor("#000000"));
                mediumSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                largeSize.setTextColor(Color.parseColor("#000000"));
                largeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                xlargeSize.setTextColor(Color.parseColor("#000000"));
                xlargeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                xxlargeSize.setTextColor(Color.parseColor("#000000"));
                xxlargeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                break;

            case R.id.mediumSize:
                mediumSize.setTextColor(Color.parseColor("#ffffff"));
                mediumSize.setBackground(getResources().getDrawable(R.drawable.background_bluee_circle));
                smallSize.setTextColor(Color.parseColor("#000000"));
                smallSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                largeSize.setTextColor(Color.parseColor("#000000"));
                largeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                xlargeSize.setTextColor(Color.parseColor("#000000"));
                xlargeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                xxlargeSize.setTextColor(Color.parseColor("#000000"));
                xxlargeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                break;

            case R.id.largeSize:
                largeSize.setTextColor(Color.parseColor("#ffffff"));
                largeSize.setBackground(getResources().getDrawable(R.drawable.background_bluee_circle));
                smallSize.setTextColor(Color.parseColor("#000000"));
                smallSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                mediumSize.setTextColor(Color.parseColor("#000000"));
                mediumSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                xlargeSize.setTextColor(Color.parseColor("#000000"));
                xlargeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                xxlargeSize.setTextColor(Color.parseColor("#000000"));
                xxlargeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                break;

            case R.id.xlargeSize:
                xlargeSize.setTextColor(Color.parseColor("#ffffff"));
                xlargeSize.setBackground(getResources().getDrawable(R.drawable.background_bluee_circle));
                smallSize.setTextColor(Color.parseColor("#000000"));
                smallSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                mediumSize.setTextColor(Color.parseColor("#000000"));
                mediumSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                largeSize.setTextColor(Color.parseColor("#000000"));
                largeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                xxlargeSize.setTextColor(Color.parseColor("#000000"));
                xxlargeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                break;

            case R.id.xxlargeSize:
                xxlargeSize.setTextColor(Color.parseColor("#ffffff"));
                xxlargeSize.setBackground(getResources().getDrawable(R.drawable.background_bluee_circle));
                smallSize.setTextColor(Color.parseColor("#000000"));
                smallSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                mediumSize.setTextColor(Color.parseColor("#000000"));
                mediumSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                largeSize.setTextColor(Color.parseColor("#000000"));
                largeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                xlargeSize.setTextColor(Color.parseColor("#000000"));
                xlargeSize.setBackground(getResources().getDrawable(R.drawable.background_whitee_circle));
                break;
        }
    }
}
