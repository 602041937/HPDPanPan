package xin.huangpeidong.hpdsdk.hpd_mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import xin.huangpeidong.hpdsdk.hpd_base.HPDBaseActivity;


/**
 * Created by hpd on 2018/1/29.
 */

public class BaseMVPActivity<P extends BaseMVPPresenterImp<V>, V extends BaseMVPViewInterface> extends HPDBaseActivity implements BaseMVPViewInterface, LoaderManager.LoaderCallbacks<P> {

    public final static int BASE_LOADER_ID = 100;
    protected ProgressDialog progressDialog;
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "hpdhpd11 BaseMVPActivity onCreate");
        progressDialog = new ProgressDialog(this);
        getSupportLoaderManager().initLoader(BASE_LOADER_ID, null, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "hpdhpd11 BaseMVPActivity onStart");
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }



    @Override

    protected void onDestroy() {
        Log.i(TAG, "hpdhpd11 BaseMVPActivity onDestroy");
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public Loader<P> onCreateLoader(int id, Bundle args) {

        return null;
    }

    @Override
    public void onLoadFinished(Loader<P> loader, P data) {
        Log.i(TAG, "hpdhpd11 BaseMVPActivity onLoadFinished");
        presenter = data;
    }

    @Override
    public void onLoaderReset(Loader<P> loader) {
        Log.i(TAG, "hpdhpd11 BaseMVPActivity onLoaderReset");
        presenter = null;
    }
}
