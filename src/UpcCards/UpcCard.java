package UpcCards;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class UpcCard{
    
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "The 'upc' parameter is required.")
    private String upc;

    @Column(name = "limit_name")
    private String limit;

    private String dateStart;
    private String dateEnd;
    private String method;
    private String channel;
}
