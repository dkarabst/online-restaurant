package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.models.*;

@WebServlet("/echo")
public class Answer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JSONObject json;
	private String modelType;

	public void initJsonAsModelUser(JSONObject json, ModelUser m) throws JSONException {
		if (json == null) return;
		json.put("login", m.getLogin());
		json.put("email", m.getEmail());
		json.put("age", new Integer(m.getAge()));
		json.put("password", m.getPassword());
	}
	
	public void initJsonAsModelDish(JSONObject jsno, ModelDish m) throws JSONException {
		if (json == null) return;
		json.put("name", m.getName());
		json.put("description", m.getDescription());
		json.put("weight", m.getWeight());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.getWriter().print("Servlet: i get a POST\n");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		json = new JSONObject();

		modelType = req.getParameter("model");
		if (modelType.equals("ModelUser")) {
			ModelUser user = new ModelUser();
			user.setAge(30);
			user.setEmail("user@gmail.com");
			user.setLogin("vasya");
			user.setPassword("121123s132");
			try {
				initJsonAsModelUser(json, user);
			} catch (JSONException e) {
				out.print("Servlet: ModelUser exception\n");
			}
		} else if (modelType.equals("ModelDish")) {
			ModelDish dish = new ModelDish();
			dish.setDescription("Molto gustosa!!!");
			dish.setName("Saltimbocca alla romana");
			dish.setWeight("200");
			try {
				initJsonAsModelDish(json, dish);
			} catch (JSONException e) {
				out.print("Servlet: ModelDish exception\n");
			}
		}
		
//		out.print("GET: model is " + modelType + "\n");
		

		out.print(json.toString());
	}

}
