package omninos.com.xlinx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.BlockedContactsAdapter;
import omninos.com.xlinx.R;

public class BlockedContactsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private RecyclerView BlockedContactsCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_blocked_contacts);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        BlockedContactsCycle = findViewById(R.id.BlockedContactsCycle);
    }

    private void performActions(){
        bar_name.setText("Blocked Contacts");
        back.setOnClickListener(this);
    }

    private void setAdapter(){
        BlockedContactsAdapter blockedContactsAdapter = new BlockedContactsAdapter(this);
        BlockedContactsCycle.setAdapter(blockedContactsAdapter);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        BlockedContactsCycle.setLayoutManager(linearLayoutManager);
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
