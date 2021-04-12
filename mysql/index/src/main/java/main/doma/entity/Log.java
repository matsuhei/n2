package main.doma.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Builder
@Data
@Entity
@Table(name = "log")
public class Log {
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
    Log() {}
}
