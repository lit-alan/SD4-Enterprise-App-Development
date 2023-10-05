package model;

import lombok.*;

/**
 *
 * @author Alan.Ryan
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Title {
    private String ISBN;
    private String title;
    private int editionNumber;
    private int yearPublished;
    private int publisherID;
    private double price;
}
