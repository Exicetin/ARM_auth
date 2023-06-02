package v2.Service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v2.domain.Orders;
import v2.domain.System;
import v2.model.request.CreateSystemRequest;
import v2.model.response.OrderResponse;
import v2.model.response.SystemResponse;
import v2.repository.OrderRepository;
import v2.repository.SystemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SystemServiceImpl implements SystemService {

    private final SystemRepository systemRepository;

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<SystemResponse> findAll() {
        return systemRepository.findAll()
                .stream()
                .map(this::buildSystemResponse)
                .collect(Collectors.toList());

    }

    @NotNull
    private SystemResponse buildSystemResponse(@NotNull System system) {
        return SystemResponse.builder()
                .idSystem(system.getIdSystem())//так же со всеми полями
                .system(system.getSystem()).build();
    }

    @NotNull
    private System buildSystemRequest(@NotNull CreateSystemRequest request) {
        return System.builder()
                .idSystem(request.getIdSystem())
                .system(request.getSystem()).build();
    }

    @Override
    public @NotNull SystemResponse create(@NotNull CreateSystemRequest request) {
        System system = buildSystemRequest(request);
        java.lang.System.out.println(system);
        /// System.out.println(request);
        System sys = systemRepository.save(system);
        SystemResponse systemResponse = buildSystemResponse(sys);
        return systemResponse;
    }

    @Override
    @Transactional
    public void delete(@NotNull Integer IdSystem) {
        systemRepository.deleteById(IdSystem);

    }

}
