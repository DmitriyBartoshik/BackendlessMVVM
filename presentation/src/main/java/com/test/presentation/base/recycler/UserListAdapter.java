package com.test.presentation.base.recycler;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.test.domain.entity.User;
import com.test.presentation.screeens.user.list.UserItemViewHolder;
import com.test.presentation.screeens.user.list.UserItemViewModel;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class UserListAdapter extends BaseRecyclerViewAdapter<User, UserItemViewModel> {

    @NonNull
    @Override
    public UserItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return UserItemViewHolder.create(parent, new UserItemViewModel());
    }
}
