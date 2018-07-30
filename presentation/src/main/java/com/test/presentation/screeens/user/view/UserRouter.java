package com.test.presentation.screeens.user.view;

import android.content.Intent;

import com.test.presentation.base.BaseRouter;
import com.test.presentation.screeens.user.edit.UserEditActivity;
import com.test.presentation.screeens.user.list.UserListActivity;

public class UserRouter extends BaseRouter<UserActivity> {
    public UserRouter(UserActivity activity) {
        super(activity);
    }

    public void goToUserEdit(String userId) {
        Intent intent = UserEditActivity.getIntent(activity, userId);
        activity.startActivity(intent);
    }

    public void goToUserList(){
        Intent intent=UserListActivity.getIntent(activity);
        activity.startActivity(intent);
    }
}
