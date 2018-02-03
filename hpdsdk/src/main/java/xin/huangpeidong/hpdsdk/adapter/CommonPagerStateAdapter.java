package xin.huangpeidong.hpdsdk.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by hpd on 2016/6/3.
 * ViewPager的fragments适配器，fragment会销毁,走到onDetach
 */
public class CommonPagerStateAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public CommonPagerStateAdapter(FragmentManager fm, List<Fragment> fragments) {
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
