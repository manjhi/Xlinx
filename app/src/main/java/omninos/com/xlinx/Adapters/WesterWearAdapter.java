package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.R;

public class WesterWearAdapter extends RecyclerView.Adapter<WesterWearAdapter.MyViewHolder> {
    private Context context;
    private Details details;

    public interface Details{
        public void Open(int position);
    }

    public WesterWearAdapter(Context context, Details details) {
        this.context = context;
        this.details = details;
    }

    @NonNull
    @Override
    public WesterWearAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.western_wear_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WesterWearAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView ShoppingDetails;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ShoppingDetails = itemView.findViewById(R.id.ShoppingDetails);

            ShoppingDetails.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ShoppingDetails:
                    details.Open(getLayoutPosition());
                    break;
            }
        }
    }
}
