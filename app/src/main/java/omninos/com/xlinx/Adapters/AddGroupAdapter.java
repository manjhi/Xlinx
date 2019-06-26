package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Set;

import omninos.com.xlinx.ModalClasses.GroupInfo;
import omninos.com.xlinx.R;

public class AddGroupAdapter extends RecyclerView.Adapter<AddGroupAdapter.MyViewHolder> {
    Context context;
    List<String> list;
    private RemoveMember removeMember;


    public interface RemoveMember{
        public void Remove(int position);
    }

    public AddGroupAdapter(Context context, List<String> list, RemoveMember removeMember) {
        this.context = context;
        this.list = list;
        this.removeMember = removeMember;
    }

    @NonNull
    @Override
    public AddGroupAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.add_group_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddGroupAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.names.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView remove;
        TextView names;
        RelativeLayout profile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile);
            names = itemView.findViewById(R.id.names);
            remove = itemView.findViewById(R.id.remove);

            remove.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.remove:
                    removeMember.Remove(getLayoutPosition());
                    break;
            }
        }
    }
}
