package omninos.com.xlinx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import omninos.com.xlinx.Adapters.GroupMembersAdapter;
import omninos.com.xlinx.R;

public class GroupInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView groupMembersCycle;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_group_info);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds(){
        groupMembersCycle = findViewById(R.id.groupMembersCycle);
        back = findViewById(R.id.back);
    }

    private void performActions(){
        back.setOnClickListener(this);
    }

    private void setAdapter(){
        GroupMembersAdapter groupMembersAdapter = new GroupMembersAdapter(this);
        groupMembersCycle.setAdapter(groupMembersAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        groupMembersCycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
