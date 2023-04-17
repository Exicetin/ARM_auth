package v2.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import v2.Service.OrderService;
import v2.controllers.OrderController;
import v2.model.response.OrderResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//EMD230131 10
@RequiredArgsConstructor
public class NextOrderNumber {

    private final OrderService orderService;
    public String getLastOrderNumber(){

        String number;
        List<OrderResponse> ListOrder = orderService.findAll();

        OrderResponse or = ListOrder.get(ListOrder.size() - 1);
        number = or.getNumber();

        System.out.println(number);
        return number;
    }



    private String nextOrder(){
        String number  = getLastOrderNumber();
        if (number == null||number ==""){
            number = "0";
        }
        return number;
    }
    public String nextOrderNumber(String system){
        String counter = counter();
        String date = dateNow();
        return system + date + counter;
    }

    private String dateNow(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        return format.format(date);
    }
    private String counter(){
        String last = nextOrder();
        Integer i =0;
        String str = last.substring(6);
        Integer lastdate = Integer.parseInt(str);
        if (lastdate == null||lastdate == 0){
            lastdate = 0;
        }
        Integer nowdate = Integer.parseInt(dateNow());
        if(lastdate<nowdate){
            i = 1;
        }
        else {
            i = 1+ Integer.parseInt(last.substring(13));
        }
        String str1;
        if (i<10){
            str1 = "0"+ Integer.toString(i);
        }
        else{  str1 = Integer.toString(i);}
        return str1;
    }
}