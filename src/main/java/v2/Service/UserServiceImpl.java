package v2.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v2.domain.UserV2;
import v2.model.request.CreateUserRequest;
import v2.model.response.UserResponse;
import v2.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::buildUserResponse)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public UserResponse findById(@NotNull Integer idUser) {
        return userRepository.findById(idUser)
                .map(this:: buildUserResponse)
                .orElseThrow(() -> new EntityNotFoundException("User " + idUser + " is not found"));
    }

    @NotNull
    @Override
    @Transactional
    public UserResponse create(CreateUserRequest request) {
        UserV2 user = buildUserRequest(request);
        System.out.println(user);
        UserV2 user1 = userRepository.save(user);
        return buildUserResponse(user1);
    }

    @NotNull
    @Override
    @Transactional
    public UserResponse update(@NotNull Integer IdUser, @NotNull CreateUserRequest request) {
        UserV2 user =  userRepository.findById(IdUser)
                .orElseThrow(() -> new EntityNotFoundException("User " + IdUser + " is not found"));
        UserV2 cv = buildUserRequest(request);
        return buildUserResponse(userRepository.save(cv));
    }


    //Удаляем пользователя по id
    @Override
    @Transactional
    public void delete(@NotNull Integer IdUser) {

        userRepository.deleteById(IdUser);
    }


    @NotNull
    private UserResponse buildUserResponse(@NotNull UserV2 user) {
        return UserResponse.builder()
                .idUser(user.getIdUser())//так же со всеми полями
                .login(user.getLogin())
                .password(user.getPassword())
                .role(user.getRole())
                .dateCreate(user.getDateCreate())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .middleName(user.getMiddleName())
                .phone(user.getPhone())
                .mail(user.getMail()).build();
    }

    @NotNull
    private UserV2 buildUserRequest(@NotNull CreateUserRequest request) {
        return UserV2.builder()
                .idUser(request.getIdUser())
                .login(request.getLogin())
                .password(request.getPassword())
                .role(request.getRole())
                .dateCreate(request.getDateCreate())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .middleName(request.getMiddleName())
                .phone(request.getPhone())
                .mail(request.getMail())
                .build();
    }
}
