package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.R;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {
    Context context;

    public StoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public StoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.story_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.MyViewHolder myViewHolder, int i) {
        if(i==0){
            myViewHolder.addStory.setImageResource(R.drawable.ic_plus);

        }else{
            myViewHolder.addStory.setImageResource(R.drawable.photo_);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView addStory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            addStory = itemView.findViewById(R.id.addStory);

        }
    }
}
