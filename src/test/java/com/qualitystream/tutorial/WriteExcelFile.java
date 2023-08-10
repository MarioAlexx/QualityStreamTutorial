package com.qualitystream.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.Iterator;

import javax.print.DocFlavor.INPUT_STREAM;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public WriteExcelFile() {
		// TODO Auto-generated constructor stub
	
	}

	//Método para escribir arreglo de datos (lista de datos) al archivo excel
	public void WriteExcel(String filepath, String sheetName, String[] dataToWrite) throws IOException {
		File file= new File(filepath);
		FileInputStream inputStream=new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		int rowCount = newSheet.getLastRowNum()-newSheet.getFirstRowNum();

		// Objeto fila
		XSSFRow row = newSheet.getRow(0);
		// Crear una nueva fila a donde vamos a escribir
		XSSFRow newRow = newSheet.createRow(rowCount + 1);

		for (int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToWrite[i]);
		}
		inputStream.close();
		
		//Esto permite escribie información en el excel
		FileOutputStream outputStream=new FileOutputStream(file);
		
		newWorkbook.write(outputStream);
		outputStream.close();
	}
	
	//Método para escribir un valor en una celda especifica
	public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {
		File file= new File(filepath);
		FileInputStream inputStream=new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		//Creamos la fila
		XSSFRow row = newSheet.getRow(rowNumber);
		 
		//Creamos una nueva celda
		//firtCell indica que leera el valor desde la primera celda A1, B1
		//cellNumber indica la celda en donde queremos escribir el resultado
		XSSFCell firtCell=row.getCell(cellNumber-1);
		
		//Envia un valor a la consola para ver que calos esta pasando por el código
		//System.out.println("fist cell value is:" + firtCell.getStringCellValue());
	
		//Proxmina celda
		XSSFCell nextCell=row.createCell(cellNumber);
		nextCell.setCellValue(resultText);
		
		//indicar que en la prxima celda se guardo el valor resultTex que nos paso como parametro de la linea anterior
		System.out.println("next cell value" + nextCell.getStringCellValue());
		inputStream.close();
		
		FileOutputStream outputStream=new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();
	}
}


