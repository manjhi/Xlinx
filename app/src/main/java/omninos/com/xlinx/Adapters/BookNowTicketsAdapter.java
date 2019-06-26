package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import omninos.com.xlinx.R;

public class BookNowTicketsAdapter extends RecyclerView.Adapter<BookNowTicketsAdapter.MyViewHolder> {
    Context context;
    BookNow bookNow;

    public interface BookNow{
        public void Book(int position);
    }

    public BookNowTicketsAdapter(Context context, BookNow bookNow) {
        this.context = context;
        this.bookNow = bookNow;
    }

    @NonNull
    @Override
    public BookNowTicketsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.tickets_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookNowTicketsAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button BookNow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            BookNow = itemView.findViewById(R.id.BookNow);

            BookNow.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.BookNow:
                    bookNow.Book(getLayoutPosition());
                    break;
            }
        }
    }
}
