package xin.huangpeidong.hpdsdk.hpd_mvp.loader;

import android.content.Context;
import android.support.v4.content.Loader;
import android.util.Log;

import xin.huangpeidong.hpdsdk.hpd_mvp.BaseMVPPresenterImp;


public class PresenterLoader<T extends BaseMVPPresenterImp> extends Loader<T> {

    public static String TAG = "PresenterLoader";
    private final PresenterFactory<T> factory;
    private T presenter;


    public PresenterLoader(Context context, PresenterFactory factory) {
        super(context);
        this.factory = factory;
    }

    @Override
    protected void onStartLoading() {
        Log.i(TAG, "hpdhpd11 PresenterLoader onStartLoading");
        if (presenter != null) {
            // 如果已经有Presenter，就直接返回，其实不用这个方法也行，因为返回的是同一个对象
            //deliverResult(presenter)不会触发onLoadFinished。
            deliverResult(presenter);
            return;
        }
        // 如果没有，需要执行onForceLoad
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        Log.i(TAG, "hpdhpd11 PresenterLoader onForceLoad");
        // 通过工厂来实例化Presenter
        presenter = factory.create();
        // 返回Presenter
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        Log.i(TAG, "hpdhpd11 PresenterLoader onReset");
        presenter = null;
    }
}