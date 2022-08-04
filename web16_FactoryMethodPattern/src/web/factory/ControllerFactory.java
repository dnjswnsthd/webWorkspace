package web.factory;
/*
 * ControllerFactory
 * ::
 * Controller를 만드는 공장
 * 이곳에서
 * RegisterController, UpdateController, RemoveController, LoginController ... 생성 ...
 * ::
 * Singletone Pattern
 */

import web.controller.AddController;
import web.controller.Controller;
import web.controller.LoginController;
import web.controller.RemoveController;
import web.controller.UpdateController;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {
		System.out.println("Createing ControllerFactory....");
	}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null; 
		if(command.equals("INSERT")) {
			controller = new AddController();
			System.out.println("AddController");
		}else if(command.equals("DELETE")) {
			controller = new RemoveController();
			System.out.println("RemoveController");
		}else if(command.equals("UPDATE")) {
			controller = new UpdateController();
			System.out.println("UpdateController");
		}else if(command.equals("LOGIN")) {
			controller = new LoginController();
			System.out.println("LOGINController");
		}
		return controller;
	}
}
