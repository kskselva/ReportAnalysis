package com.report.services;

import com.report.model.InputMessage;
import com.report.utils.ExcelUtils;
import com.report.utils.ReportUtils;

public class ReportService {
	
	public static boolean generateExcel(String data) {
		
		 ReportUtils.saveJsonToFile(data);
		 InputMessage  message = ReportUtils.getObjectFromJson(data);
		 
		

		 try {
			ExcelUtils.writeInputMessageToFile("Report.xlsx", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}

}
