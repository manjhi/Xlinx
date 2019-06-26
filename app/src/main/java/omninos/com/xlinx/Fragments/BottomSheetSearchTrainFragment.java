package omninos.com.xlinx.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomSheetSearchTrainFragment extends BottomSheetDialogFragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    List<String> tabnames = new ArrayList<>();
    FragmentManager fm;
    private MyAdapter adapter;

    public BottomSheetSearchTrainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_search_train, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.TabLayout);

        fm = getChildFragmentManager();

        adapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabnames.add("Sleeper Class");
        tabnames.add("AC 3 Tier");
        tabnames.add("AC 2 Tier");
        tabnames.add("First Class");
        adapter.notifyDataSetChanged();

//        for(int i=0; i <tabnames.size(); i++)
//        {
//            tabLayout.addTab(tabLayout.newTab().setText(tabnames.get(i)));
//        }

        return view;

    }

    private void addTabPage(String string) {

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            ChangeQuotaFragment fragment = new ChangeQuotaFragment();
            return fragment;
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
