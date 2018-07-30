package com.test.presentation.screeens.user.edit;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.com.testproject.R;
import android.test.com.testproject.databinding.ActivityUserEditBinding;
import android.view.View;
import android.widget.Button;

import com.test.presentation.base.BaseMvvmActivity;
import com.test.presentation.screeens.user.view.UserActivity;
import com.test.presentation.screeens.user.view.UserRouter;

public class UserEditActivity extends BaseMvvmActivity<UserEditViewModel,
        ActivityUserEditBinding, UserEditRouter> {
    private static final String USER_ID_EXTRA = "USER_ID_EXTRA";

    public static Intent getIntent(Activity activity, String userId) {
        Intent intent = new Intent(activity, UserEditActivity.class);
        intent.putExtra(USER_ID_EXTRA, userId);
        return intent;
    }
    @Override
    protected UserEditViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserEditViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_user_edit;
    }

    @Override
    protected UserEditRouter provideRouter() {
        return new UserEditRouter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        final String userId = bundle.getString("USER_ID_EXTRA");
        viewModel.getUser(userId);
    }
}

