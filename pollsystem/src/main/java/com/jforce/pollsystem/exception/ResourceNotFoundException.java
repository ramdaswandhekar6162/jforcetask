package com.jforce.pollsystem.exception;




public class ResourceNotFoundException extends RuntimeException {
	
	
	String fieldid;
	String fieldName;
	
	public ResourceNotFoundException(long id, String fieldName) {
		// TODO Auto-generated constructor stub
		
		String.format("poll not found %s id %s", id,fieldName);
		
	}

	public String getFieldid() {
		return fieldid;
	}

	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
	
	
	
}
