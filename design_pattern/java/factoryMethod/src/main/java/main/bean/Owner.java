package main.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Owner {
    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public int age;
}
