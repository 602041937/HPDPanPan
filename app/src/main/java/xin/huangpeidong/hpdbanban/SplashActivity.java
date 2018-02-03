package xin.huangpeidong.hpdbanban;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xin.huangpeidong.hpdbanban.base.BanBanMVPBaseActivity;
import xin.huangpeidong.hpdbanban.main.MainActivity;
import xin.huangpeidong.hpdsdk.log.LogUtils;

public class SplashActivity extends BanBanMVPBaseActivity {

    @Bind(R.id.btn_enter)
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_enter)
    public void onViewClicked() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
