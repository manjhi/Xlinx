package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import omninos.com.xlinx.Adapters.ChatAdapter;
import omninos.com.xlinx.ModalClasses.ChatModalClass;
import omninos.com.xlinx.R;

public class GroupChatActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView groupChatCycle;
    private List<ChatModalClass> models = new ArrayList<>();
    private ChatAdapter chatAdapter;
    private ImageView send, back, GroupOptions;
    private EditText input_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_group_chat);

        intIds();
        performActions();
        seAdapter();
    }

    private void intIds() {
        back = findViewById(R.id.back);
        groupChatCycle = findViewById(R.id.groupChatCycle);
        input_msg = findViewById(R.id.input_msg);
        send = findViewById(R.id.send);
        GroupOptions = findViewById(R.id.GroupOptions);
    }

    private void performActions() {
        send.setOnClickListener(this);
        back.setOnClickListener(this);
        GroupOptions.setOnClickListener(this);
    }

    private void sendMessage() {
        String data = input_msg.getText().toString();

        if (!data.isEmpty()) {
            ChatModalClass model = new ChatModalClass(data, ChatModalClass.MSG_TYPE_SENT);
            models.add(model);
            int newMsgPosition = models.size() - 1;
            chatAdapter.notifyItemInserted(newMsgPosition);
            groupChatCycle.scrollToPosition(newMsgPosition);
            input_msg.setText("");
        } else {
            Toast.makeText(this, "write something", Toast.LENGTH_SHORT).show();
        }
    }

    private void seAdapter() {
        chatAdapter = new ChatAdapter(this, models);
        ChatModalClass model = new ChatModalClass("Hi, How are You?", ChatModalClass.MSG_TYPE_RECEIVED);
        models.add(model);
        groupChatCycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        groupChatCycle.setAdapter(chatAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;

            case R.id.GroupOptions:
                PopupMenu popupMenu = new PopupMenu(GroupChatActivity.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.group_chat_items, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.groupInfo:
                                startActivity(new Intent(GroupChatActivity.this, GroupInfoActivity.class));
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();

                break;

            case R.id.send:
                sendMessage();
                break;
        }
    }
}
