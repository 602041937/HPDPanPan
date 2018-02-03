package xin.huangpeidong.hpdsdk.hpd_mvp;

/**
 * Created by hpd on 2018/1/27.
 */

public interface BaseMVPViewInterface {

    public void showLoading();

    public void hideLoading();

    public void showFailError(String message);
}
