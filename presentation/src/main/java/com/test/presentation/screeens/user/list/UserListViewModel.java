package com.test.presentation.screeens.user.list;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.test.app.App;
import com.test.domain.entity.User;
import com.test.domain.usecases.GetListUserUseCase;
import com.test.presentation.base.BaseViewModel;
import com.test.presentation.base.recycler.ClickedItemModel;
import com.test.presentation.base.recycler.UserListAdapter;


import java.util.List;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserListViewModel extends BaseViewModel<UserListRouter> {

    public UserListAdapter adapter = new UserListAdapter();


    @Inject
    public GetListUserUseCase listUserUseCase;

    @Override
    protected void runInject() {
        App.getAppComponent().runInject(this);
    }

    public UserListViewModel() {
        showProgressBar();

        getUserList();

        adapter.observeItemClick().subscribe(new Observer<ClickedItemModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ClickedItemModel clickedItemModel) {
                if (clickedItemModel.getEntity() instanceof User) {
                    router.goToUserDetails(((User) clickedItemModel.getEntity()).getObjectId());
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getUserList() {
        listUserUseCase
                .getUsers()
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(List<User> users) {
                        adapter.setItems(users);
                        dismissProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        router.showError(e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void addNewUser() {
        router.goToUserCreate();
    }
}


