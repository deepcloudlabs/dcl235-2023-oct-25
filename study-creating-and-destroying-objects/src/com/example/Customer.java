package com.example;

import java.util.List;
import java.util.Objects;

public class Customer {

// Entity (DDD)
	private String customerNo;
	private String fullname;
	private String email;
	private String sms;
	private int birthYear;
	private byte[] photo;
	private List<String> addresses;

	private Customer(Builder builder) {
		this.customerNo = builder.customerNo;
		this.fullname = builder.fullname;
		this.email = builder.email;
		this.sms = builder.sms;
		this.birthYear = builder.birthYear;
		this.photo = builder.photo;
		this.addresses = builder.addresses;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public static class Builder {
		private String customerNo;
		private String fullname;
		private String email;
		private String sms;
		private int birthYear;
		private byte[] photo;
		private List<String> addresses;

		public Builder(String customerNo) {
			this.customerNo = customerNo;
		}

		public Builder fullname(String value) {
			Objects.requireNonNull(value);
			this.fullname = value;
			return this;
		}

		public Builder email(String value) {
			Objects.requireNonNull(value);
			this.email = value;
			return this;
		}

		public Builder sms(String value) {
			Objects.requireNonNull(value);
			this.sms = value;
			return this;
		}

		public Builder birthYear(int value) {
			if (value > 2006)
				throw new IllegalArgumentException("Birth year must be less than 2006");
			this.birthYear = value;
			return this;
		}

		public Builder photo(byte[] value) {
			Objects.requireNonNull(value);
			this.photo = value;
			return this;
		}

		public Builder addresses(String... values) {
			Objects.requireNonNull(values);
			this.addresses = List.of(values);
			return this;
		}

		public Customer build() {
			// composite validation
			// business rule
			Objects.requireNonNull(this.addresses);
			// pre-/post-conditions
			// invariants
			return new Customer(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerNo == null) ? 0 : customerNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerNo == null) {
			if (other.customerNo != null)
				return false;
		} else if (!customerNo.equals(other.customerNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerNo=" + customerNo + ", fullname=" + fullname + ", email=" + email + ", sms=" + sms
				+ ", birthYear=" + birthYear + ", addresses=" + addresses + "]";
	}

}
