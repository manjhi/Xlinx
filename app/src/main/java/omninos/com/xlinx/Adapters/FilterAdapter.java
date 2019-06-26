package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.MyViewHolder> {
    Context context;
    int count=0;

    public FilterAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FilterAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.filter_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterAdapter.MyViewHolder myViewHolder, int i) {
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout relativeLayout;
        TextView filtertext;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout=itemView.findViewById(R.id.relativelyout);
            filtertext=itemView.findViewById(R.id.filtertext);

            relativeLayout.setOnClickListener(this);
            filtertext.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.relativelyout:
                    if(count==0){
                        filtertext.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tic,0,0,0);
                        count=1;
                    }
                    else if(count==1){
                        filtertext.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle,0,0,0);
                        count=0;
                    }
                    break;
            }
        }
    }
}
