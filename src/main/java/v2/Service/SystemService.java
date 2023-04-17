package v2.Service;

import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;
import v2.model.request.CreateSystemRequest;
import v2.model.response.SystemResponse;

import java.util.List;

public interface SystemService {
    @NotNull
    List<SystemResponse> findAll();

    @NotNull
    @Transactional
    SystemResponse create(@NotNull CreateSystemRequest request);

    void delete(@NotNull Integer idSystem);
}
