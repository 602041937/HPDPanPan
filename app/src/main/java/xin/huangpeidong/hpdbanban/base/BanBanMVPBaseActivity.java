package xin.huangpeidong.hpdbanban.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import xin.huangpeidong.hpdsdk.hpd_mvp.BaseMVPActivity;
import xin.huangpeidong.hpdsdk.hpd_mvp.BaseMVPPresenterImp;
import xin.huangpeidong.hpdsdk.hpd_mvp.BaseMVPViewInterface;

/**
 * Created by hpd on 2018/2/1.
 */

public class BanBanMVPBaseActivity<P extends BaseMVPPresenterImp<V>, V extends BaseMVPViewInterface> extends BaseMVPActivity<P, V> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
