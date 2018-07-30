package com.test.presentation.screeens.user.list;

import android.content.Context;
import android.content.Intent;
import android.test.com.testproject.R;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.test.presentation.base.BaseRouter;
import com.test.presentation.screeens.user.add.UserNewActivity;
import com.test.presentation.screeens.user.view.UserActivity;
import com.test.presentation.screeens.user.view.UserRouter;
import com.test.presentation.screeens.user.view.UserViewModel;

public class UserListRouter extends BaseRouter<UserListActivity> {

    public UserListRouter(UserListActivity activity) {
        super(activity);
    }

    public void goToUserDetails(String userId) {
        Intent intent = UserActivity.getIntent(activity, userId);
        activity.startActivity(intent);
    }

    public void goToUserCreate() {
        Intent intent = UserNewActivity.getIntent(activity);
        activity.startActivity(intent);
    }
}
