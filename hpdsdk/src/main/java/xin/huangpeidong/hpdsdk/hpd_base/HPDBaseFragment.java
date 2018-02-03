package xin.huangpeidong.hpdsdk.hpd_base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HPDBaseFragment extends Fragment {


    public String TAG = "";

    public HPDBaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getActivity().getComponentName().getShortClassName();
    }
}
