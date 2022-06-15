package com.smartech.vendorportal.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstname;
	private String lastname;
	private String userName;
	private String email;
	private String address;
	private String city;;
	private String region;
	private String postalcode;;
	private String country;
	private String phone;
	private Date dateEstablished;
	private String companywebsite;
	private String revenu;
	private String taxregistrationnumber;
	private String taxclassificationcode;
	private Boolean isVendor;
	private Boolean isAdmin;
	private EStatus status;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String firstName, String lastName, String userName, String email, String address,
			String city, String region, String postalcode, String country, String phone, Date dateEstablished,
			String webSite, String revenu, String taxRegistrationNumber, String taxClassificationCode, Boolean isVendor,
			Boolean isAdmin, EStatus status, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.firstname = firstName;
		this.lastname = lastName;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalcode = postalcode;
		this.country = country;
		this.phone = phone;
		this.dateEstablished = dateEstablished;
		this.companywebsite = webSite;
		this.revenu = revenu;
		this.taxregistrationnumber = taxRegistrationNumber;
		this.taxclassificationcode = taxClassificationCode;
		this.isVendor = isVendor;
		this.isAdmin = isAdmin;
		this.status = status;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		return new UserDetailsImpl(user.getId(), user.getFirstname(), user.getLastname(), user.getUsername(),
				user.getEmail(), user.getAddress(), user.getCity(), user.getRegion(), user.getPostalcode(),
				user.getCountry(), user.getPhone(), user.getDateEstablished(), user.getCompanywebsite(),
				user.getRevenu(), user.getTaxregistrationnumber(), user.getTaxclassificationcode(), user.isVendor(),
				user.isAdmin(), user.getStatus(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public String getAdresse() {
		return address;
	}

	public String getVille() {
		return city;
	}

	public String getDptProvinance() {
		return region;
	}

	public String getCodePostal() {
		return postalcode;
	}

	public String getPays() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public Boolean getIsVendor() {
		return isVendor;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public EStatus getStatus() {
		return status;
	}

	public String getUserName() {
		return userName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getRegion() {
		return region;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public String getCountry() {
		return country;
	}

	public Date getDateEstablished() {
		return dateEstablished;
	}

	public String getWebSite() {
		return companywebsite;
	}

	public String getRevenu() {
		return revenu;
	}

	public String getTaxRegistrationNumber() {
		return taxregistrationnumber;
	}

	public String getTaxClassificationCode() {
		return taxclassificationcode;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public String getUsername() {
		return userName;
	}

}
