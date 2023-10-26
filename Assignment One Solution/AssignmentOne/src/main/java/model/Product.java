package model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "products", schema = "petopiaexpress", catalog = "")
public class Product implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<Review> reviewList;



}
