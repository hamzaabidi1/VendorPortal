package com.smartech.vendorportal.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity
@Table(name = "rfqs")
public class Rfq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rfqnum;
	private String siteid;
	private String description;
	private String status;
	private String requireddate;
	private String purchaseagent;
	private boolean statusofSend;
	@Temporal(TemporalType.DATE)
	private Date dateEnvoie;

	
	@OneToMany
	@JoinColumn(name = "rfq_id")
	List<RfqLine> rfqline;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Rfq(Long id, String rfqnum,String siteid, String description, String status, String requireddate, String purchaseagent,
			Date dateEnvoie,boolean statusofSend,User user,List<RfqLine> rfqline) {
		super();
		this.id = id;
		this.rfqnum = rfqnum;
		this.siteid=siteid;
		this.description = description;
		this.status = status;
		this.requireddate = requireddate;
		this.purchaseagent = purchaseagent;
		this.statusofSend=statusofSend;
		this.dateEnvoie=dateEnvoie;
		this.user = user;
		this.rfqline=rfqline;
		
	}

	public Rfq() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRfqnum() {
		return rfqnum;
	}

	public void setRfqnum(String rfqnum) {
		this.rfqnum = rfqnum;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequireddate() {
		return requireddate;
	}

	public void setRequireddate(String requireddate) {
		this.requireddate = requireddate;
	}

	public String getPurchaseagent() {
		return purchaseagent;
	}

	public void setPurchaseagent(String purchaseagent) {
		this.purchaseagent = purchaseagent;
	}

	public boolean isStatusofSend() {
		return statusofSend;
	}

	public void setStatusofSend(boolean statusofSend) {
		this.statusofSend = statusofSend;
	}

	public Date getDateEnvoie() {
		return dateEnvoie;
	}

	public void setDateEnvoie(Date dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}

	public List<RfqLine> getRfqline() {
		return rfqline;
	}

	public void setRfqline(List<RfqLine> rfqline) {
		this.rfqline = rfqline;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
