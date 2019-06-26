package omninos.com.xlinx.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import omninos.com.xlinx.Fragments.ShowTimeFragment;

public class MoviePagerAdapter extends FragmentStatePagerAdapter {
    int NoOfTabs;

    public MoviePagerAdapter(FragmentManager fm, int noOfTabs) {
        super(fm);
        NoOfTabs = noOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                ShowTimeFragment fragment= new ShowTimeFragment();
                return fragment;

            case 1:
                ShowTimeFragment fragment1= new ShowTimeFragment();
                return fragment1;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NoOfTabs;
    }
}
