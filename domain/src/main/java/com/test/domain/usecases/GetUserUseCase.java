package com.test.domain.usecases;

import com.test.domain.entity.User;
import com.test.domain.executors.PostExecutionThread;
import com.test.domain.repositories.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserUseCase extends BaseUseCase {
    private UserRepository userRepository;

    @Inject
    public GetUserUseCase(UserRepository userRepository,
                          PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<User> getUser(String id) {
        return userRepository
                .getUser(id)
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
