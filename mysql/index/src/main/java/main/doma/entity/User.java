package main.doma.entity;

import lombok.Builder;
import lombok.experimental.Tolerate;
import org.seasar.doma.*;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "parama")
    String parama;

    @Column(name = "paramb")
    String paramb;

    @Tolerate
    User() {}
}
