package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.R;

public class BookSeatsAdapter extends RecyclerView.Adapter<BookSeatsAdapter.MyViewHolder> {
    Context context;

    public BookSeatsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BookSeatsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_seats_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSeatsAdapter.MyViewHolder myViewHolder, int i) {
        SeatsAdapter seatsAdapter = new SeatsAdapter(context);
        myViewHolder.seatsCycle.setAdapter(seatsAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 11);
        myViewHolder.seatsCycle.setLayoutManager(gridLayoutManager);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView seatsCycle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            seatsCycle = itemView.findViewById(R.id.seatsCycle);
        }
    }
}
