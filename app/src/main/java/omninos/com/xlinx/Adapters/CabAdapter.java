package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class CabAdapter extends RecyclerView.Adapter<CabAdapter.MyViewHolder> {
    Context context;
    Click click;

    public interface Click{
        public void Open(int position);
    }

    public CabAdapter(Context context, Click click) {
        this.context = context;
        this.click = click;
    }

    @NonNull
    @Override
    public CabAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cab_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CabAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.orgPrice.setPaintFlags(myViewHolder.orgPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cabCardView;
        TextView orgPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cabCardView = itemView.findViewById(R.id.cabCardView);
            orgPrice = itemView.findViewById(R.id.orgPrice);
            cabCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cabCardView:
                    click.Open(getLayoutPosition());
                    break;
            }
        }
    }
}
