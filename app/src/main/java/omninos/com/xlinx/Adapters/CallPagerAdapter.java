package omninos.com.xlinx.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import omninos.com.xlinx.Fragments.VideoCallFragment;
import omninos.com.xlinx.Fragments.VoiceCallFragment;

public class CallPagerAdapter extends FragmentStatePagerAdapter {
    int NoOfTabs;

    public CallPagerAdapter(FragmentManager fm, int noOfTabs) {
        super(fm);
        NoOfTabs = noOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                VoiceCallFragment voiceCallFragment= new VoiceCallFragment();
                return voiceCallFragment;

            case 1:
                VideoCallFragment videoCallFragment= new VideoCallFragment();
                return videoCallFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NoOfTabs;
    }
}
