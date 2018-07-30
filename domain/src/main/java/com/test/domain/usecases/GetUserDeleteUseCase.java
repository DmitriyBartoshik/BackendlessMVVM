package com.test.domain.usecases;

import com.test.domain.entity.User;
import com.test.domain.executors.PostExecutionThread;
import com.test.domain.repositories.UserRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public class GetUserDeleteUseCase extends BaseUseCase {
    private UserRepository userRepository;

    @Inject
    public GetUserDeleteUseCase(UserRepository userRepository,
                                PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Completable deleteUser(String id) {
        return userRepository.delete(id).subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
