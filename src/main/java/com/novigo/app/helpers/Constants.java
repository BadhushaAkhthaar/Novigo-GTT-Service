package com.novigo.app.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Constants {

	public static HashMap<String, String> getDC40ElemCnst() {

		HashMap<String, String> dc40Elems = new HashMap<String, String>();
		dc40Elems.put("TABNAM", "EDI_DC40");
		dc40Elems.put("MANDT", "100");
		dc40Elems.put("DOCNUM", "0000000000010000");
		dc40Elems.put("DOCREL", "754");
		dc40Elems.put("STATUS", "30");
		dc40Elems.put("DIRECT", "1");
		dc40Elems.put("OUTMOD", "2");
		dc40Elems.put("IDOCTYP", "GTTMSG01");
		dc40Elems.put("MESTYP", "GTTMSG");
		dc40Elems.put("SNDPOR", "SAPXLS");
		dc40Elems.put("SNDPRT", "LS");
		dc40Elems.put("SNDPRN", "[APPLICATION-APPSYS]");
		dc40Elems.put("RCVPOR", "GTT_TPEV");
		dc40Elems.put("RCVPRT", "LS");
		dc40Elems.put("RCVPRN", "SAPGTT");
		dc40Elems.put("CREDAT", "[Current Date]");
		dc40Elems.put("CRETIM", "[Current Time]");

		return dc40Elems;

	}

	public static List<String> getAppObjCnst() {

		List<String> appObjList = new ArrayList<String>();

		appObjList.add("APPSYS");
		appObjList.add("APPOBJTYPE");
		appObjList.add("APPOBJID");

		return appObjList;
	}

	public static List<String> getParamsCnst() {

		List<String> paramList = new ArrayList<String>();

		paramList.add("PARAMNAME");
		paramList.add("PARAMINDEX");
		paramList.add("VALUE");

		return paramList;
	}
	
	public static List<String> getPlanEveCnst() {

		List<String> planEveList = new ArrayList<String>();

		planEveList.add("MILESTONENUM");
		planEveList.add("MILESTONE");
		planEveList.add("LOCTYPE");
		planEveList.add("LOCID1");
		planEveList.add("LOCID2");
		planEveList.add("MSG_EXP_DATETIME");
		planEveList.add("MSG_ER_EXP_DTIME");
		planEveList.add("MSG_LT_EXP_DTIME");
		planEveList.add("EVT_EXP_DATETIME");
		planEveList.add("EVT_ER_EXP_DTIME");
		planEveList.add("EVT_LT_EXP_DTIME");
		planEveList.add("EVT_EXP_TZONE");

		return planEveList;
	}
	
	public static List<String> getTrackIdCnst() {

		List<String> trackIdList = new ArrayList<String>();

		trackIdList.add("TRXCOD");
		trackIdList.add("TRXID");
		trackIdList.add("START_DATE");
		trackIdList.add("END_DATE");
		trackIdList.add("TIMZON");

		return trackIdList;
	}
}
