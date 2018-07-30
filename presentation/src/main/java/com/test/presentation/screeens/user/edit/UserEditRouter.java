package com.test.presentation.screeens.user.edit;

import android.content.Intent;

import com.test.presentation.base.BaseRouter;
import com.test.presentation.screeens.user.list.UserListActivity;
import com.test.presentation.screeens.user.view.UserActivity;

public class UserEditRouter extends BaseRouter<UserEditActivity> {
    public UserEditRouter(UserEditActivity activity) {
        super(activity);
    }

    public void goToUserList() {
        Intent intent=UserListActivity.getIntent(activity);
        activity.startActivity(intent);
    }

    public void goToUserDetails(String userId) {
        Intent intent = UserActivity.getIntent(activity, userId);
        activity.startActivity(intent);
    }
}
