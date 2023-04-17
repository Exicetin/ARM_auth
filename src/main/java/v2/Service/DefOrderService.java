package v2.Service;


import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;
import v2.model.request.CreateOrderRequest;
import v2.model.response.OrderResponse;

import java.util.List;

public interface DefOrderService {

//    @NotNull
   List<OrderResponse> findAll();
    //реализовать поиск по номеру программ и номеру наряда и названии шаблона

    @NotNull
   OrderResponse findById(@NotNull Integer idOrder);




    @NotNull
    @Transactional
   OrderResponse create(@NotNull CreateOrderRequest request);

}


