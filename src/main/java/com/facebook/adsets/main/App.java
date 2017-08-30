package com.facebook.adsets.main;

import com.facebook.adset.common.AdsetCreate;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.model.TableDataList;
import com.google.api.services.bigquery.model.TableRow;
import com.google.bigquery.main.BQOperations;
import com.google.bigquery.main.GAuthenticate;

public class App{
    
	public static void main(String[] args)
	{

		Bigquery bigquery = GAuthenticate.getAuthenticated();
		
		System.out.println(bigquery);
		
		if(null != bigquery){
			
			if(BQOperations.StructureValidate(bigquery, "adset_create")){
	    	
				System.out.println("Response Message : Validated the Structure of Table : adset_update in the Big Query.");
				
				TableDataList list = BQOperations.GetUpdateRows(bigquery, "adset_create");
				
				if(null != list){
				
					for(TableRow row : list.getRows()){
						
						if(AdsetCreate.getCreateResults(row, bigquery)){
							
							System.out.println("Response Message : The Adset is created Successfully with ID : " + row.getF().get(0).getV());
							
						}
						else{
					
							System.out.println("Response Message : Error while creating Adset with ID : " + row.getF().get(0).getV());
						
						}
						
					}
					
					//BQOperations.truncateTable(bigquery, "adset_create");
				
				}
				
				else{
				
					System.out.println("Response Message : No Updation is requested in Adset Create Table.");
				
				}
				
			}
					
			else{
				
				System.out.println("Response Message : Couldn't validate the Structure of Table : adset_create in the Big Query.");
				System.exit(0);	
			
			}
			    			
		}
		
		else{
			
			System.out.println("Response Message : Couldn't Establish connection with Big Query.");
			System.exit(0);
		
		}
		 
	}
	
}