package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import omninos.com.xlinx.R;

public class ShopByProductsAdapter extends RecyclerView.Adapter<ShopByProductsAdapter.MyViewHolder> {
    Context context;
    int count = 0;

    public ShopByProductsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ShopByProductsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.shop_by_products_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopByProductsAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RecyclerView shop_products_extended_recycler;
        RelativeLayout productslayout;
        ImageView Arrow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            shop_products_extended_recycler = itemView.findViewById(R.id.shop_products_extended_recycler);
            productslayout = itemView.findViewById(R.id.productslayout);
            Arrow = itemView.findViewById(R.id.Arrow);

            productslayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.productslayout:
                    if (count == 0) {
                        shop_products_extended_recycler.setVisibility(View.VISIBLE);
                        Arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        ProductsAdapter productsAdapter = new ProductsAdapter(context);
                        shop_products_extended_recycler.setAdapter(productsAdapter);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
                        shop_products_extended_recycler.setLayoutManager(gridLayoutManager);
                        count++;
                    } else if (count == 1) {
                        shop_products_extended_recycler.setVisibility(View.GONE);
                        Arrow.setImageResource(R.drawable.ic_keyboard_arrow_right_blue_24dp);
                        count = 0;
                    }
                    break;
            }
        }
    }
}
