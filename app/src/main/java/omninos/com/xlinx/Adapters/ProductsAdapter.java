package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.Activities.GroceryItemsActivity;
import omninos.com.xlinx.R;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {
    Context context;

    public ProductsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProductsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.products_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView shop_products_card;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            shop_products_card = itemView.findViewById(R.id.shop_products_card);

            shop_products_card.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.shop_products_card:
                    context.startActivity(new Intent(context, GroceryItemsActivity.class));
                    break;
            }
        }
    }
}
