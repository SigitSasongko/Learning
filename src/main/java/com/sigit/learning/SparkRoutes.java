package com.sigit.learning;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkRoutes {
	public static void main(String[] args) {
		Spark.get("/", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return "Hello World\n";
			}
		});
		
		Spark.get("/test", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return "This is a test page\n";
			}
		});
		
		Spark.get("/echo/:first/:last", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				Integer a = Integer.valueOf(request.params(":first")) + Integer.valueOf(request.params(":last"));
				
				return a.toString();
			}
		});
	}
}
