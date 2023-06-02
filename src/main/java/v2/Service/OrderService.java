package v2.Service;


import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;
import v2.domain.CardV2;
import v2.domain.Orders;
import v2.model.request.CreateCardRequest;
import v2.model.request.CreateOrderRequest;
import v2.model.response.CardResponse;
import v2.model.response.OrderResponse;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    //Технолог,программист,разраб наряда,Номер карты,Дата создания,дата корректировки
    @NotNull
    List<OrderResponse> findAll();

    //    @NotNull
//    List<OrderResponse> findByIdCard (Integer idCard);
//    @NotNull
//    List<OrderResponse> findByIdOtv (Integer id);
//    @NotNull
//    List<OrderResponse> findByIdProg (Integer id);
//    @NotNull
//    List<OrderResponse> findByNumber (Integer num);
//    @NotNull
//    List<OrderResponse> findByIdTehn (Integer id);
//    @NotNull
//    List<OrderResponse> findByDateCreate(Date date);
//    @NotNull
//    List<OrderResponse> findByDateCorr(Date date);
    @NotNull
    OrderResponse findById(@NotNull Integer idOrder);

    @NotNull
    OrderResponse update(@NotNull Integer idOrder, @NotNull CreateOrderRequest request);

    @NotNull
    @Transactional
    OrderResponse create(@NotNull CreateOrderRequest request);

    //Обновляем пользователя по id

    void delete(@NotNull Integer idOrder);

    List<Orders> search(String keyword);

    OrderResponse    findByUser(@NotNull Integer idOtv);
}
