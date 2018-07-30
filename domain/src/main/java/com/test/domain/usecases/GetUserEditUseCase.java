package com.test.domain.usecases;

import android.util.Log;

import com.test.domain.entity.User;
import com.test.domain.executors.PostExecutionThread;
import com.test.domain.repositories.UserRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public class GetUserEditUseCase extends BaseUseCase {
    private UserRepository userRepository;

    @Inject
    public GetUserEditUseCase(UserRepository userRepository,
                              PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Completable updateUser(User user) {
        return userRepository.update(user).subscribeOn(executionThread)
                .observeOn(postExecutionThread);
//                .subscribe(new CompletableObserver() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                });

//       return userRepository
//                .update(user)
//                .subscribeOn(executionThread)
//                .observeOn(postExecutionThread)
//

    }
}
