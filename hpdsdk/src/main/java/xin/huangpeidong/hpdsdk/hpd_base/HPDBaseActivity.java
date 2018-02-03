package xin.huangpeidong.hpdsdk.hpd_base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hpd on 2018/1/26.
 */

public class HPDBaseActivity extends AppCompatActivity {

    public String TAG = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();

    }

    /**
     * 替换Frament到指定容器中
     *
     * @param fragmentContainerId 容器的id
     * @param fragment            需要替换的fragment
     */
    protected void replaceFragmentToContainer(@IdRes int fragmentContainerId, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(fragmentContainerId, fragment);
        fragmentTransaction.commit();
    }


}
