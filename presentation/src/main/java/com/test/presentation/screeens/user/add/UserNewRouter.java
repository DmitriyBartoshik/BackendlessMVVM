package com.test.presentation.screeens.user.add;

import android.content.Intent;

import com.test.presentation.base.BaseRouter;
import com.test.presentation.screeens.user.list.UserListActivity;

public class UserNewRouter extends BaseRouter<UserNewActivity> {
    public UserNewRouter(UserNewActivity activity) {
        super(activity);
    }


    public void goToUserList(){
        Intent intent=new Intent(activity,UserListActivity.class);
        activity.startActivity(intent);
    }
}
