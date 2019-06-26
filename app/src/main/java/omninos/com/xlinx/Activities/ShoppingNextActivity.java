package omninos.com.xlinx.Activities;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import omninos.com.xlinx.Adapters.WesterWearAdapter;
import omninos.com.xlinx.Fragments.BankTransfer;
import omninos.com.xlinx.Fragments.BottomSheetShoppingFilter;
import omninos.com.xlinx.Fragments.BottomSheetSortFragment;
import omninos.com.xlinx.Fragments.WesternWearFragment;
import omninos.com.xlinx.R;

public class ShoppingNextActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private TabLayout shoppingTabLayout;
    private ViewPager shoppingViewPager;
    private FloatingActionButton ShoppingFilter;
    //    private List<String> tabItems = new ArrayList<>();
//    FragmentManager fragmentManager;
    List<String> tabnames = new ArrayList<>();
    FragmentManager fm;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_shopping_next);

        intIds();
        performActions();
    }

    private void intIds() {
        bar_name = findViewById(R.id.bar_name);
        shoppingTabLayout = findViewById(R.id.shoppingTabLayout);
        shoppingViewPager = findViewById(R.id.shoppingViewPager);
        ShoppingFilter = findViewById(R.id.ShoppingFilter);
        back = findViewById(R.id.back);

        fm = getSupportFragmentManager();

        adapter = new MyAdapter(getSupportFragmentManager());
        shoppingViewPager.setAdapter(adapter);
        shoppingTabLayout.setupWithViewPager(shoppingViewPager);

//        for (int i = 0; i < 10; i++) {
//            tabnames.add(String.valueOf(i));
//            adapter.notifyDataSetChanged();
//
//        }
        tabnames.add("Western Wear");
        tabnames.add("Jewellery");
        tabnames.add("Accessories");
        tabnames.add("Bags");
        adapter.notifyDataSetChanged();
//        for (String string : tabnames) {
//            shoppingTabLayout.addTab(shoppingTabLayout.newTab().setText(string));
////            addTabPage(string);
//        }


////        tabItems.add("First");
////        tabItems.add("Second");
////        tabItems.add("Third");
////        tabItems.add("Foutpoholo");
////        tabItems.add("l;;;p.kl,k");
//        shoppingTabLayout.addTab(shoppingTabLayout.newTab().setText("First"));
//
//        shoppingTabLayout.addTab(shoppingTabLayout.newTab().setText("second"));
//
//
//        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
//        shoppingViewPager.setAdapter(adapter);
//        shoppingTabLayout.setupWithViewPager(shoppingViewPager);


//        for (int i=0;i<10;i++){
//            tabItems.add(String.valueOf(i));
//            adapter.notifyDataSetChanged();
//        }

//        for (String s:tabItems){
//            shoppingTabLayout.addTab(shoppingTabLayout.newTab().setText(s));
//
//        }

    }

    private void performActions() {
        bar_name.setText("Woman's Wear");
        back.setOnClickListener(this);
        ShoppingFilter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;

            case R.id.ShoppingFilter:
                BottomSheetShoppingFilter bottomSheetShoppingFilter= new BottomSheetShoppingFilter();
                bottomSheetShoppingFilter.show(getSupportFragmentManager(),"Bottom Sheet");
                break;
        }
    }

//    class MyAdapter extends FragmentPagerAdapter {
//
//        public MyAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            WesternWearFragment fragment = new WesternWearFragment();
//            return fragment;
//        }
//
//        @Override
//        public int getCount() {
//            return 2;
//        }
//
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return tabItems.get(position);
//        }
//    }

    private void addTabPage(String string) {

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
//            switch (i){
//                case 0:
            WesternWearFragment fragment = new WesternWearFragment();
            return fragment;
//            }
//            return null;
        }

        @Override
        public int getCount() {

            return tabnames.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabnames.get(position);
        }
    }
}
