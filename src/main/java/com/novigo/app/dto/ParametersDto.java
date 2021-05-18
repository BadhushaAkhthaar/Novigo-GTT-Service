package com.novigo.app.dto;

public class ParametersDto {
	private static final long serialVersionUID = 1L;
	
	private String PARAMNAME;
	private String PARAMINDEX;
	private String VALUE;
	public ParametersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParametersDto(String pARAMNAME, String pARAMINDEX, String vALUE) {
		super();
		PARAMNAME = pARAMNAME;
		PARAMINDEX = pARAMINDEX;
		VALUE = vALUE;
	}
	public String getPARAMNAME() {
		return PARAMNAME;
	}
	public void setPARAMNAME(String pARAMNAME) {
		PARAMNAME = pARAMNAME;
	}
	public String getPARAMINDEX() {
		return PARAMINDEX;
	}
	public void setPARAMINDEX(String pARAMINDEX) {
		PARAMINDEX = pARAMINDEX;
	}
	public String getVALUE() {
		return VALUE;
	}
	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}
	@Override
	public String toString() {
		return "ParametersDto [PARAMNAME=" + PARAMNAME + ", PARAMINDEX=" + PARAMINDEX + ", VALUE=" + VALUE + "]";
	}
	
	
}
