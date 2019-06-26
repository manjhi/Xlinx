package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.R;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.MyViewHolder> {
    private Context context;
    private FlightDetails flightDetails;

    public interface FlightDetails{
        public void Show(int position);
    }

    public FlightAdapter(Context context, FlightDetails flightDetails) {
        this.context = context;
        this.flightDetails = flightDetails;
    }

    @NonNull
    @Override
    public FlightAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.flight_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView FlightCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            FlightCardView = itemView.findViewById(R.id.FlightCardView);

            FlightCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.FlightCardView:
                    flightDetails.Show(getLayoutPosition());
                    break;
            }
        }
    }
}
