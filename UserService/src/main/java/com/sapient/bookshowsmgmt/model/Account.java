package com.sapient.bookshowsmgmt.model;

import com.sapient.bookshowsmgmt.constants.AccountStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Account {
	private String id;
	private String password;
	private AccountStatus status;

}