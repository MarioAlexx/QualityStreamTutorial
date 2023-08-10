package com.qualitystream.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public ReadExcelFile() {
		// TODO Auto-generated constructor stub
	}

	// Método general para leer toda la información de excel, fila por fila y cada
	// una de las celdas de la fila
	// Se le pasa de parametro el camino donde estara guardado el excel
	public void readExcel(String filepath, String sheetName) throws IOException {
		// Objeto de tripo File
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		// Objeto donde se guardara el fichero
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		// Objeto donde se guarda la hoja de trabajo
		// Recibe como parametro el nombre de lahoja
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

		// Se crea una variable para guardar cuantas filas de datos tiene el archivo
		// excel
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

		for (int i = 0; i <= rowCount; i++) {
			// Se crea un para leer fila por fila del archivo excel
			XSSFRow row = newSheet.getRow(i);
			// Se crea for para iterar todas las celdas de la fila
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue() + "|| ");
			}

		}
	}

	// Método para leer una celda en especifica
	public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		// Objeto donde se guardara el fichero
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		// Objeto donde se guarda la hoja de trabajo
		// Recibe como parametro el nombre de lahoja
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

		XSSFRow row = newSheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);
		
		// El método fue creado como string asi que íde un return
		return cell.getStringCellValue();
	}
}
