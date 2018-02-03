package xin.huangpeidong.hpdsdk.hpd_mvp.loader;


import xin.huangpeidong.hpdsdk.hpd_mvp.BaseMVPPresenterImp;

public interface PresenterFactory<T extends BaseMVPPresenterImp> {
    T create();
}