package com.test.domain.repositories;

import com.test.domain.entity.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface UserRepository {

    Observable<List<User>> getAll();

    Observable<User> getUser(String id);

    Completable update(User user);

    Completable delete(String id);

    Completable add(User user);
}
