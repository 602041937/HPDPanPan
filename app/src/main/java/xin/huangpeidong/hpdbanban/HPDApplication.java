package xin.huangpeidong.hpdbanban;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

import xin.huangpeidong.hpdsdk.log.LogUtils;

/**
 * Created by hpd on 2018/2/1.
 */

public class HPDApplication extends Application {

    private static HPDApplication instance;

    public static HPDApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLeakCanary();
    }

    /**
     * 初始化检测内存泄漏工具 LeakCanary
     */
    private void initLeakCanary() {

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            LogUtils.i("HPDApplication", "isInAnalyzerProcess");
            return;
        }
        LeakCanary.install(this);
    }
}
