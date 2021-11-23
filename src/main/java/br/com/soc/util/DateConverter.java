package br.com.soc.util;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateConverter {

	public static Date stringToDate(String valor) {  
		
		return DateConverter.stringToDateTime(valor, "dd/MM/yyyy");
	}  

	public static Date stringToDateTime(String valor) {  
		
		return DateConverter.stringToDateTime(valor, "dd/MM/yyyy hh:mm:ss");
	}  

	private static Date stringToDateTime(String valor, String formato) {  
		
		Date retorno;
		SimpleDateFormat formatador = new SimpleDateFormat(formato);

		try {
			retorno = formatador.parse(valor);
		}
		
		catch (ParseException ex) {
			retorno = null;
		}
		
		return retorno;
	}  

	public static String dateToString(Date data) {
		
		return DateConverter.dateTimeToString(data, "dd/MM/yyyy");
	}

	public static String dateTimeToString(Date data) {
		
		return DateConverter.dateTimeToString(data, "dd/MM/yyyy hh:mm:ss");
	}

	private static String dateTimeToString(Date data, String formato) {  
		
		SimpleDateFormat formatador = new SimpleDateFormat(formato);
		return formatador.format(data);
	} 
}

