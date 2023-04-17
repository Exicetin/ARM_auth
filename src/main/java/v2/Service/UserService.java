package v2.Service;

import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;
import v2.model.request.CreateOrderRequest;
import v2.model.request.CreateUserRequest;
import v2.model.response.OrderResponse;
import v2.model.response.UserResponse;

import java.util.List;

public interface UserService {
    @NotNull
    List<UserResponse> findAll();

    @NotNull
    UserResponse findById(@NotNull Integer idUser);

    @NotNull
    UserResponse update(@NotNull Integer idUser, @NotNull CreateUserRequest request);

    @NotNull
    @Transactional
    UserResponse create(@NotNull CreateUserRequest request);

    void delete(@NotNull Integer idUser);

}
