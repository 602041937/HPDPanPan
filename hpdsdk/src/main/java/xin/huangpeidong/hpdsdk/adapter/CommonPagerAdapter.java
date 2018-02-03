package xin.huangpeidong.hpdsdk.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hpd
 * on 2016/6/3.
 * ViewPager的fragments适配器，fragment不会销毁，只会走到onDestroyView
 */
public class CommonPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public CommonPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        int size = 0;
        if (fragments == null) {
            return size;
        }
        size = fragments.size();
        return size;
    }


}
