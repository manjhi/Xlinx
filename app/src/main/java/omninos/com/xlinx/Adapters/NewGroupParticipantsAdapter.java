package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import omninos.com.xlinx.R;
import omninos.com.xlinx.Utils.App;

public class NewGroupParticipantsAdapter extends RecyclerView.Adapter<NewGroupParticipantsAdapter.MyViewHolder> {
    Context context;
    List<String> list;

    public NewGroupParticipantsAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewGroupParticipantsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.participants_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewGroupParticipantsAdapter.MyViewHolder myViewHolder, int i) {
//        myViewHolder.names.setText(App.getSinltonPojo().getNames());
        myViewHolder.names.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView names;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            names = itemView.findViewById(R.id.names);
        }
    }
}
