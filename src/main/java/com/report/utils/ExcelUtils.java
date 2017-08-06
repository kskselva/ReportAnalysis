package com.report.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.report.model.Activity;
import com.report.model.CustomerEngagement;
import com.report.model.InputMessage;

public class ExcelUtils {

	public static void writeInputMessageToFile(String fileName, InputMessage inputMessage) throws Exception {
		Workbook workbook = null;

		if (fileName.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		
		} else {
			throw new Exception("invalid file name, should be xls or xlsx");
		}

		Sheet sheet = workbook.createSheet("Report");
		
		sheet.setDefaultColumnWidth(50);


		 // Create a row and put some cells in it. Rows are 0 based.
	    Row row = sheet.createRow((short) 1);

	   

		int rownum = 0;

		// for Team and its name

		LinkedList<String> values = new LinkedList<String>();

		values.add("Team");

		values.add(inputMessage.getTeam());

		updateRow(sheet, values, rownum++, 0, 1);

		rownum++;

		// To update Highlights
		
		 // Orange background
	    CellStyle style = workbook.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    
	    
	    // Orange background
	    CellStyle style1 = workbook.createCellStyle();
	    style1.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
	    style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
	 
		updateRow(sheet, "Highlights", rownum++, 0, style);

		List<LinkedHashMap> highlightsList = inputMessage.getCategory().getHighlights();

		System.out.println("size"+highlightsList.size());

		for (LinkedHashMap<String,String> highlight : highlightsList) {
			
			for( String key : highlight.keySet() ){
				  String value = highlight.get(key);
				  
				  updateRow(sheet, value, rownum, 1);
				
				}

			 rownum++;
		}

		rownum++;

		// To update Customer Engagement
		updateRow(sheet, "Solution Support", rownum++, 0,style);

		LinkedList<String> CustomerEng = new LinkedList<String>();

		CustomerEng.add("Customer");

		CustomerEng.add("Owned by");

		CustomerEng.add("Bid Owner");

		CustomerEng.add("IT IS");

		CustomerEng.add("Geo");

		CustomerEng.add("Industry");
		CustomerEng.add("ISU Owner");

		CustomerEng.add("Action");

		updateRow(sheet, CustomerEng, rownum++,1, 1,style1);

		List<CustomerEngagement> solutionSupportList = inputMessage.getCategory().getSolutionSupport();

		for  (CustomerEngagement ce : solutionSupportList) {

			LinkedList<String> data = new LinkedList<String>();	
			
			data.add(ce.getCustomer());
			data.add(ce.getOwnedBy());
			data.add(ce.getBidOwner());
			data.add(ce.getITIS());
			data.add(ce.getGeo());
			data.add(ce.getIndustry());
			data.add(ce.getISUOwner());
			data.add(ce.getAction());
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}

		System.out.println(solutionSupportList);
		rownum++;

		// To update Proactive Engagement

		updateRow(sheet, "Proactive Engagement", rownum++, 0, style);
		updateRow(sheet, CustomerEng, rownum++,1, 1,style1);
		List<CustomerEngagement> proActiveEngagementList = inputMessage.getCategory().getProactiveEngagement();

		for  (CustomerEngagement ce : proActiveEngagementList) {

			LinkedList<String> data = new LinkedList<String>();	
			
			data.add(ce.getCustomer());
			data.add(ce.getOwnedBy());
			data.add(ce.getBidOwner());
			data.add(ce.getITIS());
			data.add(ce.getGeo());
			data.add(ce.getIndustry());
			data.add(ce.getISUOwner());
			data.add(ce.getAction());
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}

		
		rownum++;

		// To update Delivery Support

		updateRow(sheet, "Delivery Support", rownum++, 0,style);
		updateRow(sheet, CustomerEng, rownum++,1, 1,style1);
		
		List<CustomerEngagement> deliverySupportList = inputMessage.getCategory().getDeliverySupport();

		for  (CustomerEngagement ce : deliverySupportList) {

			LinkedList<String> data = new LinkedList<String>();	
			
			data.add(ce.getCustomer());
			data.add(ce.getOwnedBy());
			data.add(ce.getBidOwner());
			data.add(ce.getITIS());
			data.add(ce.getGeo());
			data.add(ce.getIndustry());
			data.add(ce.getISUOwner());
			data.add(ce.getAction());
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}

		
		
		rownum++;

		// For Lab Activity
		LinkedList<String> activity = new LinkedList<String>();

		activity.add("Activity Name");
		activity.add("Activity By");

		updateRow(sheet, "Lab Activities", rownum++, 0,style);
		updateRow(sheet, activity, rownum++,1, 1,style1);
		
		
		List<LinkedHashMap<String, String>> labActivity = inputMessage.getCategory().getLabActivities();

		for  (LinkedHashMap<String,String> ce : labActivity) {

			LinkedList<String> data = new LinkedList<String>();	
			
			System.out.println(" lab"+ce);
			
			for( String key : ce.keySet() ){
				  data.add(ce.get(key));
	
				}	
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}
		
		rownum++;

		// For POC
		LinkedList<String> pocActivity = new LinkedList<String>();

		pocActivity.add("Activity Name");
		pocActivity.add("Activity By");

		updateRow(sheet, "POC", rownum++, 0,style);
		updateRow(sheet, pocActivity, rownum++,1, 1,style1);
		
		
		List<LinkedHashMap<String, String>> pocList = inputMessage.getCategory().getPoC();

		for  (LinkedHashMap<String,String> ce : pocList) {

			LinkedList<String> data = new LinkedList<String>();	
			
			System.out.println(" lab"+ce);
			
			for( String key : ce.keySet() ){
				  data.add(ce.get(key));
	
				}
			
		//	data.add(ce.getActivityName());
		//	data.add(ce.getActivityBy());
			
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}
		
		
		
		rownum++;

		// To update Highlights

		updateRow(sheet, "CustomerVisit", rownum++, 0,style);

		List<LinkedHashMap> custVist = inputMessage.getCategory().getCustomerVisit();

		System.out.println(custVist);

	//	List<LinkedHashMap> highlightsList = inputMessage.getCategory().getHighlights();

		System.out.println("size"+custVist.size());

		for (LinkedHashMap<String,String> cust : custVist) {
			
			for( String key : cust.keySet() ){
				  String value = cust.get(key);
				  
				  updateRow(sheet, value, rownum, 1);
				
				}

			 rownum++;
		}

		rownum++;

		// For Internal Activity
		LinkedList<String> intActivity = new LinkedList<String>();

		intActivity.add("Activity Name");
		intActivity.add("Activity By");

		updateRow(sheet, "Internal Activities", rownum++, 0,style);
		updateRow(sheet, intActivity, rownum++, 1,1,style1);
		
		
		List<LinkedHashMap<String, String>> intAct = inputMessage.getCategory().getInternalActivities();

		for  (LinkedHashMap<String,String> ce : intAct) {

			LinkedList<String> data = new LinkedList<String>();	
			
			//System.out.println(" lab"+ce);
			
			for( String key : ce.keySet() ){
				  data.add(ce.get(key));
	
				}	
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}
		
		
		rownum++;

		// For Certification
		LinkedList<String> cert = new LinkedList<String>();

		cert.add("Certification Name");
		cert.add("Completed By");

		updateRow(sheet, "Certification", rownum++, 0,style);
		updateRow(sheet, cert, rownum++,1, 1,style1);
		
		List<LinkedHashMap<String, String>> certList = inputMessage.getCategory().getCertification();

		for  (LinkedHashMap<String,String> ce : certList) {

			LinkedList<String> data = new LinkedList<String>();	
			
			//System.out.println(" lab"+ce);
			
			for( String key : ce.keySet() ){
				  data.add(ce.get(key));
	
				}	
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}
		
		
		
		rownum++;

		// For TrainingConducted
		LinkedList<String> trainCond = new LinkedList<String>();

		trainCond.add("Traning");
		trainCond.add("Conducted By");

		updateRow(sheet, "Training Conducted", rownum++, 0,style);
		updateRow(sheet, trainCond, rownum++,1, 1,style1);
		
		
		List<LinkedHashMap<String, String>> trainingCList = inputMessage.getCategory().getTrainingConducted();

		for  (LinkedHashMap<String,String> ce : trainingCList ) {

			LinkedList<String> data = new LinkedList<String>();	
			
			//System.out.println(" lab"+ce);
			
			for( String key : ce.keySet() ){
				  data.add(ce.get(key));
	
				}	
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}
		
		
		rownum++;

		// For Training Attended
		LinkedList<String> trainAttend = new LinkedList<String>();

		trainAttend.add("Training");
		trainAttend.add("Attended By");

		updateRow(sheet, "Training Attended", rownum++, 0,style);
		updateRow(sheet, trainAttend, rownum++,1, 1,style1);
		
		
		List<LinkedHashMap<String, String>> trainingAList = inputMessage.getCategory().getTrainingAttended();

		for  (LinkedHashMap<String,String> ce : trainingAList) {

			LinkedList<String> data = new LinkedList<String>();	
			
			//System.out.println(" lab"+ce);
			
			for( String key : ce.keySet() ){
				  data.add(ce.get(key));
	
				}	
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}
		
		
		
		rownum++;

		// For OEM Meet
		LinkedList<String> oem = new LinkedList<String>();

		oem.add("OEM Name");
		oem.add("Attended By");

		updateRow(sheet, "OEM Meet", rownum++, 0,style);
		updateRow(sheet, oem, rownum++, 1, 1,style1);
		
		
		
		List<LinkedHashMap<String, String>> oemList = inputMessage.getCategory().getOEMMeet();

		for  (LinkedHashMap<String,String> ce : oemList) {

			LinkedList<String> data = new LinkedList<String>();	
			
			//System.out.println(" lab"+ce);
			
			for( String key : ce.keySet() ){
				  data.add(ce.get(key));
	
				}	
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}
		
		
		rownum++;

		// For Partnership
		LinkedList<String> part = new LinkedList<String>();

		part.add("Vender Name");
		part.add("Attended By");

		updateRow(sheet, "Partnership", rownum++, 0,style);
		updateRow(sheet, part, rownum++,1, 1,style1);
		
		
		List<LinkedHashMap<String, String>> partList = inputMessage.getCategory().getPartnership();

		for  (LinkedHashMap<String,String> ce : partList) {

			LinkedList<String> data = new LinkedList<String>();	
			
			//System.out.println(" lab"+ce);
			
			for( String key : ce.keySet() ){
				  data.add(ce.get(key));
	
				}	
			
			updateRow(sheet, data, rownum++,1, 1);
			
		}
		
		
		rownum++;
		
		
		for (int i=0; i<15; i++){
			sheet.autoSizeColumn(i);
			}

		// lets write the excel data to file now
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
		System.out.println(fileName + " written successfully");
	}

	
	
	private static void updateRow(Sheet sheet, String value, int rowNum, int cellDiff,CellStyle style) {

		Row row = sheet.createRow(rowNum);

		Cell cell = row.createCell(cellDiff);
	
		cell.setCellValue(value);
		
		
		    cell.setCellStyle(style);

	}

	private static void updateRow(Sheet sheet, LinkedList<String> values, int rowNum, int cellStart, int cellDiff, CellStyle style) {

		Row row = sheet.createRow(rowNum);

		int cellNum = cellStart;

		for (String value : values) {

			Cell cell = row.createCell(cellNum);

			cellNum = cellNum + cellDiff;

			cell.setCellValue(value);
			cell.setCellStyle(style);

		}

	}
	
	
	private static void updateRow(Sheet sheet, LinkedList<String> values, int rowNum, int cellStart, int cellDiff) {

		Row row = sheet.createRow(rowNum);

		int cellNum = cellStart;

		for (String value : values) {

			Cell cell = row.createCell(cellNum);

			cellNum = cellNum + cellDiff;

			cell.setCellValue(value);
			//cell.setCellStyle(style);

		}

	}

	private static void updateRow(Sheet sheet, String value, int rowNum, int cellDiff) {

		Row row = sheet.createRow(rowNum);

		Cell cell = row.createCell(cellDiff);
	
		cell.setCellValue(value);

	}

	private static void updateCell(Sheet sheet, String value, int rowNum, int cellNum) {

		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);

		cell.setCellValue(value);

	}

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		/**
		 * Read object from file
		 */
		InputMessage value = null;
		try {
			value = mapper.readValue(new File("report.json"), InputMessage.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(value);
		try {
			writeInputMessageToFile("Reports.xlsx", value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}