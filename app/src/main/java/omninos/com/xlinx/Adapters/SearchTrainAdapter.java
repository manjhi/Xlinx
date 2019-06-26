package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.R;

public class SearchTrainAdapter extends RecyclerView.Adapter<SearchTrainAdapter.MyViewHolder> {
    Context context;
    private ChangeQuota changeQuotaa;

    public interface ChangeQuota {
        public void Change(int position);
    }

    public SearchTrainAdapter(Context context, ChangeQuota changeQuotaa) {
        this.context = context;
        this.changeQuotaa = changeQuotaa;
    }

    @NonNull
    @Override
    public SearchTrainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.search_train_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchTrainAdapter.MyViewHolder myViewHolder, int i) {
        TrainTypeAdapter trainTypeAdapter = new TrainTypeAdapter(context, new TrainTypeAdapter.ChangeQuota() {
            @Override
            public void Change(int position) {
                changeQuotaa.Change(getItemCount());
            }
        });
        myViewHolder.trainType.setAdapter(trainTypeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        myViewHolder.trainType.setLayoutManager(linearLayoutManager);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView trainType;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            trainType = itemView.findViewById(R.id.trainType);
        }
    }
}
