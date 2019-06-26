package omninos.com.xlinx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class GroceryItemsDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name, quantNum;
    private ImageView back;
    private Button decBut, incBut, buyNow, addToCart;
    private int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_grocery_items_details);

        intIds();
        performActions();
    }

    private void intIds() {
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        decBut = findViewById(R.id.prodDetDecrement);
        incBut = findViewById(R.id.prodDetIncrement);
        buyNow = findViewById(R.id.prodDetBuyNow);
        addToCart = findViewById(R.id.prodDetAddToCart);
        quantNum = findViewById(R.id.prodDetNumerOfItem);
    }

    private void performActions() {
        bar_name.setText("Product Details");
        back.setOnClickListener(this);
        decBut.setOnClickListener(this);
        incBut.setOnClickListener(this);
        buyNow.setOnClickListener(this);
        addToCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;

            case R.id.prodDetIncrement:
                quantity = Integer.parseInt(quantNum.getText().toString());
                quantity = quantity + 1;
                quantNum.setText(quantity + "");
                break;

            case R.id.prodDetDecrement:
                quantity = Integer.parseInt(quantNum.getText().toString());
                if (quantity > 0) {
                    quantity = quantity - 1;
                    quantNum.setText(quantity + "");
                }
                break;

            case R.id.prodDetBuyNow:
                buyNow.setBackgroundResource(R.drawable.background_button_round_corners);
                addToCart.setTextColor(getResources().getColor(R.color.blue));
                addToCart.setBackgroundResource(R.drawable.background_round_corners_blue_outline);
                buyNow.setTextColor(getResources().getColor(R.color.white));
                break;

            case R.id.prodDetAddToCart:
                addToCart.setBackgroundResource(R.drawable.background_button_round_corners);
                buyNow.setBackgroundResource(R.drawable.background_round_corners_blue_outline);
                buyNow.setTextColor(getResources().getColor(R.color.blue));
                addToCart.setTextColor(getResources().getColor(R.color.white));
                break;
        }
    }
}
