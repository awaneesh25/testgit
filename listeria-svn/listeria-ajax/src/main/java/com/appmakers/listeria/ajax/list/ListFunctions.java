package com.appmakers.listeria.ajax.list;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appmakers.listeria.rest.client.RestOperationsImpl;

public class ListFunctions extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		BufferedReader reader = req.getReader();
		String line = null;
		try {

			while ((line = reader.readLine()) != null)
				jb.append(line);

			System.out.println(jb.toString());

			String message = "{\"userId\":\"123\",\"jsonMessage\":\"{\\\"listeriaAction\\\": \\\"CREATE\\\",\\\"listCollectionEntity\\\":{\\\"dueDate\\\": \\\"2013-03-05\\\",\\\"creationDate\\\": \\\"2013-03-05\\\",\\\"updationDate\\\": \\\"2013-03-05\\\",\\\"status\\\": \\\"NEW\\\",\\\"userId\\\": \\\"grijesh.saini\\\",\\\"title\\\": \\\"INPUT#TITLE\\\",\\\"columnAtFly\\\":\\\"columnAtFly\\\"}}\"}";

			message = message.replaceAll("INPUT#TITLE", jb.toString());
			RestOperationsImpl restOperations = new RestOperationsImpl();

			String responseMessage = restOperations.save("SAVE_LIST", message);
			System.out.println("resp..."+responseMessage);
			resp.setContentType("application/json");
			resp.getWriter().write(responseMessage);

		} catch (Exception e) {
			e.printStackTrace();/* report an error */
		} finally {
			reader.close();
		}

	}

	public boolean saveList(String userId, String data) {

		return true;
	}

}
