package xin.huangpeidong.hpdsdk.hpd_mvp;

/**
 * Created by hpd on 2018/1/29.
 */

public interface BaseMVPPresenterInterface<V extends BaseMVPViewInterface> {

    public void attachView(V view);

    public void detachView();
}
