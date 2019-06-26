package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.R;

public class ShowMallAdapter extends RecyclerView.Adapter<ShowMallAdapter.MyViewHolder> {
    Context context;

    public ShowMallAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ShowMallAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.show_mall_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowMallAdapter.MyViewHolder myViewHolder, int i) {
        ShowTimeAdapter showTimeAdapter = new ShowTimeAdapter(context);
        myViewHolder.showTimeCycle.setAdapter(showTimeAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
        myViewHolder.showTimeCycle.setLayoutManager(gridLayoutManager);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView showTimeCycle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            showTimeCycle= itemView.findViewById(R.id.showTimeCycle);

        }
    }
}
