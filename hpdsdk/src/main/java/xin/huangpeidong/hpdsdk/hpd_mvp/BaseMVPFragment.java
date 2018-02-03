package xin.huangpeidong.hpdsdk.hpd_mvp;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import xin.huangpeidong.hpdsdk.hpd_base.HPDBaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseMVPFragment<P extends BaseMVPPresenterImp<V>, V extends BaseMVPViewInterface> extends HPDBaseFragment implements BaseMVPViewInterface, LoaderManager.LoaderCallbacks<P> {


    public BaseMVPFragment() {
        // Required empty public constructor
    }

    public final static int BASE_LOADER_ID = 10;
    public ProgressDialog progressDialog;
    public P presenter;
    private volatile boolean isShowOnce = false;

    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "hpdhpd11 BaseMVPFragment onActivityCreated");
        getLoaderManager().initLoader(BASE_LOADER_ID, null, this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "hpdhpd11 BaseMVPFragment onCreate");
        progressDialog = new ProgressDialog(getContext());

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "hpdhpd11 BaseMVPFragment onStart");
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isShowOnce) {
            isShowOnce = true;
            MVPOnResumeDealOnce();
        }
    }


    /**
     * 在onResume中执行，只会执行一次。作用：为了确保presenter存在后，才能操作数据
     */
    public abstract void MVPOnResumeDealOnce();

    @Override
    public void onDestroy() {
        Log.i(TAG, "hpdhpd11 BaseMVPFragment onDestroy");
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {

        progressDialog.setMessage("showLoading");
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {

        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showFailError(String message) {
        if (TextUtils.isEmpty(message)) {
            message = "发生错误";
        }
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public Loader<P> onCreateLoader(int id, Bundle args) {

        return null;
    }

    @Override
    public void onLoadFinished(Loader<P> loader, P data) {
        Log.i(TAG, "hpdhpd11 BaseMVPFragment onLoadFinished");
        presenter = data;
    }

    @Override
    public void onLoaderReset(Loader<P> loader) {
        Log.i(TAG, "hpdhpd11 BaseMVPFragment onLoaderReset");
        presenter = null;
    }

}
