package com.test.data.repositories;

import android.util.Log;

import com.test.data.entity.UserRequest;
import com.test.data.entity.UserResponse;
import com.test.data.net.RestService;
import com.test.domain.entity.User;
import com.test.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class UserRepositoryImpl implements UserRepository {

    private RestService restService;

    @Inject
    public UserRepositoryImpl(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Observable<List<User>> getAll() {
        return restService
                .getAllUsers()
                .map(new Function<List<UserResponse>, List<User>>() {
                    @Override
                    public List<User> apply(List<UserResponse> userResponses) throws Exception {

                        final List<User> list = new ArrayList<>();
                        for (UserResponse user : userResponses) {
                            list.add(new User(user.getObjectId(), user.getName(),
                                    user.getSurname(), user.getAge(), user.isDegree(),
                                    user.getImageUrl()));
                        }
                        return list;
                    }
                });
    }

    @Override
    public Completable update(User user) {
        UserRequest userRequest = new UserRequest();
        userRequest.setObjectId(user.getObjectId());
        userRequest.setName(user.getName());
        userRequest.setSurname(user.getSurname());
        userRequest.setAge(user.getAge());
        userRequest.setDegree(user.isDegree());
       return restService.updateUser(userRequest);
    }

    @Override
    public Observable<User> getUser(String id) {
        return restService
                .getUser(id)
                .map(new Function<UserResponse, User>() {
                    @Override
                    public User apply(UserResponse userResponse) throws Exception {
                        User user = new User(userResponse.getObjectId(), userResponse.getName(),
                                userResponse.getSurname(), userResponse.getAge(), userResponse.isDegree(),
                                userResponse.getImageUrl());
                        return user;
                    }
                });

    }


    @Override
    public Completable delete(String id) {
        return restService.deleteUser(id);
    }

    @Override
    public Completable add(User user) {
        UserRequest userRequest = new UserRequest();
          userRequest.setName(user.getName());
            userRequest.setSurname(user.getSurname());
            userRequest.setAge(user.getAge());
            userRequest.setDegree(user.isDegree());
            userRequest.setImageUrl(user.getImageUrl());
        return restService.addUser(userRequest);
    }
}
