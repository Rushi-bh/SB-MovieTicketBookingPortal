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
@Table(name = "tier")
@Data
public class Tier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tier_id")
    private int tierId;

    @Column(name = "tier_name")
    private String tierName;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @Column(name = "ticket_price_multiplier")
    private int ticketPriceMultiplier;

	public int getTierId() {
		return tierId;
	}

	public void setTierId(int tierId) {
		this.tierId = tierId;
	}

	public String getTierName() {
		return tierName;
	}

	public void setTierName(String tierName) {
		this.tierName = tierName;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public int getTicketPriceMultiplier() {
		return ticketPriceMultiplier;
	}

	public void setTicketPriceMultiplier(int ticketPriceMultiplier) {
		this.ticketPriceMultiplier = ticketPriceMultiplier;
	}


}