package devoir.tests;

import devoir.partie1.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PdvDataLoader loader = new PdvDataLoader();
		System.out.println("Loading File");
		try
		{
			loader.saveDataFromFileToDB("src/main/resources/PrixCarburants_instantane.xml", "pwa-mysql");
			System.out.println("Loading finish");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
