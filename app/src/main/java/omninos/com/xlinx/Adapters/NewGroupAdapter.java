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

import omninos.com.xlinx.ModalClasses.GroupInfo;
import omninos.com.xlinx.R;
import omninos.com.xlinx.Utils.App;

public class NewGroupAdapter extends RecyclerView.Adapter<NewGroupAdapter.MyViewHolder> {
    private Context context;
    private List<GroupInfo> list;
    private AddGroup addGroup;

    public interface AddGroup{
        public void Open(int position);
    }

    public NewGroupAdapter(Context context, List<GroupInfo> list, AddGroup addGroup) {
        this.context = context;
        this.list = list;
        this.addGroup = addGroup;
    }

    @NonNull
    @Override
    public NewGroupAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.new_group_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewGroupAdapter.MyViewHolder myViewHolder, int i) {
        GroupInfo groupInfo = list.get(i);
        myViewHolder.names.setText(groupInfo.getNames());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout addGroupLayout;
        ImageView profile;
        TextView names;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            addGroupLayout = itemView.findViewById(R.id.addGroupLayout);
            profile = itemView.findViewById(R.id.profile);
            names = itemView.findViewById(R.id.names);

            addGroupLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.addGroupLayout:
                    addGroup.Open(getLayoutPosition());
                    break;
            }
        }
    }
}
