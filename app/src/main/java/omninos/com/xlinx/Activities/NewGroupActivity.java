package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import omninos.com.xlinx.Adapters.AddGroupAdapter;
import omninos.com.xlinx.Adapters.BottomSheetAdapter;
import omninos.com.xlinx.Adapters.NewGroupAdapter;
import omninos.com.xlinx.ModalClasses.GroupInfo;
import omninos.com.xlinx.R;
import omninos.com.xlinx.Utils.App;

public class NewGroupActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView groupCycle, addGroupCycle;
    private RelativeLayout NextLayout;
    private List<String> list = new ArrayList<>();
    private List<GroupInfo> list1 = new ArrayList<>();
    private ImageView back;
    private AddGroupAdapter addGroupAdapter;
    private String names;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_new_group);

        intIds();
        performActions();
        setAdapter();

        list1.add(new GroupInfo("Shaman"));
        list1.add(new GroupInfo("Jennifer"));
        list1.add(new GroupInfo("Shaman"));
        list1.add(new GroupInfo("Jennifer"));
        list1.add(new GroupInfo("Shaman"));
        list1.add(new GroupInfo("Jennifer"));
        list1.add(new GroupInfo("Shaman"));
        list1.add(new GroupInfo("Jennifer"));
        list1.add(new GroupInfo("Shaman"));
        list1.add(new GroupInfo("Jennifer"));
        list1.add(new GroupInfo("Shaman"));
        list1.add(new GroupInfo("Jennifer"));
        list1.add(new GroupInfo("Shaman"));
        list1.add(new GroupInfo("Jennifer"));
        list1.add(new GroupInfo("Shaman"));
        list1.add(new GroupInfo("Jennifer"));
    }

    private void intIds() {
        groupCycle = findViewById(R.id.groupCycle);
        addGroupCycle = findViewById(R.id.addGroupCycle);
        NextLayout = findViewById(R.id.NextLayout);
        back = findViewById(R.id.back);
        view = findViewById(R.id.view);
    }

    private void performActions() {
        NextLayout.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void setAdapter() {
        NewGroupAdapter newGroupAdapter = new NewGroupAdapter(this, list1, new NewGroupAdapter.AddGroup() {
            @Override
            public void Open(int position) {
                names = list1.get(position).getNames();
                GroupInfo groupInfo = new GroupInfo(names);
                list.add(groupInfo.getNames());
                addGroupAdapter.notifyDataSetChanged();
                view.setVisibility(View.VISIBLE);
            }
        });
        groupCycle.setAdapter(newGroupAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        groupCycle.setLayoutManager(gridLayoutManager);

        addGroupAdapter = new AddGroupAdapter(this, list, new AddGroupAdapter.RemoveMember() {
            @Override
            public void Remove(int position) {
                list.remove(position);
                addGroupAdapter.notifyDataSetChanged();
                view.setVisibility(View.GONE);
            }
        });
        addGroupCycle.setAdapter(addGroupAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        addGroupCycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.NextLayout:
//                App.getSinltonPojo().setNames(names);
                App.getSinltonPojo().setParticipantsList(list);
                startActivity(new Intent(NewGroupActivity.this, NewGroupInfoActivity.class));
                break;

            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
