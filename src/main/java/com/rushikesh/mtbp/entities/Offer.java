package com.rushikesh.mtbp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "offers")
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private int offerId;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private MovieShow show;

    @Column(name = "offer_details")
    private String offerDetails;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public MovieShow getShow() {
		return show;
	}

	public void setShow(MovieShow show) {
		this.show = show;
	}

	public String getOfferDetails() {
		return offerDetails;
	}

	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
	}

    // Getters and setters
    
}
