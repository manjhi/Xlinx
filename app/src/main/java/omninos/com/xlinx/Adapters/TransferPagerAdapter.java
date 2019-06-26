package omninos.com.xlinx.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import omninos.com.xlinx.Fragments.BankTransfer;
import omninos.com.xlinx.Fragments.TransferBetweenUsers;

public class TransferPagerAdapter extends FragmentPagerAdapter {
    int tabcount;

    public TransferPagerAdapter(FragmentManager fm, int tabcount) {
        super(fm);
        this.tabcount = tabcount;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                TransferBetweenUsers Fragment=new TransferBetweenUsers();
                return Fragment;
            case  1:
                BankTransfer Fragment1=new BankTransfer();
                return Fragment1;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
