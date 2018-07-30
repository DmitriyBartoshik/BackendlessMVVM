package com.test.presentation.screeens.user.list;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.test.com.testproject.R;
import android.test.com.testproject.databinding.ActivityUserListBinding;
import android.util.Log;
import android.view.View;

import com.test.domain.entity.User;
import com.test.presentation.base.BaseMvvmActivity;
import com.test.presentation.base.BaseRouter;
import com.test.presentation.screeens.user.view.UserActivity;

public class UserListActivity extends BaseMvvmActivity<UserListViewModel,
        ActivityUserListBinding, UserListRouter>  {
    private static final String USER_ID_EXTRA = "USER_ID_EXTRA";

    public static Intent getIntent(Activity activity) {
        Intent intent = new Intent(activity, UserListActivity.class);
        return intent;
    }

    @Override
    protected UserListViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserListViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_user_list;
    }

    @Override
    protected UserListRouter provideRouter() {
        return new UserListRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        настройка адаптера;
        binding.userList.setAdapter(viewModel.adapter);
        binding.userList.setLayoutManager(new LinearLayoutManager(this));
        binding.userList.setHasFixedSize(true);
    }
}
