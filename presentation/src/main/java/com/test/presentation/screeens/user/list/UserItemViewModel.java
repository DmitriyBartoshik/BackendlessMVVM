package com.test.presentation.screeens.user.list;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.test.domain.entity.User;
import com.test.presentation.base.recycler.BaseItemViewModel;
import com.test.presentation.base.recycler.ClickedItemModel;

import io.reactivex.subjects.PublishSubject;

public class UserItemViewModel extends BaseItemViewModel<User> {
    public ObservableField<String> name = new ObservableField<String>("");
    public ObservableField<String> surname = new ObservableField<String>("");
    public ObservableField<String> age = new ObservableField<String>("");
    public ObservableField<Boolean> degree = new ObservableField<Boolean>(false);
    public ObservableField<String> imageUrl = new ObservableField<String>("");

    private int position = 0;
    private User user;


    @Override
    public void setItem(User user, int position) {
        this.user = user;
        this.position = position;

        name.set(user.getName());
        surname.set(user.getSurname());
        age.set("" + user.getAge());
        degree.set(user.isDegree());
        imageUrl.set(user.getImageUrl());
    }
    @BindingAdapter(value = "imageUrl", requireAll = false)
    public static void setImageUrl(ImageView imageView, String url) {
        Picasso.get().load(url).into(imageView);
    }
}
