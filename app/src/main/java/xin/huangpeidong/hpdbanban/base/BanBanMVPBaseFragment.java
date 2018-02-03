package xin.huangpeidong.hpdbanban.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.view.View;

import butterknife.ButterKnife;
import xin.huangpeidong.hpdsdk.hpd_mvp.BaseMVPFragment;
import xin.huangpeidong.hpdsdk.hpd_mvp.BaseMVPPresenterImp;
import xin.huangpeidong.hpdsdk.hpd_mvp.BaseMVPViewInterface;

/**
 * Created by hpd on 2018/2/1.
 */

public abstract class BanBanMVPBaseFragment<P extends BaseMVPPresenterImp<V>, V extends BaseMVPViewInterface> extends BaseMVPFragment<P, V> {

    //用于懒加载，判断是否加载过
    protected boolean isLazyFragmentLoad = false;

}
