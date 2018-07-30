package com.test.injection;

import com.test.presentation.screeens.user.add.UserNewViewModel;
import com.test.presentation.screeens.user.edit.UserEditViewModel;
import com.test.presentation.screeens.user.list.UserListViewModel;
import com.test.presentation.screeens.user.view.UserViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void runInject(UserListViewModel listViewModel);
    void runInject(UserViewModel userViewModel);
    void runInject(UserEditViewModel userEditViewModel);
    void runInject(UserNewViewModel userNewViewModel);

}