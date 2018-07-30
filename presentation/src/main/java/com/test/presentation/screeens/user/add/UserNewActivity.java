package com.test.presentation.screeens.user.add;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.com.testproject.R;
import android.test.com.testproject.databinding.ActivityUserNewBinding;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.test.presentation.base.BaseMvvmActivity;
import com.test.presentation.screeens.user.list.UserListRouter;
import com.test.presentation.screeens.user.list.UserListViewModel;
import com.test.presentation.screeens.user.view.UserActivity;

public class UserNewActivity extends BaseMvvmActivity<UserNewViewModel,
        ActivityUserNewBinding, UserNewRouter> {

    public static Intent getIntent(Activity activity) {
        Intent intent = new Intent(activity, UserNewActivity.class);
        return intent;
    }

    @Override
    protected UserNewViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserNewViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_user_new;
    }

    @Override
    protected UserNewRouter provideRouter() {
        return new UserNewRouter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.downloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = "https://randomuser.me/api/portraits/men/" + binding.imagePath.getText().toString() + ".jpg";
                Picasso.get().load(path).into(binding.userImage);
                viewModel.imageUrl.set(path);
            }
        });
    }
}
