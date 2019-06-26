package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import omninos.com.xlinx.Adapters.ChatAdapter;
import omninos.com.xlinx.ModalClasses.ChatModalClass;
import omninos.com.xlinx.R;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView chatCycle;
    private List<ChatModalClass> models=new ArrayList<>();
    private ChatAdapter chatAdapter;
    private ImageView send, back, options;
    private EditText input_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_chat);

        intIds();
        performActions();
        seAdapter();
    }

    private void intIds(){
        chatCycle = findViewById(R.id.chatCycle);
        send = findViewById(R.id.send);
        back = findViewById(R.id.back);
        options = findViewById(R.id.options);
        input_msg = findViewById(R.id.input_msg);
    }

    private void performActions(){
        send.setOnClickListener(this);
        back.setOnClickListener(this);
        options.setOnClickListener(this);
    }

    private void seAdapter(){
        chatAdapter =new ChatAdapter(this,models);
        ChatModalClass model=new ChatModalClass("Hi, How are You?",ChatModalClass.MSG_TYPE_RECEIVED);
        models.add(model);
        chatCycle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        chatCycle.setAdapter(chatAdapter);
    }

    private void sendMessage() {
        String data = input_msg.getText().toString();

        if (!data.isEmpty()) {
            ChatModalClass model = new ChatModalClass(data, ChatModalClass.MSG_TYPE_SENT);
            models.add(model);
            int newMsgPosition = models.size() - 1;
            chatAdapter.notifyItemInserted(newMsgPosition);
            chatCycle.scrollToPosition(newMsgPosition);
            input_msg.setText("");
        }else {
            Toast.makeText(this, "write something", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.send:
                sendMessage();
                break;

            case R.id.options:
                PopupMenu popupMenu = new PopupMenu(ChatActivity.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.chat_popup_items, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.viewContact:
                                startActivity(new Intent(ChatActivity.this, ViewContactActivity.class));
                                break;
                        }

//                        Toast.makeText(ChatActivity.this,"You Clicked:" + menuItem.getTitle(),Toast.LENGTH_LONG).show();
                        return true;
                    }
                });

                popupMenu.show();
                break;

        }
    }
}
