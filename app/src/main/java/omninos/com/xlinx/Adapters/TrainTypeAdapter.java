package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import omninos.com.xlinx.R;

public class TrainTypeAdapter extends RecyclerView.Adapter<TrainTypeAdapter.MyViewHolder> {
    private Context context;
    private ChangeQuota changeQuotaa;

    public interface ChangeQuota{
        public void Change(int position);
    }

    public TrainTypeAdapter(Context context, ChangeQuota changeQuota) {
        this.context = context;
        this.changeQuotaa = changeQuota;
    }

    @NonNull
    @Override
    public TrainTypeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.train_type_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainTypeAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout changeQuota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            changeQuota = itemView.findViewById(R.id.changeQuota);

            changeQuota.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.changeQuota:
                    changeQuotaa.Change(getLayoutPosition());
                    break;
            }
        }
    }
}
