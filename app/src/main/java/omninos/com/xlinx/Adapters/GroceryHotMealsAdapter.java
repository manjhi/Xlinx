package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.R;

public class GroceryHotMealsAdapter extends RecyclerView.Adapter<GroceryHotMealsAdapter.MyViewHolder> {
    Context context;

    public GroceryHotMealsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GroceryHotMealsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.groceries_hotmeals_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryHotMealsAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
