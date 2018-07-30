package com.test.data.net;

import com.test.data.entity.DeleteResponse;
import com.test.data.entity.UserRequest;
import com.test.data.entity.UserResponse;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestApi {

    @GET("data/Friends")
    Observable<List<UserResponse>> getAllUsers();

    @GET("data/Friends/{id}")
    Observable<UserResponse> getUser(@Path("id") String id);

    @PUT("data/Friends/{id}")
    Completable updateUser( @Body UserRequest user,@Path("id") String id);

    @DELETE("data/Friends/{id}")
    Completable deleteUser(@Path("id") String id);

    @PUT("data/Friends")
    Completable addUser(@Body UserRequest user);
}
