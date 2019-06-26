package omninos.com.xlinx.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import omninos.com.xlinx.ModalClasses.ChatModalClass;
import omninos.com.xlinx.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    Context context;
    List<ChatModalClass> models;

    public ChatAdapter(Context context, List<ChatModalClass> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.chat_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.MyViewHolder myViewHolder, int i) {
        if (ChatModalClass.MSG_TYPE_RECEIVED.equalsIgnoreCase(models.get(i).getMsgType())){
            myViewHolder.right.setVisibility(View.GONE);
            myViewHolder.left.setVisibility(View.VISIBLE);
            myViewHolder.leftChat.setText(models.get(i).getMsgContent());
        }else if (ChatModalClass.MSG_TYPE_SENT.equalsIgnoreCase(models.get(i).getMsgType())){
            myViewHolder.right.setVisibility(View.VISIBLE);
            myViewHolder.left.setVisibility(View.GONE);
            myViewHolder.rightChat.setText(models.get(i).getMsgContent());
        }
    }

    @Override
    public int getItemCount() {
        if (models==null){
            models=new ArrayList<ChatModalClass>();
        }
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout right,left;
        TextView rightChat,leftChat;
        ImageView sender,receiver;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            right=itemView.findViewById(R.id.right);
            left=itemView.findViewById(R.id.left);
            sender=itemView.findViewById(R.id.sender);
            receiver=itemView.findViewById(R.id.receiver);
            rightChat=itemView.findViewById(R.id.rightChat);
            leftChat=itemView.findViewById(R.id.leftChat);
        }
    }
}
