package v2.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemResponse {
    //Функция предназначена для обертки данных из БД и последующему взаимодействию с ними
    private Integer idSystem;
    private String system;

}
