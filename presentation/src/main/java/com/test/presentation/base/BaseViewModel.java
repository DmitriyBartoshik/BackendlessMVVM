package com.test.presentation.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<R extends BaseRouter> extends ViewModel {

    private CompositeDisposable compositeDisposable;
    public ObservableField<Integer> progressBar= new ObservableField<>(0);

    protected R router;
    public void showProgressBar(){
        progressBar.set(0);
    }
    public void dismissProgressBar(){
        progressBar.set(4);
    }


    protected abstract void runInject();

    public BaseViewModel() {
        runInject();
    }

    public void addRouter(R router) {
        this.router = router;
    }

    public void removeRouter() {
        router = null;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public CompositeDisposable getCompositeDisposable() {
        if(compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }

        return compositeDisposable;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(compositeDisposable != null
                && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
