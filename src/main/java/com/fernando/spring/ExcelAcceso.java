package com.fernando.spring;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.activeX.*;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.File;

public class ExcelAcceso {
	
	public boolean openFile(String file) {
		try {
			
			final String macroName = "!Hoja1.suma";
			
			final ActiveXComponent excel;
			
			excel = new ActiveXComponent("Excel.Application");
			
			final Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
			final Dispatch workBook = Dispatch.call(workbooks, "Open",file).toDispatch();
			 
			final Variant result = Dispatch.call(excel, "Run",new Variant("Suma.xlsm" + macroName));
			 
			Dispatch.call(workBook, "Save");
			 
			com.jacob.com.Variant f = new com.jacob.com.Variant(true);
			
			Dispatch.call(workBook, "Close", f);
			
			//executeMacro(new File(file), macroName);
			return true;
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return true;
	}
	 
	public boolean executeMacro(File file, String macroName) {
	
		//ComThread.InitSTA();
		 
		final ActiveXComponent excel = new ActiveXComponent("Excel.Application");
	 
		try {
	 
			final Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
			final Dispatch workBook = Dispatch.call(workbooks, "Open",file.getAbsolutePath()).toDispatch();
			 
			final Variant result = Dispatch.call(excel, "Run",new Variant(file.getName() + macroName));
			 
			Dispatch.call(workBook, "Save");
			 
			com.jacob.com.Variant f = new com.jacob.com.Variant(true);
			
			Dispatch.call(workBook, "Close", f);
		 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			excel.invoke("Quit", new Variant[0]);
			ComThread.Release();
			return true;
		}
	}
  
}
