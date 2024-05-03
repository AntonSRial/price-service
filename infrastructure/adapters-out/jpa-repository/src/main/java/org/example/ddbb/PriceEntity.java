package org.example.ddbb;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "price")
@Getter
@Setter
public class PriceEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8953615786709346205L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String brandId;

    private Date startDate;

    private Date enDate;

    private String priceList;

    private String productId;

    private double price;

    private String curr;

}
