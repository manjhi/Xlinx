package omninos.com.xlinx.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.MoviePagerAdapter;
import omninos.com.xlinx.R;

public class BookNowActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private TabLayout MovieTabLayout;
    private ViewPager MovieViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_book_now);

        intIds();
        performActions();

        MovieTabLayout = findViewById(R.id.MovieTabLayout);
        MovieViewPager = findViewById(R.id.MovieViewPager);
        MovieTabLayout.addTab(MovieTabLayout.newTab().setText("Show Times"));
        MovieTabLayout.addTab(MovieTabLayout.newTab().setText("Trailers and More"));

        MoviePagerAdapter adapter = new MoviePagerAdapter(getSupportFragmentManager(), MovieTabLayout.getTabCount());
        MovieViewPager.setAdapter(adapter);

        MovieViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(MovieTabLayout));

        MovieTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                MovieViewPager.setCurrentItem(tab.getPosition());
                Log.d("onTabSelected", String.valueOf(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void intIds() {
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
    }

    private void performActions() {
        bar_name.setText("Book Now");
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
