package com.ui.pojo;

public class CreateJobPOJO {

	private String oemName;
	private String modelName;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmailAddress;
	private String customerContactNumber;

	

	public String getCustomerContactNumber() {
		return customerContactNumber;
	}

	public void setCustomerContactNumber(String customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}

	public CreateJobPOJO(String oemName, String modelName, String customerFirstName, String customerLastName,
			String customerEmailAddress, String customerContactNumber) {
		super();
		this.oemName = oemName;
		this.modelName = modelName;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmailAddress = customerEmailAddress;
		this.customerContactNumber = customerContactNumber;
	}

	public String getOemName() {
		return oemName;
	}

	public void setOemName(String oemName) {
		this.oemName = oemName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmailAddress() {
		return customerEmailAddress;
	}

	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress = customerEmailAddress;
	}

	@Override
	public String toString() {
		return "CreateJobPOJO [oemName=" + oemName + ", modelName=" + modelName + ", customerFirstName="
				+ customerFirstName + ", customerLastName=" + customerLastName + ", customerEmailAddress="
				+ customerEmailAddress + "]";
	}

}
