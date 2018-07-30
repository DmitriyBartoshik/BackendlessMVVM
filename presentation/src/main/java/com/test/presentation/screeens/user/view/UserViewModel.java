package com.test.presentation.screeens.user.view;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.test.app.App;
import com.test.domain.entity.User;
import com.test.domain.usecases.GetUserDeleteUseCase;
import com.test.domain.usecases.GetUserUseCase;
import com.test.presentation.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserViewModel extends BaseViewModel<UserRouter> {
    public ObservableField<String> name = new ObservableField<String>();
    public ObservableField<String> surname = new ObservableField<String>();
    public ObservableField<String> age = new ObservableField<String>();
    public ObservableField<Boolean> degree = new ObservableField<Boolean>();
    public ObservableField<String> imageUrl = new ObservableField<String>();
    public String userId;

    @Inject
    public GetUserUseCase userUseCase;

    @Inject
    public GetUserDeleteUseCase userDeleteUseCase;

    @Override
    protected void runInject() {
        App.getAppComponent().runInject(this);
    }

    public UserViewModel() {
    }

    public void getUser(String id) {
        userUseCase.getUser(id)
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(User user) {
                        Log.d("AAA", "onNext User name " + user.getName());
                        userId = user.getObjectId();
                        name.set(user.getName());
                        surname.set(user.getSurname());
                        age.set("" + user.getAge());
                        degree.set(user.isDegree());
                        imageUrl.set(user.getImageUrl());
                        progressBar.set(new Integer(4));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("aaa", "Exeption" + e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void deleteUser(String id) {
        userDeleteUseCase
                .deleteUser(id)
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        router.goToUserList();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }

    @BindingAdapter(value = "imageUrl", requireAll = false)
    public static void setImageUrl(ImageView imageView, String url) {
        Picasso.get().load(url).into(imageView);
    }

    public void deleteButtonClick() {
        deleteUser(userId);
    }

    public void editButtonClick() {
        router.goToUserEdit(userId);
    }
}
