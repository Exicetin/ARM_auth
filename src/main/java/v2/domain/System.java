package v2.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "systems")
public class System {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_system",nullable = false)
    private Integer idSystem;

    @Column(name = "system")
    private String system;

    @Override
    public String toString() {
        return "Orders{" +
                "idSystem=" + idSystem +
                ", system=" + system +
                '}';

    }
    //Создаем связь OneToOne с нарядами
//    @OneToOne(optional = false)
//    @JoinColumn(name = "idOrder", nullable = false)
//    private Orders order;
//
//    public Orders getOrder() {
//        return order;
//    }
//
//    public void setOrder(Orders order) {
//        this.order = order;
//    }
}
