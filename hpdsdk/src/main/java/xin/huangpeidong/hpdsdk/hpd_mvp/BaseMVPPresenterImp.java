package xin.huangpeidong.hpdsdk.hpd_mvp;

/**
 * Created by hpd on 2018/1/29.
 */

public class BaseMVPPresenterImp<V extends BaseMVPViewInterface> implements BaseMVPPresenterInterface<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public V getAttachView() {
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MVPViewNotAttachedException();
        }
    }

    public static class MVPViewNotAttachedException extends RuntimeException {
        public MVPViewNotAttachedException() {
            super("请先调用 attachView(view) 方法与View绑定");
        }
    }
}
