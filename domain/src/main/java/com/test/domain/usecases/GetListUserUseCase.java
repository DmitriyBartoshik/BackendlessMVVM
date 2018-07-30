package com.test.domain.usecases;

import com.test.domain.entity.User;
import com.test.domain.executors.PostExecutionThread;
import com.test.domain.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetListUserUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public GetListUserUseCase(UserRepository userRepository,
                              PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<List<User>> getUsers() {
        return userRepository
                .getAll()
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
