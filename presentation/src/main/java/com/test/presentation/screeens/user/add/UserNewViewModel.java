package com.test.presentation.screeens.user.add;

import android.databinding.ObservableField;

import com.squareup.picasso.Picasso;
import com.test.app.App;
import com.test.domain.entity.User;
import com.test.domain.usecases.GetUserNewUseCase;
import com.test.presentation.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public class UserNewViewModel extends BaseViewModel<UserNewRouter> {
    public ObservableField<String> name = new ObservableField<String>();
    public ObservableField<String> surname = new ObservableField<String>();
    public ObservableField<String> age = new ObservableField<String>();
    public ObservableField<Boolean> degree = new ObservableField<Boolean>();
    public ObservableField<String> imageUrl = new ObservableField<String>();

    @Inject
    GetUserNewUseCase userNewUseCase;

    @Override
    protected void runInject() {
        App.getAppComponent().runInject(this);
    }

    public User getNewUser() {
        User user = new User();
        user.setName(this.name.get());
        user.setSurname(this.surname.get());
        if (this.age.get() != null) user.setAge(Integer.parseInt(this.age.get()));
        if (this.degree.get() != null) user.setDegree(this.degree.get());
        user.setImageUrl(this.imageUrl.get());
        return user;
    }

    public void saveButtonOnClick() {
        User user = getNewUser();
        userNewUseCase.addUser(user).subscribe(new CompletableObserver() {
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

    public void cancelButtonOnClick() {
        router.goToUserList();
    }
}
