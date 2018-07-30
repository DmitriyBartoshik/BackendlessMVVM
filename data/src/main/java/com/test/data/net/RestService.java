package com.test.data.net;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.data.entity.DeleteResponse;
import com.test.data.entity.HttpError;
import com.test.data.entity.UserRequest;
import com.test.data.entity.UserResponse;
import com.test.domain.entity.Error;
import com.test.domain.entity.ErrorType;

import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class RestService {

    private RestApi restApi;
    private Gson gson;
    private ErrorParserTransformer errorParserTransformer;

    @Inject
    public RestService() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttp = new OkHttpClient
                .Builder()
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        gson = new GsonBuilder()
                .create();

        this.restApi = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.backendless.com/8568161A-C4E4-525D-FFA8-5ABCFF42D200/77A15928-52A2-7EA4-FF1A-A2AAD831B400/")
                .client(okHttp)
                .build()
                .create(RestApi.class);

        errorParserTransformer = new ErrorParserTransformer(gson);
    }

    public Observable<List<UserResponse>> getAllUsers() {
        return restApi
                .getAllUsers()
                .compose(errorParserTransformer.<List<UserResponse>, HttpError>parseHttpError());
    }

    public Observable<UserResponse> getUser(String id) {
        return restApi
                .getUser(id)
                .compose(errorParserTransformer.<UserResponse, HttpError>parseHttpError());
    }

    public Completable updateUser(UserRequest user) {
        String id = user.getObjectId();
        return restApi
                .updateUser(user, id);
    }

    public Completable deleteUser(String id) {
        return restApi
                .deleteUser(id);
    }
    public Completable addUser(UserRequest user){
        return restApi.addUser(user);
    }
}
