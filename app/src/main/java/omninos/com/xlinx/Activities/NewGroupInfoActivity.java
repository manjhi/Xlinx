package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.NewGroupParticipantsAdapter;
import omninos.com.xlinx.R;
import omninos.com.xlinx.Utils.App;

public class NewGroupInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView ParticipantsCycle;
    private ImageView back, GroupChat;
    private TextView NoOfParticipants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_new_group_info);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds(){
        ParticipantsCycle = findViewById(R.id.ParticipantsCycle);
        back = findViewById(R.id.back);
        GroupChat = findViewById(R.id.GroupChat);
        NoOfParticipants = findViewById(R.id.NoOfParticipants);
    }

    private void performActions(){
        back.setOnClickListener(this);
        GroupChat.setOnClickListener(this);
    }

    private void setAdapter(){
        NewGroupParticipantsAdapter newGroupParticipantsAdapter = new NewGroupParticipantsAdapter(this, App.getSinltonPojo().getParticipantsList());
        ParticipantsCycle.setAdapter(newGroupParticipantsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ParticipantsCycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.GroupChat:
                startActivity(new Intent(NewGroupInfoActivity.this, GroupChatActivity.class));
                break;
        }
    }
}
