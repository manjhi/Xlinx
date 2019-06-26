package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.R;

public class GroceryItemAdapter extends RecyclerView.Adapter<GroceryItemAdapter.MyViewHolder> {
    private Context context;
    private ShowDetails showDetails;

    public interface ShowDetails{
        public void Show(int position);
    }

    public GroceryItemAdapter(Context context, ShowDetails showDetails) {
        this.context = context;
        this.showDetails = showDetails;
    }

    @NonNull
    @Override
    public GroceryItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.grocery_item_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryItemAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView productsDetails;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productsDetails = itemView.findViewById(R.id.productsDetails);

            productsDetails.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.productsDetails:
                    showDetails.Show(getLayoutPosition());
                    break;
            }
        }
    }
}
