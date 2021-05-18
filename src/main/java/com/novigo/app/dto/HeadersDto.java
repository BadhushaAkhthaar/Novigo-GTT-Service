package com.novigo.app.dto;

public class HeadersDto {
	private static final long serialVersionUID = 1L;
	
	private String TABNAM;
	private String MANDT;
	private String DOCNUM;
	private String DOCREL;
	private String STATUS;
	private String DIRECT;
	private String OUTMOD;
	private String IDOCTYP;
	private String MESTYP;
	private String SNDPOR;
	private String SNDPRT;
	private String SNDPRN;
	private String RCVPOR;
	private String RCVPRT;
	private String RCVPRN;
	private String CREDAT;
	private String CRETIM;
	public HeadersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeadersDto(String tABNAM, String mANDT, String dOCNUM, String dOCREL, String sTATUS, String dIRECT,
			String oUTMOD, String iDOCTYP, String mESTYP, String sNDPOR, String sNDPRT, String sNDPRN, String rCVPOR,
			String rCVPRT, String rCVPRN, String cREDAT, String cRETIM) {
		super();
		TABNAM = tABNAM;
		MANDT = mANDT;
		DOCNUM = dOCNUM;
		DOCREL = dOCREL;
		STATUS = sTATUS;
		DIRECT = dIRECT;
		OUTMOD = oUTMOD;
		IDOCTYP = iDOCTYP;
		MESTYP = mESTYP;
		SNDPOR = sNDPOR;
		SNDPRT = sNDPRT;
		SNDPRN = sNDPRN;
		RCVPOR = rCVPOR;
		RCVPRT = rCVPRT;
		RCVPRN = rCVPRN;
		CREDAT = cREDAT;
		CRETIM = cRETIM;
	}
	public String getTABNAM() {
		return TABNAM;
	}
	public void setTABNAM(String tABNAM) {
		TABNAM = tABNAM;
	}
	public String getMANDT() {
		return MANDT;
	}
	public void setMANDT(String mANDT) {
		MANDT = mANDT;
	}
	public String getDOCNUM() {
		return DOCNUM;
	}
	public void setDOCNUM(String dOCNUM) {
		DOCNUM = dOCNUM;
	}
	public String getDOCREL() {
		return DOCREL;
	}
	public void setDOCREL(String dOCREL) {
		DOCREL = dOCREL;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getDIRECT() {
		return DIRECT;
	}
	public void setDIRECT(String dIRECT) {
		DIRECT = dIRECT;
	}
	public String getOUTMOD() {
		return OUTMOD;
	}
	public void setOUTMOD(String oUTMOD) {
		OUTMOD = oUTMOD;
	}
	public String getIDOCTYP() {
		return IDOCTYP;
	}
	public void setIDOCTYP(String iDOCTYP) {
		IDOCTYP = iDOCTYP;
	}
	public String getMESTYP() {
		return MESTYP;
	}
	public void setMESTYP(String mESTYP) {
		MESTYP = mESTYP;
	}
	public String getSNDPOR() {
		return SNDPOR;
	}
	public void setSNDPOR(String sNDPOR) {
		SNDPOR = sNDPOR;
	}
	public String getSNDPRT() {
		return SNDPRT;
	}
	public void setSNDPRT(String sNDPRT) {
		SNDPRT = sNDPRT;
	}
	public String getSNDPRN() {
		return SNDPRN;
	}
	public void setSNDPRN(String sNDPRN) {
		SNDPRN = sNDPRN;
	}
	public String getRCVPOR() {
		return RCVPOR;
	}
	public void setRCVPOR(String rCVPOR) {
		RCVPOR = rCVPOR;
	}
	public String getRCVPRT() {
		return RCVPRT;
	}
	public void setRCVPRT(String rCVPRT) {
		RCVPRT = rCVPRT;
	}
	public String getRCVPRN() {
		return RCVPRN;
	}
	public void setRCVPRN(String rCVPRN) {
		RCVPRN = rCVPRN;
	}
	public String getCREDAT() {
		return CREDAT;
	}
	public void setCREDAT(String cREDAT) {
		CREDAT = cREDAT;
	}
	public String getCRETIM() {
		return CRETIM;
	}
	public void setCRETIM(String cRETIM) {
		CRETIM = cRETIM;
	}
	@Override
	public String toString() {
		return "HeadersDto [TABNAM=" + TABNAM + ", MANDT=" + MANDT + ", DOCNUM=" + DOCNUM + ", DOCREL=" + DOCREL
				+ ", STATUS=" + STATUS + ", DIRECT=" + DIRECT + ", OUTMOD=" + OUTMOD + ", IDOCTYP=" + IDOCTYP
				+ ", MESTYP=" + MESTYP + ", SNDPOR=" + SNDPOR + ", SNDPRT=" + SNDPRT + ", SNDPRN=" + SNDPRN
				+ ", RCVPOR=" + RCVPOR + ", RCVPRT=" + RCVPRT + ", RCVPRN=" + RCVPRN + ", CREDAT=" + CREDAT
				+ ", CRETIM=" + CRETIM + "]";
	}
	
	
}
