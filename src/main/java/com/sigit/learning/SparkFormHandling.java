package com.sigit.learning;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkFormHandling {

	public static void main(String[] args) {
		final Configuration config = new Configuration();
		config.setClassForTemplateLoading(SparkFormHandling.class, "/");
		
		Spark.get("/test", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				StringWriter writer = new StringWriter();
				
				Template template = config.getTemplate("test.ftl");
				template.process(null, writer);
				
				return writer ;
			}
		} );
		
		Spark.post("/response", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				final String name = request.queryParams("user_name");
				String email = request.queryParams("user_mail");
				String Message = request.queryParams("user_message");
				return String.format("%s %s %s", name, email, Message);
			}
		});
		
		Spark.get("/", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				StringWriter writer = new StringWriter();
				
				try{
						Template template = config.getTemplate("fruitPicker.ftl");
						Map<String, Object> fruitMap = new HashMap<>();
						fruitMap.put("fruits", Arrays.asList("apple", "oranges", "banana", "watermelon", "manggo"));
						
						template.process(fruitMap, writer);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				// TODO Auto-generated method stub
				return writer;
			}
		});
		
		Spark.post("/favorite", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
					final String fruit = request.queryParams("fruit");
					String name = request.queryParams("name");
					if (fruit == null) {
						return "Why don't you pick one?";
					} else {
						return name + " favorite fruit is " + fruit;
					}
			}
		});
	}
}
