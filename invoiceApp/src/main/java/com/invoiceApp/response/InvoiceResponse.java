package com.invoiceApp.response;

import java.util.Date;

public class InvoiceResponse {

	private String name;
	private Date date;
	private String customerName;

	public InvoiceResponse() {
	}

	public InvoiceResponse(String name, Date date, String customerName) {
		this.name = name;
		this.date = date;
		this.customerName = customerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
