package com.test.presentation.screeens.user.list;

import android.test.com.testproject.databinding.ItemUserBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.test.domain.entity.User;
import com.test.presentation.base.recycler.BaseItemViewHolder;

public class UserItemViewHolder extends BaseItemViewHolder<User, UserItemViewModel, ItemUserBinding> {

    private UserItemViewHolder(UserItemViewModel viewModel, ItemUserBinding binding) {
        super(viewModel, binding);
    }

    public static UserItemViewHolder create(ViewGroup parent, UserItemViewModel viewModel) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return  new UserItemViewHolder(viewModel, binding);
    }
}
