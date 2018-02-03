package xin.huangpeidong.hpdbanban.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xin.huangpeidong.hpdbanban.R;
import xin.huangpeidong.hpdbanban.base.BanBanMVPBaseActivity;
import xin.huangpeidong.hpdbanban.main.fragments.Tab1Fragment;
import xin.huangpeidong.hpdbanban.main.fragments.Tab2Fragment;
import xin.huangpeidong.hpdbanban.main.fragments.Tab3Fragment;
import xin.huangpeidong.hpdbanban.main.fragments.Tab4Fragment;
import xin.huangpeidong.hpdbanban.test.TestFragment;
import xin.huangpeidong.hpdsdk.adapter.CommonPagerAdapter;
import xin.huangpeidong.hpdsdk.adapter.CommonPagerStateAdapter;

public class MainActivity extends BanBanMVPBaseActivity {

    @Bind(R.id.activity_main_view_pager)
    ViewPager activityMainViewPager;
    @Bind(R.id.activity_main_iv_tab1)
    ImageView activityMainIvTab1;
    @Bind(R.id.activity_main_tv_tab1)
    TextView activityMainTvTab1;
    @Bind(R.id.activity_main_ll_tab1)
    LinearLayout activityMainLlTab1;
    @Bind(R.id.activity_main_iv_tab2)
    ImageView activityMainIvTab2;
    @Bind(R.id.activity_main_tv_tab2)
    TextView activityMainTvTab2;
    @Bind(R.id.activity_main_ll_tab2)
    LinearLayout activityMainLlTab2;
    @Bind(R.id.activity_main_iv_tab3)
    ImageView activityMainIvTab3;
    @Bind(R.id.activity_main_tv_tab3)
    TextView activityMainTvTab3;
    @Bind(R.id.activity_main_ll_tab3)
    LinearLayout activityMainLlTab3;
    @Bind(R.id.activity_main_iv_tab4)
    ImageView activityMainIvTab4;
    @Bind(R.id.activity_main_tv_tab4)
    TextView activityMainTvTab4;
    @Bind(R.id.activity_main_ll_tab4)
    LinearLayout activityMainLlTab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Tab1Fragment());
        fragments.add(new Tab2Fragment());
        fragments.add(new Tab3Fragment());
        fragments.add(new Tab4Fragment());

        CommonPagerAdapter commonPagerAdapter = new CommonPagerAdapter(getSupportFragmentManager(), fragments);
        activityMainViewPager.setAdapter(commonPagerAdapter);
        activityMainViewPager.setOffscreenPageLimit(4);
        activityMainViewPager.setCurrentItem(0);

    }

    @OnClick({R.id.activity_main_ll_tab1, R.id.activity_main_ll_tab2, R.id.activity_main_ll_tab3, R.id.activity_main_ll_tab4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_main_ll_tab1:
                activityMainViewPager.setCurrentItem(0);
                break;
            case R.id.activity_main_ll_tab2:
                activityMainViewPager.setCurrentItem(1);
                break;
            case R.id.activity_main_ll_tab3:
                activityMainViewPager.setCurrentItem(2);
                break;
            case R.id.activity_main_ll_tab4:
                activityMainViewPager.setCurrentItem(3);
                break;
        }
    }

}
