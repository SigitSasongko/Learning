package com.sigit.learning;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkStyle {

	public static void main(String[] args) {
		Spark.get("/", new Route() {

			@Override
			public Object handle(Request request, Response response) throws Exception {
				return "Hello From Spark";
			}
		});
	}

}
