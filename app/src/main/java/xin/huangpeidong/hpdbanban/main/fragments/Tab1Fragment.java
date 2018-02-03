package xin.huangpeidong.hpdbanban.main.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import xin.huangpeidong.hpdbanban.R;
import xin.huangpeidong.hpdbanban.base.BanBanMVPBaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends BanBanMVPBaseFragment {

    @Bind(R.id.fragment_tab1_tv)
    TextView fragmentTab1Tv;

    public Tab1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void MVPOnResumeDealOnce() {
        initData(getUserVisibleHint());
    }

    /**
     * Fragment的懒加载,通过setUserVisibleHint()和isLazyFragmentLoad和onResume()来控制
     * 注意：
     * 1.第一个Fragment不应该懒加载，即不要实现setUserVisibleHint()
     * 2.当用户锁屏后再开启，所有的Fragment都执行了，所以需要跟onResume一直判断，即再MVPOnResumeDealOnce（）中
     *
     * @param isVisibleToUser
     */
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        initData(isVisibleToUser);
//    }
    private void initData(boolean isVisibleToUser) {
        if (!isLazyFragmentLoad && isVisibleToUser) {
            isLazyFragmentLoad = true;
            showFailError("Tab1Fragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
