package com.test.presentation.screeens.user.view;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.com.testproject.R;
import android.test.com.testproject.databinding.ActivityUserBinding;
import android.test.com.testproject.databinding.ActivityUserListBinding;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.test.presentation.base.BaseMvvmActivity;
import com.test.presentation.screeens.user.edit.UserEditActivity;
import com.test.presentation.screeens.user.list.UserListActivity;
import com.test.presentation.screeens.user.list.UserListRouter;
import com.test.presentation.screeens.user.list.UserListViewModel;

public class UserActivity extends BaseMvvmActivity<UserViewModel,
        ActivityUserBinding, UserRouter> {
    private static final String USER_ID_EXTRA = "USER_ID_EXTRA";

    public static Intent getIntent(Activity activity, String userId) {
        Intent intent = new Intent(activity, UserActivity.class);
        intent.putExtra(USER_ID_EXTRA, userId);
        return intent;
    }

    @Override
    protected UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected UserRouter provideRouter() {
        return new UserRouter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        final String userId = bundle.getString("USER_ID_EXTRA");
        viewModel.getUser(userId);
    }
}
