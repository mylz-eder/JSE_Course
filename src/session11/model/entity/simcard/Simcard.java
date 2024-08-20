package session11.model.entity.simcard;


import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor

public class Simcard {
private int id;
private long phoneNumber;
private String name, company, plan;
private LocalDate purchaseDate = LocalDate.now();
    @Override
    public String toString() {return new Gson().toJson( this);
    }
}
