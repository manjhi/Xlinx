package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.SearchTrainAdapter;
import omninos.com.xlinx.Fragments.BottomSheetSearchTrainFragment;
import omninos.com.xlinx.Fragments.BottomSheetSortFragment;
import omninos.com.xlinx.Fragments.ChangeQuotaFragment;
import omninos.com.xlinx.R;

public class SearchTrainsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private RecyclerView searchTrainCycle;
    private Button sort, Filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_search_trains);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds() {
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        searchTrainCycle = findViewById(R.id.searchTrainCycle);
        sort = findViewById(R.id.Sort);
        Filter = findViewById(R.id.Filter);
    }

    private void performActions() {
        bar_name.setText("Search");
        back.setOnClickListener(this);
        sort.setOnClickListener(this);
        Filter.setOnClickListener(this);
    }

    private void setAdapter() {
        SearchTrainAdapter searchTrainAdapter = new SearchTrainAdapter(this, new SearchTrainAdapter.ChangeQuota() {
            @Override
            public void Change(int position) {
                BottomSheetSearchTrainFragment bottomSheetSearchTrainFragment= new BottomSheetSearchTrainFragment();
                bottomSheetSearchTrainFragment.show(getSupportFragmentManager(),"Bottom Sheet");
            }
        });
        searchTrainCycle.setAdapter(searchTrainAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        searchTrainCycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;

            case R.id.Sort:
                BottomSheetSortFragment bottomSheetSortFragment= new BottomSheetSortFragment();
                bottomSheetSortFragment.show(getSupportFragmentManager(),"Bottom Sheet");
                break;

            case R.id.Filter:
                startActivity(new Intent(SearchTrainsActivity.this, FilterActivity.class));
                break;
        }
    }
}
