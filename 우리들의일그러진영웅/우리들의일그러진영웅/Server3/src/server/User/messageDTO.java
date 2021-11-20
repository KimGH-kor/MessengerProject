package server.User;

import java.util.Date;

public class messageDTO {
	private String CHATID;
	private String FROM_ID;
	private String MSG_TEXT;
	private String MSG_DATE;
	
	public messageDTO() {

	}
	
	public messageDTO(String cHATID, String fROM_ID, String mSG_TEXT) {
		CHATID = cHATID;
		FROM_ID = fROM_ID;
		MSG_TEXT = mSG_TEXT;
	}
	public String getCHATID() {
		return CHATID;
	}
	public void setCHATID(String cHATID) {
		CHATID = cHATID;
	}
	public String getFROM_ID() {
		return FROM_ID;
	}
	public void setFROM_ID(String fROM_ID) {
		FROM_ID = fROM_ID;
	}
	public String getMSG_TEXT() {
		return MSG_TEXT;
	}
	public void setMSG_TEXT(String mSG_TEXT) {
		MSG_TEXT = mSG_TEXT;
	}
	public String getMSG_DATE() {
		return MSG_DATE;
	}
	public void setMSG_DATE(String mSG_DATE) {
		MSG_DATE = mSG_DATE;
	}

	
}
