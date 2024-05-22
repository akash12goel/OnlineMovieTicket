package com.sapient.bookshowsmgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer extends Member {

	public Customer(String id, String name, String email, String phone) {
		super(id, name, email, phone);
	}

}