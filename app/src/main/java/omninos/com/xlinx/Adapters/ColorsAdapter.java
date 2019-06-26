package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import omninos.com.xlinx.R;

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.MyViewHolder> {
    Context context;
    private int row_index;
    private int count = 0;

    public ColorsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ColorsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.colors_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorsAdapter.MyViewHolder myViewHolder, int i) {
        if (i == 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myViewHolder.color.setBackgroundTintList(context.getColorStateList(R.color.red));
            }
        }
        if (i == 1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myViewHolder.color.setBackgroundTintList(context.getColorStateList(R.color.green));
            }
        }
        if (i == 2) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myViewHolder.color.setBackgroundTintList(context.getColorStateList(R.color.orange));
            }
        }
        if (i == 3) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myViewHolder.color.setBackgroundTintList(context.getColorStateList(R.color.pink));
            }
        }
        if (i == 4) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myViewHolder.color.setBackgroundTintList(context.getColorStateList(R.color.blue));
            }
        }
        if (i == 5) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myViewHolder.color.setBackgroundTintList(context.getColorStateList(R.color.skyblue));
            }
        }
        if (i == 6) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myViewHolder.color.setBackgroundTintList(context.getColorStateList(R.color.purple));
            }
        }
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageButton color;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            color = itemView.findViewById(R.id.color);

            color.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.color:

                    break;
            }
        }
    }
}
