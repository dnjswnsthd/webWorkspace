package web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import web.controller.Controller;
import web.factory.ControllerFactory;

public class ClientTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(">>>> command 값 입력");

		String command = br.readLine();
		ControllerFactory factory = ControllerFactory.getInstance();
		Controller controller = factory.createController(command);

		controller.handle();
	}
}
