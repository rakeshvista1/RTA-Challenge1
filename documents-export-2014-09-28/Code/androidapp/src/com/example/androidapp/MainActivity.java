package com.example.androidapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.StringTokenizer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	


	private String twitterda;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

			 
		
		Button button1 =(Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				

				FileInputStream file;
				try{
					File fa = new File(Environment.getExternalStorageDirectory()+"/Data2/ADTRead.txt");
					if(fa.exists()==true){
						file = new FileInputStream(fa);
						
						BufferedReader bufferr = new BufferedReader(new FileReader(fa));
						String text;
						String da=new String();
						 String st = "";
						 
						 while((text = bufferr.readLine())!=null)
						 {
							 st = text;
						
							 da=da.concat(st+"\n");
							 
							
						 }
						// System.out.println(data);
						 //read data from the file and store 
						 twitterda=da;
						 String result=Analysys(da);
						 
						 TextView textview=(TextView)findViewById(R.id.textView1);
						 textview.setText(da);
						 file.close();
						bufferr.close();
					}
							
					
				}
				catch(Exception e){
					System.out.println("exception in reading file");
				}
			}
 
		});
		

		Button button2 =(Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				
				String result=Analysys(twitterda);
				 System.out.println("result>>>>>"+result);
				 TextView textview1=(TextView)findViewById(R.id.textView1);
				 textview1.setText(result);
				}
 
		});

	}
	
	  
	  public String Analysys(String data)
	    {		 
		  int count1=0;
		  int count2=0;
			   		    try {
			   		    	
			   		    	
			   		   
			   		   StringTokenizer st = new StringTokenizer(data,"/");
			   		   while (st.hasMoreTokens()) {			   			   
			   			   String comp=st.nextToken();
			   			   
			   			   if(comp.contains("positive")){
			   				   	 count1++;
			   				   	 
			   			   }
			   			   else if(comp.contains("negative")){
			   				   count2++;
			   				 
			   			   }			   	
			   			}
			   		   /*End of while*/
			   		  String analysys=new String("Positive Tweets : "+count1+"\t"+" Negative tweets  : "+count2);
			   		  
			   		  data=analysys;
			   		/*  data=data.concat("\n");
			   		  data=data.concat("\n");
			   		  data=data.concat(analysys);*/
			   		
			   		 
			    } catch (Exception e) {
			           e.printStackTrace();
			    }
						
					return data;

	    }
	 
}


  

